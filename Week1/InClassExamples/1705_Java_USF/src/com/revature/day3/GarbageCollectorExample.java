package com.revature.day3;

public class GarbageCollectorExample {

	public static void main(String[] args) {
		//Garbage collector will collect in an arbitrary order.
		
		//Using system.gc will request the collector to work. However,
		//it will DRAMATICALLY slow down the system when used.
		
		for(int i = 0; i < 1000000000; i++){
			GarbageObject go = new GarbageObject(i);
			System.gc(); 
		}
	}

}
