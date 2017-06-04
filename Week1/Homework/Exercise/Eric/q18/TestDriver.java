package q18;

import java.util.Scanner;

public class TestDriver {

	/*
	 * This class tests the SubClass methods
	 * that were inherited from the SuperClass
	 */
	public static void main(String[] args) {
		
		SubClass sub = new SubClass();
		String str;
		
		// Use a scanner object to get string for first two methods
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		str = sc.next();
		
		// test the uppercase boolean method
		if (sub.hasUpper(str))
			System.out.println("The string has uppercase letters");
		else
			System.out.println("The string does not have uppercase letters");
		
		// converts any lower case chars to upper and outputs
		System.out.println("Converted to uppercase: " + sub.makeUpper(str));
		
		// Asks for another test string to convert to an integer
		System.out.println("Please enter a number: ");
		
		String num_string = sc.next();
		
		// close the scanner
		if (sc != null)
			sc.close();
		
		// testing last method
		sub.printInt(num_string);
		
	}

}
