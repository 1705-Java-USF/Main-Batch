package com.revature.question15;

public class IntegerMath implements Mathable<Integer> { //Implementation of Mathable Interface for Integers

	@Override
	public Integer add(Integer t1, Integer t2) { //Adds two Integers
		return t1 + t2;
	}

	@Override
	public Integer subtract(Integer t1, Integer t2) { //Subtracts two Integers
		return t1 - t2;
	}

	@Override
	public Integer multiply(Integer t1, Integer t2) { //Multiply two Integers
		return t1 * t2;
	}

	@Override
	public Integer divide(Integer t1, Integer t2) { //Divide two integers
		return t1 / t2;
	}

}
