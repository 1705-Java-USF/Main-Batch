package com.revature.q13;

public class Main {
	public static void main(String [] args){
		boolean isOn = false;
		//prints the line
		for(int i = 0; i < 4; i++){
			//prints the individual items per line
			for(int j = 0; j <= i; j++){
				if(!isOn){
					//prints a 0 and switches to a 1
					System.out.print(0);
					isOn = true;
				}
				else{
					//prints a 1 and switches to a 0
					System.out.print(1);
					isOn = false;
				}
			}
			//prints a new line
			System.out.println();
		}
	}
}
