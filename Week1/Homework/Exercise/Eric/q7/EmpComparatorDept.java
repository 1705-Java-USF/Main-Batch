package q7;

import java.util.Comparator;

// compares employee objects by department
public class EmpComparatorDept implements Comparator<Employee>{

	// uses string compareTo to save time and effort
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDept().compareTo(o2.getDept());
	}

}
