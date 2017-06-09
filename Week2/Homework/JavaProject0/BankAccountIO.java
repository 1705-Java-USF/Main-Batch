package com.java.JavaProject0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BankAccountIO {
	BufferedReader br;
	BufferedWriter bw;
	FileWriter fw;
	

	static final String FILENAME = "Data2.txt";
	final static Logger logger = Logger.getLogger(BankAccountIO.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		BankAccountIO fr = new BankAccountIO(); // New instance of the class to
												// call the reader method
		Scanner scan = new Scanner(System.in);
		
		ArrayList<BankAccount> list = new ArrayList<BankAccount>();
		int id = 0;
		String name = " ";
		double balance = 0.0;
		boolean bool = false;
		String Answer = " ";
		
		do{
		System.out.println("Please enter an ID");
		id = scan.nextInt();
		System.out.println("Please enter a name");
		name= scan.next();
		System.out.println("Please enter a balance");
		balance = scan.nextDouble();
		list.add(new BankAccount(id,name,balance));
		System.out.println("Are You Done yes/no");
		Answer = scan.next();
		if(Answer == "yes" || Answer == "Yes"){
			bool = true;
			scan.close();
		}
		else{
			bool = false;
		}
		}while(bool==false);
		
		
		
		
		
		String s = null;
		
		try {
			for (BankAccount acc : list){
			s = acc.toString();
			fr.writer(s, FILENAME);
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		try {
			fr.reader(FILENAME); // Method that will read the file
									// The try-catch block takes away the
									// IOException in order to compile
		} catch (Exception e) {
			e.printStackTrace(); // if exception is caught it prints the stack
									// trace
		}

	}

	public void reader(String FilePath) throws IOException {
		try {
			br = new BufferedReader(new FileReader(FilePath));
			String s = null;
			while ((s = br.readLine()) != null) { // while there's still another
													// line that hasn't been
													// read
				logger.info(s + " \n\n");

			}

		} catch (FileNotFoundException e) { // Catching IOException
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close(); // closing stream
			}
		}
	}

	public void writer(String s, String filename) throws IOException {
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
