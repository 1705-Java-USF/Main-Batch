package com.assignment.q7;

import java.util.ArrayList;

public class Question7 
{

	public static void main(String[] args) 
	{
		//ArrayLsit to hold employees
		ArrayList<Employee> list = new ArrayList<>();
		
		//Populate array
		list.add(new Employee("Joe", "Sales", 34));
		list.add(new Employee("Sue", "Eng", 38));
		list.add(new Employee("Ben", "HR", 36));
		list.add(new Employee("Paul", "HR", 24));
		list.add(new Employee("Kim", "Sales", 55));
		list.add(new Employee("Carl", "Eng", 29));
		list.add(new Employee("Val", "Eng", 27));
		
		//Print unsorted array
		System.out.println("Unsorted: ");
		for(Employee e : list)
		{
			System.out.println(e);
		}
		
		//Sort employees by name and pritn
		list.sort(new employeeComparatorName());
		System.out.println("Name Sorted: ");
		for(Employee e : list)
		{
			System.out.println(e);
		}
		
		//Sort employees by age and print
		list.sort(new employeeComparatorAge());
		System.out.println("Age Sorted: ");
		for(Employee e : list)
		{
			System.out.println(e);
		}
		
		//Sort employees by department and print
		list.sort(new employeeComparatorDep());
		System.out.println("Department Sorted: ");
		for(Employee e : list)
		{
			System.out.println(e);
		}
	}

}
