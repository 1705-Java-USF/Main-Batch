package com.revature.question18;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exStr1 = "This is an example String";
		SuperClass s = new SubClass();
		System.out.println(s.hasCapital(exStr1));
		System.out.println(s.hasCapital(exStr1.toLowerCase()));
		System.out.println(s.upperCase(exStr1));
		System.out.println(s.getIntValue(exStr1));
	}

}
