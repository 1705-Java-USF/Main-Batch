package com.revature.question7;

import java.util.Comparator;

public class PersonComparatorDepartment implements Comparator<Person>{
	//method to compare person by department
	@Override
	public int compare(Person a, Person b) {
		return a.getDepartment().compareTo(b.getDepartment());
	}
	
}