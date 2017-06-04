package q6;

import java.util.Scanner;

public class IsEven {

	public static void main(String[] args) {
		// Uses a scanner object to retrieve input
		IsEven ie = new IsEven();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check parity: ");
		int n = sc.nextInt();
		
		// close scanner after input
		if (sc != null)
			sc.close();
		// check if input is even
		if (ie.isEven(n))
			System.out.println(n + " is even");
		// could call isOdd here - but it's unnecessary as if n isn't even it has to be odd
		else
			System.out.println(n + " is odd");

	}

	// isEven method - return true if i is even, otherwise false
	public boolean isEven(int i){
		// base case
		if (i == 0)
			return true;
		// i is even if i - 1 is odd
		else
			return isOdd(i - 1);
	}
	
	// isOdd method - return true if i is even, otherwise false
	public boolean isOdd(int i){
		// base case
		if (i == 0)
			return false;
		// i is odd if i - 1 is even
		else 
			return isEven(i - 1);
	}
}
