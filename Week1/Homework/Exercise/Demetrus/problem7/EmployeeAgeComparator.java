/* Demetrus Atkinson
 * 
 */
package com.revature.problem7;

import java.util.Comparator;

// orders Employees age in ascending order
public class EmployeeAgeComparator implements Comparator<Employees> {
	public int compare(Employees a, Employees b) {
		return ((Integer) a.getAge()).compareTo(b.getAge()); // return age in
																// ascending
																// order
	}
}
