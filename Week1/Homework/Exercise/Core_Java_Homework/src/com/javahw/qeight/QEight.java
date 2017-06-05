package com.javahw.qeight;

import com.javahw.qthree.QThree;

import java.util.ArrayList;
import java.util.List;

public class QEight {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		String[] strs = {"karan","madam","tom","civic",
						"radar","sexes","jimmy","kayak",
						"john","refer","billy","did"};
		
		//Add strings to an array list
		for(String s : strs){
			l.add(s);
		}
		System.out.println(l);
		
		List<String> l2 = new ArrayList<>();
		
		//Check for palindromes and add them to an array list
		for(String s : strs){
			if(s.equals(QThree.reverse(s)))
				l2.add(s);
		}
		System.out.println(l2);
		
	}

}
