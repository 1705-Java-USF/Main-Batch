package Question7;

//Must implement comparable interface, using it across a number of classes.
public class Employee implements Comparable<Employee> {
	private String name;
	private String department;
	private int age;
	
	//Constructor for Employee
	public Employee (String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	/*
	 * ALL the getters and setters for the names, departments, and ages
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//toString() method to format the console prints effectively.
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	//Compare method for the age by subtracting.
	@Override
	public int compareTo(Employee o) {
		
		return this.age - o.age;
	}

	
}
