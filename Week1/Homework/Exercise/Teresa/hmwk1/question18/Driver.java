package com.revature.hmwk1.question18;

public class Driver {
	
	// Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass
	// Create an appropriate class having a main method to test the above setup
	
	// create test variables
	final static String STR1 = "sfdrDgfdJ";
	final static String STR2 = "NgfdFbgJnfdDjhgSIO";
	final static String NUM = "45";

	public static void main(String[] args) {
		ParentClass pc = new ChildClass();
		System.out.println( pc.hasUpperCase(STR1) );
		System.out.println( pc.convertCase(STR2) );
		pc.addTen(NUM);

	}

}
