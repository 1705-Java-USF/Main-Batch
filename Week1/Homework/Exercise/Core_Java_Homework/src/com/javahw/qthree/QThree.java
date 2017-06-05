package com.javahw.qthree;

import java.util.Scanner;

public class QThree {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please input a string you would like to reverse!");
		
		String test = scan.nextLine();
		
		scan.close();
		
		//String test = "testing";
		
		//Call reverse function
		reverse(test);
		System.out.println();
		System.out.println("You entered: " + test);
		System.out.println("The reversed string is: "+ reverse(test));
		
	}
	
	//Return a String that has been reversed
	public static String reverse(String arr) {
		String reversedString= "";
		//Concatenate the String starting from the last index to the first index
		//into a new String
		for(int i = arr.length()-1; i >= 0; i--)
		{
			reversedString += (arr.toCharArray())[i];
		}
		return reversedString;
	}
	
}
