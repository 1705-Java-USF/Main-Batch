package com.revature.question6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenInteger {

	

	public static void main(String[] args) throws NumberFormatException, IOException{
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //gets user input 
		
		System.out.println("Please input a number!");
		int number = Integer.parseInt(br.readLine());
		String temp = number + "";		//converts number to a string
		
		char ch = temp.charAt(temp.length() - 1); //gets last character in string
		temp = ch + "";
		
		//check if last number is even(which indicates it is divisible by 2)
		if(temp.equals("0") || temp.equals("2") || temp.equals("4") || temp.equals("6") || temp.equals("8"))
			System.out.println("Number is even!");
		else
			System.out.println("Number is odd");	//if last number not even then will print it is odd
	}
}
