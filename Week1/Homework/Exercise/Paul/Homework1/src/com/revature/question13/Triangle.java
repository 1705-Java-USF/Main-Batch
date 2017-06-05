package com.revature.question13;

public class Triangle {

	public static void main(String []args){
        
		//for loop using ternary operator 
		//first for loop is for first two lines of triangle
		//second for loop is for last two lines of triangle
		
        for(int i = 1; i <= 2; ++i)
        {
        	//for loop counter for the "0" or "1" needed to make triangle
        	//ternary operator checks if sum of number of lines and
        	//"0" or "1" is divisible by 2. If true places "0" false "1"
        	
           for(int j = 0; j < i; ++j)
              System.out.print((i+j) % 2 == 1 ? "0 " : "1 ");

           //prints line space between numbers in triangle 
            System.out.println("\n");
        }
        
        for(int i = 3; i <= 4; ++i)
        {
        	//for loop counter for the "0" or "1" needed to make triangle
        	//ternary operator checks if sum of number of lines and
        	//"0" or "1" is divisible by 2. If true places "1" false "0"
        	        
           for(int j = 0; j < i; ++j)
              System.out.print((i+j) % 2 == 1 ? "1 " : "0 ");

         //prints line space between numbers in triangle 
            System.out.println("\n");
        }

     }
}


