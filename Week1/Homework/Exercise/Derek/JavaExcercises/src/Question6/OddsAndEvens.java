package Question6;

public class OddsAndEvens {

	public static void main(String[] args) {
		
		/*
		 * Declare a final num var that can be changed to test.
		 * Create a OddsaAndEvens object to use the isEven() method.
		 * Prints to the console the num value along with true or false.
		 */
		final int num = 11;
		OddsAndEvens oe = new OddsAndEvens();
		
		
		System.out.println("Is " + num + " even? " + oe.isEven(num));	
	}
	
	public boolean isEven(int n) {
		
		//Divide the number by 2, easiest way to test evenness, because then
		//if able to multiply by 2 back and get same number than its even!
		int quotient = n / 2; 
		
		return (quotient * 2) == n;
	}
}