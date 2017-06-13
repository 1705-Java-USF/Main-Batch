package project0;

import java.util.Scanner;
import org.apache.log4j.*;;

public class AccountInfo {
	
	final static Logger logger = Logger.getLogger(AccountInfo.class);
	Scanner input = new Scanner(System.in);

	private int bankAccountNumber;
	private String customerName;
	private double balance;
	 
	@Override           // Overriding toString method
	public String toString() {   
		return bankAccountNumber + ":" + customerName + ":" + balance;
	}

	public int getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(int bankAccountNumber) {

		logger.info("Please input your bank account >> ");

		while (!input.hasNextInt()) {           // data validation for int only
			logger.info("That's not a valid account. Only enter numbers >> ");
			input.next();
		}

		this.bankAccountNumber = input.nextInt();  // setter

	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		
		logger.info("Please input your name >> ");          

		while (!input.hasNext("[A-Za-z]+")) {      // data validation for characters only
			logger.info("That's not a valid name. Please enter characters only >> ");
			input.next();
		}

		this.customerName = input.next();
	}

	public double getBalance() {
		return balance;
	}

	

	public void setBalance(double balance) {
		
		logger.info("Please input your balance >> ");

		while (!input.hasNextDouble()) {            // data validation for double
			logger.info("That's not a valid input. Only enter numbers >> ");
			input.next();
		}

		this.balance = input.nextDouble();
	}
	
	
}
