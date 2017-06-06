package com.revature.java_hw.q18;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Subclass sc = new Subclass();
		Scanner scan = new Scanner(System.in);
		
		//Get a string, call the method for testing for an upper case letter, print result.
		System.out.println("Enter a String to test for upper case letters.");
		System.out.println((sc.anyUpperCase(scan.nextLine()))?
				"There is at least one upper case letter.\n":"There are no upper case letters.\n");
		
		//Get a string, call the method to convert to upper case letters, print result.
		System.out.println("Enter a String to convert to upper case letters.");
		System.out.println(sc.toUpperCase(scan.nextLine()));
		
		//Get a string that can be converted to an int, call method. (method already prints the result)
		System.out.println("Enter a string to convert to int, result displayed is 10 more than your string.");
		while(!scan.hasNextInt()){
			scan.next();
		}
		String str = scan.nextLine();
		sc.parseStringToInt(str);
		
		scan.close();
	}

}
