package com.revature.hmwk1.question11.package2;

import com.revature.hmwk1.question11.package1.*;

public class TwoClass {

	// create float variables
	private float num1;
	private float num2;
	
	public TwoClass(OneClass one) {
		this.num1 = one.one;
		this.num2 = one.two;
	}

	public float getNum1() {
		return num1;
	}

	public float getNum2() {
		return num2;
	}
}
