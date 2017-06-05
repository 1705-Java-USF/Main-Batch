package com.revature.hmwk1.question11;

import com.revature.hmwk1.question11.package1.OneClass;
import com.revature.hmwk1.question11.package2.TwoClass;

public class Driver {
	// test variables
	final static float NUM1 = 159784;
	final static float NUM2 = 369741;

	public static void main(String[] args) {
		// Q11. Write a program that accesses two float-variables from a class in another package
		// Note, you will need to create two packages to demonstrate the solution
		
		OneClass one = new OneClass(NUM1, NUM2);
		TwoClass two = new TwoClass(one);
		
		System.out.println(two.getNum1());
		System.out.println(two.getNum2());

	}

}
