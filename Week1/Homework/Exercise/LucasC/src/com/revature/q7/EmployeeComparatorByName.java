package com.revature.q7;

import java.util.*;

public class EmployeeComparatorByName implements Comparator<Employee> {
		
	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		String name1 = emp1.getName();   // using method getName from Employee and storing the names in variables
		String name2 = emp2.getName();
		
		int result = name1.compareTo(name2); // comparing name1 to name2 and returning the int
		
		return result ;
	}
}
