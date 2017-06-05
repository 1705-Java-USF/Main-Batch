package com.revature.question7;

import java.util.ArrayList;
import java.util.List;

public class ComparingEmployees {

	public static void main(String[] args) {
			List<Employee> l = new ArrayList <>(); 		//ArraryList to hold the employees in memory
			//adding employees to list 
			l.add(new Employee(" Bobbert", 65," USF"));
			l.add(new Employee(" Adam", 42," Holly G Apts."));
			l.add(new Employee(" Charles", 25," Revature"));
	
			
			System.out.println("=====Employees Sorted by Name (Comparator)====");
				l.sort(new EmployeeNameComparator());	//calling comparator function to sort employees by name
					for(Employee e : l) {
						System.out.println(e);			//print employees according to name(alphabetically)
						}
					
						System.out.println();
						
			System.out.println("=====Employees Sorted by Age (Comparator)====");
				l.sort(new EmployeeAgeComparator());	//calling comparator function to sort employees by age
					for(Employee e : l) {
						System.out.println(e);			//print employees according to age(numerically)
						}
					
						System.out.println();
						
			System.out.println("=====Employees Sorted by Department Name (Comparator)====");
				l.sort(new EmployeeDepartmentNameComparator());	//calling comparator function to sort employees by department name
					for(Employee e : l) {
						System.out.println(e);			//print employees according to department name(alphabetically)
							}
				
	}

}
