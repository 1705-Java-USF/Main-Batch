package com.revature.proj0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class BankAccountIO {

	public static void main(String[] args) throws IOException {
		BankAccountIO account = new BankAccountIO();
		// file to read and write from/to
		// propagating excpetion for file because created file is mandatory for project
		// so it will not be 'NotFound'
		String filePath = "src/com/revature/proj0/Accounts.txt";
		account.write(filePath);
		System.out.println( account.read(filePath) );
	}

	public String read(String path) throws IOException {
		// method to read file and print data 
		String line = ""; 
		BufferedReader br = new BufferedReader(new FileReader(path));
		String str = br.readLine();
		while (str != null) {
			String[] arr = str.split(":");
			line += "Bank Account Number: " + arr[0] + "\nName: " + arr[1]
					+ "\nBalance: " + arr[2] + "\n";
			str = br.readLine();
		}
		br.close();
		return line;
	}
	
	public Collection<BankAccount> write(String path) throws IOException {
		// method to ask for bank account information and write it to a file
		BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
		Collection<BankAccount> list = new ArrayList<BankAccount>();
		Scanner input =  new Scanner(System.in);
		String strNumber, strName, strBalance;
		System.out.println("Enter a new bank account number or 'done' when you are finished entering bank inforamtion");
		strNumber = input.nextLine();
		while (!strNumber.equalsIgnoreCase("done")) {
			System.out.println("Enter a name for bank account: " + strNumber);
			strName = input.nextLine();
			System.out.println("Enter the balance for bank account: " + strNumber);
			strBalance = input.nextLine();
			list.add(new BankAccount(strNumber, strName, strBalance));
			System.out.println("Enter a new bank account number or 'done' when you are finished entering bank inforamtion");
			strNumber = input.nextLine();
		}
		input.close();
		for (BankAccount a : list) {
			bw.append(a.toString() + "\n");
		}
		bw.close();
		return list;
	}
}
