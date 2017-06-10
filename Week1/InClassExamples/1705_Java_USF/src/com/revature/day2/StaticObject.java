package com.revature.day2;

public class StaticObject {
	/*
	 * Static keyword will separate the method/field from specific instances of that class.
	 * IE. all future instances share that field/method.
	 * In addition to this, you can now reference static elements without having to 
	 * create an actual object, simply by reference classname.element
	 */
	static public int count = 0;
	
	//This constructor will call count++ whenever it is called. (IE the "new" keyword is invoked)
	public StaticObject(){
		count++;
	}
	
	//Static methods can be called without having to instantiate the class as an object
	public static void printCount(){
		System.out.println(count);
	}
}
