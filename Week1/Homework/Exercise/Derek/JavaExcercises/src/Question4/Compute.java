package Question4;

public class Compute {

	public static void main(String[] args) {
		
		//Prints to console using a Compute object the factorial of a number.
		System.out.println(Compute.factorial(1));
	}
	
	//Factorial function taking in any double n, since the values can get quite large.
	public static double factorial(double n) {
		
		//Account for one just being 1, otherwise compute the factorial normally.
		return n == 1 ? 1 : n * factorial(n - 1);
	}
}
