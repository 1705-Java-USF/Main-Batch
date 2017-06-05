package com.revature.question3;

public class ReverseString {

	
	public static void main(String [] args) {
		
		String reverseString = "Reverse This String!"; 		//string to be reversed
		for(int i = 0; i < reverseString.length(); i++) {	
			reverseString = reverseString.substring(1, reverseString.length()- i) //substring used to grab string from start of index to end of index -1 
					+ reverseString.substring(0,1)
					+ reverseString.substring(reverseString.length() - i, reverseString.length());
		}
		System.out.println(reverseString);
	}
}
