package com.tpizza.service;

import java.util.List;
import java.util.Map;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.Cart;
import com.tpizza.pojos.Discount;
import com.tpizza.pojos.User;

public interface BillService {
    Bill createBill(Map<Integer, Cart> cartItems, Map<Integer, Discount> discount, User userCreated, String nameOrder, String phoneOrder, String addOrder, String emailOrder);
    List<Bill> getListBills(User user);
    Bill getBillById(Integer billId);
    List<Bill> getBillsByDay(String date);

    Bill updateBill(int idBill, String status, User staffUser);
    Boolean removeBill(int idBill);

    List<Bill> getBills(String kw, int page, int size);

    int getTotalRevenueByDay(String date);
    int getTotalRevenueByMonth(String month);
}
