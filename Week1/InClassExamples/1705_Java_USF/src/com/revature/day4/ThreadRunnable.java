package com.revature.day4;

public class ThreadRunnable implements Runnable{
	/*
	 * Implementing runnable is a more ideal way to create Threads.
	 * It allows for the ability to extend another class, as well as 
	 * only requiring to determine WHAT gets executed as oppose to changing
	 * existing functionality of a Thread itself.
	 */
	
	
	@Override
	public void run(){
		for(int i = 0; i < 20; i++){
			System.out.println("\t\t" + Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
