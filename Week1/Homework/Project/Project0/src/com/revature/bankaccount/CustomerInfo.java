package com.revature.bankaccount;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerInfo implements Serializable {
	
	private int bankAccountNumber;
	private String Name;
	private double balance;

	public CustomerInfo(int bankAccountNumber, String Name, double balance) {
		super();
		this.bankAccountNumber = bankAccountNumber;
		this.Name = Name;
		this.balance = balance;
	}

	public int getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(int bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
		
	
		
}

