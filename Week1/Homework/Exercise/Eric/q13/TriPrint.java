package q13;

public class TriPrint {
	
	public static void main(String[] args){
		boolean toggle = false; // used to toggle between outputting 1s and 0s
		// outer for loop - prints four lines
		for (int i = 0; i < 4; i++){
			// inner for loop - prints between 1 to 4 characters depending on the line
			for (int j = 0; j < i + 1; j++){ // print 0 to i + 1 chars
				if (toggle)
					System.out.print("1 ");
				else
					System.out.print("0 ");
				toggle = !toggle; // swap for next iteration
			}
			// starts new line
			System.out.println();
		}
	}
	
}
