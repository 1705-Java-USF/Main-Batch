package com.revature.bean;

public class Person {
	private String name;
	private int age;
	private int height;
	private int weight;
	//Person has a dependency for Occupation
	private Occupation occupation;
	
	public Person() {
		super();
	}
	
	
	
	public Person(String name, int age, int height, int weight, Occupation occupation) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.occupation = occupation;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + ", occupation="
				+ occupation + "]";
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
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Occupation getOccupation() {
		return occupation;
	}
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
	
	
}
