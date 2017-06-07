package Question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeInfo {

	public static void main(String[] args) {
		

						

		
			   ArrayList<Employees> arraylist = new ArrayList<Employees>();

			   arraylist.add(new Employees("Baw", "Mikes", 56));
			   arraylist.add(new Employees("Law", "Jones", 27));
			   arraylist.add(new Employees("Daw", "Adams", 62));
			   


			   /*Sorting based on Employee Name*/
			   System.out.println("Employee Name Sorting:");
			   Collections.sort(arraylist, Employees.EmpNameComparator);

			   for(Employees emp: arraylist){
					System.out.println(emp);
			   }

			   /* Sorting on Department property*/
			   System.out.println("Department Sorting:");
			   Collections.sort(arraylist, Employees.EmpDepartment);
			   for(Employees emp: arraylist){
					System.out.println(emp);
			   }
			   
			   /* Sorting on Age property*/
			   System.out.println("Employee Age Sorting:");
			   Collections.sort(arraylist, Employees.EmpAge);
			   for(Employees emp: arraylist){
					System.out.println(emp);
			   }
			
	}
}

