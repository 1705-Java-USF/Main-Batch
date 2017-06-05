package com.javahw.qthirteen;

public class QThirteen {

	public static void main(String[] args) {
		boolean toggle = false;
		
		//Print a right angled triangle using 0's and 1's
		for(int i = 0; i < 4; i++){	
			for(int j=0; j < i+1; j++)
			{
				if(toggle == false){
					System.out.print(0 + " ");
					toggle = true;
					continue;
				}
				
				if(toggle == true){
					System.out.print(1 + " ");
					toggle = false;
				}
			}
			System.out.println();
			System.out.println();
		}
	}

}
