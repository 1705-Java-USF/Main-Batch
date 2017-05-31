package com.revature.day1;

public class HelloWorld {

	//Single line comments are done using //
	
	/*
	 * 
	 * Block level comments are done via /*
	 * 
	 */
	
	//Print to console with System.out.println();
	public static void main(String args[]) {
		System.out.println("Hello World!"); 
		
		System.out.println("sysout + (ctrl + space) shorthands a system.out");
		System.out.println("syso also works");
		
		//System.out.println will implicitly add a \n to the end of a string.
		//Use System.out.print to avoid that added \n
		
		System.out.print("1");
		System.out.print("2");
		System.out.print("3");
		System.out.print("4\n\n====================\n");
		
		System.out.println("Primitive Datatypes\n");
	
		//consider a class a blueprint for an object.
		//An object is an instance of a class that holds state.
		//in short, and object is an instance of a class.
		
		//To create an object, you must declare the datatype, name, and make it equal to a new instance.

		PrimitiveDatatypes pd = new PrimitiveDatatypes();
		
		pd.printPrimitives();
	}
}

class PrimitiveDatatypes{ //CamelCase classes
	//Any variables declared outside of all methods, are considered instance variables.
	//These can be referenced from anywhere within the class.
	
	int i; //32 bit variable. can hold -2^31/2^31-1
	double d; //64 bit. Holds Decimals. Can hold absurd sizes
	float f; //32 bit. Holds Decimals. Can also hold absurd sizes, not as extreme as double
	char c; //16 bit. Represents a single unicode letter. 
	boolean bool; //Either true or false. size is arguable... 
	byte b; //8 bits. A single byte.
	long l; //64 bits. Ranges: -2^63/2^63-1
	short s; //16 bits. 
	
	
	public void printPrimitives(){ //pascalCase methods, and variables
		//Variables declared within methods are called local variables, and can only be referenced
		//within the method it is declared in.
		//As soon as method finishes running, all variables within are collected garbage collector.
			
		System.out.println("int: " + i + "\n" +			//default = 0
							"double: " + d + "\n" +		//default = 0.0
							"float: " + f + "\n" +		//default = 0.0
							"char: " + c + "\n" +		//char = nothing.. (unicode for 0)
							"boolean: " + bool + "\n" +	//false
							"byte: " + b + "\n" +		//0
							"long: " + l + "\n" +		//0
							"short: " + s + "\n");		//0
		
	}
}
