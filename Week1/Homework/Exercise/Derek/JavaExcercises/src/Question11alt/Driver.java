package Question11alt;

//Importing for accessibility from another package
import Question11.AccessPackageClass;

//Also extend AccessPackageClass for access to get functions
public class Driver extends AccessPackageClass {

	public static void main(String[] args) {
		
		//Creating a driver object to print out the float values from get()
		Driver d = new Driver();
		
		System.out.println(d.getNum1());
		System.out.println(d.getNum2());
	}

}
