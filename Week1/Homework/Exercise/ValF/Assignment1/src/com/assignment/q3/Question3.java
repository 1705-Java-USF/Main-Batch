package com.assignment.q3;

public class Question3 {

	public static void main(String[] args) 
	{
		//Initiate string
		String str = "reverse this";
		
		//Iterate from the last spot of the string down to the first
		for(int i = str.length() -1 ; i >= 0; i--)
		{
			//Print each character
			System.out.print(str.charAt(i));
		}

	}

}
