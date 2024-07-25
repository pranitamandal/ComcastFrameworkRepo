package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTest extends BaseClass {

	@Test 
	public void createContactTest() throws Throwable {

		// read test script data from excel file

		String lastName = eLib.getDataFromExcel("contact", 7, 2)+jLib.getRandomNumber();

	



		// step2: navaigate to contacts module
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();

		// step3:click on contacts button
	
		

		// step4: enter all the details and create organization
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		// verify header msg expected result
		String lastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (lastname.contains(lastName)) {
			System.out.println(lastname + "is created==PASS");
		} else {
			System.out.println(lastname + "is not created==FAIL");
		}

	}

}
