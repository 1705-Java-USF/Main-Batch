package Question7;

import java.util.Comparator;

//Import Comparator and need to implements the comparator interface of Employee!
public class EmployeeComparatorByDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		
		//Gets the departments of the two from Employee.java then compares them.
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
}
