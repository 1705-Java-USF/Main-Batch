package q7;

import java.util.Comparator;

// compares employee objects by name
public class EmpComparatorName implements Comparator<Employee>{

	// uses compareTo to compare strings to save time
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
