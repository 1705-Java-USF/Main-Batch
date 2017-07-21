package Question12;

import java.util.Scanner;

public class EnhancedForLoop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a[] = new int[100];
		
		for(int i=0;i<100;i++)
		//length is the property of array  
			a[i] = i+1;
			//storing the values 1 - 100
		
		for(int j : a){
			if(j%2 == 0){
				System.out.print(" "+j);
			}	
			//if statement to 
		}
	}
}
