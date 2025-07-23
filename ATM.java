package com.raj.BankApplictionException;

import java.util.Scanner;

public class ATM 
{
	public static void main(String[] args) 
	{
		BankAccount account1 = new BankAccount(123456,10000);
		BankAccount account2 = new BankAccount(987654,20000);
		Customer customer1 = new Customer("Rajesh", account1);
		Customer customer2 = new Customer("Rocky", account2);
		
		Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("Select an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Loan Application");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your option: ");
            int option = scanner.nextInt();
            double amount;
            BankAccount toAccount;
            try 
            {
                switch (option) 
                {
                    case 1: // Deposit
                        System.out.print("Enter amount to deposit: ");
                        amount = scanner.nextDouble();
                        customer1.getAccount().deposit(amount);
                        System.out.println("Deposit successful. Current balance: " + customer1.getAccount().getBalance());
                        break;

                    case 2: // Withdraw
                        System.out.print("Enter amount to withdraw: ");
                        amount = scanner.nextDouble();
                        customer1.getAccount().withdraw(amount);
                        System.out.println("Withdrawal successful. Current balance: " + customer1.getAccount().getBalance());
                        break;

                    case 3: // Transfer
                        System.out.print("Enter amount to transfer: ");
                        amount = scanner.nextDouble();
                        toAccount = customer2.getAccount(); // Assuming transfer to customer2's account
                        customer1.getAccount().transfer(toAccount, amount);
                        System.out.println("Transfer successful. Your balance: " + customer1.getAccount().getBalance());
                        System.out.println("Recipient's balance: " + customer2.getAccount().getBalance());
                        break;

                    case 4: // Loan Application
                        System.out.print("Enter loan amount: ");
                        amount = scanner.nextDouble();
                        customer1.getAccount().applyForLoan(amount);
                        System.out.println("Loan approved. Current balance: " + customer1.getAccount().getBalance());
                        break;

                    case 5: // Check Balance
                        System.out.println("Current balance: " + customer1.getAccount().getBalance());
                        break;

                    case 6: // Exit
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
            catch (InsufficientFundsException | InvalidAmountException | AccountNotFoundException | LoanNotAllowedException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

	