package com.revature.day3;

public class GarbageObject {
	int id;
	
	public GarbageObject(int id){
		this.id = id;
		System.out.println("Created Object: " + id);
	}
	
	//This method is called before it is garbage collected. The final method of the lifecycle of an object.
	//Called by the garbage collector
	
	@Override
	public void finalize(){
		System.out.println("\t\tCollecting Object: " + id);
	}
}
