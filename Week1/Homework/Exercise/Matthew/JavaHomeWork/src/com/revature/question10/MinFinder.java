package com.revature.question10;

public class MinFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 7;
		int b = 8;
		System.out.println(min(a,b));
	}
	public static int min(int a, int b)
	{
		return (a<=b) ? a : b; 
		/*
		 * if a is less then or equal to be return a
		 * else return b
		 */
	}

}
