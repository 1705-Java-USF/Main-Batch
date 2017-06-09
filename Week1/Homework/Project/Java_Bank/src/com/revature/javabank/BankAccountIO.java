package com.revature.javabank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BankAccountIO {
	
	private BufferedWriter bw;
	
	private BufferedReader br;
		
	
	//Write method specific to current project requirements
	public void write(String filepath, List<BankAccount> accounts) throws IOException{
	
		//Write the Objects to the file with any type of loop
		try {
			bw = new BufferedWriter(new FileWriter(filepath));
			
			//Convert files to string and write to filepath
			for(BankAccount account : accounts){
				bw.write(account.toString());
				bw.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null){
				bw.close();
			}
		}
	}
	
	//Read objects from the file, return a list of BankAccount
	public List<BankAccount> read(String filepath) throws IOException{
		String file = "";
		String[] accountValues;
		List<BankAccount> accounts = new ArrayList<BankAccount>();

		try {
			br = new BufferedReader(new FileReader(filepath));
			
			//Append string content
			String s = "";
			while((s = br.readLine()) != null){
				file += s;
				file += '\n';
			}
			
			//Split all the strings into an array of strings
			accountValues = file.split("\n|:");
			
			//Create a list of BankAccounts using the values read from filepath
			for(int i = 0; i < accountValues.length; i+=3){
				accounts.add( new BankAccount(	Integer.parseInt(accountValues[i]),
												accountValues[i+1],
												Double.parseDouble(accountValues[i+2])) );
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(br != null){
				br.close();
			}
		}
		return accounts;
	}
}
