package com.revature.q3;

public class Main {

	public static void main(String[] args){
		String test = "lesson";
		//Prints initial string
		System.out.println(test);
		//Prints each character from end to beginning
		for(int i = test.length()-1; i >= 0; i--)
			System.out.print(test.charAt(i));
	}
}
