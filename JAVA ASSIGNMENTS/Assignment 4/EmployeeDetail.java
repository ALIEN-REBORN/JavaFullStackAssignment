// ASSIGNMENT 4

import java.util.Scanner;

class Employee{
	int id;
	String name;
	double salary;

	 Scanner sc = new Scanner(System.in);
	 Address addr = new Address();
	
	void read() {
		System.out.println("Enter the Id of Employee");
		id=sc.nextInt();
		System.out.println("Enter the Name of Employee");
		name=sc.next();
		System.out.println("Enter the Salary of Employee");
		salary=sc.nextDouble();
	}

	void calsalary() {
		double hra,da,pf;

	     hra = salary*1/10;
	     da = salary*7/100;
	     pf = salary*5/100;

	     salary = salary+hra+da-pf;
	 	 System.out.println("Employee Salary is = "+salary);
	}

	void display() {
		System.out.println("Employee Id is = "+id);
		System.out.println("Employee Name is = "+name);
	
	}
}

class Manager extends Employee{
	int noofmgr;

	void readmgr() {
		System.out.println("Enter Number of Managers");
		noofmgr=sc.nextInt();
		addr.readaddr();
	}

	void dismgr() {
		System.out.println("Number of Managers are = "+noofmgr);
		addr.displayaddr();
	}
}

class Programmer extends Employee{
	String project;

	void readprog() {
		System.out.println("Enter the Project Name");
		project=sc.next();
		addr.readaddr();
	}

	void disprog() {
		System.out.println("The project Name is "+project);
	}
}

class Address{

	String city,state;
	int pincode;
	Scanner obj=new Scanner(System.in);

	void readaddr() {
		System.out.println("Name of the City. They are Currently Working");
		city=obj.next();
		System.out.println("State of the City");
		state=obj.next();
		System.out.println("Pincode of City");
		pincode=obj.nextInt();
	}
	
	void displayaddr() {
		System.out.println("Name of City. They are Currently working = "+city);
		System.out.println("State of the City is = "+state);
		System.out.println("Pincode of City is = "+pincode);
	}
}


public class EmployeeDetail {
	public static void main(String[] args) {

	  System.out.println("Manager details  ");
      Manager mgr=new Manager();
      mgr.read();
      mgr.readmgr();
      mgr.calsalary();
      
      System.out.println("\n");

      System.out.println("Programmer details ");
      Programmer prog=new Programmer();
      prog.read();
      prog.readprog();
      prog.calsalary();
	}

}