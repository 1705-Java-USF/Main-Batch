package com.assignment.q7;

import java.util.Comparator;

//Compare employees based on Name
public class employeeComparatorName implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getName().compareTo(o2.getName());
	}

}
