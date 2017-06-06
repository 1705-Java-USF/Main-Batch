package com.revature.q7;

import java.util.*;

public class EmployeeComparatorByDpt implements Comparator<Employee> {
	
	public int compare(Employee emp1, Employee emp2)
	{
		/*String dpt1 = emp1.getDpt();
		String dpt2 = emp2.getDpt();
		
		int result = dpt1.compareTo(dpt2);
		
		return result;*/
		return emp1.getDpt().compareTo(emp2.getDpt());  // doing all of that ^^ in one line
	}

}
