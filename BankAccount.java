package com.raj.BankApplictionException;


@SuppressWarnings("unused")
public class BankAccount implements Bank
{
	private long accountNumber;
	private double balance;

	public BankAccount(long accountNumber, double balance) 
	{
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) throws InvalidAmountException 
	{
		if(amount<=0)
		{
			throw new InvalidAmountException("Deposit amount must be greater than zero.");
		}
		balance=balance+amount;
	}

	@Override
	public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException 
	{
		if(amount<=0)
		{
			throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
		}
		if(amount>balance)
		{
			throw new InsufficientFundsException("Insufficient funds for withdrawal.");
		}
		balance=balance-amount;
	}

	@Override
	public void transfer(BankAccount toAccount, double amount)
			throws InsufficientFundsException, AccountNotFoundException, InvalidAmountException 
	{
		if(toAccount==null)
		{
			throw new AccountNotFoundException("Target account not found.");
		}
		if(amount <=0)
		{
			throw new InvalidAmountException("Transfer amount must be greater than zero.");
		}
		if(amount>balance)
		{
			throw new InsufficientFundsException("Insufficient funds for transfer.");
		}
		this.withdraw(amount);
		toAccount.deposit(amount);
	}
	
	@Override
	public void applyForLoan(double amount) throws LoanNotAllowedException, InvalidAmountException 
	{
		if(amount<=0)
		{
			throw new InvalidAmountException("Loan amount must be greater than zero.");
		}
		if(amount>50000)
		{
			throw new LoanNotAllowedException("Loan amount exceeds the allowed limit of 50000.");
		}
		if(balance<50000)
		{
			throw new LoanNotAllowedException("Balance must be at least 50000 to apply for a loan.");
		}
		balance=balance + amount;
	}

	@Override
	public double getBalance() 
	{
		return balance;
	}
}
