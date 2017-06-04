package CoreJavaHomework.src.q1;

public class Q1
{
	public static void main(String[] args)
	{
		
		//These exact values were given in the initial prompt.
		int[] inputArray = {1,0,5,6,3,2,3,7,9,8,4};
		//I pull this value once, instead of several times, to improve performance.
		int size = inputArray.length;
		
		//i is set to 1 to start because inputArray[(size-0)+1] gives an ArrayIndexOutOfBoundsException.
		//i is allowed to go all the way up to size because size-size equals zero, a valid index.
		for(int i=1; i<=size; i++)
		{
			//We don't have to sort beyond size-i,
			//because we know that area already contains the largest values in order. 
			for(int j=0; j<size-i; j++)
			{
				//We need to swap the values if the current value is greater than the next.
				if(inputArray[j]>inputArray[j+1])
				{
					int temp = inputArray[j];	//Temp holds the value to ensure it isn't lost.
					inputArray[j] = inputArray[j+1];
					inputArray[j+1] = temp;
				}
			}
		}
		
		//Technically, I wasn't asked to output the sorted array,
		//but I'm going to do it anyway.
		for(int i=0; i<size; i++)
			//The space is for readability, though it adds an extra at the end of the line.
			System.out.print(inputArray[i] + " ");
	}
}
