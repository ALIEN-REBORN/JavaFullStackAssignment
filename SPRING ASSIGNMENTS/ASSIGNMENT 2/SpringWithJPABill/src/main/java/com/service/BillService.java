package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Bill;
import com.dao.BillDao;

@Service
public class BillService {
	@Autowired
	BillDao billDao;
	
	public List<Bill> getAllBill() {
				return billDao.getAllBill().stream().filter(bill->bill.getPrice()>13000).collect(Collectors.toList());
	}
	
	public String storeBill(Bill bill) {
		if(bill.getPrice()>10000) {
				if(billDao.storeBill(bill)>0) {
					return "Record stored successfully";
				}else {
					return "Record didn't store";
				}
		}else {
			return "Salary must > 10000";
		}
	}
	
	public String deleteBill(int BId) {
			int res = billDao.deleteBill(BId);
				if(res==1) {
					return "Record deleted successfully";
				}else if(res==2) {
					return "Exception generated";
				}else {
					return "Record didn't find";
				}
			} 
	
	public boolean updateBill(int i , double price) {
        if(billDao.updateBill(i,price) > 0) {
            return true;
        }else {
            return false;
        }
	}
}
