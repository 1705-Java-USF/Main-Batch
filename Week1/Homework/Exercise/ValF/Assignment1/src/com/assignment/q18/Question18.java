package com.assignment.q18;

public class Question18 
{

	public static void main(String[] args) 
	{
		//Create an instance of subclass 
		SubClass sub = new SubClass();
		
		//Test each method in subclass
		System.out.println(sub.upperCheck("maimiHeat"));
		System.out.println(sub.upperCheck("maimiheat"));
		System.out.println(sub.toUpperCase("MaimIHeaT"));
		System.out.println(sub.toUpperCase("miamiheat"));
		System.out.println(sub.strToInt(""));
		System.out.println(sub.strToInt("MiamiHeat"));
	}

}
