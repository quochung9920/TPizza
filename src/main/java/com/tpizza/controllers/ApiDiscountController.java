package com.tpizza.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tpizza.pojos.Discount;
import com.tpizza.service.DiscountService;

@RestController
public class ApiDiscountController {
    @Autowired
    private DiscountService discountService;
    
    
    @PostMapping("/api/addDiscount")
    public ResponseEntity<Discount> addDiscount(@RequestBody Map<String, String> params) {
        try {
            String nameDiscount = params.get("nameDiscount");
            int percentageReduction = Integer.parseInt(params.get("percentageReduction"));
            Date startDate = Date.valueOf(params.get("startDate"));
            Date endDate = Date.valueOf(params.get("endDate"));
            int amountDiscount = Integer.parseInt(params.get("amountDiscount"));
            String statusDiscount = params.get("statusDiscount");

            Discount discount = new Discount();
            discount.setName(nameDiscount);
            discount.setPercentageReduction(percentageReduction);
            discount.setStartDate(startDate);
            discount.setEndDate(endDate);
            discount.setAmount(amountDiscount);
            discount.setStatus(statusDiscount);

            return ResponseEntity.ok(this.discountService.addDiscount(discount));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/api/getDiscounts")
    public ResponseEntity<Iterable<Discount>> getDiscounts() {
        try {
            return ResponseEntity.ok(this.discountService.getDiscounts());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }


    @PostMapping("/api/addDiscountToSession")
    public ResponseEntity<Map<Integer, Discount>> addDiscountToSession(@RequestBody Map<String, String> params, HttpSession session) {
        try {
            int idDiscount = Integer.parseInt(params.get("idDiscount"));
            if(idDiscount > 0){
                Map<Integer, Discount> discountItems = (Map<Integer, Discount>) session.getAttribute("discount");
            
                if(discountItems == null) {
                    discountItems = new HashMap<>();
                    discountItems.put(idDiscount, this.discountService.getDiscountById(idDiscount));
                } else{
                    session.removeAttribute("discount");
                    discountItems = new HashMap<>();
                    discountItems.put(idDiscount, this.discountService.getDiscountById(idDiscount));
                }
                session.setAttribute("discount", discountItems);
                return ResponseEntity.ok(discountItems);
            } else {
                return ResponseEntity.ok(null);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
}
