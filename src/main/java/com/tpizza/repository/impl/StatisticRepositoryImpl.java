package com.tpizza.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.BillDetails;
import com.tpizza.pojos.Product;
import com.tpizza.pojos.User;
import com.tpizza.repository.StatisticRepository;
import com.tpizza.service.BillDetailsService;
import com.tpizza.service.BillService;
import com.tpizza.service.ProductService;

@Repository
@Transactional
public class StatisticRepositoryImpl implements StatisticRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private BillService billService;
    @Autowired
    private BillDetailsService billDetailsService;
    @Autowired
    private ProductService productService;

    @Override
    public Integer getTotalRevenue() {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
            query.select(query.from(Bill.class));
            return session.createQuery(query).getResultList().stream().mapToInt(bill -> bill.getTotalPrice()).sum();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer getTotalOrder() {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
            query.select(query.from(Bill.class));
            return session.createQuery(query).getResultList().size();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer getTotalProducts() {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            query.select(query.from(Product.class));
            return session.createQuery(query).getResultList().size();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer getTotalUsers() {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            query.select(query.from(User.class));
            return session.createQuery(query).getResultList().size();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Map<String, String>> getTotalBillsByDay(int numberOfDays) {
        
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
            Root<Bill> root = query.from(Bill.class);
            query.select(root);
            List<Bill> bills = session.createQuery(query).getResultList();
            List<java.util.Date> dates = bills.stream().map(bill -> bill.getCreateDate()).collect(Collectors.toList());
            List<Date> sqlDates = dates.stream().map(date -> new Date(date.getTime())).collect(Collectors.toList());
            List<String> sqlDatesString = sqlDates.stream().map(date -> date.toString()).collect(Collectors.toList());
            List<String> sqlDatesStringDistinct = sqlDatesString.stream().distinct().collect(Collectors.toList()); 
            sqlDatesStringDistinct.sort((date1, date2) -> date1.compareTo(date2));

            if (sqlDatesStringDistinct.size() > numberOfDays && numberOfDays > 0) {
                sqlDatesStringDistinct = sqlDatesStringDistinct.subList(sqlDatesStringDistinct.size() - numberOfDays, sqlDatesStringDistinct.size());
            }

            List<Map<String, String>> listBillByDate = new ArrayList<Map<String, String>>();
            int index = 1;
            for (String date : sqlDatesStringDistinct) {
                int listBill = this.billService.getTotalRevenueByDay(date);
                Map<String, String> map = new HashMap<>();
                map.put("id", String.valueOf(index));
                map.put("date", date);
                map.put("total", String.valueOf(listBill));
                listBillByDate.add(map);
                index++;
            }
            
            return listBillByDate;
        } catch (Exception e) {
            return null;
        } 

    }

    @Override
    public List<Integer> getBillsByMonth() {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
            Root<Bill> root = query.from(Bill.class);
            query.select(root);
            List<Bill> bills = session.createQuery(query).getResultList();

            List<String> months = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");

            List<Integer> listTotalRevenueByMonth = new ArrayList<Integer>();
            for (String month : months) {
                int listBill = this.billService.getTotalRevenueByMonth(month);
                listTotalRevenueByMonth.add(listBill);
            }
            
            return listTotalRevenueByMonth;
        } catch (Exception e) {
            return null;
        } 
    }

    @Override
    public List<Map<String, Object>> getTopProducts(int limit) {
        try {
            // Lấy ra danh sách sản phẩm
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            query.select(root);
            List<Product> products = session.createQuery(query).getResultList();
            List<Map<String, Object>> listTopProducts = new ArrayList<Map<String, Object>>();
            for (Product product : products) {
                Map<String, Object> map = new HashMap<>();
                map.put("total", this.billDetailsService.getListBillDetailsByProductId(this.productService.getProductById(product.getId())));
                map.put("productId", product.getId());
                map.put("productName", product.getName());
                map.put("productImage", product.getImage());
                listTopProducts.add(map);
            }
            listTopProducts.sort((product1, product2) -> ((Integer) product2.get("total")).compareTo((Integer) product1.get("total")));
            if (listTopProducts.size() > limit && limit > 0) {
                listTopProducts = listTopProducts.subList(0, limit);
            }

            return listTopProducts;
        } catch (Exception e) {
            return null;
        }
    }


}
