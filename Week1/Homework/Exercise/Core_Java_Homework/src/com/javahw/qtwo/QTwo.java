package com.javahw.qtwo;

public class QTwo {

	public static void main(String[] args) 
	{
		//Print first 25 characters of fibonacci
		fib(25);
	}
		
	//Brute force fibonacci algorithm
	static void fib(int iteration)
	{
		int first = 0;
		int second = 1;
		int i = 0;
		int fib = 0;
		
		while (i < iteration)
		{
			System.out.println(first);
			i++;
			fib = first + second; 
			first = second;
			second = fib;
		}
	}
	
	

}
