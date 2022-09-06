/**
 * @author Ketan Kumar
 * Illustrating to ADD DATA TO DATABASE AND PRINT DATA OF ONE OR ALL EMPLOYEE USING DATA ACCESS OBJECT
 *
 */
package LabDay.jbdcTest;

import java.util.Scanner;

public class EmployeeData {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int empId,empSalary,choice=0;
		String empName,empDepartment;
		
		// CREATING OBJECT OF EMPLOYEEDOA
		employeeDOA employeeDOA = new employeeDOA();
		
		// CALLING COONECT METHOD TO ACCESS DATABASE
		employeeDOA.connect();
		
		
		while(choice<4) {
		System.out.println("Press 1 - Add Employee in Database \nPress 2 - Print an Employee Detail \nPress 3 - Print all Employee Data from DataBase \nPress 4 - Exit");
		System.out.print("ENTER CHOICE : ");
		choice = scan.nextInt();
		
		switch(choice) {
			case 1->{
				
				//CREATING EMPLOYEE OBJECT TO  STORE DETAILS
				employee emp = new employee();
				System.out.print("Enter Employee Name : ");
				empName = scan.next();// ASKING USER TO INPUT NAME
				emp.empName = empName;
				System.out.print("Enter Employee Department : ");
				empDepartment = scan.next();// ASKING USER TO INPUT DEPARTMENT
				emp.empDepartment = empDepartment;
				System.out.print("Enter Employee Salary : ");
				empSalary = scan.nextInt();// ASKING USER TO INPUT SALARY
				emp.empSalary = empSalary;
				
				employeeDOA.setemployee(emp);// CALLING SET EMPLOYEE METHOD TO ADD DATA IN DATABASE
			}
			
			case 2->{
				System.out.print("Enter Employee Id : ");
				empId = scan.nextInt();
				
				// CALLING GET EMPLOYEE METHOD TO ACCESS AN EMPLOYEE DATA
				employee emp = employeeDOA.getemployee(empId);
				System.out.println("\n"+emp.empId+" "+emp.empName+" "+emp.empDepartment+" "+emp.empSalary+"\n");
			}
			
			case 3->{
				// CALLING GET ALL DATA
				// TO PRITNT DATA OF EVERY EMPLOYEE FROM DATABASE
				employeeDOA.getAllData();
			}
		}
		
		
		}
		scan.close();
	}

}
