package com.tpizza.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.BillDetails;
import com.tpizza.pojos.Product;
import com.tpizza.repository.BillDetailsRepository;
import com.tpizza.service.BillDetailsService;
@Service
public class BillDetailsServiceImpl implements BillDetailsService {

    @Autowired
    private BillDetailsRepository billDetailsRepository;

    @Override
    public Boolean addBillDetail(BillDetails billDetails) {
        return this.billDetailsRepository.addBillDetail(billDetails);
    }

    @Override
    public List<BillDetails> getListBillDetailsByBillId(Bill billId) {
        return this.billDetailsRepository.getListBillDetailsByBillId(billId);
    }

    @Override
    public Boolean removeBillDetailsByBillId(Bill bill) {
        return this.billDetailsRepository.removeBillDetailsByBillId(bill);
    }

    @Override
    public Integer getListBillDetailsByProductId(Product billId) {
        return this.billDetailsRepository.getListBillDetailsByProductId(billId);
    }

}
