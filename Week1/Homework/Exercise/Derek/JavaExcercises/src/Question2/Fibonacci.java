package Question2;

public class Fibonacci {

	public static void main(String[] args) {
		
		//Starting numbers for the sequence
		int a = 0;
		int b = 1;
		
		//Loop for the first 25 numbers in sequence starting with zero printed
		for(int i = 1; i <= 25; i++) {
			//c handles adding the prev and current values to create the new current value
			int c = a + b;
			System.out.println(a);
			//Assign new prev value and new current value
			a = b;
			b = c;
		}
	}

}
