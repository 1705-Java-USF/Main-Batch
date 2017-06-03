package com.revature.q6;

public class Main {
	public static void main(String []args){
		int i = 4;
		//if the number divided by 2 and then multiplied by 2 is the same it should be even
		//2 / 2 = 1 * 2 = 2
		//3 / 2 = 1 * 2 = 2
		//4 / 2 = 2 * 2 = 4
		if((i/2)*2 == i)
			System.out.println("Even");
		else
			System.out.println("Odd");
	}

}
