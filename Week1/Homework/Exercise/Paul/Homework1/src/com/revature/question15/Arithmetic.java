package com.revature.question15;

public interface Arithmetic {

		public default int addition(int a, int b){
			return a + b;
		}
		
		public default int subtraction(int a, int b){
			return a - b;
		}
		
		public default int multiplication(int a, int b){
			return a * b;
		}
		
		public default int division(int a, int b){
			return a / b;
		}
}


