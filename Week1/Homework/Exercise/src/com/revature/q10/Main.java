package com.revature.q10;

public class Main {
	public static void main(String[] args){
		//two test numbers
		int a = 5, b = 6;
		//prints the minimum of the two
		System.out.println(min(a,b));
	}
	public static int min(int a, int b){
		//uses ternary operator to print the minimum
		return (a < b) ? a : b;
	}

}
