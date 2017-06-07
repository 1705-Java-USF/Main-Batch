//Done
package Question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		
		//Allowing user to input a variable
		Scanner userInput = new Scanner(System.in);
		
		//Printing out directions for the user
		System.out.println("Type two words");
		
		//Converting what the user inputs into a String
	    String userInput1 = userInput.nextLine();
	    
	    //Using a charArray to set each individual character in the String variable as a sequence of characters in an Array
	    char[] ui=userInput1.toCharArray(); 
	    
	    //This is creates an ArrayList
	    List<Character> listOfElements= new ArrayList<>();
	    
	    //for loop that will add a new element within the array and getting the elements from the charArray "userInput1"
	    for(char c: ui)
	    	listOfElements.add(c);
	    //Using the Collections API's, I am reversing the order of the elements within the ArrayList
	    Collections.reverse(listOfElements);
	    
	    Iterator<Character> li = listOfElements.iterator();  
	    //While loop that will continue to execute in a forward direction of an array, while there is another element in the array
	    while(li.hasNext()){
	    	//This will print the elements in the order that was brought in by the 
	    	 System.out.print(li.next());
	    }  
		
		
	    
	 }
}


