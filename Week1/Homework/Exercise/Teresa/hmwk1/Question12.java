package com.revature.hmwk1;

import java.util.ArrayList;

public class Question12 {
	// Q12. Write a program to store numbers from 1 to 100 in an array
	// Print out all the even numbers from the array 
	// Use the enhanced FOR loop for printing out the numbers
	
	private ArrayList<Integer> list;
	final int SIZE = 100;
	
	public Question12 () {
		list = new ArrayList<Integer>();
		// create ArrayList with numbers 1 to 100
		for (int i = 1; i < SIZE+1; i++) {
			list.add(i);
		}
		// print all even numbers
		printEven(list);
	}

	private void printEven(ArrayList<Integer> listCreated) {
		// use enhanced loop to extract each integer value in list
		// use mod by 2 to determine if even
		for (int i : listCreated) {
			if (i%2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.print("\n");
	}
}
