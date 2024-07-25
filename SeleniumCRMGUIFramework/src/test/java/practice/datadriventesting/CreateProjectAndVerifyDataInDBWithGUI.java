
package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGUI {
	
	public static void main(String[] args) throws SQLException {
		
		//Create a project in GUI using selenium code
	
		String projectName="Instagram_1";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8084");
		
	 driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputpassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("demo");
		Select sel=new Select(driver.findElement(By.name("status")));
		sel.deselectByVisibleText("On going");
		driver.findElement(By.xpath("input[@value='Add Project']")).click();
		
		//verify the project in Backend Db using JDBC
		boolean flag= false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranita_db", "root"," root");
	System.out.println("==============Done==============");
	
	Statement state = conn.createStatement();

	ResultSet resultset = state.executeQuery("select * from pranita_db");
	while(resultset.next()) {
		String actProjectName=resultset.getString(4);
				if(projectName.equals(actProjectName)) {
					flag=true;
					System.out.println(projectName+"is available==PASs");
				}
					}
	if(flag==false) {
		System.out.println(projectName+"is not available==FAIL");
		
	}
	//step5:close the connection
	conn.close();
	}

		
		
	
}
