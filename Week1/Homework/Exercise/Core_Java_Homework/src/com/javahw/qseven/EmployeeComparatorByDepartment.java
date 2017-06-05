package com.javahw.qseven;

import java.util.Comparator;

public class EmployeeComparatorByDepartment implements Comparator<Employee>{

	@Override
	public int compare(Employee a, Employee b) {
		return a.getDepartment().compareTo(b.getDepartment());
	}
}
