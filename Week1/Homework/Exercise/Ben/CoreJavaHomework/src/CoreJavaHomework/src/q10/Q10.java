package CoreJavaHomework.src.q10;

public class Q10
{
	//These floats exist for question 11, and have no bearing on question 10.
	public static float float1 = 5.5F;
	public float float2 = 7.7F;
	
	//Use a ternary operator to find the minimum of two numbers
	public static void main(String[] args)
	{
		//Define inputs
		double A = Math.random()*100;
		double B = Math.random()*100;
		
		//This line just clarifies to the user that the answer is right.
		System.out.println("A is " + A + ", B is " + B);
		
		//Use the ternary operator to find the minimum.
		System.out.println((A<B) ? A : B);
	}
}
