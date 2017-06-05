package com.revature.day3;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	/*
	 * compareTo is used to define how an object gets considered to be "ordered".
	 * This is how you define the natural ordering for numerous versions of this object.
	 */
	@Override
	public int compareTo(Person p) {
		if(this.age < p.age){
			return -1; //You can return anything, long as its negative
		}
		if(this.age > p.age){
			return 1; //This means the current object is "greater than" the comparison
		}
		return 0; //Person is equal to comparison
	}
	
	/*
	 * Use comparable, when you have access to the contents of the class you are comparing.
	 * You can define the natural ordering of the class from within.
	 */
	
	
}
