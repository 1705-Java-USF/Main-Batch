package Question15;

public class OperandsTest {

	public static void main(String[] args) {
		
		//Creates OperandsClass object and prints to console
		//using addition and multiplication of two numbers from
		//the interface methods addition() and multiplication().
		OperandsClass oc = new OperandsClass();
		
		System.out.println(oc.addition(5, 7));
		System.out.println(oc.multiplication(5, 7));
	}

}
