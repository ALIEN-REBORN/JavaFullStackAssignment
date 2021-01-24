package service;

import bean.Account;

abstract class AccountInitialize
{
	public static int acccnt=0,count=0;
	public static int accNo = 101;
	public static int accNoCopy = 101;
	public Account account[] = new Account[10];
	public String name;
	public float amount;
	public static int i=0,j=0;

	public void accountCreate()
	{
		if(acccnt<10)
		{
			name = "Unknown";
			amount = 500;
			account[i] = new Account(accNo,name,amount);
			accNo++;
			i++;
			acccnt++;
		}
		else
		{
			count=1;
			System.out.println("\n Account Capacity Already Reached To Limit");
		}
	}

	public void accountCreate(String name, float amount)
	{
		if(count<10)
		{
			if(amount>500.0f)
			{
				this.name = name;
				this.amount = amount;
				account[j].setAccno(this.accNoCopy);
				account[j].setName(this.name);
				account[j].setAmount(this.amount);
				System.out.println("Name : " + account[j].getName());
				System.out.println("Account Number : " + account[j].getAccno());
				accNoCopy++;
				count++;
				j++;
			}
			else
			{
				throw new ArithmeticException("\nDeposited amount should be greater than 500"); 
			}
		}
		else
		{
			throw new ArithmeticException("\n Account Capacity Already Reached To Limit");
		}
	}

	abstract void transfer(int fromAccNo , int toAccNo, float amount);
}