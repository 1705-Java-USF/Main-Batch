package com.revature.question13;

public class TrianglePrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printTriangle(4);
	}
	public static void printTriangle(int lines)
	{
		int currentLineLength = 1; //the size of the current line
		int currentNumber = 0; //the number that will be printed
		for(int l = 0; l < lines; l++) //iterate through all the lines
		{
			for(int i = 0; i < currentLineLength; i++) //iterate through the size of the current line
			{
				System.out.print(currentNumber); // print the number and then switch it
				if(currentNumber == 0)
				{
					currentNumber = 1;
				}else
				{
					currentNumber = 0;
				}
			}
			System.out.println(); // end the line
			currentLineLength ++; // increase the size of the line by 1 for the next time through
		}
		
	}

}
