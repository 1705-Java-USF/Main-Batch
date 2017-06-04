package com.revature.question14;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class QuestionFourteen {
	

	public static void doCase(int i)
	{
		//have to put a try/catch around switch statements
		try( Scanner scan = new Scanner(System.in) )
		{
			//start of the switch statement
			switch(i)
			{
				//square root of number inputed by user
				case 1:                 
					System.out.println("Enter a number: ");
					double num = scan.nextDouble();
					System.out.println("The square root of " + num + " is: " + Math.sqrt(num));
					break;
				//Date of today
				case 2:
					Date today = Calendar.getInstance().getTime();
					System.out.println("Today's date is: " + today);
					break;
				//splitting the string 
				case 3:
					String str = "I am Learning core java";
					String[] arr = str.split("\\s");
					for(String s: arr)
						System.out.println(s);
					break;
			}
		} //end-try
		
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		
	}

	public static void main(String[] args) {
		
		
		doCase(1);
		System.out.println();
		doCase(2);
		System.out.println();
		doCase(3);

	}

}
