package q10;

import java.util.Scanner;

public class MyMin {
	
	public static void main(String[] args){
		// uses a scanner object to get inputs
		MyMin mm = new MyMin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number 1: ");
		int i1 = sc.nextInt();
		System.out.print("Enter number 2: ");
		int i2 = sc.nextInt();
		
		// outputs result
		System.out.println("The smaller number is " + mm.myMin(i1, i2));
		// closes the scanner once input finished
		if (sc != null)
			sc.close();
	}
	
	public int myMin(int n1, int n2){
		// ternary operator return
		// if condition is true, returns what is left of colon
		// if condition is false, returns what is right of colon
		return n1 < n2 ? n1 : n2;
	}
}
