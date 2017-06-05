package com.revature.question_18;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		final Scanner scan = new Scanner(System.in);
		ConcreteClass cc = new ConcreteClass();
		String input;
		
		do {
			System.out.print("Input all letters for upper case check: ");		// User input: For upper case methods.
			input = scan.nextLine();
		} while(!input.chars().allMatch(Character::isLetter));					// Lambda check: All letter.
		
		System.out.println("Is upper case: " + cc.isUpperCase(input));
		System.out.println("All upper case: " + cc.convertToUpperCase(input));
		
		do {
			System.out.print("Input all numbers for Integer conversion: ");		// User input: For Integer conversion.
			input = scan.nextLine();
		} while(!input.chars().allMatch(Character::isDigit));					// Lambda check: All digit.
		
		scan.close();
		
		System.out.println("Integer: " + cc.convertStringToInteger(input));
	}
}
