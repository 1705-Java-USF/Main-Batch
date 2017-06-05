package com.javahw.qten;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QTen {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please input two numbers");
		
		
		try{
			int x = scan.nextInt();
			int y = scan.nextInt();
			scan.close();
			
			System.out.println("The minimum (of the first two numbers) is: " + ternMin(x,y));
		}catch(InputMismatchException e){
			System.out.println("Invalid input");
		}

	}
	
	//Return the minimum between two numbers
	static int ternMin(int a, int b) {
		int min;
		min = a < b ? a : b;
				
		return min;
	}
}
