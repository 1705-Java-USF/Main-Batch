package com.revature.q7;

import java.util.Comparator;

public class EmployeeComparatorByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2)
	{
		int age1 = emp1.getAge();
		int age2 = emp2.getAge();
		
		int result = age1 < age2 ? -1 : age1 > age2 ? 1 : 0;  // returning either -1, 1, or 0
		//return emp1.getAge().compareTo(emp2.getAge());
		
		return result;
	}
	
}
