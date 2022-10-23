package com.tpizza.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpizza.pojos.Discount;
import com.tpizza.repository.DiscountRepository;

@Repository
@Transactional
public class DiscountRepositoryImpl implements DiscountRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Discount addDiscount(Discount discount) {
        try {
            sessionFactory.getObject().getCurrentSession().save(discount);
            return discount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Discount> getDiscounts() {
        try {
            return sessionFactory.getObject().getCurrentSession().createQuery("FROM Discount", Discount.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Discount getDiscountById(int id) {
        try {
            return sessionFactory.getObject().getCurrentSession().createQuery("FROM Discount WHERE id = :id", Discount.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
