// ASSIGNMENT 4

import java.util.Scanner;

class Employee{
	int id;String name;double salary;
	 Scanner sc=new Scanner(System.in);
	 Address add=new Address();
	void read() {
		System.out.println("Enter the id of employee");
		id=sc.nextInt();
		System.out.println("Enter the name of employee");
		name=sc.next();
		System.out.println("Enter the salary of employee");
		salary=sc.nextDouble();
	}
	void calsalary() {
		double hra,df,pa;
	     hra=salary*1/10;
	     df=salary*7/100;
	     pa=salary*5/100;
	     salary=salary+hra+df+pa;
	 	System.out.println("salary of employee is "+salary);
	     }
	void display() {
		System.out.println("id of employee is "+id);
		System.out.println("name of employee is "+name);
	
	}
}

class Manager extends Employee{
	int noofmanagers;
	void readmgr() {
		System.out.println("Enter number of managers");
		noofmanagers=sc.nextInt();
		add.readadd();
	}
	void dismgr() {
		System.out.println("Number of managers are "+noofmanagers);
		add.displayadd();
	}
}

class Programmer extends Employee{
	String projectname;
	void readpgr() {
		System.out.println("Enter the project name");
		projectname=sc.next();
		add.readadd();
	}
	void dispgr() {
		System.out.println("The project name is "+projectname);
	}
}
class Address{
	String city,state;
	int pincode;
	Scanner obj=new Scanner(System.in);
	void readadd() {
		System.out.println("Name of city they are working is ");
		city=obj.next();
		System.out.println("State of city is");
		state=obj.next();
		System.out.println("Pincode of city is");
		pincode=obj.nextInt();
	}
	void displayadd() {
		System.out.println("Name of city they are working  "+city);
		System.out.println("State of city is "+state);
		System.out.println("Pincode of city is "+pincode);
	}
}


public class EmployeeDetail {

	public static void main(String[] args) {

	  System.out.println("Manager details  ");
      Manager mg=new Manager();
      mg.read();
      mg.readmgr();
      mg.calsalary();
      
      System.out.println("\n");
      System.out.println("Programmer details ");
      Programmer pg=new Programmer();
      pg.read();
      pg.readpgr();
      pg.calsalary();
	}

}