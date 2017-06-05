package com.revature.question19;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			ints.add(i);
		}
		System.out.println(ints);
		System.out.println(ArrayListOps.sumOfEvenNumbers(ints));
		System.out.println(ArrayListOps.sumOfOddNumbers(ints));
		ArrayListOps.removePrimeNumbers(ints);
		System.out.println(ints);
	}

}
