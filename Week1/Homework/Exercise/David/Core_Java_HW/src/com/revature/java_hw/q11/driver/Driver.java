package com.revature.java_hw.q11.driver;

import com.revature.java_hw.q11.floats.StoringFloats;

public class Driver {
	
	public static void main(String[] args) {
		//Create an instance of the class in a different package
		StoringFloats otherClass = new StoringFloats(3.14f, 5f);
		
		//Use the getters to get the floats.
		System.out.println("The StoringFloats class has float: " + otherClass.getF1());
		System.out.println("The StoringFloats class also has a float: " + otherClass.getF2());
		
	}
}
