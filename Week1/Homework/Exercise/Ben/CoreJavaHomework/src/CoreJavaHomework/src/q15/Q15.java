package CoreJavaHomework.src.q15;

public class Q15 implements Q15Interface
{
	/*TODO: Q15. Write a program that defines an interface having the following methods:
	 * addition, subtraction, multiplication, and division. Create a class that implements
	 * this interface and provides appropriate functionality to carry out the required
	 * operations. Hard code two operands in a test class having a main method that calls
	 * the implementing class.*/
	public static void main(String[] args)
	{
		//Here I hard-code two operands
		final double a = 42.9001;
		final double b = 3.1415926;
		//and notify the user what they are.
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		//This is the class that implements the interface, and it's the test class.
		//The test class calls the implementing class, which is why I create a new instance.
		Q15 q15 = new Q15();
		System.out.println("a+b: " + q15.addition(a,b));
		System.out.println("a-b: " + q15.subtraction(a,b));
		System.out.println("a*b: " + q15.multiplication(a,b));
		System.out.println("a/b: " + q15.division(a,b));
		
	}

	//These are all basic mathematical operations, returned simply.
	@Override
	public double addition(double a, double b) {
		return a+b;
	}

	@Override
	public double subtraction(double a, double b) {
		return a-b;
	}

	@Override
	public double multiplication(double a, double b) {
		return a*b;
	}

	@Override
	public double division(double a, double b) {
		return a/b;
	}
}
