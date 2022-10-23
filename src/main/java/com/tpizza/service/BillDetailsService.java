package com.tpizza.service;

import java.util.List;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.BillDetails;
import com.tpizza.pojos.Product;

public interface BillDetailsService {
    Boolean addBillDetail(BillDetails billDetails);
    List<BillDetails> getListBillDetailsByBillId(Bill billId);
    Integer getListBillDetailsByProductId(Product billId);

    Boolean removeBillDetailsByBillId(Bill bill);
}
