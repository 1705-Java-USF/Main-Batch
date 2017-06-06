package com.revature.q7;

import java.util.*;

public class SortEmployees {

	public static void main(String[] args) {

		String message = "Sort two employees based on their name, department, and age using the Comparator interface.";
		System.out.println(message);
	
		ArrayList<Employee> emp = new ArrayList<>();  // creating a list of type Employee named emp
		
		Employee e1 = new Employee("Lucas", "dev", 25);  // creating two instances of Employee named e1/e2
		Employee e2 = new Employee("Bob", "it", 24);
		emp.add(e1);           // adding both objects to ArrayList emp
		emp.add(e2);
		
		emp.sort(new EmployeeComparatorByName());  // sort list emp by the manner the EmployeeComparator tells it to(by Name)
		
		for (Employee i : emp)   // printing out the list after it was sorted by name
		{
			System.out.println(i);
		}
		
		EmployeeComparatorByDpt byDpt = new EmployeeComparatorByDpt();  // creating new instance of type EmployeeComparatorByDpt
		emp.sort(byDpt);  // sorting emp list by the manner empInstance tells it to (by dpt)
		
		System.out.println(emp);  // prints out the list after being sorted
		
		emp.sort(new EmployeeComparatorByAge());  // sort them by age
		System.out.println(emp);
	
		
		
	}

}
