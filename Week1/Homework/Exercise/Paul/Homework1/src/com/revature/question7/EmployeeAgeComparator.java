package com.revature.question7;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {
	
	//comparator function to compare employees 
	//this is function is called from my ComparingEmployees class
	//in this particular class, the employees are compared by age(integer) 
	
	@Override
	public int compare(Employee e1, Employee e2) {
		
		/*
		 * Integer wraps primitive type of int to object of type int
		 * compare() is able to compare the int values and returns 0 if equal
		 * less than 0 if e1 < e2 and greater than 0 if e1 > e2 
		 * 
		 */
		return Integer.compare(e1.getAge(), e2.getAge());		
	}
		
}


