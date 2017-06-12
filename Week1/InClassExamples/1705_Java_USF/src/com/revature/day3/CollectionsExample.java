package com.revature.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

public class CollectionsExample {

	public static void main(String[] args) {
		//LISTS
		/*
		 * Represents an ordered collection.
		 * *Supports random access.
		 * Indexed base. (0 indexed based)
		 * The arrayList size is dynamic.
		 * 		-The size of the list can change
		 * 		-If you add an element past the current max memory allocation of an arrayList
		 * 			The array is resized to %150 the initial size
		 */
		
		/*
		 * Generics:
		 * -Generics are used to enforce compile time restrictions of datatypes.
		 * -offers a means to parameterize datatypes for runtime offering a more dynamic approach to class design.
		 * -Eliminates the need to use casting for getting/placing elements.
		 */
		
		ArrayList<Integer> al = new ArrayList<>();
		System.out.println("al initial size: " +al.size());
		al.add(5);
		al.add(3);
		al.add(7);
		al.add(1);
		al.add(9);
		System.out.println("al size after input: " +al.size()); 
		System.out.println(al); //Unsorted
		
		
		al.sort(null); //uses merge sort
		System.out.println(al);
		/*
		 * Anything implementing Collection, implements Iterable as well.
		 * What this offers is a means to traverse the collection either using
		 * and iterator, enum, or enhanced for loop.
		 * 
		 * 
		 * An iterator object, is an object that can act as a marker (Sort of like a pointer) to
		 * each element in a collection. And you can have it move 1 by 1 throughout the collection.
		 */
		
		for(int i : al){
			System.out.println(i);
		}
		
		System.out.println("========Iterator Traversal====");
		Iterator <Integer>ali = al.iterator(); //You dont create new instances of an iterator
												//Instances are provided by collections.
		while(ali.hasNext()){
			System.out.println(ali.next());
		}
		
		//You cannot traverse backwards!
		//In order to reset, you reassign the iterator.
		
		System.out.println("=====List Iterator====");
		//Anything implementing List can provide a ListIterator
		ListIterator <Integer>li = al.listIterator();
		
		while(li.hasNext()){
			System.out.println(li.next());
		}
		System.out.println("Previous: " + li.previous());
		/*
		 * List Iterators can go, both, forward and backward in a LIST collection.
		 */
		
		
		System.out.println("=========sets=========");
		/*
		 * Sets:
		 * -Sets do NOT allow duplicate values.
		 * -Sets tend to be automatically sorted as you insert into them
		 * 	-Indexes are stored in a hash table, using characterics of the elements to create a hashcode,
		 * 		and using that hashcode to order them.
		 */
		
		HashSet <Integer>set = new HashSet<>();
		set.add(5);
		set.add(236);
		set.add(5);
		set.add(78);
		set.add(9);
		System.out.println(set);
		
		for(int i: set){
			System.out.println(i);
		}
		
		TreeSet <Integer>set2 = new TreeSet<>();
		set2.add(5);
		set2.add(236);
		set2.add(5);
		set2.add(78);
		set2.add(9);
		System.out.println(set2);
		
		
		System.out.println("=======queue=======");
		/*
		 * Queue
		 * -This collection enforces FIFO
		 * -Think: Lining up at the store
		 */
		
		Queue <Integer>queue = new LinkedList<>();
		
		queue.add(5);
		queue.add(3);
		queue.add(7);
		queue.add(1);
		queue.add(9);
		System.out.println(queue);
		System.out.println(queue.peek()); //What is the next element?
		System.out.println(queue.poll()); //Retrieve the next element, removing it from the collection
		System.out.println(queue.peek()); //What is the next element?
		System.out.println("size:" + queue.size()); //What is the next element?
		
	
		System.out.println("=======Stack=======");
		Stack st = new Stack();
		st.push(5);
		st.push(3);
		st.push(7);
		st.push(1);
		st.push(9);
		System.out.println(st);
		
		int ssize = st.size();
		for(int i=0; i < ssize; i++){
			System.out.println(st.pop());
		}
		
		
		
		
		
	}

}
