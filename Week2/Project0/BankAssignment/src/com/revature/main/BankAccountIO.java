package com.revature.main;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.Bank.BankAccount;
import com.revature.Bank.BankAccountFactory;
import com.revature.IO.Console.ConsoleIO;
import com.revature.IO.File.FileIO;

public class BankAccountIO {
	private static Logger logger = Logger.getLogger(BankAccountIO.class);
	public static void main(String[] args) {
		ConsoleIO cio = new ConsoleIO();
		FileIO fio = new FileIO("account.txt");
		BankAccountFactory factory = new BankAccountFactory();
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		//Gather info from user
		cio.write("Enter account information in the following format");
		cio.write("accountNumber:customerName:Balance");
		cio.write("Submit an empty line or type q or quit to finish entering information");
		boolean inEnterPhase = true;
		String input;
		ArrayList<String> info = new ArrayList<String>();
		while(inEnterPhase)
		{
			input = cio.read();
			if(input.isEmpty() || input.toLowerCase().equals("q") || input.toLowerCase().equals("quit"))
			{
				inEnterPhase = false;
			}else
			{
				info.add(input);
			}
		}
		//Make and store bank accounts in file
		accounts = factory.getBankAccounts(info);
		ArrayList<Object> objects = new ArrayList<Object>();
		for(BankAccount a : accounts)
		{
			objects.add(a);
		}
		try {
			fio.write( new ArrayList<Object>(objects));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Get the file and print out the results
		try {
			info = fio.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cio.write(info);
		
	}
	

}
