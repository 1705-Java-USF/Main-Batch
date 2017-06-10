package com.revature.proj0;

import org.apache.log4j.Logger;

public class BankAccount {
	// POJO for bank account

	 final static Logger logger = Logger.getLogger(BankAccount.class);
	 private int bankAccountNumber;
	 private String customerName;
	 private double balance;
	 
	 public BankAccount(String bankNum, String name, String bal) {
		 // if user enters invlaid types for any of the inputs,
		 // it will be logged and defaults values used in place
		 try {
			 this.bankAccountNumber = Integer.parseInt(bankNum);
			 this.customerName = name;
			 this.balance = Double.parseDouble(bal);
		 } catch (NumberFormatException e) {
			 logger.info("invlaid input for bank account information");
		 }
	 }

	@Override
	public String toString() {
		// format to write to the file
		return bankAccountNumber + ":" + customerName + ":" + balance;
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
