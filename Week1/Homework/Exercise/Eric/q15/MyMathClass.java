package q15;

// implementations of the mymath interface
public class MyMathClass implements MyMath{

	@Override // simple additon
	public int myAddition(int a, int b) {
		return a + b;
	}

	@Override // simple subtraction
	public int mySubtraction(int a, int b) {
		return a - b;
	}

	@Override // simple multiplication
	public int myMultiplication(int a, int b) {
		return a*b;
	}

	@Override // simple division
	public int myDivision(int a, int b) {
		return a/b;
	}

}
