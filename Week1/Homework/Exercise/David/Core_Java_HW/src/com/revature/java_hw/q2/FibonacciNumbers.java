package com.revature.java_hw.q2;

public class FibonacciNumbers {
	public static void main(String[] args) {
		//Number of fibonacci numbers to print (given)
		final int NUMBER = 25;
		
		FibonacciNumbers q = new FibonacciNumbers();
		q.fibonacci(NUMBER);
	}
	
	//Returns fibonacci number num and prints fibonacci numbers up to (and including) num.
	public int fibonacci(int num) {
		//The main algorithm for finding fibonacci numbers by adding the previous 2.
		if(num >= 2) {
			//Print and set the first two fibonacci numbers
			System.out.println(0);
			System.out.println(1);
			int prev0 = 0;
			int prev1 = 1;
			//Flag used to switch between updating prev0 and prev1
			boolean previous = false;
			
			//Loop through until you get 1 less than the number of fibonacci numbers requested
			for(int i=3; i<=num; i++) {
				//Alternate which previous to update
				if(previous) {
					prev1 += prev0;
					System.out.println(prev1);
					previous = !previous;
				}
				else {
					prev0 += prev1;
					System.out.println(prev0);
					previous = !previous;
				}
			}
			return prev0 + prev1;
		} else if(num == 1) { //Base case for the 1st fibonacci number
			System.out.println(0);
			return 0;
		} else { //Asked for the "0th" or negative fibonacci number. Invalid
			System.out.println("Invalid. Can't find fibonacci number " + num + ". Returned -1");
			return -1;
		}
	}
}
