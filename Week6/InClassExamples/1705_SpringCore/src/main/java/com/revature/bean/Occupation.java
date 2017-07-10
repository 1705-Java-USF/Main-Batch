package com.revature.bean;

public class Occupation {
	private String occupation;
	private int salary;
	
	public Occupation() {
		super();
	}

	
	
	public Occupation(String occupation, int salary) {
		super();
		this.occupation = occupation;
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Occupation [occupation=" + occupation + ", salary=" + salary + "]";
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
