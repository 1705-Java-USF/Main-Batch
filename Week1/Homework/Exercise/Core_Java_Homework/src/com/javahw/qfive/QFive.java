package com.javahw.qfive;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QFive {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please input a string you would like to reverse!");
		
		String test = scan.nextLine();

		System.out.println("Now input an index to see a string to obtain a substring, \n beginning at the 0 index to index-1");
		
		//Check for valid numerical input
		try{
			int idx = scan.nextInt();
			
			scan.close();
			
			System.out.println(substr(test,idx));
		}catch(InputMismatchException e){
			System.out.println("You did not input a valid number");
		}
	}
	
	//Returns a substring of a String between 0 and idx-1 inclusive
	static String substr(String str, int idx) {
		//Case for index being greater than length of String
		if(idx > str.length()) {
			return str;
		}
		
		String subString= "";
		//Iterate through charArr of String starting from 0 to idx-1
		for(int i = 0; i < idx; i++) {
			//Concatenate onto subString the substring
			subString += (str.toCharArray())[i];
		}
		return subString;
	}
}
