package com.revature.project0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BankAccountIO {
	BufferedReader br;
	BufferedWriter bw;
	FileWriter fw;
	

	static final String FILENAME = "BankAccountIO.txt";
	

	public static void main(String[] args) {
		/*
		 * New instance of the class to call readFile
		 */
		BankAccountIO fr = new BankAccountIO(); 
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<BankAccount> list = new ArrayList<BankAccount>();
		int id = 0;
		String name = " ";
		double balance = 0.0;
		boolean bool = false;
		String Answer = " ";
		
		do{
		System.out.println("Please enter a Bank Account Number");
		id = scan.nextInt();
		System.out.println("Please enter a Name");
		name= scan.next();
		System.out.println("Please enter a Balance");
		balance = scan.nextDouble();
		list.add(new BankAccount(id,name,balance));
		System.out.println("Are You Done yes/no");
		Answer = scan.next();
		if(Answer == "Yes"){
			bool = true;
			scan.close();
		}
		else{
			bool = false;
			}
		}while(bool);
		
		
		String s = null;
		
		try {
			for (BankAccount acc : list){	//WRITE to file
			s = acc.toString();				//formats in list as entries are added
			fr.writeFile(s, FILENAME);
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		

		try {
			fr.readFile(FILENAME); // Method that will read the file
									// The try-catch block takes away the
									// IOException in order to compile
		} catch (Exception e) {
			e.printStackTrace(); // if exception is caught it prints the stack
									// trace
		}

	}
	
	
//method to read from file 
	public void readFile(String FilePath) throws IOException {
		try {
			br = new BufferedReader(new FileReader(FilePath));

		} catch (FileNotFoundException e) { // Catching IOException
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close(); // closing stream
			}
		}
	}

	//method to write to file 
	public void writeFile(String s, String filename) throws IOException {
		try {
			
			fw = new FileWriter(filename, true);
			bw = new BufferedWriter(fw);
			bw.write(s);
			bw.newLine();

		} catch (FileNotFoundException e) { // Catching IOException
			e.printStackTrace();
		} finally {
			if (bw != null) {
				bw.close(); // closing stream
			}
		}

	}
}