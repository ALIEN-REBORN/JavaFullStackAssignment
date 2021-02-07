package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;
import com.resource.DbResource;

public class ProductDao {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
			public int storeProduct(Product pro) {
				try {
					con = DbResource.getDbConnection();
					pstmt = con.prepareStatement("insert into product values(?,?,?)");
					pstmt.setInt(1, pro.getPid());
					pstmt.setString(2, pro.getPname());
					pstmt.setFloat(3, pro.getPrice());
					return pstmt.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					return 0;
				}
			}
			
			
			public int deleteProduct(int pid) {
				try {
					con = DbResource.getDbConnection();
					pstmt = con.prepareStatement("delete from product where pid = ?");
					pstmt.setInt(1, pid);
					return pstmt.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					return 2;
				}
			}
			
			public List<Product> getAllProduct() {
			List<Product> listOfPro = new ArrayList<>();
				try {
					con = DbResource.getDbConnection();
					pstmt = con.prepareStatement("select * from product");
					rs = pstmt.executeQuery();
					while(rs.next()) {
						Product pro = new Product();
						pro.setPid(rs.getInt(1));
						pro.setPname(rs.getString(2));
						pro.setPrice(rs.getFloat(3));
						listOfPro.add(pro);
					}
				} catch (Exception e) {
					System.err.println(e);
					return null;
				}
				return listOfPro;
			}

}
