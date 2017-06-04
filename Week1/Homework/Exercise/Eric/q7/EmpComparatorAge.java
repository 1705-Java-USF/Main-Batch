package q7;

import java.util.Comparator;

// compares employee objects by age
public class EmpComparatorAge implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// use getter/accessors to get each employees age
		if (o1.getAge() > o2.getAge())
			return 1;
		else if (o1.getAge() < o2.getAge())
			return -1;
		else
			return 0;
	}

}
