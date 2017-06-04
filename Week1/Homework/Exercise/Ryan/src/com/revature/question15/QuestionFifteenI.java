package com.revature.question15;

public interface QuestionFifteenI {
	
	//creating the method for addition
	public static int addition(int x, int y){
			int z;
	      z = x + y;
	      System.out.println(z);
	      return z;
	}
	//creating the method for subtraction
	public static int subtraction(int x, int y){
		int z;
		z = x - y;
		System.out.println(z);
		return z;
	}
	//creating the method for multiplication
	public static int multiplication(int x, int y){
		int z;
		z = x * y;
		System.out.println(z);
		return z;
		
	}
	//creating method for division
	public static int division(int x, int y){
		int z;
		z = x / y;
		System.out.println(z);
		return z;
		
	}

}