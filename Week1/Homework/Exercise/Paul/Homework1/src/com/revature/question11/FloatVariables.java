package com.revature.question11;

//import used to get variables from other package that was created 
import com.revature.question11alt.VarFromOtherClass;

public class FloatVariables {

	public static void main(String[] args) {
		
		//instantiate or create an object of VarFromOtherClass 
		VarFromOtherClass other = new VarFromOtherClass();
		
		//Print out of two variables from other package  
		System.out.println("These Two Float Variables " 
		+ other.oneVar + " and " 
		+ other.secondVar + " Were Imported From Another Package!");
		

	}

	
	
}
