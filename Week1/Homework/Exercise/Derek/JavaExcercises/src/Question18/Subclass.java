package Question18;

//Concrete Subclass inheriting three abstract methods from Superclass
public class Subclass extends Superclass{

	@Override
	public boolean methodB(String s1) {
		
		//Takes the string param s and converts to char array ch. 
		String s = s1;
		s.toCharArray();
		char[] ch=s.toCharArray();  
		
		//Checks through each char seeing if uppercase, otherwise continue looping.
		for(int x = 0; x < ch.length; x++){
			
			if (Character.isUpperCase(ch[x])) {
				return true;
			}
			else {
				continue;
			}
		}
		//Returns false if none are found.
		return false;
	}

	@Override
	public String methodS(String s1) {
		
		//Takes the input string and converts entirely to uppercase,
		//then returns the result to the console.
		String s = s1;
		String s2 = s.toUpperCase();
		return s2;
	}

	@Override
	public int methodI(String s1) {
		
		//Int to represent the converted string to int.
		//Add 10 to it and return result to the console.
		//Try catch block for NumberFormatException,
		//So users will need to input a numbered string to work.
		String s = s1;
		int i = 0;
		
		try {
			i = Integer.parseInt(s);
			i += 10;
		}
		catch(NumberFormatException ex) {
			System.out.println("Not a numbered string!");
		}
		return i;
	}

}
