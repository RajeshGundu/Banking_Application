package com.raj.BankApplictionException;

public class Customer 
{
	@SuppressWarnings("unused")
	private String customerName;
	private BankAccount account;
	
	public Customer(String customerName, BankAccount account) 
	{
		super();
		this.customerName = customerName;
		this.account = account;
	}

	protected BankAccount getAccount()
	{
		return account;
	}	
}
