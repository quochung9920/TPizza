package com.tpizza.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.BillDetails;
import com.tpizza.pojos.Cart;
import com.tpizza.pojos.Discount;
import com.tpizza.pojos.User;
import com.tpizza.service.BillDetailsService;
import com.tpizza.service.BillService;
import com.tpizza.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiBillController {

    @Autowired
    private BillService billService;
    @Autowired
    private UserService userDetailService;

    @PostMapping("/createBill")
    public Bill createBill(HttpSession session, Authentication authentication,
            @RequestBody Map<String, String> params) {

        Map<Integer, Cart> cartItems = (Map<Integer, Cart>) session.getAttribute("cart");
        String nameOrder = params.get("nameOrder");
        String phoneOrder = params.get("phoneOrder");
        String addressOrder = params.get("addressOrder");
        String emailOrder = params.get("emailOrder");
        Map<Integer, Discount> discount = (Map<Integer, Discount>) session.getAttribute("discount");

        if (cartItems != null) {
            if (authentication != null) {
                User user = this.userDetailService.getUsers(authentication.getName()).get(0);
                session.removeAttribute("cart");
                session.removeAttribute("discount");
                return this.billService.createBill(cartItems, discount, user, nameOrder, phoneOrder, addressOrder, emailOrder);
            } else {
                User user = new User();
                user.setId(1);
                session.removeAttribute("cart");
                session.removeAttribute("discount");
                return this.billService.createBill(cartItems, discount, user, nameOrder, phoneOrder, addressOrder, emailOrder);
            }
        }
        return null;
    }


    @GetMapping("/getBillDashboard")
    public List<Bill> getBillDashboard() {
        return this.billService.getBills("", 1, 5);
    }

    @PostMapping("/getBillDashboard/{page}")
    public List<Bill> getBillDashboard(@RequestBody Map<String, String> params, @PathVariable("page") int page) {
        String kw = params.get("kw");
        return this.billService.getBills(kw, page, 5);
    }


    @GetMapping("/listBill")
    public ResponseEntity<List<Bill>> getBillList(Authentication authentication) {
        if (authentication != null) {
            User user = this.userDetailService.getUsers(authentication.getName()).get(0);
            return ResponseEntity.ok(this.billService.getListBills(user));
        } else {
            return ResponseEntity.ok(this.billService.getListBills(new User()));
        }
    }



    @GetMapping("/bill/{id}")
    public ResponseEntity<Bill> getBill(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(this.billService.getBillById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateBill/{idBill}")
    public ResponseEntity<Bill> updateBill(@PathVariable("idBill") int idBill, @RequestBody Map<String, String> params, Authentication authentication) {
        try {
            String status = params.get("status");
            return ResponseEntity.ok(this.billService.updateBill(idBill, status, this.userDetailService.getUsers(authentication.getName()).get(0)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/deleteBill/{idBill}")
    public ResponseEntity<Boolean> deleteBill(@PathVariable("idBill") int idBill) {
        try {
            return ResponseEntity.ok(this.billService.removeBill(idBill));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
