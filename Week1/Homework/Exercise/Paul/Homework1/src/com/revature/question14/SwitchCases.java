package com.revature.question14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SwitchCases {

	//field variables to be accessed by the Scanner class 
	private static Scanner scan;
	private static Scanner root;

	public static void main(String[] args) {
		
		
			//Output menu for the switch cases
			//each number represents a different case 
			System.out.println("Please Select an Option: " + "\n");
			System.out.println("1: Find Square Root of Number");
			System.out.println("2: Display Today's Date");
			System.out.println("3: Split String in String Array");
			System.out.println("4: Exit");
			
			//Scanner to get input for menu selection 
			scan = new Scanner(System.in);
			int i = 1; 
			 i =  scan.nextInt();
			 
			 
			 
			switch(i){
			case 1:						//case one runs square root method
				double num = 0; 
				findSqrRoot(num);		
				break;
			case 2:						//case two runs display date method
				displayDate();
				break;
			case 3:						//case three runs split string method
				splitString();
				break;
			default:
				System.out.println("Good Bye...");	//case 4 ends program
				break;
			}
		}
	
	
	//method to find square root using the Math class
	public static void findSqrRoot(double x){
		System.out.println("Please Enter a Number: ");
		root = new Scanner(System.in);
		x = root.nextInt(); 
		System.out.println("The Square Root is: " + Math.sqrt(x));
	}
	
	//method to display today's date using the DateTimeFormatter class
	public static void displayDate(){ 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		System.out.println("Today's Date is: "+dtf.format(localDate));
		
	}
	//method to split string and put in string array 
	//string is separated whenever it encounters a whitespace
	//as denoted by string.split("\\s+")
	public static void splitString() {
		String string = "I am learning Core Java";
		String [] array = string.split("\\s+");
		for(int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
}

