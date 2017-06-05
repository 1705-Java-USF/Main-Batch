package com.javahw.qfifteen;

public class QFifteenTest {
	public static void main(String[] args) {
		double opA = 5.4;
		double opB = 4.7;
		
		QFifteen implementingClass = new QFifteen();
		
		System.out.println( implementingClass.addition(opA, opB) );
		System.out.println( implementingClass.subtraction(opA, opB) );
		System.out.println( implementingClass.multiplication(opA, opB) );
		System.out.println( implementingClass.division(opA, opB) );
	}
}
