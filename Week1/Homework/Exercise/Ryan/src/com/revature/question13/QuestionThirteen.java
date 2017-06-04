package com.revature.question13;

public class QuestionThirteen {

	public static void main(String[] args) {
		int i = 1;
			
			// check to see if the int is even, if not print 0 if so print 1. Repeats this type of loop throughout
			if (i%2 == 0){
				System.out.print(1);
			}
			else{
				System.out.print(0);
			}
			System.out.println();
			
		for (i = 1; i < 3; i++){
			
			if (i%2 == 0){
				System.out.print(0);
			}
			else{
				System.out.print(1);
			}
		}
		System.out.println();
		
		for(i = 1; i < 4; i++){
			if (i%2 == 0){
				System.out.print(0);
			}
			else{
				System.out.print(1);
			}
		}
		System.out.println();
		
		for(i = 1; i < 5; i++){
			if (i%2 == 0){
				System.out.print(1);
			}
			else{
				System.out.print(0);
			}
		}
		

	}

}
