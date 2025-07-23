package com.raj.BankApplictionException;

@SuppressWarnings("serial")
public class LoanNotAllowedException extends Exception
{

	public LoanNotAllowedException(String message) 
	{
		super(message);
	}	
}
