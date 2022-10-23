package com.tpizza.repository;

import java.util.List;
import java.util.Map;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.Cart;
import com.tpizza.pojos.Discount;
import com.tpizza.pojos.User;

public interface BillRepository {
    Bill createBill(Map<Integer, Cart> cartItems, Map<Integer, Discount> discount, Bill bill);
    List<Bill> getListBills(User user);
    Bill getBillById(Integer billId);
    List<Bill> getBillsByDay(String date);

    Bill updateBill(int idBill, String status, User staffUser);
    Boolean removeBill(int idBill);
    List<Bill> getBills(String kw, int page, int size);

    int getTotalRevenueByDay(String date);
    int getTotalRevenueByMonth(String month);
}
    
