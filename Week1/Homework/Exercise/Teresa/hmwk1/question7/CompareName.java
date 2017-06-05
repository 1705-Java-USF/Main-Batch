package com.revature.hmwk1.question7;

import java.util.Comparator;

public class CompareName implements Comparator<Employee> {
	// custom compare class using the comparator interface 
	// to compare employees by name

	@Override
	public int compare(Employee a, Employee b) {
		// using String class compare to compare names
		return a.getName().compareTo(b.getName());
	}

}
