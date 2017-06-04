package q7;

public class Employee {
	
	// private fields
	private String name;
	private String dept;
	private int age;
	
	public Employee(String name, String dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	// toString for printing
	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}

	// accessors
	
	public String getName(){
		return this.name;
	}
	
	public String getDept(){
		return this.dept;
	}
	
	public int getAge(){
		return this.age;
	}
	
	// mutators
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDept(String dept){
		this.dept = dept;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
}
