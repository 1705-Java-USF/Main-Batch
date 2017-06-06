package com.assignment.q7;

import java.util.Comparator;

//Compare employees based on department
public class employeeComparatorDep implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getDep().compareTo(o2.getDep());
	}

}
