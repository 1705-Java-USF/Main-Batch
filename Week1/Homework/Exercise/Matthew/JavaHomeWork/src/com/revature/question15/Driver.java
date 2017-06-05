package com.revature.question15;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mathable<Integer> ops = new IntegerMath();
		int a = 1;
		int b = 5;
		System.out.println(ops.add(1, 2));
		System.out.println(ops.subtract(a, b));
		System.out.println(ops.divide(a, b));
		System.out.println(ops.multiply(a, b));

	}

}
