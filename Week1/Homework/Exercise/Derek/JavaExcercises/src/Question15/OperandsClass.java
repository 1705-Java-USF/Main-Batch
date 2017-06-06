package Question15;

//Class to implement the OperandsInterface
public class OperandsClass implements OperandsInterface{

	//Adds two integer inputs.
	@Override
	public int addition(int input1, int input2){
		return input1 + input2;
	}
	
	//Subtracts two integer inputs.
	@Override
	public int subtraction(int input1, int input2){
		return input1 - input2;
	}
	
	//Multiplies two integer inputs.
	@Override
	public int multiplication(int input1, int input2){
		return input1 * input2;
	}
	
	//Divides two integer inputs.
	@Override
	public int division(int input1, int input2){
		return input1/input2;
	}

}
