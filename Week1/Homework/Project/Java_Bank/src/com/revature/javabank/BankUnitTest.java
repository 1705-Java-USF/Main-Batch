package com.revature.javabank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//log4j logger
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BankUnitTest {
	
	final static Logger logger = Logger.getLogger(BankAccountIO.class);
	
	BankAccountIO bank;
	
	public static final String FILEPATH = "accounts.txt";


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.info("===Pre-class Setup===");
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.info("===Post-Class===");
	}


	@Before
	public void setUp() throws Exception {
		logger.info("====Pre-test Setup====");
	}


	@After
	public void tearDown() throws Exception {
		logger.info("====Post-test====");
	}
	
	@Test
	public void testWriteMethod() {
		logger.info("===Testing write method==");
		
		//Created 3 BankAccounts with properties initialized
		BankAccount a = new BankAccount(1,"John",120.5);
		BankAccount b = new BankAccount(2,"Amy",3000.0);
		BankAccount c = new BankAccount(3,"Austin",460.7);
		
		//Stored them in a Collection
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		
		accounts.add(a);
		accounts.add(b);
		accounts.add(c);
		
		BankAccountIO bio = new BankAccountIO();
		try {
			bio.write(FILEPATH, accounts);
		} catch (IOException e) {
			logger.warn("Caught IO Exception in JUnit Test for write!");
		}
	}
	
	@Test
	public void testReadMethod() {
		logger.info("===Testing read method==");

		BankAccountIO bio = new BankAccountIO();
		try {
			logger.info( bio.read(FILEPATH) );
		} catch (IOException e) {
			logger.warn("Caught IO Exception in JUnit Test for read!");
		}
	}

}
