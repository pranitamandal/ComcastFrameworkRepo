package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args, CharSequence orgName, CharSequence contactLastName) throws Throwable {

		// create object
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib= new WebDriverUtility();

		// read common data from properties file

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		//read test script data from excel file
		String orgName1=eLib.getDataFromExcel("contact", 7, 2)+jLib.getRandomNumber();
		
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
		
		wLib.waitForPageToLoad(driver);
		
		// step1: login to app
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// step2: navaigate to organization module
		driver.findElement(By.linkText("Contacts")).click();

		// step3:click on contact button
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step4: enter all the details and create contactWithOrg
		//driver.findElement(By.name("accountname")).sendKeys(orgName1);
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		

		
					
	//verify header msg expected result
	/*
	 * String headerInfo =
	 * driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	 * if(headerInfo.contains(orgName1)) {
	 * System.out.println(orgName1+"is created==PASS"); } else {
	 * System.out.println(orgName1+"is not created==FAIL"); }
	 */
		//step5:navigate to contact module

		// step2: navaigate to organization module
		driver.findElement(By.linkText("Contacts")).click();

		// step3:click on organization button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step4: enter all the details and create contact with organization
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
         wLib.switchToTabOnURL(driver, "module=Accounts");
		
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		//switch to parent window
		wLib.switchToTabOnURL(driver, "Contacts&action");
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//verify Header Phone numberInfo Result
		String  headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName)) 
		{
			System.out.println(orgName+"is created==PASS");
			}
		else {
			System.out.println(orgName+"is not created==FAIL");
		}
		
			//Verify Header orgName info Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgName.equals(orgName)) 
		{
			System.out.println(orgName+"is created==PASS");
			}
		else {
			System.out.println(orgName+"is not created==FAIL");
		}
	
	driver.quit();
		

	}

	
}
