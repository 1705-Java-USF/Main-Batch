package com.assignment.q16;

public class Question16 
{
	public static void main(String[] args) 
	{
		//If not arguments were passed display message
		//Else, print out length of first argument
		if(args.length == 0)
		 System.out.println("No command line arguements passed");
		else
			System.out.println(args[0].length());
	}
}
