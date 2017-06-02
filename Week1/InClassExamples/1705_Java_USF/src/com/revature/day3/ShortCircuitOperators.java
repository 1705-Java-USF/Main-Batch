package com.revature.day3;

public class ShortCircuitOperators {

	public static void main(String[] args) {
		if(returnFalse() & returnTrue()){
			
		}
		System.out.println("=========");
		if(returnTrue() | returnFalse()){
			
		}
		System.out.println("=========");
		if(returnFalse() && returnTrue()){
			
		}
		System.out.println("=========");
		if((returnTrue() || returnFalse()) || (returnFalse() && returnFalse() && returnFalse() && returnFalse())){
			
		}
		/*
		 * Shortcircuits aim to save processing power by checking conditions in a smarter way.
		 * If the left side of an || evaluates true, then it doesnt even bother checking the rest of the 'or'
		 * statement since it will evaluate to true regardless.
		 * Same goes for 'and', if the left side evaluates false, then the whole thing will evaluate false.
		 */
	
	}
	
	public static boolean returnTrue(){
		System.out.println("Returned true");
		return true;
	}
	
	public static boolean returnFalse(){
		System.out.println("Returned false");
		return false;
	}
	
}
