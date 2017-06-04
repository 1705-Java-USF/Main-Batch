package CoreJavaHomework.src.q11;

public class Q11
{
	public static void main(String[] args)
	{
		//Here, I demonstrate the ability to access a static variable without creating an instance.
		float a = CoreJavaHomework.src.q10.Q10.float1;
		//Here, I demonstrate the ability to instantiate a class that isn't imported.
		float b = (new CoreJavaHomework.src.q10.Q10()).float2;
		
		//Here, I demonstrate the acquired knowledge to the user.
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("a+b = " + (a + b));
		System.out.println("a-b = " + (a - b));
		System.out.println("a*b = " + (a * b));
		System.out.println("a/b = " + (a / b));
	}
}