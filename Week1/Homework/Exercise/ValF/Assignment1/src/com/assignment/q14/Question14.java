package com.assignment.q14;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;


public class Question14 
{
		
	public static void main(String[] args) 
	{
		/*
		 * Varables: integer to hold menu option, boolean to evaluate if menu
		 * input is within range, scanner to read in user input
		 */
		Question14 q = new Question14();
		int option = -1;
		boolean valid = false;
		Scanner scan = new Scanner(System.in);
		
		//Display menu
		System.out.println("Menu:\t1)SquareRoot\n\t2)Date\n\t3)String Split");
		System.out.print("\nEnter a number: ");
	
		//While input is out of range, keep prompting
		while(!valid)
		{
			try
			{
				//Read user input
				option = scan.nextInt();
				
				//Evaluete value
				if((option >= 1) && (option <= 3))
				{
					valid = true;
				}
				else
					System.out.print("Invalid number, try again: ");
			}
			//Catch input that might not be of integer value
			catch(InputMismatchException e)
			{
				System.err.println("That's not even a number!!");
				//e.printStackTrace();
				valid = true;
			}
		}
		/*
		 * Case 1 calls squareRoot() method
		 * Case 2 calls todaysDate() method
		 * Case 3 calls splitString() method
		 * Default: invoked if user does not input inter value for menu
		 */
		switch(option)
		{
			case 1: q.squareRoot();; break;
			case 2: q.todaysDate();; break;
			case 3: q.splitStringt();; break;
			default: System.out.println("Try inputing a number next time.");
		}
		
		//Exit message and close scanner
		System.out.println("Goodbye.");
		scan.close();

	}
	
	public void squareRoot()
	{
		double num = 0;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("\n\n=====Root Function=====");
		System.out.print("Enter a number: ");
		
		try
		{
			num = scan.nextDouble();	
			System.out.println(Math.sqrt(num));
		}
		catch(InputMismatchException e)
		{
			System.out.println("That's not even a number!!");
			//e.printStackTrace();
		}
		scan.close();
	}

	public void todaysDate()
	{
		System.out.println("\n\n=====Date=====");
		Date date = new Date();
		System.out.println(date);
	}
	
	public void splitStringt()
	{
		System.out.println("\n\n=====Split String=====");
		String original = "I am learning Core Java", buffer = "";
		String[] arr;
		LinkedList<String> link = new LinkedList<>();
		int currLen;
		
		System.out.println("Original string: \n" + original);
		
		do
		{
			currLen = original.length(); 
			if(original.charAt(0) != ' ')
			{
				buffer += original.charAt(0);
				original = original.substring(1, currLen);
			}
			else
			{
				original = original.substring(1, currLen);
				link.add(buffer);
				buffer = "";
			}
			
		}while(!original.isEmpty());
		
		if(!buffer.isEmpty())
		{
			link.add(buffer);
		}
		
		System.out.println("Now its split in a string array");
		
		arr = new String[link.size()];
		for(int i = 0; i < link.size(); i++)
		{
			arr[i] = link.get(i);
			System.out.println(i + ")" + arr[i]);
		}
		link.clear();
	}


}
