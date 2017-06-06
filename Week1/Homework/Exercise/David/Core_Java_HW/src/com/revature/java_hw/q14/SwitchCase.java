package com.revature.java_hw.q14;


import java.util.Calendar;
import java.util.Scanner;

public class SwitchCase{

	public static void main(String[] args) {
		//Instructions for the program
		System.out.println("Demonstrating switch cases, which method would you like to run?");
		System.out.println("1: Find the Square root of a number");
		System.out.println("2: Display today's date");
		System.out.println("3: Split a given string and store it in a String array\n");
		System.out.println("Please Enter 1, 2, or 3 to select one of the above options");
		Scanner scan = new Scanner(System.in);
		
		//Read in and store 1, 2, or 3
		int num = 0;
		do {
			while(!scan.hasNextInt()){
				scan.next();
			}
			num = scan.nextInt();
		} while (num < 1 || num > 3);
		
		//Switch statement to operate based on the number entered
		switch(num) {
		
		//Find the square root
		case 1:
			System.out.println("Enter a number to find its square root.");
			while(!scan.hasNextDouble()) {
				scan.next();
			}
			double d = scan.nextDouble();
			System.out.println("The Square root of " + d + " is " + Math.sqrt(d));
			break;
		
		//Display today's date
		case 2:
			Calendar cal = Calendar.getInstance();
			System.out.println("Today's date is " + (cal.get(Calendar.MONTH)+1) + "/" +
								cal.get(Calendar.DATE) + "/" + cal.get(Calendar.YEAR));
			break;
			
		//Split the string "I am learning Core Java" into a string array
		case 3:
			System.out.println("The string \"I am learning Core Java\" will be split into an array.");
			String str = "I am learning Core Java";
			String[] strArray = str.split(" ");
			
			//Print the array
			System.out.print("Array: [" + strArray[0]);
			for(int i=1; i<strArray.length; i++)
				System.out.print(", " + strArray[i]);
			System.out.println("]");
			break;
		}
		
		scan.close();
	}

}
