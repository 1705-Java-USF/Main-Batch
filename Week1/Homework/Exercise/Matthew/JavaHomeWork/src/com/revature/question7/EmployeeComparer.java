package com.revature.question7;

import java.util.Comparator;

public class EmployeeComparer implements Comparator<Employee> {
	public static enum Settings { // The settings that can be used for determing
									// sort order
		AGE, NAME, DEPARTMENT
	}

	private Settings setting; // Used to determine what the Employee should be
								// sorted by

	public EmployeeComparer() {
		setting = Settings.AGE; // Default value to AGE
	}

	public EmployeeComparer(Settings setting) { // Constructor to initialize
												// Sort setting
		this.setting = setting;
	}

	@Override
	public int compare(Employee o1, Employee o2) { // Compares based on what the
													// setting is
		// TODO Auto-generated method stub
		switch (setting) { // Select method and what to pass as parameters based
							// on the setting
		case AGE:
			return compareByInt(o1.getAge(), o2.getAge());
		case NAME:
			return compareByString(o1.getName(), o2.getName());
		case DEPARTMENT:
			return compareByString(o1.getDepartment(), o2.getDepartment());
		}
		return 0;
	}

	private int compareByInt(int i1, int i2) { // Compare by an integer
		return i1 - i2;
	}

	private int compareByString(String s1, String s2) { // Compare by a string
		return s1.compareTo(s2);
	}

	public void setSetting(Settings setting) { // Setter for setting
		this.setting = setting;
	}

	public Settings getSetting() { // GEtter for setting
		return setting;
	}

}
