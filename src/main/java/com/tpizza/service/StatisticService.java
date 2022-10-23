package com.tpizza.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.Product;

public interface StatisticService {
    Integer getTotalRevenue();
    Integer getTotalOrder();
    Integer getTotalProducts();
    Integer getTotalUsers();

    List<Map<String, String>> getTotalBillsByDay(int date);
    List<Integer> getBillsByMonth();

    List<Map<String, Object>> getTopProducts(int limit);
}
