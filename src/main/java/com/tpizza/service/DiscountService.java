package com.tpizza.service;

import java.util.List;

import com.tpizza.pojos.Discount;

public interface DiscountService {
    Discount addDiscount(Discount discount);
    List<Discount> getDiscounts();
    Discount getDiscountById(int id);
}
