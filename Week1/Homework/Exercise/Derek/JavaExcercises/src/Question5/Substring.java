package Question5;

public class Substring {
	
	//String to be used.
	static final String STR = "This is some random string.";
	
	public static void main(String[] args) {
		
		//Prints 'some rand' substring to the console, with start and end options.
		System.out.println(getSubstring(STR, 8, 17));
	}
	
	//Pure Function where there's a start and end index that represent the substring.
	public static String getSubstring(String str, int startIndex, int endIndex) {
		
		char[] arrStr = str.toCharArray();
		StringBuilder subStr = new StringBuilder();
		
		endIndex = endIndex > arrStr.length ? arrStr.length : endIndex;
		
		//Uses a char array along with a string builder object for the new substring.
		//As it indexes from start to end, append to the substring each char array index.
		
		for (int i = startIndex;  i < endIndex; i++) {
			subStr.append(arrStr[i]);
		}
		
		//Use toString() to obtain the character sequence from subStr in string form.
		return subStr.toString();
	}

}
