package com.aseda;
import java.util.Scanner;

public class BankAccount {
	private String customerName;
	private String customerId;
	private int balance = 0;
	private int previousTransaction;
	
	public BankAccount(String customerName, String customerId) {
		this.customerName = customerName;
		this.customerId = customerId;
	}
	
	public void deposit(int amount) {
		if(amount != 0) {
			this.balance += amount;
			this.previousTransaction = amount;
		}
	}
	
	public void withdraw(int amount) {
		if(amount != 0) {
			this.balance -= amount;
			this.previousTransaction = -amount;
		}
	}
	
	public void getPreviousTransaction() {
		if(this.previousTransaction > 0) {
			System.out.println("Deposit: " + this.previousTransaction);
		}
		else if(this.previousTransaction < 0) {
			System.out.println("Withdrawal: " + Math.abs(this.previousTransaction));
		}
		else {
			System.out.println("No transaction occurred");

		}
	}
	
	public void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " + this.customerName);
		System.out.println("Your ID is " + this.customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("=======================================");
			System.out.println("Enter an option: ");
			System.out.println("=======================================");
			option = scanner.next().charAt(0);
			
			switch(option) {
			case 'A':
				System.out.println("=======================================");
				System.out.println("Your available balance is: " + this.balance);
				System.out.println("=======================================");
				break;
				
			case 'B':
				System.out.println("=======================================");
				System.out.println("Please enter amount to be deposited:");
				int amount = scanner.nextInt();
				this.deposit(amount);
				System.out.println("=======================================");
				break;

			case 'C':
				System.out.println("=======================================");
				System.out.println("Please enter amount to be withdrawn: ");
				int amount2 = scanner.nextInt();
				this.withdraw(amount2);
				System.out.println("=======================================");
				break;

			case 'D':
				System.out.println("=======================================");
				this.getPreviousTransaction();
				System.out.println("=======================================");
				break;

			case 'E':
				System.out.println("***************************************");
				break;
				
			default:
				System.out.println("Invalid option! Please select a valid option");
			}

		}while(option != 'E');

		
		System.out.println("Thank you for using our services");
		scanner.close();


	}
	
}
