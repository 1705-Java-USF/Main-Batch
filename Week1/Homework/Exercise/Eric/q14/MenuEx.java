package q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuEx {
	
	// This program uses a simple menu to perform 3 different actions
	
	public static void main(String[] args){
		// menu output
		System.out.println("Please select an option:");
		System.out.println("1) Find a square root");
		System.out.println("2) Display date");
		System.out.println("3) Split a string");
		
		// Scanner object used to get user input
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		// switch statement based on user input
		switch (choice){
		case 1: // Square root
			System.out.println("Please enter a number: ");
			double n = sc.nextDouble(); // parses a double
			System.out.println("Square root of " + n + " is " + Math.sqrt(n));
			break;
		case 2:
			// formats the date for output
			DateFormat dformat = new SimpleDateFormat("mm/dd/yyyy HH:mm:ss");
			Date dt = new Date();
			System.out.println("The date and time are " + dformat.format(dt));
			break;
		case 3:
			// Outputs the string before splitting and goes through the array of the split strings
			String str = "I am learning Core Java";
			String strs[] = str.split(" "); // the argument passed to split (" ") tells the method where to split (In this case, by spaces) the string
			System.out.println("Now splitting: \"" + str + "\"");
			System.out.println("Result: ");
			for (String s : strs){
				System.out.println(s);
			}
			break;
		default:
			// if something other than 1-3 is entered, tell the user their option was unrecognized
			System.out.println("Option unrecognized");
			break;
		}
		
		// close the scanner object
		if (sc != null)
			sc.close();
	}
	
}
