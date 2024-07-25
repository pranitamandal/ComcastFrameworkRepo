package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args, CharSequence lastName) throws Throwable {
		// create obkject
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib= new JavaUtility();

		// read common data from properties file

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
			
        	//read test script data from excel file
			String orgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();	
		
		//System.out.println(orgName);
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		// driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// step1: login to app
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// step2: navaigate to organization module
		driver.findElement(By.linkText("Contacts")).click();

		// step3:click on organization button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step4: enter all the details and create organization
		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);
	
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

					
	//verify header msg expected result
	String lastname = driver.findElement(By.id("dtlview_Last Name")).getText();
	if(lastname.contains(lastName)) 
	{
		System.out.println(lastname+"is created==PASS");
		}
	else {
		System.out.println(lastname+"is not created==FAIL");
	}
	String actenddDate = driver.findElement(By.id("dtlview_Last Name")).getText();
	if(actenddDate.equals(endDate)) 
	{
		System.out.println(endDate+"is created==PASS");
		}
	else {
		System.out.println(endDate+"is not created==FAIL");
	}

	}

}
