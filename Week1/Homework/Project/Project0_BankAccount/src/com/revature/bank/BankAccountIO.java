package com.revature.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankAccountIO {
	final static Logger logger = Logger.getRootLogger();
	final static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String fileName = "accounts.txt";
		int userReadOrWrite = askUserToReadOrWrite();
		if(userReadOrWrite == 1)							// User enters 1 to read.
			readFile(fileName);
		else												// User enters 2 to write.
			writeFile(fileName);
	}

	private static int askUserToReadOrWrite() {
		int num;
		logger.debug("User Input: Begin");
		while(true) {
			try {
				System.out.print("Enter 1 or 2 for read and write file, respectively: ");
				num = scan.nextInt();
				if(num == 1 || num == 2) {
					logger.debug("User Input: " + num + " inputted.");
					return num;										// If number is valid (i.e., 1 or 2), return.
				}
			} catch(InputMismatchException e) {	}					// Otherwise, ask user to enter a valid number.
			logger.trace("User Input: 1 or 2 not entered.");
			System.out.println("Please enter 1 or 2.\n");
			scan.nextLine();										// Consume
		}
	}

	private static void readFile(String fileName) throws IOException {
		BufferedReader br = null;
		String line;
		String[] accountValues = null;
		logger.debug("Read File: Begin");
			
		try {
			br = new BufferedReader(new FileReader(fileName));
			
			while( (line = br.readLine()) != null) {				// Split each line by : and syso.
				accountValues = line.split(":");
				System.out.println("Account #: " + accountValues[0]);
				System.out.println("Name: " + accountValues[1]);
				System.out.println("Balance: " + accountValues[2] + "\n");
				logger.trace("Read Account #" + accountValues[0]);
			}
			logger.debug("Read File: Success");
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException thrown", e);
		} catch (IOException e) {
			logger.error("IOException thrown", e);
		} finally {
			if (br != null)
				br.close();
		}
	}
	
	static void writeFile(String fileName) throws IOException {
		BufferedWriter bw = null;
		List<BankAccount> bankAccounts = new ArrayList<>();
		
		// Ask user to create accounts.
		bankAccounts = createBankAccounts();
		
		// Write accounts to file.
		logger.debug("Write File: Begin");
		try {
			bw = new BufferedWriter(new FileWriter(fileName));
			for(BankAccount ba : bankAccounts) {
				bw.write(String.valueOf(ba.getBankAccountNumber()) + ":");
				bw.write(ba.getCustomerName() + ":");
				bw.write(String.valueOf(ba.getBalance()) + "\n");
			}
			logger.debug("Write File: Success");
			System.out.println("Accounts successfully written to file.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null)
				bw.close();
		}
	}
	
	private static List<BankAccount> createBankAccounts() {
		List<BankAccount> bankAccounts = new ArrayList<>();
		System.out.print("How many accounts do you want to enter: ");
		int limit = scan.nextInt();
		
		// Ask for name and balance for each account, add to list, return to writer.
		for(int i = 1; i <= limit; i++) {
			scan.nextLine();			// Consume
			System.out.print("Enter name: ");
			String name = scan.nextLine();
			System.out.print("Enter balance: ");
			double balance = scan.nextDouble();
			
			bankAccounts.add(new BankAccount(i, name, balance));
			logger.trace(i + " auto-assigned to new account owner " + name);
		}
		return bankAccounts;
	}
	
}