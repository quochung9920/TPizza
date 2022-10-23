package com.tpizza.repository;

import java.util.List;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.BillDetails;
import com.tpizza.pojos.Product;

public interface BillDetailsRepository {
    Boolean addBillDetail(BillDetails billDetail);
    List<BillDetails> getListBillDetailsByBillId(Bill billId);
    Integer getListBillDetailsByProductId(Product billId);
    Boolean removeBillDetailsByBillId(Bill bill);
}
