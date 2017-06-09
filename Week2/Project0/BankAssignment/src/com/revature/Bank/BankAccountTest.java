package com.revature.Bank;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountTest {
	int tn1;
	int tn2;
	int tn3;
	String ts1;
	String ts2;
	String ts3;
	double td1;
	double td2;
	double td3;
	BankAccount acc;
	BankAccount acc1;
	BankAccount acc2;
	BankAccount acc3;
	String toos1;
	String toos2;
	String toos3;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tn1 = 5;
		tn2 = 589;
		tn3 = -1;
		ts1 = null;
		ts2 = "Billy Bob";
		ts3 = "This is a very long name, in fact it sounds less like a name and more like a fake name for the purpose of testing software, suspicious";
		td1 = Double.POSITIVE_INFINITY;
		td2 = 5.0;
		td3 = -899.99;
		acc1 = new BankAccount(tn1, ts1, td1);
		acc2 = new BankAccount(tn2, ts2, td2);
		acc3 = new BankAccount(tn3, ts3, td3);
		toos1 = "5:null:" + Double.POSITIVE_INFINITY;
		toos2 = "589:Billy Bob:5.0";
		toos3 = "-1:This is a very long name, in fact it sounds less like a name and more like a fake name for the purpose of testing software, suspicious:-899.99";
	}

	@After
	public void tearDown() throws Exception {
		tn1 = 0;
		tn2 = 0;
		tn3 = 0;
		ts1 = null;
		ts2 = null;
		ts3 = null;
		td1 = 0.0;
		td2 = 0.0;
		td3 = 0.0;
		acc1 = null;
		acc2 = null;
		acc3 = null;
	}

	@Test
	public void testBankAccount() {
		/*
		 * Test the constructor
		 */
		acc = new BankAccount(tn1, ts1, td1);
		assertEquals(tn1, acc.getBankAccountNumber());
		assertEquals(ts1, acc.getCustomerName());
		assertEquals(td1, acc.getBalance(), 0.0);
		acc = new BankAccount(tn2, ts2, td2);
		assertEquals(tn2, acc.getBankAccountNumber());
		assertEquals(ts2, acc.getCustomerName());
		assertEquals(td2, acc.getBalance(), 0.0);
		acc = new BankAccount(tn3, ts3, td3);
		assertEquals(tn3, acc.getBankAccountNumber());
		assertEquals(ts3, acc.getCustomerName());
		assertEquals(td3, acc.getBalance(), 0.0);
	}

	@Test
	public void testGetBankAccountNumber() {
		assertEquals(tn1, acc1.getBankAccountNumber());
		assertEquals(tn2, acc2.getBankAccountNumber());
		assertEquals(tn3, acc3.getBankAccountNumber());
	}

	@Test
	public void testSetBankAccountNumber() {
		acc1.setBankAccountNumber(tn3);
		assertEquals(tn3, acc1.getBankAccountNumber());
		acc2.setBankAccountNumber(tn1);
		assertEquals(tn1, acc2.getBankAccountNumber());
		acc3.setBankAccountNumber(tn2);
		assertEquals(tn2, acc3.getBankAccountNumber());
	}

	@Test
	public void testGetCustomerName() {
		assertEquals(ts1, acc1.getCustomerName());
		assertEquals(ts2, acc2.getCustomerName());
		assertEquals(ts3, acc3.getCustomerName());
	}

	@Test
	public void testSetCustomerName() {
		acc1.setCustomerName(ts3);
		assertEquals(ts3, acc1.getCustomerName());
		acc2.setCustomerName(ts1);
		assertEquals(ts1, acc2.getCustomerName());
		acc3.setCustomerName(ts2);
		assertEquals(ts2, acc3.getCustomerName());
	}

	@Test
	public void testGetBalance() {
		assertEquals(td1, acc1.getBalance(), 0.0);
		assertEquals(td2, acc2.getBalance(), 0.0);
		assertEquals(td3, acc3.getBalance(), 0.0);
	}

	@Test
	public void testSetBalance() {
		acc1.setBalance(td3);
		assertEquals(td3, acc1.getBalance(), 0.0);
		acc2.setBalance(td1);
		assertEquals(td1, acc2.getBalance(), 0.0);
		acc3.setBalance(td2);
		assertEquals(td2, acc3.getBalance(), 0.0);
	}

	@Test
	public void testToString() {
		assertEquals(toos1, acc1.toString());
		assertEquals(toos2, acc2.toString());
		assertEquals(toos3, acc3.toString());
	}

}
