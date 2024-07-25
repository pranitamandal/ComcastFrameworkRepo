package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackend {

@Test
public void projectCheckTest() throws SQLException {
	
	String expectedProjectName="FB";
	boolean flag=false;
	// step1: load/register the database driver
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				//step2:connect to database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranita_db", "root"," root");
			System.out.println("==============Done==============");
			
			//step3:create sql statement
			Statement state = conn.createStatement();
			
			//step4:execute select query and get result
			ResultSet resultset = state.executeQuery("select * from project");
			while(resultset.next()) {
				String actProjectName=resultset.getString(4);
			if(expectedProjectName.equals(actProjectName)) {
				flag=true;
			
				System.out.println(expectedProjectName+"is available==PASS");
			}
			}
			if(flag==false) {
				System.out.println(expectedProjectName+"is not available==FAIL");
			}
			//step5:close the connection
			conn.close();
		
}

}
