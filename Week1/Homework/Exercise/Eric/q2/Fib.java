package q2;

public class Fib {

	public static void main(String[] args) {
		Fib fb = new Fib();
		// iterate from 0 to 24 to print first 25 fibonacci numbers
		for (int i = 0; i < 25; i++)
			System.out.println(i + 1 + ": " + fb.fib(i));
	}

	// the fib method returns the nth fibonacci number given an integer n
	public int fib(int n){
		// "0th" number = 0
		if (n == 0)
			return 0;
		// 1st number = 1
		else if (n == 1)
			return 1;
		// any other number will be the sum of the two prior fibonacci numbers
		else{
			return fib(n-1) + fib(n-2);
		}
	}
}
