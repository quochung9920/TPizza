package com.tpizza.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tpizza.pojos.Cart;
import com.tpizza.pojos.User;
import com.tpizza.service.DiscountService;

@Controller
public class HomeController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginView(){
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/order")
    public String orderViewForward() {
        return "redirect:/order/pizza";
    }

    @GetMapping("/order/{category}")
    public String orderView(Model model, HttpSession session) {
        Map<Integer, Cart> cartItems = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cartItems != null) {
            session.setAttribute("carts", cartItems.values());
        } else {
            session.setAttribute("carts", null);
        }
        model.addAttribute("discounts", this.discountService.getDiscounts());
        return "order";
    }

    @GetMapping("/payment")
    public String paymentView(){
        return "payment";
    }


    @GetMapping("/tracking")
    public String tracking(){
        return "tracking";
    }
}
