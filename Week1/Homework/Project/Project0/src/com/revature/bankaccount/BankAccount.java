package com.revature.bankaccount;
//BankAccount POJO
public class BankAccount {
	private int bankAccountNumber;
	private String customerName;
	private double balance;
	
	public BankAccount(int bankAccountNumber, String customerName, double balance) {
		super();
		this.bankAccountNumber = bankAccountNumber;
		this.customerName = customerName;
		this.balance = balance;
	}

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
	
}
