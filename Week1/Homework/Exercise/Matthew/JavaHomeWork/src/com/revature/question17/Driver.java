package com.revature.question17;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console con = new Console();
		SimpleIntrestCalculator calc = new SimpleIntrestCalculator();
		con.getUserInput();
		double result = calc.calculateIntrest(con.getPrincipal(), con.getRate(), con.getTime());
		con.reportResult("The Intrest is: ", result);
		
	}

}
