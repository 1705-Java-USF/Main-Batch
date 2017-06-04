package CoreJavaHomework.src.q13;

public class Q13 {

	public static void main(String[] args) {
		for(int i=0; i<4; i++)
		{
			//This is a rule for determining if a line should start with zero.
			//Nearly any number of rules could have been used, but this was easiest.
			boolean zero = false;
			if(i%3 == 0)
			{
				zero = true;
			}
			
			//This does the actual printing. It uses a for loop instead of multiple prints.
			for(int j=0; j<=i; j++)
			{
				System.out.print(zero ? "0" : "1");
				zero = !zero;
			}
			System.out.println();	//This ensures the next level of the triangle is on a new line.
		}
	}

	//public void finalize()
	// this method is called when an item is garbage-collected.
	//This has nothing to do with the above program. It's just a cool note.
}