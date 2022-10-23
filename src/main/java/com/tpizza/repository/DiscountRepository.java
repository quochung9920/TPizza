package com.tpizza.repository;

import java.util.List;

import com.tpizza.pojos.Discount;

public interface DiscountRepository {
    Discount addDiscount(Discount discount);
    List<Discount> getDiscounts();
    Discount getDiscountById(int id);
}
