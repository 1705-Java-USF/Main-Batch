package com.revature.q11;

import com.revature.q11v2.FloatVar2;

public class FloatVarPackages {

	public static void main(String[] args) {
		
		String message = "Write a program that would access two float-variables from"
				+ " a class that exists in another package. Note, you will need to create"
				+ " two packages to demonstrate the solution.";
		System.out.println(message);
		
		System.out.println("1st float: " + FloatVar2.a);   // accessing it from public scope 
		System.out.println("2nd float: " + FloatVar2.b);
		
		float f = FloatVar2.getFloats();
		System.out.println("3rd float: " + f);   // accessing it from method
		
	}

}
