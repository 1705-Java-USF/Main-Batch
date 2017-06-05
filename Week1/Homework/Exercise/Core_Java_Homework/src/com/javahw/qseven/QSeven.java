package com.javahw.qseven;

import java.util.ArrayList;
import java.util.List;

public class QSeven {
	
	public static void main(String[] args) {
		Employee e1 = new Employee("Bob", "Art", 27);
		Employee e2 = new Employee("Adam", "Computer Science", 32);
		
		List<Employee> l = new ArrayList<>();
		l.add(e1);
		l.add(e2);
	
		//Use comparator to sort by...
		//name
		l.sort(new EmployeeComparatorByName());
		System.out.println(l);
		
		//department
		l.sort(new EmployeeComparatorByDepartment());
		System.out.println(l);
		
		//age
		l.sort(new EmployeeComparatorByAge());
		System.out.println(l);
	}
	
	


}
