package com.revature.project0;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A suite of test cases to check the correctness of the BankAccount class
 * 
 * 
 */

public class BankTester extends TestCase {

	private BankAccount a;

	/**
	 * Creates a test case to test the BankAccount class
	 */
	public BankTester() {
		super("Bank Account Test");
	}

	/**
	 * Sets up the test case before testing each fixture
	 */
	@Before
	protected void setUp() {
		// not really needed here
		a = null; // make sure that a test is run from scratch
	}

	/**
	 * Cleans up the test case after testing a fixture
	 */
	@After
	protected void tearDown() {
		a = null; // don't leave anything behind after a test
	}

	/**
	 * Test for newly created bank account has id, an owner, and a double balance
	 */
	@Test
	public void testGetBalance() {
		a = new BankAccount(20,"Pablo ",83.0);
		double b = a.getBalance();
		assertTrue(b != 0);
	}

}