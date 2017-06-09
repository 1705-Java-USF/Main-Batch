package com.java.JavaProject0;

public class BankAccount {
	
	 private int bankAccountNumber;
	 private String customerName;
	 private double balance;
	 
	 public BankAccount(int bankAccountNumber, String customerName, double balance){
			this.bankAccountNumber = bankAccountNumber;
			this.customerName = customerName;
			this.balance = balance;
		}
	 
	public int getBankAccountNumber(int bankAccountNumber) {
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
	
	@Override
	public String toString(){
		return bankAccountNumber + ":" + customerName + ":" + balance;
		
	}
	
	 
}
