package com.assignment.q2;

/*
 * Story: I had a professor who was obsessed with recursion
 * I did not look up this solution, is been drilled in my head for years now
 * it was actually a question on a final exam
 * I even had an assignment where I had to display fib sequence up to 250 times in C
 * overflow nightmare
 * This function takes in a number is its less than 2, it displays that same number (0,1,1)
 * else its calls itself recursively i times adding up to the correct fib value of i
 * 
 */

public class Question2 {

	public static void main(String[] args) 
	{
		//Call fib on numbers 1 to 25
		for(int i = 0; i < 25; i++)
		System.out.print(fib(i) + " ");
	}
	
	//Compute fib value 
	private static int fib(int i) 
	{
		if(i < 2)
			return i;
		else 
			return fib(i - 1) + fib(i-2);//Boom mike drop**
	}

}
