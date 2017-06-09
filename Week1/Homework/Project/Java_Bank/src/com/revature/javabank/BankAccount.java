package com.revature.javabank;

public class BankAccount {
	 private int bankAccountNumber;

	 private String customerName;

	 private double balance;

	//No-args constructor
	public BankAccount()
	{
		this.bankAccountNumber = 0;
		this.customerName = "default";
		this.balance = 0.0;
	}
	
	//Constructor using the member variables
	public BankAccount(int bankAccountNumber, String customerName, double balance) {
		super();
		this.bankAccountNumber = bankAccountNumber;
		this.customerName = customerName;
		this.balance = balance;
	}
	
	//Getters and Setters
	public int getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(int bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	//1:John:120.5
	//Set toString to correct format for writing into file
	@Override
	public String toString() {
		return bankAccountNumber + ":" + customerName + ":" + balance;
	}
	 
	

}
