package Question6;

import java.util.Scanner;

public class EvenNumber {
	public static void main(String []args )    {
		 
		//setting the number to an int
	    int number;
	    
	    //user input
	    Scanner in= new Scanner(System.in);
	 //printed directions for user
	    System.out.println("Enter a number to check even or odd");
	    number=in.nextInt();
	 
	    //if else statement to see if the number divided by 2 * 2 equals itself
	    //if not (else) then the number is odd
	    if((number / 2)*2==number){
	        System.out.println(+number+" is Even number");
	    }else{
	        System.out.println(+number+" is Odd Number");
	    }
	 
	}
}
