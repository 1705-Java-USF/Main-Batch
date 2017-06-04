package CoreJavaHomework.src.q12;

public class Q12
{
	//Write a program to store numbers from 1 to 100 in an array.
	//Print out all the even numbers from the array.
	//Use the enhanced FOR loop for printing out the numbers.
	
	final static byte MAX_NUMBER = 100;
	public static void main(String[] args)
	{
		//First I create an array of size 100.
		byte[] array = new byte[MAX_NUMBER];
		//Then, I populate the array.
		for(int i=0; i<MAX_NUMBER; i++)
		{
			array[i] = (byte) (i+1);
		}
		
		//Then, I iterate across the array using the enhanced for loop and print the even numbers.
		for(byte x : array)
		{
			if(x%2==0)
			{
				System.out.println(x);
			}
		}
	}
}
