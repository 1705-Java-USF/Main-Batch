package com.revature.day2;

public class ControlStatements {

	public static void main(String[] args) {

		// control statements:
		// Blocks of code that control the flow of the execution

		// if statements
		/*
		 * if(comparison){ execute if true }
		 */

		boolean b = true;

		if (b == true) {
			System.out.println("hey, b was true!");
		}

		if (b) {
			System.out.println("true!");
		}

		if (b)
			System.out.println("true!");

		if (!b) {
			System.out.println("false!");
		}

		// else statements take place directly after an if.
		if (!b) { // shorthand 'for b != true'
			System.out.println("true!");
		} else {
			System.out.println("false!");
		}

		// elseif statement will take place after a failed if, but ONLY if the
		// the previous if failed.

		if (b) {
			System.out.println("do something");
		} else if (!b) {
			System.out.println("do something else");
		} else {
			System.out.println("the end!");
		}

		// Switch statements
		int i = (int) (Math.random() * 5); // Random generates a number in
											// between 0 and 1

		// switch(variable)
		switch (i) {
		case 0:
			System.out.println(0);
			break;
		case 1:
			System.out.println(1);
			break;
		default:
			System.out.println("Anything but 0-3");
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		}
		
		//while loops
		//While a condition is true, loop/
		while(true){
			System.out.println(i++);
			if(i==10){
				break;
			}
		}
		
		while(i-- != 0){
			System.out.println(i);
		}
		
		//Theres also DO while loops.
		//Perform the action at LEAST once before checking condition
		
		System.out.println("========DO WHILE=========");
		int j = 0;
		do{
			System.out.println(j);
		}while(j++ < 10);
		
		
		j=0;
		while(j++ < 10){
			System.out.println(j);
		}
		
		System.out.println("=======enhanced for loop=======");
		//Enhanced for loops (the foreach loop)
		int[] nums = new int[10];
		for(i = 0; i < nums.length; i++){
			nums[i] = i;
		}
		
		for(int num : nums){
			System.out.println(num);
		}
		
		//shorthand for creating an array:
		int[] nums2 = {0,1,2,3,4,5,6,7,8,9};
		
		
		//ternary operators
		i = (int)(Math.random()*5);
		System.out.println( (i < 3) ? true : false );
		
		//shorthanded if statements
		if(true)
			System.out.println( (i < 3) ? true : false );
		else
			System.out.println( (i < 3) ? true : false );

		System.out.println("=======break and continue======");
		//break and continue
		//Break: leaves the loop
		//Continue skips to next iteration of loop
		for(i=0; i<10; i++){
			if(i==5){
				continue;
			}
			if(i==7){
				break;
			}
			System.out.println(i);
		}
	}
}
