package com.revature.hmwk1.question7;

import java.util.Comparator;

public class CompareDepartment implements Comparator<Employee> {
	// custom compare class using the comparator interface 
	// to compare employees by department name
	
	@Override
	public int compare(Employee a, Employee b) {
		// using String class compare to compare department names
		return a.getDepartment().compareTo(b.getDepartment());
	}

}
