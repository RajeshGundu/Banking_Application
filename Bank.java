package com.raj.BankApplictionException;

import java.security.InvalidAlgorithmParameterException;

public interface Bank 
{
	void deposit(double amount)throws InvalidAmountException;
	void withdraw(double amount)throws InsufficientFundsException,InvalidAmountException;
	void transfer(BankAccount toAccount,double amount)throws InsufficientFundsException,AccountNotFoundException,InvalidAmountException;
	void applyForLoan(double amount)throws LoanNotAllowedException,InvalidAmountException, InvalidAlgorithmParameterException;
	double getBalance();
}
