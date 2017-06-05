package com.revature.question2;

public class Fibonacci {

	public static void main(String[] args) {
		
		int n1 = 0 , n2 = 1, n3, i;
		System.out.println(n1 + "\n" + n2); //print first two numbers of Fibonacci sequence
		
		for(i = 2; i < 25; ++i) // start loop for fibonacci sequence after 0 and 1
		{
			n3 = n1 + n2;
			System.out.println(n3);
			n1 = n2;
			n2 = n3;
		}
	}

}
