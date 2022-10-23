package com.tpizza.utils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tpizza.pojos.Cart;
import com.tpizza.pojos.Discount;

public class Utils {
    public static int countCart(Map<Integer, Cart> cart) {
        int count = 0;
        if(cart != null) {
            for(Cart item: cart.values()) {
                count += item.getQuantity();
            }
        }
        return count;
    }

    public static int totalPriceCart(Map<Integer, Cart> cart) {
        int total = 0;
        if(cart != null) {
            for(Cart item: cart.values()) {
                total +=  item.getPrice() * item.getQuantity();
            }
        }
        return total;
    }

    public static int totalPriceCart(Map<Integer, Cart> cart, Map<Integer, Discount> discount) {
        int total = 0;
        if(cart != null) {
            for(Cart item: cart.values()) {
                total +=  item.getPrice() * item.getQuantity();
            }
        }
        total = total - ((total * discount.get(1).getPercentageReduction()) / 100);
        return total;
    }
    
}
