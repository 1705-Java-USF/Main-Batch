package com.revature.question7;

import java.util.Comparator;

public class EmployeeDepartmentNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getDepartmentName().compareTo(e2.getDepartmentName());	//comparing strings e1 and e2 
	}

}
