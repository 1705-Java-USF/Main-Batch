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

	public static void main(String[] args) throws IOException {
		String fileName = "accounts.txt";
		int userReadOrWrite = askUserToReadOrWrite();
		if(userReadOrWrite == 1)							// User enters 1 to read.
			readFile(fileName);
		else												// User enters 2 to write.
			writeFile(fileName);
	}

	private static int askUserToReadOrWrite() {
		final Scanner scan = new Scanner(System.in);
		int num;
		logger.debug("User Input: Begin");
		while(true) {
			try {
				System.out.print("Enter 1 or 2 for read and write file, respectively: ");
				num = scan.nextInt();
				if(num == 1 || num == 2) {
					logger.debug("User Input: 1 or 2 inputted.");
					scan.close();
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
	
	private static void writeFile(String fileName) throws IOException {
		BufferedWriter bw = null;
		logger.trace("Adding 3 accounts to collection.");
		
		// Add 3 accounts to collection.
		List<BankAccount> bankAccounts = new ArrayList<>();
		bankAccounts.add(new BankAccount(1, "John", 3000.23));
		bankAccounts.add(new BankAccount(2, "Hunter", 248.44));
		bankAccounts.add(new BankAccount(3, "Elmo", 1009.98));
		logger.trace("Added 3 accounts to collection.");
		logger.debug("Write File: Begin");
		
		// Write 3 accounts to file.
		try {
			bw = new BufferedWriter(new FileWriter(fileName));
			for(BankAccount ba : bankAccounts) {
				bw.write(String.valueOf(ba.getBankAccountNumber()) + ":");
				bw.write(ba.getCustomerName() + ":");
				bw.write(String.valueOf(ba.getBalance()) + "\n");
			}
			logger.debug("Write File: Success");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null)
				bw.close();
		}
	}
}