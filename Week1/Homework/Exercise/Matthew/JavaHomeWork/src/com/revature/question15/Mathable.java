package com.revature.question15;

public interface Mathable<T> {  //Generic Math operations Interface
	public T add(T t1, T t2);
	public T subtract(T t1, T t2);
	public T multiply(T t1, T t2);
	public T divide(T t1, T t2);
}
