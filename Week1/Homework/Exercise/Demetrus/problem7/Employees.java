/* Demetrus Atkinson
 * 
 */
package com.revature.problem7;

public class Employees {

	// instance variable are well encapsulated, so they cannot be referred to
	// directly

	private String name;
	private int age;
	private String department;

	// Employee constructor: must have a name, age and department
	public Employees(String name, int age, String department) {
		// this refers to the Employees class
		this.name = name;
		this.age = age;
		this.department = department;
	}

	// getters and setters for name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// getters and setters for age
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// getters and setters for department
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// String needs to be overridden to sort other object Strings
	public String toString() {
		return "Employees [name: " + name + ", age: " + age + ", department: " + department + "]";
	}

}
