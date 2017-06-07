package Qestion11B;

import java.util.Scanner;

import Question11A.NewPackageAccessA;
//importing over the class from the other package

public class NewPackageAccessB {

	public static void main(String[] args){
		float float1;
		float float2;
		
		@SuppressWarnings("resource")
		//I just used this from intelesense for the suppression of the warning on my "input" 
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 1st float");
		float1 = input.nextFloat();
		
		System.out.println("Enter 2nd float");
		float2 = input.nextFloat();
		//Taking the user generated floats and setting the to float1 and float2
		
		NewPackageAccessA i = new NewPackageAccessA(float1, float2);
		//creating an object for the other class in the other package
		System.out.println("Here are the Floats from the other package");
		
		System.out.println("Float 1 " +i.getFloat1());
		
		System.out.println("Float 2 " +i.getFloat2());
		//getting the values of float1 and float2 and printing them out here
	}
	
	
}
