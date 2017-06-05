package com.revature.question6;

public class EvenOddDeterminer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("5 is: " + ((isEven(5)) ? "Even" : "Odd"));
		System.out.println("28 is: " + ((isEven(28)) ? "Even" : "Odd"));
	}

	/*
	 * Restriction: Do not use % operator
	 */
	public static boolean isEven(int i) {
		/*
		 * First divide the number by two. If the number is odd, because it is
		 * an integer the decimal will be cut off leaving the number smaller
		 * than half the original number really is. Multiplying it by two means
		 * that the number will be less than the original number.
		 */
		if (((i / 2) * 2) == i) {
			return true;
		}
		return false;
	}

}
