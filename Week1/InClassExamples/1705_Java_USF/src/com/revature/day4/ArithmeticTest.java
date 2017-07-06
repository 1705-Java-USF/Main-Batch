package com.revature.day4;

/*
 * Observe the "static" imports.
 * When you use a static import, you will import all the static methods
 * of that specific class(es).
 * This allows us to call the methods of that class, without having to invoke
 * the classname they come from.
 * What does this mean?
 * instead of doing: Assert.assertEquals(stuff)
 * we can now just use the method as is:
 * assertEquals(stuff)
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ArithmeticTest {
	//Place test objects in the instance scope.
	Arithmetic a;
	int input1, input2;
	
	final static Logger logger = Logger.getLogger(ArithmeticTest.class);
	
	
	/*
	 * This method is called ONCE when the test is ran.
	 * It will always be the FIRST method to be called.
	 * Serves to set up a static environment for the test cases.
	 * Naming convention dictates it be a "setUp" method
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.out.println("===Before Class===");
		logger.info("===Before Class===");
	}

	/*
	 * Will be the LAST method to be called.
	 * Will only be called ONCE.
	 * Serves to tear down the test environment.
	 * eg. shut down streams, clean up objects as you see fit, etc.
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("===After Class===");
	}

	/*
	 * Method will be run before each individual test.
	 * Will run the same amount of running tests available.
	 * Serves to instantiate, or reinstantiate test objects.
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("===Before===");
		a = new Arithmetic();
		input1 = 10;
		input2 = 2;
	}

	/*
	 * Method will be run after each individual test.
	 * Will also run the same amount of running tests available.
	 * Serves to typically reset objects that may be used for multiple tests.
	 * Also can serve to clean up test environment for next test. eg. closing streams.
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("===After===");
	}

	/*
	 * In order to actually test something, you must make use of the "assert" class.
	 * Assert offers a ton of different overloaded methods that can be used to test almost
	 * everything.
	 * such as: assertTrue() which only passes if the parameter returns true
	 * assertEqauls(expected, actual) //Where you place the result you expect as param1
	 * 		-Then you place the method call to the object under test as param2.
	 * 		*Note: if you use a 3 parameter overloaded version of assertEquals(), the first param
	 * 				will be used as a custom failed testcase message.
	 * 
	 */
	@Test
	public void testAdditionMethod() {
		System.out.println("===Testing addition method===");
		assertEquals("This was not working the way I want!", 12, a.addition(input1, input2));
	}
	
	@Test
	public void testSubtraction() {
		System.out.println("===Testing Subtraction===");
		assertEquals(8, a.subtraction(input1, input2));
	}
	
	@Test
	public void testMultiplication() {
		System.out.println("===Testing Multiplication===");
		assertEquals(20, a.multiplication(input1, input2));
	}
	
	@Test
	public void testDivision() {
		System.out.println("===Testing Division===");
		assertEquals(5, a.division(input1, input2));
	}
	
	
	/*
	 * If one wants to skip a test, they simple have to use the
	 * "@Ignore" annotation on top of the "@Test" annotation
	 */
	@Ignore
	@Test
	public void ignoreExample(){
		fail("failed");
	}
	
	/*
	 * The test annotation can take parameters. 
	 * Some parameters include:
	 * -expected
	 * 		-Requires an exception to trigger during execution.
	 * 		-If exception occurs, test passes. If exception does not occur
	 * 		-test fails.
	 * -timeout
	 * 		-Use this parameter to set a requirement that the test will fail abruptly if it
	 * 		takes longer than the assigned time(in milliseconds) to execute the test fully.
	 * 
	 * 	*Note, an unexpected exception produces an "error" result meaning something is wrong
	 * 		with the actual code.
	 */
	@Test(expected=ArithmeticException.class)
	public void expectedExample(){
		System.out.println(1/0);
	}
	
	@Test(timeout=3000) //Test fails if it takes longer than 3000 ms to complete.
	public void timeoutTest(){
		String a = new String("");
		for(int i = 0; i < 100000; i++){
			a+='a';
		}
	}
}
