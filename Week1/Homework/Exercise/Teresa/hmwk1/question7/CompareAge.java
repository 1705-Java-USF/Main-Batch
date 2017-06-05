package com.revature.hmwk1.question7;

import java.util.Comparator;

public class CompareAge implements Comparator<Employee> {
	// custom compare class using the comparator interface 
	// to compare employees by age
	
	@Override
	public int compare(Employee a, Employee b) {
		// if age of employee a is less than employee b, then return negative
		// if age of employee a is greater than employee b, then return positive
		if (a.getAge() < b.getAge()) {
			return -1;
		}
		if (a.getAge() > b.getAge()) {
			return 1;
		}
		return 0;
	}

}
