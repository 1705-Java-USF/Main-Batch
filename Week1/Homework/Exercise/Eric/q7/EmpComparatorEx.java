package q7;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpComparatorEx{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, dept;
		int age;

		/*
		 * Uses scanner to gather input on both employees
		 */
		
		System.out.println("Enter employee 1 info: ");
		System.out.print("Name: ");
		name = sc.next();
		System.out.print("Department: ");
		dept = sc.next();
		System.out.print("Age: ");
		age = sc.nextInt();
		
		// Field constructor called
		Employee e1 = new Employee(name, dept, age);
		
		System.out.println("Enter employee 2 info: ");
		System.out.print("Name: ");
		name = sc.next();
		System.out.print("Department: ");
		dept = sc.next();
		System.out.print("Age: ");
		age = sc.nextInt();
		
		// Field constructor called
		Employee e2 = new Employee(name, dept, age);
		
		// close input scanner
		if (sc != null)
			sc.close();
		
		// store in an array
		ArrayList<Employee> e_list = new ArrayList<>();
		e_list.add(e1);
		e_list.add(e2);
		
		// sorts using each Comparator class
		// then outputted on console
		e_list.sort(new EmpComparatorDept());
		System.out.println("Sorted by Department: ");
		System.out.println(e_list);
		
		e_list.sort(new EmpComparatorName());
		System.out.println("Sorted by Name: ");
		System.out.println(e_list);
		
		e_list.sort(new EmpComparatorAge());
		System.out.println("Sorted by Age: ");
		System.out.println(e_list);
	}

}
