package com.revature.hmwk1;

public class Driver {
	
	final static int TEST_INT = 5;
	final static String TEST_STRING = "This is a test string.";

	public static void main(String[] args) {
		
		/*
		 * This Driver class was used to test the the classes in this package
		 * Other packages in this package have their own driver to test the question
		 */
		
		// Q1. Perform a bubble sort  
		Question1 q1 = new Question1();
		// Q2. Write a program to display the first 25 Fibonacci numbers
		Question2 q2 = new Question2();
		// Q3. Reverse a string without using a temporary variable
		Question3 q3 = new Question3(TEST_STRING);
		// Q4. Write a program to compute N factorial
		Question4 q4 = new Question4(TEST_INT);
		// Q5. Write a substring method that accepts a string str and an integer idx
		Question5 q5 = new Question5(TEST_STRING, TEST_INT);
		// Q6. Write a program to determine if an integer is even
		Question6 q6 = new Question6(TEST_INT);
		// Q7 found in package question7
		// Q8. Write a program that stores an ArrayList and saves palindromes
		Question8 q8 = new Question8();
		// Q9. Create ArrayList storing numbers 1 to 100 and print prime numbers
		Question9 q9 = new Question9();
		// Q10. Find the minimum of two numbers using ternary operators
		Question10 q10 = new Question10(TEST_INT, (TEST_INT-1));
		// Q11 found in package question11
		// Q12. Write a program to store 1 to 100 in an array, print even numbers
		Question12 q12 = new Question12();
		// Q13. Display the triangle (shown on worksheet) on the console using any type of loop
		Question13 q13 = new Question13();
		// Q14. Write a program that demonstrates the switch case 
		Question14 q14 = new Question14(3);  // to use, enter number of case you want (1, 2, or 3)
		// Q15 found in package question15
		// Q16 tested in Question16 class
		// Q17. Write a program that calculates interest on principal, rate, and years provided by the user
		Question17 q17 = new Question17();
		// Q18 found in package question18
		// Q19. Create an ArrayList and insert integers 1 through 10.
		Question19 q19 = new Question19();
		// Q20 found in package question20
		
	}

}
