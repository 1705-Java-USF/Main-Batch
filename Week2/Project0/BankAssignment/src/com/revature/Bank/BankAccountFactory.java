package com.revature.Bank;

import java.io.BufferedReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;



public class BankAccountFactory {
	private Logger logger = Logger.getLogger(BankAccountFactory.class);
	public BankAccount getBankAccount(String infoString)
	{
		String[] splitStr =	infoString.split(":");
		/*
		 * 1st Bank Account Number
		 * 2nd Name
		 * 3rd Balance
		 */
		if(splitStr.length >= 3)
		{	
			return new BankAccount(Integer.parseInt(splitStr[0]), splitStr[1], Double.parseDouble(splitStr[2]));
		}
		return null;
	}
	public ArrayList<BankAccount> getBankAccounts(ArrayList<String> infoStrings)
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		for(String s : infoStrings)
		{
			accounts.add(getBankAccount(s));
		}
		return accounts;
	}
}
