package com.revature.question11;

import com.revature.question11a.QuestionElevenA;


public class QuestionEleven {

	public static void main(String[] args) {
		
		QuestionElevenA class1 = new QuestionElevenA();
		
		//printing out the float variables found in a different package
		System.out.println("The value of a in the other package is: " + class1.a);
		System.out.println("The value of b in the other package is: " + class1.b);
	}

}
