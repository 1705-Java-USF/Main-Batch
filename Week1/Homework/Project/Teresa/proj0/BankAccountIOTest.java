package com.revature.proj0;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountIOTest {
	static String filePath = "src/com/revature/proj0/Accounts.txt";
	static BankAccountIO bank;
	Collection<BankAccount> list;
	String test, number, name, balance;
	final static Logger logger = Logger.getLogger(BankAccountIOTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// start new instance
		bank = new BankAccountIO();
		// start with empty file to write to
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		bw.write("");
		bw.close();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// set up for write method
		list = new ArrayList<BankAccount>();
		number = "1";
		name = "john";
		balance = "120.5";
		// set up for read method
		test = "Bank Account Number: 1\nName: John\nBalance: 120.5\n";
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testWrite() throws IOException {
		// test write method
		list.add(new BankAccount(number, name, balance));
		assertEquals("write method failed", list.toString(), bank.write(filePath).toString());
	}

	@Test
	public void testRead() throws IOException {
		// test read method
		assertEquals("read method failed", test, bank.read(filePath));
	}

}
