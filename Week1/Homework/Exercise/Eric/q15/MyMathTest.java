package q15;

public class MyMathTest {
	
	public static void main(String[] args){
		
		// testing variables - can be easily changed
		int a = 10;
		int b = 5;
		MyMathClass mmc = new MyMathClass();
		
		// Addition test
		if ((a + b) == mmc.myAddition(a,b))
			System.out.println("Addition works");
		else
			System.out.println("Addition does not work");
		
		// Subtraction test
		if ((a - b) == mmc.mySubtraction(a, b))
			System.out.println("Subtraction works");
		else
			System.out.println("Subtraction does not work");
		
		// Multiplication test
		if ((a*b) == mmc.myMultiplication(a, b))
			System.out.println("Multiplication works");
		else
			System.out.println("Multiplication does not work");
		
		// Division test
		if ((a/b) == mmc.myDivision(a, b))
			System.out.println("Division works");
		else
			System.out.println("Division does not work");
	}
}
