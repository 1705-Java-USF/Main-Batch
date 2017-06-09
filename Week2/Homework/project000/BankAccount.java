/* Demetrus Atkinson */
package com.revature.project000;

/* BankAccount class for creating objects of BankAccount. The construct takes three (and only three) arguments
 * the toString() method is overridden for user readable output
 */
public class BankAccount {
	// variables cannot be accessed directly (encapsulation)
	private long bankAccountNumber;
	private String customerName;
	private double balance;

	public BankAccount(int bankAccountNumber, String customerName, double balance) {

		this.customerName = customerName;
		this.bankAccountNumber = bankAccountNumber;
		this.balance = balance;

	}

	// getters and setters are used for the account number, name and balance
	// (more encapsulation)
	public long getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(long bankAccountNumber) {
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

	// String class is overridden
	public String toString() {
		return bankAccountNumber + ":" + customerName + ":" + balance;
	}

}