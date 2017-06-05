package com.revature.question15;


import org.apache.log4j.*;

import static org.junit.Assert.*;
import org.junit.After;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




public class ArithmeticTest implements Arithmetic  {

	Arithmetic a; 
	int input1,input2;
	
	/*
	 * 
	 * This method is called once when the test is ran
	 * it will always be the first method to be called
	 * serves to set up a static environment for the test cases 
	 * Naming convention dictates it be a "setup" method
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.out.println("=====Before Class====");
		Logger.getLogger("=====Before Class===");
	}

	/*
	 * Will be the last method to be called 
	 * will only be called once, serves to tear down the testing environment
	 * e.g. shut down streams, clean up objects as you see fit, etc. 
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("====After Class====");
	}

	/*
	 * Method will be run before each individual test
	 * will run the same amount of running tests available
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("=====Before====");
		a = new ArithmeticTest();
		input1 = 10; 
		input2 = 2; 
	}

	/*
	 * Method will be run after each individual test
	 * will also run the same amount of running tests available
	 * serves to typically reset objects that may be used for multiple tests.
	 * Also can serve to clean up test environment for next test. e.g. closing streams. 
	 * 
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("=====After=====");
	}
	
	/*
	 *
	 */

	/*
	 * In order to actually test something must make use of the assert class
	 * Assert offers a ton of different overloaded methods that can be used to test almost everything.
	 * 
	 * such as: assertTrue() which only passes if the parameter returns true 
	 * assertEquals(expected,actual) //where you place the parameters
	 */
	@Test
	public void testAdditionMethod() {
		System.out.println("====Test Addition Method====");
		assertEquals(12,a.addition(input1,input2 ));
		//fail("Not yet implemented");
	}
	@Test
	public void testSubtractionMethod() {
		System.out.println("====Test Subtraction Method====");
		assertEquals(8,a.subtraction(input1, input2));
		//fail("Not yet implemented");
	}
	
	
	 
	@Test
	public void testMultiplicationMethod() {
		System.out.println("====Test Multiplication Method====");
		assertEquals(20,a.multiplication(input1, input2));
		//fail("Not yet implemented");
	}
	@Test
	public void testDivisionMethod() {
		System.out.println("====Test Division Method====");
		assertEquals(5,a.division(input1, input2));
		//fail("Not yet implemented");
	}
}
