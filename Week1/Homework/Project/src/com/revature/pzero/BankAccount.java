package com.revature.pzero;

import org.apache.log4j.Logger;

public class BankAccount {

	// BankAccount logger
	final static Logger logger = Logger.getLogger(BankAccount.class);

	// variables
	private int bankAccountNumber;
	private String customerName;
	private double balance;

	// Empty Constructor
	public BankAccount() {
		logger.trace("Blank Bank Account Added");
		this.bankAccountNumber = 0;
		this.customerName = "";
		this.balance = 0f;
	}

	public BankAccount(int ban, String cn, double b) {
		//logs the files data and stores it in the object
		logger.trace("Bank Account " + ban + " added");
		logger.trace(ban + ": Customer Name is " + cn);
		logger.trace(ban + ": Balance is " + b);
		this.bankAccountNumber = ban;
		this.customerName = cn;
		this.balance = b;
	}

	// Getters and Setters
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
