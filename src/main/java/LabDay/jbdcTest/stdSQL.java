package LabDay.jbdcTest;
import java.sql.*;

public class stdSQL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","142307");
		
		Statement stm = con.createStatement();
		
		ResultSet set = stm.executeQuery("select * from studentData");
		
		System.out.println("Student Id   Student Name\n");
		
		while(set.next()) {
			String std= set.getInt("stdId")+"          "+set.getString("stdName")+"\n             Marks : "+set.getInt("stdMarks")+"\n";
			System.out.println(std);
		}
		con.close();
	}

}
