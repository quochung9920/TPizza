package com.tpizza.repository.impl;

import java.util.List;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.BillDetails;
import com.tpizza.pojos.Product;
import com.tpizza.repository.BillDetailsRepository;

@Repository
@Transactional
public class BillDetailsRepositoryImpl implements BillDetailsRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public Boolean addBillDetail(BillDetails billDetail) {
        
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            session.save(billDetail);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<BillDetails> getListBillDetailsByBillId(Bill billId) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            return session.createQuery("FROM BillDetails WHERE bill = : idBill ", BillDetails.class)
                    .setParameter("idBill", billId).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean removeBillDetailsByBillId(Bill bill) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            session.createQuery("DELETE BillDetails WHERE bill = : idBill").setParameter("idBill", bill);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Integer getListBillDetailsByProductId(Product billId) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            List<BillDetails> listBillDetails = session.createQuery("FROM BillDetails WHERE idProduct = : idProduct ", BillDetails.class)
                    .setParameter("idProduct", billId).getResultList();
            int total = 0;
            for (BillDetails billDetails : listBillDetails) {
                total += billDetails.getAmount();
            }

            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    
}
