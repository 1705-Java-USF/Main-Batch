package com.revature.question7;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{
	//method to compare person by name
	@Override
	public int compare(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}
	
}

