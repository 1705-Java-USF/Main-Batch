package com.revature.question7;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getName().compareTo(e2.getName());	//comparing strings e1 and e2
														
	}
	

	

}
