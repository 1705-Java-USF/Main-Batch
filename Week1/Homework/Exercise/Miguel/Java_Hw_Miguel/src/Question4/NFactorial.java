package Question4;

import java.util.Scanner;

public class NFactorial {
	
	//I have to use 'long' becuase if you try to do factorial for a number bigger than 12, it goes beyond the
	//limit of an 'int'.
	public static void main(String[] args){
	      //User input
	      Scanner userInput = new Scanner(System.in);
	      //Console directions for the user
	      System.out.println("Enter the number ");
	      
	      //Stored the user input in a variable
	      long num = userInput.nextInt();
	      
	      //Called the user defined function factorial
	      long factorial = fact(num);
	      System.out.println("Factorial of entered number is: "+factorial);
	   }
	
	   static long fact(long n){
	       long output;
	       //Limiting what the user inputs, because this program gets exceptions if the user uses 0 and this is not present
	       if(n==0){
	    	   return 1;
	       }
	       else{
	       //Recursion: Function calling itself
	       output = fact(n-1)* n;
	       return output;
	       }
	   }
}

