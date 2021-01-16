// Program 3

import java.util.*;
class Emp
{
	int n;
	Emp(int size)
	{
		id = new int [size];
		name = new String [size];
		salary = new double [size];
		desg = new String [size];
	}
	int id[];
	String name[];
	double salary[];
	String  desg[];

	void read(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee Details");

		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Employee "+(i+1)+" Record");
			System.out.println(id.length);
			System.out.println("Enter Id of Employee = ");
			id[i] = sc.nextInt();
			System.out.println("Enter Name of Employee = ");
			name[i] = sc.next();
			System.out.println("Enter Salary of Employee = ");
			salary[i] = sc.nextDouble();
			System.out.println("Enter Designation of Employee = ");
			desg[i] = sc.next();
		}
	}

	void calSalary(){
		double bonus,hra,pf,da;
		for(int i=0;i<n;i++)
		{
			if(desg[i].equals("Manager")){
				bonus = salary[i]*15/100;
			}else if(desg[i].equals("Programmer")){
				bonus = salary[i]*10/100;
			}else {
				bonus = salary[i]*5/100;
			}
			hra = salary[i]*10/100;
			da = salary[i]*7/100;
			pf = salary[i]*5/100;
			salary[i] = salary[i]+hra+da-pf;
		}
	}

	void display()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println("Employee "+(i+1)+"Record");
			System.out.println("Employee Id "+id[i]);
			System.out.println("Employee Name "+name[i]);
			System.out.println("Employee Salary "+salary[i]);
			System.out.println("Employee Designation "+desg[i]);
		}
	}
}

class Employee{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size of the Array = ");
		int size = sc.nextInt();
		Emp emp = new Emp(size);
		emp.read();
		emp.calSalary();
		emp.display();
	}
}