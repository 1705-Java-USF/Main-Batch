/* Demetrus Atkinson
 * 
 */
package com.revature.problem7;

import java.util.Comparator;

// order the department in a natural ascending order (alphabetical) based on first letter of String
public class EmployeeDepartmentComparator implements Comparator<Employees> {

	public int compare(Employees a, Employees b) {
		return a.getDepartment().compareTo(b.getDepartment()); // returns the
																// department in
																// ascending
																// (alphabetical)
																// order
	}
}
