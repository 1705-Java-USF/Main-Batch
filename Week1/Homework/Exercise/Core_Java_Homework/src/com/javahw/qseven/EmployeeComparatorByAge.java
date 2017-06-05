package com.javahw.qseven;

import java.util.Comparator;

public class EmployeeComparatorByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee a, Employee b) {
		return (a.getAge() > b.getAge()) ? 1 : -1;
	}
}
