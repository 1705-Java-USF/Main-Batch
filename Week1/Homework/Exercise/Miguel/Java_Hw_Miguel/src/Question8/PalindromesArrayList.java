package Question8;

import java.util.ArrayList;


public class PalindromesArrayList {
	
    public static void main(String[] args) {
    	System.out.println("This is the list of Palindromes");
    	ArrayList<String> palindromelist = new ArrayList<>();
    	//Second list that will hold the Palindromes
    	

    	ArrayList<String> stringlist = new ArrayList<>();
    	stringlist.add("karan");
    	stringlist.add("madam");
    	stringlist.add("tom");
    	stringlist.add("civic");
    	stringlist.add("radar");
    	stringlist.add("sexes");
    	stringlist.add("jimmy");
    	stringlist.add("kayak");
    	stringlist.add("john");
    	stringlist.add("refer");
    	stringlist.add("billy");
    	stringlist.add("did");
    	//List of strings that was given to us to check
    	//Using Generics to only pass in strings
    
    	for(String i : stringlist){
    		StringBuilder pali = new StringBuilder(i);
    		//Have to use the StringBuilder API inorder to be able to use .reverse() with the strings in the list
    		
    		if(i.equals(pali.reverse().toString())) {
    			palindromelist.add(i);
    			
    		}
    		//if statement that will check to see is the element in the stringlist is a palindrome
    		//by comparing it to the revers of itself
    	}
    	//For loop that will iterate through each one of the elements within the stringlist
    	System.out.println(palindromelist);
    	//Displaying the palindrome list


    }


}
		


