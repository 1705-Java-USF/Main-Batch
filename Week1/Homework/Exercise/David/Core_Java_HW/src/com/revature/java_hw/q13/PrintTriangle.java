package com.revature.java_hw.q13;

public class PrintTriangle {
	
	public static void main(String[] args) {
		//Number of lines to print (given)
		final int LINES = 4;
		
		//Bit to be printed, alternates between 1 and 0
		int bit = 0;
		
		//Loop for the number of lines
		for(int i=1; i<=LINES; i++) {
			//Loop for printing each character on the line
			for(int j=1; j <= i; j++) {
				//Print bit and then flip it
				System.out.print(bit);
				bit = 1-bit;
			}
			//Next line
			System.out.println();
		}
	}
}
