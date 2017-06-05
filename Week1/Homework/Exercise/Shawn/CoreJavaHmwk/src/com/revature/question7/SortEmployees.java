package com.revature.question7;

import java.util.ArrayList;
import java.util.List;

public class SortEmployees {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Joshua", "Computer Science", 22));
		employees.add(new Employee("Evan", "Urban Planning", 20));
		
		// Sort Employees by name using Comparator.
		System.out.println("===Sort By Name===");
		employees.sort(new EmployeeComparatorByName());
		System.out.println(employees + "\n");
		
		// Sort Employees by department using Comparator.
		System.out.println("===Sort By Department===");
		employees.sort(new EmployeeComparatorByDepartment());
		System.out.println(employees + "\n");
		
		// Sort Employees by age using Comparator.
		System.out.println("===Sort By Age===");
		employees.sort(new EmployeeComparatorByAge());
		System.out.println(employees + "\n");
	}
}
