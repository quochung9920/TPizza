package com.tpizza.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tpizza.pojos.Product;
import com.tpizza.pojos.User;
import com.tpizza.service.BillService;
import com.tpizza.service.CategoryService;
import com.tpizza.service.ProductService;
import com.tpizza.service.StatisticService;
import com.tpizza.service.UserService;



@Controller
public class AdminController {
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StatisticService statisticService;




    @GetMapping("/admin/")
    public String index(Model model) {
        model.addAttribute("totalRevenue", this.statisticService.getTotalRevenue());
        model.addAttribute("totalOrder", this.statisticService.getTotalOrder());
        model.addAttribute("totalProducts", this.statisticService.getTotalProducts());
        model.addAttribute("totalUsers", this.statisticService.getTotalUsers());
        model.addAttribute("totalBillsByDay", this.statisticService.getTotalBillsByDay(7));
        model.addAttribute("top3Product", this.statisticService.getTopProducts(3));
        return "admin-index";
    }

    @GetMapping("/admin/user-manager")
    public String userView() {
        return "user-manager";
    }

    @GetMapping("/admin/add-user")
    public String registerView(Model model) {
        return "add-user";
    }

    @GetMapping("/admin/update-user")
    public String updateUserView(Model model, @RequestParam("user") String email) {
        List<User> user = this.userDetailsService.getUsers(email);
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_STAFF");

        model.addAttribute("user", user.get(0));
        model.addAttribute("roles", roles);
        return "update-user";
    }

    @GetMapping("/admin/product-manager")
    public String productView() {
        return "product-manager";
    }

    @GetMapping("/admin/add-product")
    public String addProductView(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories(""));
        return "add-product";
    }

    @PostMapping("/admin/add-product")
    public String addProductImage(@ModelAttribute(value = "addProductImage") Product product) {
        this.productService.addProductImage(product.getProductImage());
        return "redirect:/admin/product-manager";
    }

    @GetMapping("/admin/bill-manager")
    public String billView() {
        return "bill-manager";
    }

    @GetMapping("/admin/discount-manager")
    public String discountView() {
        return "discount-manager";
    }

}


