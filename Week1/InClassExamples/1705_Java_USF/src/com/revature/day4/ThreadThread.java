package com.revature.day4;

public class ThreadThread extends Thread{
/*
 *  By extending the Thread class, we are aiming to change how a Thread works.
 *  For the most part, you will deal with threads by implementing runnable.
 *  -Extending Thread eliminates the ability to inherit from other classes
 *  -In addition to this, chances are you are NOT going to write a better Thread class then
 *  	the one that already exists.
 */
	
	//The run method determines what gets executed in this specific thread.
	@Override
	public void run(){
		for(int i = 0; i < 20; i++){
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
