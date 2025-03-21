package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JDBCSampleProgram
{
	@Test()
	public void  SelectQuerySample() throws SQLException
	{
		//fetch the driver from database
		Driver dref=new Driver();
		
		//Register the driver 
		DriverManager.registerDriver(dref);
		
		//get the connection with driver=give database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//issues create Statement 	
	Statement state = con.createStatement();
	
	//execute the query -> table name
	ResultSet res = state.executeQuery("select * from customerinfo");
	
	while(res.next())
	{
		System.out.println(res.getString(1) + "-" + res.getInt(2) + "-" + res.getString(3));
	}
	
	//close the database
	con.close();
	}
	
	

}
