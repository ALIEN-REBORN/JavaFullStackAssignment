package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import bean.Product;
import service.ProductService;

public class ProductOperations {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int k,num,temp,ch=0;
		String name;
		float price;
		boolean flag = true;
		int a = 1,id;
	
		ProductService ps = new ProductService();
	    ArrayList<Product> al=new ArrayList<Product>();
		
		
		do
		{
			System.out.println("Enter the Correct Option");
			System.out.println("1. Add Product");
			System.out.println("2. Update the Product Price");
			System.out.println("3. Delete the Product");
			System.out.println("4. View All Product");
			System.out.println("5. View Price of the Product");
			System.out.println("6. Exit");
			
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1:
						al = ps.displayAllProduct();
						
						Iterator it1 = al.iterator();
						System.out.println("\n Enter Your Product Name and Price");
						name = sc.next();
						price = sc.nextFloat();
						boolean inflag = true;
						while(it1.hasNext())
						{
							Product pdt = (Product)it1.next();
							if(pdt.getPname().equals(name))
							{
								System.out.println(" This Product already Registered : " + pdt.getPname());
								System.out.println();
								inflag=false;
								break;
							}						
						}
						
						if(inflag)
						{
							id = ps.addproduct(a,name, price);
							a++;
							System.out.println("\n Please Note Your Product Id : " + id);
							ch=0;
						}
						break;
						
				case 2:
						System.out.println("Enter Your Product Id");
						id = sc.nextInt();
						System.out.println("Enter Your Product Price");
						price = sc.nextFloat();
						ps.updateProduct(id, price);
						System.out.println("\n Product Price Updated");
						break;
						
				case 3:
						System.out.println("Enter Your Product Id");
						id = sc.nextInt();
						ps.deleteProduct(id);
						System.out.println("\n Product Deleted");
						break;
						
				case 4:
						al = ps.displayAllProduct();
						Iterator it = al.iterator();
						while(it.hasNext())
						{
							System.out.println(it.next()); ;
						}
						break;
						
				case 5:
						System.out.println("\n Enter Your Product Id");
						id = sc.nextInt();
						System.out.println(ps.retrieveProductPrice(id));
						break;
						
				case 6:
						break;
						
				default:
					
						System.out.println("\n Enter Appropriate option");
						
			}
			
		    try
	        {
	            FileOutputStream fos = new FileOutputStream("EmployeeRecords");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(al);
	            oos.close();
	            fos.close();
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	        }
			
		}while(flag);
		System.out.println("test1");

	}
}