package com.revature.day2;

public class PojoExample {
	//Plain Old Java Object
	/*
	 * POJO is a design pattern.
	 * The pattern dictates that you create a plain object that has
	 * both, getters and setters for each "private" instance member.
	 * In addition to this, you must override toString() and provide a no-args constructor.
	 */
	private String name;
	private int age;
	
	/*
	 * Constructors are called via the "new" keyword when instantiating an object.
	 * Constructor will be the first method called in the lifecycle of an object.
	 * 
	 * If no constructor is defined for an object you created, the compiler provides a "default constructor"
	 * which is simple a no-args constructor that calls "super();"
	 */
	/*
	public PojoExample(){ What a supplied default constructor looks like.
		super();	//Super references the parent class version of something.
	}
	*/
	public PojoExample(){ //No-args constructor
		this.name = "default";
		this.age = 10;
	}
	
	public PojoExample(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PojoExample other = (PojoExample) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override //This is an annotation
	public String toString() {
		return "PojoExample [name=" + name + ", age=" + age + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; //"this" keyword: References the class itself.
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
