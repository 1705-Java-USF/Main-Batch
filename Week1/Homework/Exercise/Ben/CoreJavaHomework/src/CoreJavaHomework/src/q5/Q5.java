package CoreJavaHomework.src.q5;

public class Q5
{
	//In this one, I am asked to create my own substring method, returning everything from 0 to idx-1.
	public static void main(String[] args)
	{
		//No values for idx or the string are given, so I make my own.
		System.out.println(substring("What's your favorite idea? Mine is being creative!", 26));
	}
	
	//I was told to specifically make a method with this functionality.
	static String substring(String in, int idx)
	{
		//The value of out should be defined explicitly, even if it is merely to the default value.
		String out = "";
		//Here, I skip the logic if idx is greater than the string's length.
		//This avoids ArrayIndexOutOfBoundsExceptions.
		if(in.length()>=idx)
		{
			//For every character before the given index,
			for(int i=0; i<idx; i++)
			{
				//Put it in the output.
				out += in.charAt(i);
			}
		}
		return out;
	}
}
