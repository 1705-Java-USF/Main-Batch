/* Demetrus Atkinson */
package com.revature.project000;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* Unit testing for the main BankAccountID class, looks for events and either logs or asserts 
 * depending on the context the standard methods for unit testing are available in this class
 */

public class BankTest {

	final static Logger logger = Logger.getLogger(BankTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		logger.info("===Before Class Starts===\n");
	}

	public static void tearDownAfterClass() throws Exception {
		System.out.println("Shutting down ........");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Setting up .......");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Done Processing ......");
	}

	@Test
	public void testForNotNull() { // testing for a null condition
		System.out.println("===Testing FilePath===");
		assertNotNull("FilePath cannot be null.");
	}

}