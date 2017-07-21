package Question9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		int x;
		System.out.println("Enter the higest level number to find all the prime numbers up to that point");
		Scanner userInput = new Scanner(System.in);
		x = userInput.nextInt();
		//Taking the user input and setting it to x
		
        List<Integer> primeList = new ArrayList<Integer>();
        //creating an ArrayList for all numbers in the array up to the number the user entered
        for (int i = 1; i<=x; i++){

            primeList.add(i);
            //is adding the next number in the Array list up to the number that the user entered
        }

        for (int i = 0; i<primeList.size()-1; i++){
        if (!isPrime(primeList.get(i))){
        	primeList.remove(primeList.get(i));
            i--;
            }
        }
        System.out.println(primeList);
        //calculating the Prime numbers up to the number the user entered
    }

    public static boolean isPrime(int x){
        boolean itIs = true;
        for (int i = 2; i < x; i++){
            if(x%i == 0){
                itIs = false;  
            }
        }
        return itIs;
        //deciding if the number is Prime or not
    }
}


