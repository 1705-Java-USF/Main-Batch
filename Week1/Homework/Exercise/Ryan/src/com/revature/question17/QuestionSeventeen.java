package com.revature.question17;

import java.util.Scanner;

public class QuestionSeventeen {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//enter in the amount for float principle 
		System.err.println("please enter principle amount:");
		float principle = scanner.nextFloat();
		//enter in the amount for float years
		System.err.println("please enter time in years:");
		float years = scanner.nextFloat();
		//enter in the amount for float rate
		System.err.println("please enter the anual rate:");
		float rate = scanner.nextFloat();
		//run the method
		float interest = questionSeventeenInterest(principle, rate, years);
		//print interest
		System.out.println("the interest is " + interest);
		
		//close scanner so no leaks occur
		scanner.close();
		

	}
	
	//method to get interest
	public static float questionSeventeenInterest(float principle, float rate, float years){
		
		float interest = principle * rate * years;
		return interest;
				
	}

}
