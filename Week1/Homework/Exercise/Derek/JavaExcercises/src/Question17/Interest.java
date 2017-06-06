package Question17;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		
		//Scanner for user input towards with print statements for each
		//requirement for the equation to calculate interest.
		Scanner sc = new Scanner(System.in);
		System.out.println("Provide principal: ");
		double p = sc.nextDouble();
		System.out.println("Provide rate: ");
		double r = sc.nextDouble();
		System.out.println("Provide number of years: ");
		int t = sc.nextInt();
		
		//Calculates the interest and prints to console, then close scanner.
		double i = p*(r/100)*t;
		System.out.println(i);
		sc.close();
	}

}
