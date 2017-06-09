package com.revature.Bank;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountFactoryTest {
	BankAccountFactory factory;
	String test1;
	String test2;
	String test3;
	ArrayList<String> accounts;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		factory = new BankAccountFactory();
		test1 = "1:name1:100";
		test2 = "-1:null:23.4";
		test3 = "800:A name with spaces:19.19";
		accounts = new ArrayList<String>();
		accounts.add(test1);
		accounts.add(test2);
		accounts.add(test3);
	}

	@After
	public void tearDown() throws Exception {
		factory = null;
		accounts = null;
		test1 = null;
		test2 = null;
		test3 = null;
	}

	@Test
	public void testGetBankAccount() {
		BankAccount acc1 = factory.getBankAccount(test1);
		assertEquals(1,acc1.getBankAccountNumber());
		assertEquals("name1",acc1.getCustomerName());
		assertEquals(100,acc1.getBalance(),0);
		acc1 = factory.getBankAccount(test2);
		assertEquals(-1,acc1.getBankAccountNumber());
		assertEquals("null",acc1.getCustomerName());
		assertEquals(23.4,acc1.getBalance(),0);
		acc1 = factory.getBankAccount(test3);
		assertEquals(800,acc1.getBankAccountNumber());
		assertEquals("A name with spaces",acc1.getCustomerName());
		assertEquals(19.19,acc1.getBalance(),0);
		
	}

	@Test
	public void testGetBankAccounts() {
		ArrayList<BankAccount> ar = factory.getBankAccounts(accounts);
		assertEquals(1,ar.get(0).getBankAccountNumber());
		assertEquals("name1",ar.get(0).getCustomerName());
		assertEquals(100,ar.get(0).getBalance(),0);
		
		assertEquals(-1,ar.get(1).getBankAccountNumber());
		assertEquals("null",ar.get(1).getCustomerName());
		assertEquals(23.4,ar.get(1).getBalance(),0);
		
		assertEquals(800,ar.get(2).getBankAccountNumber());
		assertEquals("A name with spaces",ar.get(2).getCustomerName());
		assertEquals(19.19,ar.get(2).getBalance(),0);
	}

}
