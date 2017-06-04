package com.revature.question6;

public class QuestionSix {
	
	public static void main (String[] args){
		
		//For the numbers 1 - 5 check if even or odd
		for(int i = 1; i < 5; i++){
			isOddOrEven(i);
		}
	}
	
	//Method to check if number is even or odd using bitwise AND(&) operator
	public static void isOddOrEven(int n){
		
		//if the number & with 1 is 0 then the number is even, if not its odd
		if((n & 1) == 0){
			System.out.println("The number " + n + " is even");
		}
		else{
			System.out.println("The number " + n + " is odd");
		}
	}

}
