package com.tpizza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpizza.pojos.Discount;
import com.tpizza.repository.DiscountRepository;
import com.tpizza.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public Discount addDiscount(Discount discount) {
        return this.discountRepository.addDiscount(discount);
    }

    @Override
    public java.util.List<Discount> getDiscounts() {
        return this.discountRepository.getDiscounts();
    }
    
    @Override
    public Discount getDiscountById(int id) {
        return this.discountRepository.getDiscountById(id);
    }
}
