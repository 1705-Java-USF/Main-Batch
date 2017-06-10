package com.revature.bankaccount;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitBankAccount {
	final static Logger logger = Logger.getLogger(JUnitBankAccount.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.info("===Before Class===");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.info("===After Class===");
	}

	@Before
	public void setUp() throws Exception {
		logger.info("===Before Test===");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("===After Test===");
	}
	
	//Test to make sure the filepath in BankAccountIO is valid
	@Test
	public void testForFile() throws IOException {
		FileReader fr = null;
		try {
			fr = new FileReader(BankAccountIO.FILEPATH);
		} catch (FileNotFoundException e) {
			fail("File not found");
		} finally {
			if(fr != null)
				fr.close();
		}
	}
	
	//Test that the file isn't blank after writing to it.
	//(NOTE: ERASES THE FILE - USE ONLY FOR TESTING)
	@Test
	public void testForBlankFileAfterWrite() throws IOException {
		FileReader fr = null;
		BufferedWriter bw = new BufferedWriter(new FileWriter(BankAccountIO.FILEPATH));
		bw.write("");
		bw.close();
		BankAccountIO ba = new BankAccountIO();
		try {
			ba.writeAccount(BankAccountIO.FILEPATH);
			
			fr = new FileReader(BankAccountIO.FILEPATH);
			
			assert(fr.read() != -1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fr != null)
				fr.close();
		}
	}

}
