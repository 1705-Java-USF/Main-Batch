package com.revature.q12;

import java.util.ArrayList;

public class Main {
	public static void main(String [] args){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		//adds numbers to the arraylist
		for(int i = 1; i <= 100; i++)
			nums.add(i);
		
		//prints only even numbers
		for(int i : nums){
			if(i % 2 == 0)
				System.out.println(i);
		}
	}
}
