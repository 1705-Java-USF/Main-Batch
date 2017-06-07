package Question2;

public class FibonacciNumbers {

	public static void main(String[] args) {
		//What Fibonacci to stop on
        int fibCount = 25;
        int[] fib = new int[fibCount];//array "fib" 
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2; i < fibCount; i++){//for loop that starting at 2 will continue to display the Fib Number by one till it reaches the fibCount limit
            fib[i] = fib[i-1] + fib[i-2];
        }

        for(int i=0; i< fibCount; i++){
                System.out.print(fib[i] + " ");
        }
 

	}

}
