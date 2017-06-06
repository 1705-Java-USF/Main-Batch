package com.assignment.q7;

import java.util.Comparator;

//Compare employees based on age
public class employeeComparatorAge implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getAge().compareTo(o2.getAge());
	}
	
}
