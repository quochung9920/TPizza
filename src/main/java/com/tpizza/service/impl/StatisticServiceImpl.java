package com.tpizza.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.Product;
import com.tpizza.repository.StatisticRepository;
import com.tpizza.service.StatisticService;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public Integer getTotalRevenue() {
        return this.statisticRepository.getTotalRevenue();
    }

    @Override
    public Integer getTotalOrder() {
        return this.statisticRepository.getTotalOrder();
    }

    @Override
    public Integer getTotalProducts() {
        return this.statisticRepository.getTotalProducts();
    }

    @Override
    public Integer getTotalUsers() {
        return this.statisticRepository.getTotalUsers();
    }
 
    @Override
    public List<Map<String, String>> getTotalBillsByDay(int date) {
        return this.statisticRepository.getTotalBillsByDay(date);
    }

    @Override
    public List<Integer> getBillsByMonth() {
        return this.statisticRepository.getBillsByMonth();
    }

    @Override
    public List<Map<String, Object>> getTopProducts(int limit) {
        return this.statisticRepository.getTopProducts(limit);
    }
}
