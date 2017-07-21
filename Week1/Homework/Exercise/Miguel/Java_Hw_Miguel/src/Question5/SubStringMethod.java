package Question5;

import java.util.Scanner;

public class SubStringMethod {

	public static void main(String[] args) {
		String str;
		
		Scanner input = new Scanner(System.in);
		//User input
		
		System.out.println("Enter a string with more than 10 characters");
		str = input.nextLine();
		//Tells the scanner to move on to the next element in the string
		
		

	       System.out.println("Substring starting from index 3 and ending at 10:");
	       //Directions for the user
	       System.out.println(str.substring(3, 10));
	       //The window of the string that will display
	   }
	}


