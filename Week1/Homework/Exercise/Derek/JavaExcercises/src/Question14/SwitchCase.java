package Question14;

import java.time.LocalDate;
import java.util.Scanner;

public class SwitchCase {
	
public static void main(String[] args) {
		
		//Declaring a int 'choice' to represent the users choice in input through Scanner.
		int choice;
		Scanner input = new Scanner(System.in);
		
		//Three options
		System.out.println("Choose 1 for finding the sqrt of a number.\n"
				+ "Choose 2 for displaying today's date.\n"
				+ "Choose 3 for viewing a string split and stored into an array:");
		
		choice = input.nextInt();
		
		//Switch case for each option: Square root, Current Date, and string split into array.
		switch(choice) {
			
			case 1:
				//Asks the user for an Integer and takes its square root (casting to handle double).
				System.out.println("Enter a Integer for its square root:");
				int num = input.nextInt();
				double root = (double)Math.sqrt(num);
				System.out.println("The square root of " + num + " is " + root);
				break;
			case 2:
				//Current date using LocalDate object.
				LocalDate today = LocalDate.now();
				System.out.println("Today's date is " + today);
				break;
			case 3:
				//Taking string from question and using split() to take away
				//any spaces, then store it into a string array.
				String line = "I am learning Core Java";
				String[] words = line.split(" ");
				for(String word : words) {
					System.out.print(word);
				}
				break;
			default:
				//Prints message when user tries any other integers
				//not between 1 and 3 and close scanner.
				System.out.print("Not an appropriate choice, choose between 1 and 3!");
				input.close();
						
		}
		
	}

}
