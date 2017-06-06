package com.assignment.q5;

import java.util.Scanner;

public class Question5 
{
	//Custom method to split a string
	public static String subStr(String str, int idx)
	{
		//Create empty string
		String newStr = "";
		
		//Concatenate string until privided index
		for(int i = 0; i < idx; i++)
		{
			newStr += str.charAt(i);
		}
		
		//return new string
		return newStr;
	}
	
	public static void main(String[] args)
	{
		//Variables: integer to hold desired index, scanner for user input
		int shorten;
		Scanner scan = new Scanner(System.in);
		
		//Crate and print original string
		String str = "This is a String.. its umm long for no (burp) reason Morty";
		System.out.println("This is the original string:");
		System.out.println(str);
		System.out.println(str.length());
		
		//Prompt user input
		System.out.print("Now shorten it: ");
		shorten = scan.nextInt();
		
		//Ensure that number provided is shorter that sting length
		//Will crash if non integer input is provided
		while(shorten > str.length())
		{
			System.out.print("Try a samller number: ");
			shorten = scan.nextInt();
		}
		
		System.out.println("Valid!!");
		
		//Display new shortened string
		System.out.println("Here's your new string:");
		System.out.println(subStr(str, shorten));
		
	}

}
