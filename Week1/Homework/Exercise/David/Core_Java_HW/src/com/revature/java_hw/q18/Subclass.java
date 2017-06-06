package com.revature.java_hw.q18;

public class Subclass extends AbstractSuperclass{
	//Extends AbstractSuperclass, meaning it implements all unimplemented methods
	@Override
	public boolean anyUpperCase(String str) {
		//String is not equal to the string with lowercase letters means at least one upper case letter
		return !str.equals(str.toLowerCase());
	}

	@Override
	public String toUpperCase(String str) {
		//String method toUpperCase() returns the string with all letters converted to upper case
		return str.toUpperCase();
	}
	
	@Override
	public int parseStringToInt(String str) {
		//parse the String as an int, add 10. print out and return the result.
		int num = Integer.parseInt(str) + 10;
		System.out.println(num);
		return num;
	}

}
