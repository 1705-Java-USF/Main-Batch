package com.revature.question7;

import java.util.Comparator;

public class EmployeeComparatorByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getAge() < e2.getAge())
			return -1;
		if (e1.getAge() > e2.getAge())
			return 1;
		return 0;
	}

}
