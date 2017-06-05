package com.revature.question18;

public class Driver {

	private static String s;

	public static void main(String [] args){
		
		//Driver class to call the methods created in the subclass
		
			SuperClass sp = new SubClass();
			/*
			 * Wrapper classes to convert strings to appropriate types
			 * Objects created are instances of the superclass methods
			 */
			Boolean checkUpperCase = sp.checkUpperCase(s);
			System.out.println(checkUpperCase);
			
			StringBuilder checkLowerCase = sp.checkLowerCase(s);
			System.out.println(checkLowerCase);
			
			int stringToInteger = sp.stringToInteger(s);
			System.out.println(stringToInteger);
			
			}

	
	}


