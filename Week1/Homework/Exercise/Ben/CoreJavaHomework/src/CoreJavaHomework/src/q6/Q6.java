package CoreJavaHomework.src.q6;

public class Q6 {

	//Here, I only need to determine if a number is even without using the % operator.
	public static void main(String[] args)
	{
		//I iterate across these numbers to include numbers in the following categories:
		//Negative even, Negative odd, Zero, Positive even, Positive odd
		for(int i=-2; i<3; i++)
		{
			//This shows the user the number being evaluated, and then determines if it's even.
			//With even values, i/2 merely returns half of i.
			//With odd numbers, the .5 left over is truncted by the integer division used here.
			//When I double that, I end up with one less than i.
			//When comparing i == (i/2)*2, the result will be true if and only if i is even.
			System.out.println(i + ": " + (i==(i/2)*2));	
		}
	}

}
