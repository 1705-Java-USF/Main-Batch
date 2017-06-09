package com.revature.pzero;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountTest {
	
	static BankAccountIO bio;

	final static Logger logger = Logger.getLogger(BankAccountTest.class);
	
	static BankAccount ba1, ba2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bio = new BankAccountIO();
		ba1 = new BankAccount();
		ba2 = new BankAccount(1,"Nathan",500.0);
		bio.accounts = new ArrayList();
		bio.accounts.add(ba1);
		bio.accounts.add(ba2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void bankAccountEmptyNumberTest()
	{
		assertEquals(0,ba1.getBankAccountNumber());
	}
	
	@Test
	public void bankAccountEmptyNameTest()
	{
		assertEquals("",ba1.getCustomerName());
	}
	
	@Test
	public void bankAccountEmptyBalanceTest()
	{
		assertEquals(0.0,ba1.getBalance(), 0);
	}
	
	
	@Test
	public void bankAccountNumberTest()
	{
		assertEquals(1,ba2.getBankAccountNumber());
	}
	
	@Test
	public void bankAccountNameTest()
	{
		assertEquals("Nathan",ba2.getCustomerName());
	}
	
	@Test
	public void bankAccountBalanceTest()
	{
		assertEquals(500.0,ba2.getBalance(),0);
	}
	
	@Test
	public void accountSize()
	{
		assertEquals(2,bio.numAccounts());
	}
	
}
