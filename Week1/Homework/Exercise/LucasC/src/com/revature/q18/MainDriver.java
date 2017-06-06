package com.revature.q18;

import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);  // scanner allowing input
		 
		System.out.print("Please input a string: ");
		String str = input.nextLine();   // asking for user input
		
		AbstractClass obj = new ImplementingAbstractClass();  // extending abstract class
	
		obj.upperCaseChecker(str);
		obj.lowerCaseConverter(str);
		obj.stringConverter(str);
	
		input.close();
	}
}
