package q17;

import java.util.Scanner;

public class InterestCalc {
	
	public static void main(String[] args){
		// Scanner used to get input from the console
		Scanner sc = new Scanner(System.in);
		
		// prompts for input
		System.out.println("Interest Calculator");
		System.out.print("Principal: $");
		double principal = sc.nextDouble();
		System.out.print("Rate (%): ");
		double rate = sc.nextDouble();
		System.out.print("Years: ");
		int yrs = sc.nextInt();
		
		if (sc != null) // close the scanner
			sc.close();
		
		// output the interest and total amount accrued
		System.out.println("Accrued interest: $" + principal*rate*yrs);
		System.out.println("Total amount: $" + (principal + principal*rate*yrs));
	}

}
