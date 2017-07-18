package com.revature.dao;

public class Dao {
	public SessionFactory getSessionFactory() throws RuntimeException{
		System.out.println("SessionFactory sf = new Configuration().yaddayaddayadda");
		return new SessionFactory();
	}
	
	public String getSomething(int i){
		System.out.println(i);
		return "" + i;
	}
	
	public String getSomething(String i){
		System.out.println(i);
		System.out.println(1/0);
		return i;
	}
	
	public void getSomethingElse(int i, int y){
		System.out.println(i + " " + y);
	}
}
