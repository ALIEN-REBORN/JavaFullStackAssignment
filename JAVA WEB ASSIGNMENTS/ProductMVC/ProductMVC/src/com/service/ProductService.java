package com.service;

import java.util.List;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductService {

ProductDao pd =new ProductDao();
	
	public String storeProduct(Product pro) {
		if(pro.getPrice()>10000) {
				if(pd.storeProduct(pro)>0) {
					return "Record stored successfully";
				}else {
					return "Record didn't store";
				}
		}else {
			return "Price must > 10000";
		}
	}
	
	public String deleteProduct(int Pid) {
			int res = pd.deleteProduct(Pid);
				if(res==1) {
					return "Record deleted successfully";
				}else if(res==2) {
					return "Exception generated";
				}else {
					return "Record didn't find";
				}
			}
	
	public List<Product> getAllProduct() {
		return pd.getAllProduct();
	}
}
