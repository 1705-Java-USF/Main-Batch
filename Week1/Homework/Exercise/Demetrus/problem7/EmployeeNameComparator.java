/* Demetrus Atkinson
 * 
 */
package com.revature.problem7;

import java.util.Comparator;

//order the name in a natural ascending order (alphabetical) based on first letter of String
public class EmployeeNameComparator implements Comparator<Employees> {

	public int compare(Employees a, Employees b) {
		return a.getName().compareTo(b.getName()); // returns the name in
													// ascending (alphabetical)
													// order
	}

}
