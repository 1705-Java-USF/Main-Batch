package Question7;

import java.util.Comparator;

//Import Comparator and need to implements the comparator interface of Employee!
public class EmployeeComparatorByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		//Gets the names of the two from Employee.java and compares them.
		return o1.getName().compareTo(o2.getName());
	}
}
