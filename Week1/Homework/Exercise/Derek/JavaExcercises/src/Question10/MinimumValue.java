package Question10;

public class MinimumValue {
	
	//Two numbers to use.
	static final int NUM1 = 7;
	static final int NUM2 = 21;
	
	public static void main(String[] args) {
		
		//Create MinimumValue obj and calls the findMin method to determine the minimum.
		//Prints the two numbers and then the one that is found to be the minimum.
		MinimumValue mv = new MinimumValue();
		System.out.println("The minimum number between " + NUM1 + " and " 
				+ NUM2 + " is " + mv.findMin(NUM1, NUM2) + ".");
	}
	
	int findMin(int num1, int num2) {
		
		//Condition check for either number being larger than the other.
		return num1 > num2 ? num2 : num1;
	}

}
