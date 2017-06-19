package com.revature.day3;

import java.io.Serializable;

public class Employee implements Serializable{
	/*
	 * Serializable is a "Marker Interface".
	 * A marker interface is simply an interface with no methods whatsoever.
	 * Serves simply to "mark" a class as something, in this case, serializable.
	 * Other classes will be restricted to only accepting classes/objects that inherit from a 
	 * specific marker interface.
	 */
	
	private String firstName;
	private String lastName;
	private transient int ssn; 
	//Marking a field as transient will ensure the value is not serialized with the object.
	//Replaces value itself with the default.
	
	
	
	public Employee(String firstName, String lastName, int ssn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}
	
	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + "]";
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	
}
