package Question17;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		
		float p;
		float r;
		float t;
		
		Scanner userInput = new Scanner(System.in);
		
        System.out.println("Please enter principle amount :");
        //float amount = scanner.nextFloat();
        p = userInput.nextInt();
      
        System.out.println("Enter time in years : ");
        //float time = scanner.nextFloat();
        t = userInput.nextInt();
      
        System.out.println("Enter rate annually : ");
        //float rate = scanner.nextFloat();
        r = userInput.nextInt();
      
        float interest = simpleInterest(p, r, t);
      
        System.out.println("Simple interested calculate by program is : " + interest);
    }
  
    public static float simpleInterest(float principle, float rate, float time){
        float interest = (principle*rate*time)/100;
        return interest;
    }

		
}

