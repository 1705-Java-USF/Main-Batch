package com.revature.question15;

public class QuesitonFifteen implements QuestionFifteenI{

public static void main(String[] args) {
		
		int x = 10;
		int y = 20;
		
		//print x + y
		QuestionFifteenI.addition(x, y);
		
		System.out.println("=========subtraction=======");
		//print x - y
		QuestionFifteenI.subtraction(x, y);
		
		System.out.println("======multiplicatoin======");
		//print x * y
		QuestionFifteenI.multiplication(x, y);
		
		System.out.println("======division========");
		//print x / y
		QuestionFifteenI.division(x, y);
		
		
		

	}

}
