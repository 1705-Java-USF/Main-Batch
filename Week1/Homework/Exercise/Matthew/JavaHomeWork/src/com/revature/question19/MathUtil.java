package com.revature.question19;

public class MathUtil {

	public static boolean isEven(int n) {
		return (n % 2 == 0) ? true : false; // if n (mod 2) = 0 then 2 | n
											// therefore it is even
	}

	public static boolean isPrime(int n) {
		return com.revature.question9.PrimeChecker.isPrime(n); // use the
																// isPrime
																// method from a
																// previous
																// Question
	}
}
