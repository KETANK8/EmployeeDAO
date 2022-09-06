/**
 * @author Ketan Kumar
 * Illustrating to ADD DATA TO DATABASE AND PRINT DATA OF ONE OR ALL EMPLOYEE USING DATA ACCESS OBJECT
 *
 */
package LabDay.jbdcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class employeeDOA {

	Connection con = null;
	
	//Method 1
	// METHOD TO SET CONNECTION WITH DATABASE
	public void connect()throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","142307");
	}
	
	//Method 2
	// METHOD TO ADD NEW DATA IN DATABASE
	public void setemployee(employee emp) throws Exception {
		String query = ("insert into employeeData(empName,empDepartment,empSalary) values(?,?,?)");
		PreparedStatement prepstm = con.prepareStatement(query);
		
		//Putting value on the index of question mark
		prepstm.setString(1,emp.empName); // PUTTING NAME ON FIRST MARK
		prepstm.setString(2,emp.empDepartment); // PUTTING DEPARTMET ON SECOND MARK
		prepstm.setInt(3,emp.empSalary); // PUTTING SALARY ON THIRD MARKS
		
		int count = prepstm.executeUpdate();// UPDATING/ADDING THE DATA IN DATABASE
		System.out.println(count+" rows affected.");
	}
	
	//Method 3
	// METHOD TO PRINT AN EMPLOYEE DETAIL BASED ON EMPLOYEE ID
	public employee getemployee(int empId) throws Exception {
		employee emp = new employee();
		emp.empId = empId;
		String query = "select * from employeeData where empId = "+empId;
		Statement stm = con.createStatement();
		ResultSet set = stm.executeQuery(query);set.next();
		
		// ACCESSING DATA OF EMPLOYEE 
		emp.empName = set.getString(2);// GIVING COLOUMN NO TO ACCESS NAME
		emp.empDepartment = set.getString(3);// GIVING COLOUMN NO TO ACCESS DEPARTMENT
		emp.empSalary = set.getInt(4);// GIVING COLOUMN NO TO ACCESS SALARY
		
		return emp;// RETURNING EMP OBJECT
	}
	
	//Method 4
	// METHOD TO PRINT ALL EMPLOYEES DETAILS
	public void getAllData() throws SQLException {
		Statement stm = con.createStatement();
		
		ResultSet set = stm.executeQuery("select * from employeeData");
		
		System.out.println("\n\n----------Employee List----------");
		
		// ACCESSING DATABASE TO THE LAST ROW
		while(set.next()) {
			String std= "Id :"+set.getInt("empId")+"  Name :"+set.getString("empName")+"\nDepartment :"+set.getString("empDepartment")+"  Salary : "+set.getInt("empSalary")+"\n";
			System.out.println(std);// PRINTING THE DATA
		}
	}
	
	
	
}
