package CoreJavaHomework.src.q7;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q7 {
	//Here, I need to define comparators to sort employees by name, department, and age.
	public static void main(String[] args) {
		//First, define two employees.
		Employee greg = new Employee();
		Employee ryan = new Employee();
		
		//Then, give them names, departments, and ages.
		greg.name = "Greg";
		ryan.name = "Ryan";
		greg.department = "Redundant Department of Redundancy";
		ryan.department = "Awesome Department of Epic Dragon-Riding Zombie Slayers";
		greg.age = (int) (60*Math.random()) + 20;
		ryan.age = (int) (60*Math.random()) + 20;
		
		//Create three priority queues to contain the employees and sort by different criteria.
		//Priority queues automatically sort their contents based on the given comparator.
		PriorityQueue<Employee> pqName = new PriorityQueue<Employee>(new EmployeeComparatorName());
		PriorityQueue<Employee> pqDept = new PriorityQueue<Employee>(new EmployeeComparatorDepartment());
		PriorityQueue<Employee> pqAge = new PriorityQueue<Employee>(new EmployeeComparatorAge());
		
		//Add each employee to each priority queue.
		pqName.add(greg);
		pqName.add(ryan);
		pqDept.add(greg);
		pqDept.add(ryan);
		pqAge.add(greg);
		pqAge.add(ryan);
		
		//Output the results.
		System.out.println("Sort by name:");
		for(Employee curr : pqName)
		{
			System.out.println(curr);
		}
		System.out.println("Sort by department:");
		for(Employee curr : pqDept)
		{
			System.out.println(curr);
		}
		System.out.println("Sort by age:");
		for(Employee curr : pqAge)
		{
			System.out.println(curr);
		}
	}

}

//This comparator compares employees purely through their names, with no consideration for department or age.
//It uses the default String ordering.
class EmployeeComparatorName implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2)
	{
		return o1.name.compareTo(o2.name);
	}
}

//This comparator compares employees purely through their departments, with no consideration for name or age.
//It uses the default String ordering.
class EmployeeComparatorDepartment implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2)
	{
		return o1.department.compareTo(o2.department);
	}
}

//This comparator compares employees purely through their ages, with no consideration for department or name.
//It uses the default Integer ordering.
class EmployeeComparatorAge implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2)
	{
		return Integer.compare(o1.age, o2.age);
	}
}

//This is a very simplistic class that uses the default constructor and public access to its variables.
//This is generally bad practice. Don't do this at home, kids. I'm a trained professional.
class Employee {
	String name;
	String department;
	int age;
	
	@Override
	public String toString()
	{
		return "Name: " + name + " Dept: " + department + " Age: " + age;
	}
}