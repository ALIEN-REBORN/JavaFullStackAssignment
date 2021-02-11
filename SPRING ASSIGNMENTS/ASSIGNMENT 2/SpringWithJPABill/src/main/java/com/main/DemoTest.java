package com.main;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Bill;
import com.dao.BillDao;
import com.service.BillService;

import antlr.collections.List;

public class DemoTest {

	public static void main(String[] args) {
		
		int choice;
		
		do 
		{
			System.out.println("Select the Choice");
			System.out.println("\n 1. Insert \n 2. Display \n 3. Update \n 4. Delete \n 5. Retrieve ");
			Scanner sc=new Scanner(System.in);
			
			ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
			BillService bs = (BillService)ac.getBean("billService");
			
			choice=sc.nextInt();
			
			switch(choice)
			{
						
			case 1:
					//Display All Records
					bs.getAllBill().forEach(bill->System.out.println(bill));
					break;

			case 2:
					//Insert
					Bill b = new Bill();
					b.setBid(107);
					b.setEname("Arun");
					b.setCname("Mahesh");
					b.setPname("PS4");
					b.setQty(1);
					b.setPrice(43000);
					LocalDate date = LocalDate.now();
					b.setDOP(date);
					BillDao bd = (BillDao)ac.getBean("billDao");
					int res = bd.storeBill(b);
					if(res>0) {
						System.out.println("Bill Inserted Success");
					}else {
						System.out.println("Bill Not Inserted Success");
					}
					break;
					
			case 3:
					//Delete
					BillDao bd1 = (BillDao)ac.getBean("billDao");
					int res1 = bd1.deleteBill(4);
					if(res1>0) {
						System.out.println("Deleted Success");
					}else {
						System.out.println("Not Deleted");
					}
					break;

			case 4:
					//Update
					if(bs.updateBill(4,7000)) {
						System.out.println("Update Success");
					}else {
						System.out.println("Not Update");
					}
					break;
						
			}
		}while(choice<6);
	}

}
