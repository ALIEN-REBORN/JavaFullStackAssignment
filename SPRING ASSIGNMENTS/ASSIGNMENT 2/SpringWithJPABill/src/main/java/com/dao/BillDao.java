package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Bill;

@Repository
public class BillDao {
	@Autowired
	EntityManagerFactory emf;
	
	public List<Bill> getAllBill() {
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select e from Bill e");
		List<Bill> listOfBill = qry.getResultList();
		return listOfBill;
	}
	
	public int storeBill(Bill b) {
		EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
				tran.begin();
						manager.persist(b);		// store the product in DB like insert query 
				tran.commit();
				System.out.println("Record Stored Successfully..");
				return 0;
	}
	
	public int deleteBill(int Bid) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		
		Bill b	= manager.find(Bill.class, Bid);			// primary key	if record is available automatically convert record to object 
		if(b==null) {															// select * from product where pid =1
			System.out.println("Bill Is Not Present");
		}else {
			tran.begin();
						manager.remove(b);						// delete from product where pid = 1;
			tran.commit();
			System.out.println("Bill Record Deleted Successfully");
		}
		return Bid;
	}
	
	public int updateBill(int Bid, double salary) {
		
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		
		Bill bill = manager.find(Bill.class, Bid);			// primary key
		if(bill==null) {
			System.out.println("Bill is not present");
		}else {
			tran.begin();
						bill.setPrice((float) (bill.getPrice()+salary));
						manager.merge(bill);									//update price using pid column 
			tran.commit();
			System.out.println("Bill Record updated successfully");
		}
		return 0;
	}
	
	public List<Bill> getAllBillByPrice(float price) {
		
		EntityManager manager = emf.createEntityManager();
			Query qry = manager.createQuery("select b from Bill b where b.Price > ?4");
			qry.setParameter(6, price);
			List<Bill> listOfBill = qry.getResultList();
			return listOfBill;
	}
}
