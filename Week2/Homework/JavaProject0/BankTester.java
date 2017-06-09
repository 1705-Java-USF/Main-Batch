package com.java.JavaProject0;

import static org.junit.Assert.*;

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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankTester {
	BufferedReader br;
	BufferedWriter bw;
	FileWriter fw;
	

	static final String FILENAME = "Data2.txt";
	int count = 0;

	final static Logger logger = Logger.getLogger(BankTester.class);
	

	@Test
	public void test() throws IOException {
		try {
			br = new BufferedReader(new FileReader(FILENAME));
			String s = null;
			while ((s = br.readLine()) != null) { // while there's still another
													// line that hasn't been
													// read
				logger.info(s + " \n\n");
				count++;

			}

		} catch (FileNotFoundException e) { // Catching IOException
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close(); // closing stream
			}
		}
		
		assertEquals("Did read/write exactly 3 rows!",3, count);
	}
	
	
	 @Before
	    public void setUp() {
		 
		 BasicConfigurator.configure();
			BankAccountIO fr = new BankAccountIO(); // New instance of the class to
													// call the reader method
			Scanner scan = new Scanner(System.in);
			
			ArrayList<BankAccount> list = new ArrayList<BankAccount>();
			int id = 0;
			String name = " ";
			double balance = 0.0;
			boolean bool = false;
			int Answer = 0;
			System.out.println("Please be sure to enter 3 records! \n\n");
			do{
			System.out.println("Please enter an ID");
			id = scan.nextInt();
			System.out.println("Please enter a name");
			name= scan.next();
			System.out.println("Please enter a balance");
			balance = scan.nextDouble();
			list.add(new BankAccount(id,name,balance));
			System.out.println("Are You Done? Press 1 for yes and press 0 for no");
			Answer = scan.nextInt();
			if(Answer == 1){
				bool = true;
				scan.close();
				break;
			}
			else{
				bool = false;
			}
			}while(bool == false);
			
			
			
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
			
		 
	        
	    }
	
	 @After
	    public void tearDown() {
		 
	    }
	
	
	

}
