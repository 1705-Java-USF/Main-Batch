package q4;

import java.util.Scanner;

public class Factorial {
	
	public static void main(String args[]){
		Factorial f = new Factorial();
		Scanner sc = new Scanner(System.in); // scanner object to get input
		System.out.print("Please enter a number: ");
		int n = sc.nextInt();
		if (sc != null) // close scanner object
			sc.close();
		// print out result
		System.out.println(n + " factorial: " + f.fact(n)); // 5*4*3*2*1 = 120
	}
	
	// fact method - returns the nth factorial given an integer n
	public int fact(int n){
		// return error of -1 if negative number passed
		if (n < 0)
			return -1;
		// 0 or 1 will return 0 or 1
		else if (n < 2)
			return n;
		// multiply by next number if greater than
		else{
			return n*fact(n-1);
		}
	}
}
