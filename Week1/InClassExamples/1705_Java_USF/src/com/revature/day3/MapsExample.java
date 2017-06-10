package com.revature.day3;

import java.util.HashMap;
import java.util.Hashtable;

public class MapsExample {

	public static void main(String[] args) {
		/*
		 * Maps:
		 * -Maps are a datastructure order by key/value pairs.
		 * -The keys are obtained via a keyset.
		 * 		-What does this mean.
		 * 		-You cannot have duplicate keys
		 * 		-You CAN have duplicate values.
		 */
		
		HashMap<Integer,String> map = new HashMap<>();
		map.put(1, "Bobbert");
		map.put(2, "Bobbert");
		map.put(3, "Bobby");
		map.put(4, "Bob");
		System.out.println(map);
		
		
		System.out.println("=====Take 2======");
		map.put(4, "Bobson");
		System.out.println(map);
		
		System.out.println("=====Take 3======");
		map.put(5, null);
		map.put(null, "5");
		System.out.println(map);
		
		//Iterate through a map by using its keyset
		System.out.println("=====Iterating through a map====");
		for(Integer i: map.keySet()){
			System.out.println(i + ": " + map.get(i));
		}
		
		/*
		 * Hashtable:
		 * -Virtually the same as a Map in functionality
		 * -However, there are a few things to note:
		 * 		-Hashtables are considered a Legacy class.
		 * 		-HashMaps are not Threadsafe, whereas HashTables are.
		 * 		-HashTables can NOT have null keys or values, whereas HashMaps can.
		 */
		Hashtable ht = new Hashtable();
		ht.put(1, "bob");
		ht.put(1, null);	//Will result in nullPointerException
		ht.put(null, "bob");//Will result in nullPointerException
		
	}

}
