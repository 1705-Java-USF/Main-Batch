package com.revature.question3;

public class StringReverser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "This is a string"; //Input for function
		System.out.println(reverseString(s)); //Print the results from the reverseString method with input in
		//Expected output: gnirts a si sihT
	}
	public static String reverseString(String in)
	{
		if(in.length()<=1) //a string of size one is already the reverse of itself. 
		{
			return in;
		}
		/*
		 * Takes the last character of the input and then calls reverseString with the 
		 * substring of everything but the last character 
		 */
		return in.substring(in.length()-1) + reverseString(in.substring(0, in.length()-1));
	}

}
