package com.tpizza.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.Cart;
import com.tpizza.pojos.Discount;
import com.tpizza.pojos.User;
import com.tpizza.repository.BillRepository;
import com.tpizza.service.BillService;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill createBill(Map<Integer, Cart> cartItems, Map<Integer, Discount> discount, User userCreated, String nameOrder, String phoneOrder,
            String addressOrder, String emailOrder) {
        Bill bill = new Bill();
        bill.setNameOrder(nameOrder);
        bill.setPhone(phoneOrder);
        bill.setAddress(addressOrder);
        bill.setEmail(emailOrder);
        bill.setIdClient(userCreated);
        return this.billRepository.createBill(cartItems, discount, bill);
    }

    @Override
    public List<Bill> getListBills(User user) {
        return this.billRepository.getListBills(user);
    }

    @Override
    public Bill getBillById(Integer billId) {
        return this.billRepository.getBillById(billId);
    }

    @Override
    public Bill updateBill(int idBill, String status, User staffUser) {
        return this.billRepository.updateBill(idBill, status, staffUser);
    }

    @Override
    public Boolean removeBill(int idBill) {
        return this.billRepository.removeBill(idBill);
    }

    @Override
    public List<Bill> getBills(String kw, int page, int size) {
        return this.billRepository.getBills(kw, page, size);
    }

    @Override
    public List<Bill> getBillsByDay(String date) {
        return this.billRepository.getBillsByDay(date);
    }

    @Override
    public int getTotalRevenueByDay(String date) {
        return this.billRepository.getTotalRevenueByDay(date);
    }

    @Override
    public int getTotalRevenueByMonth(String month) {
        return this.billRepository.getTotalRevenueByMonth(month);
    }

}
