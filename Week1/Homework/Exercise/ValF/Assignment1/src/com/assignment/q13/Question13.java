package com.assignment.q13;

public class Question13 
{
	//Hardcode height of trinagle
	static final int HEIGHT = 4;
	
	public static void main(String[] args) 
	{
		//Variable: boolean to switch back and forward between 1 & 0
		boolean bool = false;
		
		//Nested loops
		//Outer loop will run for height of triangle
		for(int i = 0; i <= HEIGHT; i++)
		{
			//Inner loop will be bounded by current iteration of outer loop
			for(int j = 0; j <= i; j++)
			{
				//If bool switch is false print 0
				if(!bool)
				{
					System.out.print(0 + " ");
					bool = true;
				}
				//If bool switch is true print 1
				else
				{
					System.out.print(1 + " ");
					bool = false;
				}
			}
			System.out.println("\n");
		}
	}

}
