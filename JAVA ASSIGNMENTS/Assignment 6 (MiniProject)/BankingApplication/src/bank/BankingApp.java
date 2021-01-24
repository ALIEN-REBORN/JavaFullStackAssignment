package bank;

import java.util.Scanner;

import service.MyBank;

public class BankingApp 
{
	public static void main(String args[]) throws Exception
	{
		Scanner obj = new Scanner(System.in);
		String ch,name;
		int accNo,transAccNo;
		float amount;
		boolean flag=true;
		MyBank myBnk = new MyBank();
		do
		{
			System.out.println("Choose your appropiate option");
			System.out.println("a. Create account");
			System.out.println("  1.Default Details");
			System.out.println("  2.Name and Amount to Deposit");
			System.out.println("b.Check Account Balance");
			System.out.println("c.Withdraw the Amount");
			System.out.println("d.Deposit the Amount");
			System.out.println("e.Transfer the Amount");
			System.out.println("f.Exit");
			System.out.println("Please Choose the appropriate Banking option");

			ch = obj.next();

			switch(ch)
			{
				case "a":
					
					System.out.println("Enter you choice");
					System.out.println("  	1.Default Details");
					System.out.println("  	2.Name and Amount to Deposit");
					int choice=obj.nextInt();
						switch (choice) {
						case 1:{
							System.out.println("Your default account is created ");
							myBnk.accountCreate();
							break;
						}
						case 2:{
							System.out.println("To create account Please Enter Your Name and Amount to Deposit Amount that should be more than 500");
							name = obj.next();
							amount = obj.nextFloat();
							myBnk.accountCreate(name,amount);
							break;
						}
						default:
							System.out.println("Select the correct option");

							break;
						}
				case "b":
							System.out.println(" Enter Your Account Number");
							accNo = obj.nextInt();
							myBnk.checkBalance(accNo);
							break;
				case "c":
							System.out.println(" Enter Your Account Number");
							accNo = obj.nextInt();
							System.out.println(" Enter Amount To Be Withdraw");
							amount = obj.nextFloat();
							myBnk.withdraw(accNo,amount);
							break;
				case "d":
							System.out.println(" Enter Your Account Number");
							accNo = obj.nextInt();
							System.out.println("Enter Amount To Be Deposited");
							amount = obj.nextFloat();
							myBnk.deposit(accNo, amount);
							break;
				case "e":
							System.out.println(" Enter Your Account Number");
							accNo = obj.nextInt();
							System.out.println(" Enter Transfer Account Number");//amount
							transAccNo = obj.nextInt();
							System.out.println(" Enter Amount To Be Transfer");
							amount = obj.nextFloat();
							myBnk.transfer(accNo,transAccNo,amount);
							break;
				case "f":
							System.out.println("Thank You For Chossing Standard Chartered Bank");
							flag=false;
							break;
				default:
					System.out.println();
							System.out.println("Select correct option");

							break;
			}
		}while(flag);
	}
}