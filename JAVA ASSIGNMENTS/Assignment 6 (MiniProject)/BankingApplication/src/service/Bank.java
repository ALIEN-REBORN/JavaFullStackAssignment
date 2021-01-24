package service;

public interface Bank
{
	void withdraw(int accno, float amount);
	void deposit(int accno, float amount);
	void checkBalance(int accno);
}