package com.revature.question18;


import java.util.Scanner;

public class SubClass extends SuperClass {

	private Scanner scan;
	public int number; 

	//Implementation of the super class to check for uppercase letters
	//will give a boolean result 
	@Override
	Boolean checkUpperCase(String s) {
		System.out.println("Check if UpperCase Letters(True or False)!");
		scan = new Scanner(System.in);
		s = scan.nextLine();
		
		//for loop to go through each letter of string
		//if letter is lowercase it will have a ASCII value 
		//between 97 and 122 and give a false result
		//else it is uppercase and will yield true
		for(int i=0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c >= 97 && c <= 122) {
				return false;
			}
		}
		return true;
	}
		

	//Implements checkLowerCase class from super class 
	//uses string builder to change the string to uppercase 
	//as it works through the string
	@Override
	StringBuilder checkLowerCase(String s) {
		scan = new Scanner(System.in);
		System.out.println("Convert LowerCase to UpperCase Letters!");
		String value = scan.nextLine();
		
		//utilizes charAt to get index of each character 
		//allowing the swap of lowercase to uppercase letters
		StringBuilder sb = new StringBuilder(value);
		for (int index = 0; index < sb.length(); index++) {
		    char c = sb.charAt(index);
		    if (Character.isLowerCase(c)) {
		        sb.setCharAt(index, Character.toUpperCase(c));
		    } 
		}
		return sb;
	}

	
	//Implements stringToInteger class from super class
	//class is of int type and will return the number value
	
	@Override
	int stringToInteger(String s) {
		
		/*
		 * try-catch block to print message if user 
		 * inputs something other than a number 
		 */
		try{
		scan = new Scanner(System.in);
		System.out.println("Convert String to Integer(Adds 10)!");
		
		String num = scan.nextLine();
		
		//Parse through string to get number value from string number
		number = Integer.parseInt(num);
		number += 10;
		
		}catch(NumberFormatException e){
			e.printStackTrace();
			System.err.println("Please Enter a Number!");
			System.exit(0);
		}
		return number;
	}
}
