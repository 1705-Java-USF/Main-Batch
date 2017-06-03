package com.revature.q18;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperClass sc = new SubClass();
		System.out.println(sc.toUpperCase("This Is a TeSt"));
		System.out.println(sc.hasUpperCase("nope"));
		sc.printNumber("Testing");
	}

}
