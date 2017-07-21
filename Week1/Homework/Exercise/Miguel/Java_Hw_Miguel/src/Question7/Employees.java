/*
 * Needs:
 *  -Comments
 *  -Scanner for user input
 */
package Question7;

import java.util.Comparator;
import java.util.Scanner;



public class Employees {
    
	private String employeename;
	private String department;
	private int employeeage;
	
	

    
    public Employees(String department, String employeename, int employeeage) {
        this.department = department;
        this.employeename = employeename;
        this.employeeage = employeeage;
    }
   
    //Getter and setter methods same as the above examples
    /*Comparator for sorting the list by Student Name*/
    public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getEmployeeage() {
		return employeeage;
	}
	public void setEmployeeage(int employeeage) {
		this.employeeage = employeeage;
	}
	
	
	public static Comparator<Employees> EmpNameComparator = new Comparator<Employees>() {

	public int compare(Employees e1, Employees e2) {
	   String EmployeeName1 = e1.getEmployeename().toUpperCase();
	   String EmployeeName2 = e2.getEmployeename().toUpperCase();

	   //ascending order
	   return EmployeeName1.compareTo(EmployeeName2);

	   //descending order
	   //return StudentName2.compareTo(StudentName1);
    }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<Employees> EmpDepartment = new Comparator<Employees>() {

	public int compare(Employees e1, Employees e2) {

	   String department1 = e1.getDepartment();
	   String department2 = e2.getDepartment();

	   /*For ascending order*/
	   return department1.compareTo(department2);

	   /*For descending order*/
	   //rollno2-rollno1;
   }};
   public static Comparator<Employees> EmpAge = new Comparator<Employees>() {

		public int compare(Employees e1, Employees e2) {

		   int employeeage1 = e1.getEmployeeage();
		   int employeeage2 = e2.getEmployeeage();

		   /*For ascending order*/
		   return employeeage1-employeeage2;

		   /*For descending order*/
		   //rollno2-rollno1;
	   }};
    @Override
    public String toString() {
        return "[ Department = " + department + ", Employee Name = " + employeename + ", Employee Age = " + employeeage + "]";
    }

}
