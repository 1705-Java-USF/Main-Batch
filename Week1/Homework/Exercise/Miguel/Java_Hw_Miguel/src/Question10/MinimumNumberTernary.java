package Question10;

import java.util.Scanner;

public class MinimumNumberTernary {

	public static void main(String[] args) {
	    {
	    	
	        int a, b, c;
	        //set the variables as int's
	        Scanner s = new Scanner(System.in);
	        //Instantiating the scanner utility
	        System.out.println("Enter 2 numbers:");
	        //directions for the user
	        
	        a = s.nextInt();
	        b = s.nextInt();
	        //taking the first input of the user then the second
	       
	        c = ((a) = (a) < (b) ? a : b);
	        //if a is less than b then display a, else display b
	        System.out.println("Lowest Number:"+c);
	        //Printing to the console which number of the two that are user generated is the smallest in value
	    }
	}

}
