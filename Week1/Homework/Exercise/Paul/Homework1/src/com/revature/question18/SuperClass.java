package com.revature.question18;

public abstract class SuperClass {

	/*
	 * abstract methods created to change 
	 * or manipulate the String passed from user input 
	 * but with different implementations 
	 * as provided by the sub class 
	 *  
	 */
	abstract Boolean checkUpperCase(String s);
	
	abstract StringBuilder checkLowerCase(String s); 
	
	abstract int stringToInteger(String s);


}
