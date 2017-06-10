package com.revature.bankaccount;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountIO {
	final static Logger logger = Logger.getLogger(BankAccountIO.class);
	public static BufferedReader br;
	public static BufferedWriter bw;
	public final static String FILEPATH = "Bank Accounts.txt";
	
	public static void main(String[] args) throws IOException {
		//Erase contents to make 3 bank accounts for assignment
		logger.trace("===Erasing File Contents For Assignment===");
		bw = new BufferedWriter(new FileWriter(FILEPATH));
		bw.write("");
		bw.close();
		
		BankAccountIO ba = new BankAccountIO();
		//Loop through writeAccount 3 times
		for(int i=0; i<3; i++) {
			logger.trace("===CALLING WRITE METHOD===");
			ba.writeAccount(FILEPATH);
		}
		
		//Read the Bank Accounts file.
		logger.trace("===CALLING READ METHOD===");
		ba.readAccount(FILEPATH);
	}
	
	public void readAccount(String filePath) throws IOException {
		try {
			br = new BufferedReader(new FileReader(filePath));
			
			String str;
			//While there's lines left in the file, read each line in and separate the information
			while((str = br.readLine()) != null) {
				String[] arr = str.split(":");
				System.out.println("Account Number: " + arr[0]);
				System.out.println("Customer Name: " + arr[1]);
				System.out.println("Balance: " + arr[2] + "\n");
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException thrown!");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException thrown!");
			e.printStackTrace();
		} finally {
			if(br != null)
				br.close();
		}
	}
	
	public void writeAccount(String filePath) throws IOException {
		//Collection used to store bank accounts
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		logger.info("====Entering information for bank account====");
		Scanner scan = new Scanner(System.in);
		
		//Ask for integer for the bank account to be written
		System.out.println("Enter the bank account number");
		while(!scan.hasNextInt())
			scan.next();
		int accountNumber = scan.nextInt();
		
		//nextLine is called to get rid of the new line character after the integer
		scan.nextLine();
		
		//Ask for a String for the customer's name
		System.out.println("Enter the customer's name");
		String name = scan.nextLine();
		
		//Ask for a double to store the account's balance.
		System.out.println("Enter the account's balance");
		while(!scan.hasNextDouble())
			scan.next();
		double balance = scan.nextDouble();
		
		//Add the new BankAccount to the collection
		accounts.add(new BankAccount(accountNumber, name, balance));
		
		try {
			bw = new BufferedWriter(new FileWriter(filePath, true));
			
			//While the collection has BankAccounts in it, write them to the file and remove them.
			while(accounts.size() > 0) {
				String str = "";
				//Combine the information in the format given by the assignment
				str += accounts.get(0).getBankAccountNumber() + ":" +
				accounts.get(0).getCustomerName() + ":" + accounts.get(0).getBalance() + "\n";
				logger.info("String added to file: " + str);
				
				//Write the string to the file and remove the bank account from the arraylist
				bw.write(str);
				accounts.remove(0);
			}
		} catch (IOException e) {
			logger.error("IOException thrown!");
			e.printStackTrace();
		} finally {
			if(bw != null)
				bw.close();
		}
	}
}
