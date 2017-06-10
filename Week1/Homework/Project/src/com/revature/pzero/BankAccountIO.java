package com.revature.pzero;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankAccountIO {

	final static Logger logger = Logger.getLogger(BankAccountIO.class);

	public final static String FILENAME = "BankData.txt";

	public ArrayList<BankAccount> accounts;
	
	public static BankAccountIO bio;
	
	public static Scanner in;

	public static void main(String[] args) {
		
		
		//Bank Account IO object
		bio = new BankAccountIO();
		

		//Collection of accounts
		bio.accounts = new ArrayList();
		
		//Scanner object
		in = new Scanner(System.in);
		
		bio.readFile();
		try {
			bio.writeFile(FILENAME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("File IO Exception was caught.");
		}
		

		/*
		try {
			
			//Reads from the file to objects
			bio.readFile(FILENAME);
			
			//Writes objects data to a file
			bio.writeFile(FILENAME);
			
			//Logs various exceptions
		} catch (FileNotFoundException e) {
			logger.warn("A File Not Found Exception has occured");
		} catch (IOException e) {
			logger.warn("An I/O Exception has occured");
		} catch (Exception e) {
			logger.warn("An Exception has occured");
		}
		*/
	}

	/*
	public void readFile(String fileName) throws FileNotFoundException,IOException {
		//Stream Reader
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		//will store the current line
		String line;
		
		//reads to the line variable until it is the end of the file
		while ((line = br.readLine()) != null) {
			//splits the line by colons
			String accountValues[] = line.split(":");
			//creates the BankAccount object
			accounts.add(new BankAccount(
					Integer.parseInt(accountValues[0]), 
					accountValues[1], 
					Double.parseDouble(accountValues[2])));
		}
		
		//closes the stream
		br.close();
	}
	*/
	public void readFile(){
		//endless loop
		while(true){
			//prompt for account number
			System.out.println("Enter an account number. -1 to quit");
			int bankAccount = 0;
			if(in.hasNextInt())
			{
				bankAccount = in.nextInt();
				if(bankAccount == -1){
					logger.trace("User Exited Program");
					break;
				}
			}
			//prompt for name
			System.out.println("Enter you name.");
			String name = in.next();
			double balance = 0;
			//prompt for balance
			System.out.println("Enter your balance.");
			while(!in.hasNextDouble()){
				logger.warn("User has entered an invalid set of characters for their balance");
			}
			balance = in.nextDouble();
			bio.accounts.add(new BankAccount(bankAccount, name, balance));
			logger.info("User has added an account");
		}
	}
	
	public int numAccounts(){
		System.out.println(accounts.size());
		return accounts.size();
	}
	
	public void writeFile(String fileName) throws IOException {
		//Stream Writer
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		
		//Goes through each account file...
		for(BankAccount ba : accounts){
			//Appends the objects data to the file
			bw.append(ba.getBankAccountNumber() + ":" +
					ba.getCustomerName() + ":" +
					ba.getBalance() + "\n");
			//logs that the object was written
			logger.debug("Writing account " + ba.getBankAccountNumber() + " to file " + fileName );
		}
		
		//closes the stream
		bw.close();
	}

}
