package com.revature.day4;

public class ThreadExample {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		System.out.println("======THREADS======\n");
		
		//First step: Create the objects for what will become threads
		ThreadThread tt = new ThreadThread();
		ThreadRunnable tr = new ThreadRunnable();
		
		Thread t1 = new Thread(tt, "Thread 1"); //state = NEW
		Thread t2 = new Thread(tr, "Thread 2"); //state = NEW
		
		
		t1.start();	//State = runnable/running
		t2.start();	//State = runnable/running
		
	}

}
