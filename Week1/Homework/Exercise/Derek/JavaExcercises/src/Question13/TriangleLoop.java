package Question13;

public class TriangleLoop {
	
	//4 rows
	final static int ROWS = 4;
	
	public static void main(String[] args) {
		
		//Array of strings for each row.
		String[] b = new String[ROWS];
	
		for (int i = 0; i < ROWS; i++) {
			
			//Makes sure the first row will start with zero.
			if (i < 1) {
				b[i] = "0";
				continue;
			}
			
			//Based of zero, it will then add a 1 followed by a zero.
			if ("0".equals(b[0]) && "0".equals(b[i - 1])) {
				b[i] = "1" + b[0];
			}
			//Then following with the basis of the 3rd row
			else if (i % 2 == 0 && b[i - 1].length() % 2 == 0) {
				b[i] = b[i-1] + "1";
			}
			//And finally for the last row
			else {

				b[i] = "0" + b[i-1];
			}
		}
		
		//Enhance for loop to print each of the rows out.
		for (String str : b) {
			System.out.println(str);
		}
	}
}
