package com.revature.q15;

public class Operands implements Operations {
	//The two operands that will be used in the operations
	private double first, second;

	public Operands(){
		//default values
		this.first = 5;
		this.second = 6;
	}
	
	@Override
	public double addition() {
		// Adds the two operands
		return first + second;
	}

	@Override
	public double subtraction() {
		// Subtracts the operands
		return first - second;
	}

	@Override
	public double multiplication() {
		// Multiplies the operands
		return first * second;
	}

	@Override
	public double division() {
		// Divides the operands
		return first / second;
	}
	
	
}
