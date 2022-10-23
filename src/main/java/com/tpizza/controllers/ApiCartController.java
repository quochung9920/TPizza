package com.tpizza.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tpizza.pojos.Cart;

@RestController
public class ApiCartController {
    
    @PostMapping("/api/cart")
    public Cart addToCart(@RequestBody Cart cart, HttpSession session) {
        Map<Integer, Cart> cartItems = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cartItems == null) {
            cartItems = new HashMap<>();
        }
        int productId = cart.getProductId();
        if(cartItems.containsKey(productId)) {
            Cart cartItem = cartItems.get(productId);
            cartItem.setQuantity(cartItem.getQuantity() +1);
        } else {
            cartItems.put(productId, cart);
        }

        session.setAttribute("cart", cartItems);
        return cart;
    }

    @DeleteMapping("/api/cart/{productId}")
    public int removeFromCart(HttpSession session, @PathVariable("productId") int productId) {
        Map<Integer, Cart> cartItems = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cartItems != null && cartItems.containsKey(productId)) {
            cartItems.remove(productId);
            session.setAttribute("cart", cartItems);
            return 1;
        }
        return 0;
    }
}
