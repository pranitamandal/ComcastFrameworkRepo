package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQuery {

	public static void main(String[] args) throws SQLException {
		// step1: load/register the database driver
					Driver driverRef=new Driver();
					DriverManager.registerDriver(driverRef);
					
					//step2:connect to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranita_db", "root"," root");
				System.out.println("==============Done==============");
				
				//step3:create sql statement
				Statement state = conn.createStatement();
				
				//step4:execute select query and get result
				int result = state.executeUpdate("insert into project values('TY_PROJ_1','PRANITA','06/07/2024','on going','100')");
				
				//step5:close the connection
				conn.close();
			

	}

}
