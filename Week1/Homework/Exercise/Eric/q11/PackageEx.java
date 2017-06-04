package q11;

public class PackageEx {
	
	// testing to retrieve variables/methods from other packages
	public static void main(String[] args){
		System.out.println("Testing float from other package: ");
		// prints floats from other package and their sum
		System.out.println(q11alt.PackageExample.f1);
		System.out.println(q11alt.PackageExample.f2);
		System.out.println("Sum: " + q11alt.PackageExample.sum());
	}
	
}
