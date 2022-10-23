package com.tpizza.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.BillDetails;
import com.tpizza.pojos.Cart;
import com.tpizza.pojos.Discount;
import com.tpizza.pojos.Product;
import com.tpizza.pojos.User;
import com.tpizza.repository.BillRepository;
import com.tpizza.service.BillDetailsService;
import com.tpizza.service.BillService;
import com.tpizza.service.ProductService;
import com.tpizza.utils.Utils;

@Repository
@Transactional
public class BillRepositoryImpl implements BillRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;
    @Autowired
    private ProductService productService;
    @Autowired
    private BillDetailsService billDetailsService;
    @Autowired
    private BillService billService;

    @Override
    public Bill createBill(Map<Integer, Cart> cartItems, Map<Integer, Discount> discount, Bill bill) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            bill.setCreateDate(new Date());
            bill.setStatus("PENDING");
            if(discount != null) {
                bill.setIdDiscount(discount.get(1));
                bill.setTotalPrice(Utils.totalPriceCart(cartItems, discount));
            } else {
                bill.setIdDiscount(null);
                bill.setTotalPrice(Utils.totalPriceCart(cartItems));
            }
            session.save(bill);

            List<BillDetails> billDetailsList = new ArrayList<BillDetails>();

            for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
                Cart cartItem = entry.getValue();
                BillDetails billDetails = new BillDetails();
                Product product = this.productService.getProductById(cartItem.getProductId());
                billDetails.setBill(bill);
                billDetails.setAmount(cartItem.getQuantity());
                billDetails.setPrice(cartItem.getPrice());
                billDetails.setTotalPrice(cartItem.getQuantity() * cartItem.getPrice());
                billDetails.setIdProduct(product);
                billDetailsList.add(billDetails);
                this.billDetailsService.addBillDetail(billDetails);
            }
            return bill;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Bill> getListBills(User user) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            List<Bill> list = new ArrayList<Bill>();
            System.out.println(user);
            if (user.getId() != null) {
                if (user.getRole().equals("ROLE_ADMIN") || user.getRole().equals("ROLE_STAFF")) {
                    Query<Bill> query = session.createQuery("from Bill");
                    list = query.getResultList();
                } else {
                    Query<Bill> query = session.createQuery("FROM Bill WHERE idClient=:order", Bill.class)
                        .setParameter("order", user);
                    list = query.getResultList();
                }
            } else {
                Query<Bill> query = session.createQuery("from Bill");
                list = query.getResultList();
            }
            for (Bill bill : list) {
                List<BillDetails> billDetailsList = this.billDetailsService.getListBillDetailsByBillId(bill);
                bill.setBillDetails(billDetailsList);
            }
            return list;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Bill getBillById(Integer billId) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            CriteriaQuery<Bill> billQuery = session.getCriteriaBuilder().createQuery(Bill.class);
            billQuery.from(Bill.class);
            Bill bill = session.get(Bill.class, billId);
            if (bill != null) {
                List<BillDetails> billDetailsList = this.billDetailsService.getListBillDetailsByBillId(bill);
                bill.setBillDetails(billDetailsList);
                return bill;
            } else {
                return new Bill(null);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Bill updateBill(int idBill, String status, User staffUser) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            Bill bill = this.billService.getBillById(idBill);
            bill.setStatus(String.valueOf(status));
            bill.setIdStaff(staffUser);
            List<BillDetails> billDetailsList = this.billDetailsService.getListBillDetailsByBillId(bill);
            bill.setBillDetails(billDetailsList);
            session.update(bill);
            return bill;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean removeBill(int idBill) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            Bill findBill = this.billService.getBillById(idBill);
            if (findBill != null) {
                session.remove(findBill);
                this.billDetailsService.removeBillDetailsByBillId(findBill);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Bill> getBills(String kw, int page, int size) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
        Root root = query.from(Bill.class);
        query = query.select(root);

        if (kw != null && !kw.isEmpty()) {
            Predicate p = builder.like(root.get("id").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        q.setFirstResult((page - 1) * size);
        q.setMaxResults(size);
        List<Bill> list = q.getResultList();
        for (Bill bill : list) {
            List<BillDetails> billDetailsList = this.billDetailsService.getListBillDetailsByBillId(bill);
            bill.setBillDetails(billDetailsList);
        }
        return list;

    }

    @Override
    public List<Bill> getBillsByDay(String date) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
            Root<Bill> root = query.from(Bill.class);
            query.select(root).where(builder.like(root.get("createDate").as(String.class), "%" + date + "%"));
            List<Bill> bills = session.createQuery(query).getResultList();
            for (Bill bill : bills) {
                List<BillDetails> billDetailsList = this.billDetailsService.getListBillDetailsByBillId(bill);
                bill.setBillDetails(billDetailsList);
            }
            return bills;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public int getTotalRevenueByDay(String date) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
            Root<Bill> root = query.from(Bill.class);
            query.select(root).where(builder.like(root.get("createDate").as(String.class), "%" + date + "%"));
            List<Bill> bills = session.createQuery(query).getResultList();
            int total = 0;
            for (Bill bill : bills) {
                List<BillDetails> billDetailsList = this.billDetailsService.getListBillDetailsByBillId(bill);
                bill.setBillDetails(billDetailsList);
                total += bill.getTotalPrice();
            }
            return total;
        } catch (Exception e) {
            return 0;
        }

    }

    @Override
    public int getTotalRevenueByMonth(String month) {
        try {
            Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
            Root<Bill> root = query.from(Bill.class);
            query.select(root).where(builder.like(root.get("createDate").as(String.class), "%-" + month + "-%"));
            List<Bill> bills = session.createQuery(query).getResultList();
            int total = 0;
            for (Bill bill : bills) {
                List<BillDetails> billDetailsList = this.billDetailsService.getListBillDetailsByBillId(bill);
                bill.setBillDetails(billDetailsList);
                total += bill.getTotalPrice();
            }
            return total;
        } catch (Exception e) {
            return 0;
        }

    }

}
