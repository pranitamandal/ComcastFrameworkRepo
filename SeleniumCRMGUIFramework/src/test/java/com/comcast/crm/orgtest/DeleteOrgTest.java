package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		
		// create object
				FileUtility fLib = new FileUtility();
				ExcelUtility eLib = new ExcelUtility();
				JavaUtility jLib= new JavaUtility();
				WebDriverUtility wLib= new WebDriverUtility();
				// read common data from properties file

				String BROWSER = fLib.getDataFromPropertiesFile("browser");
				String URL = fLib.getDataFromPropertiesFile("url");
				String USERNAME = fLib.getDataFromPropertiesFile("username");
				String PASSWORD = fLib.getDataFromPropertiesFile("password");
					
		        	//read test script data from excel file
					String orgName=eLib.getDataFromExcel("org", 10, 2)+jLib.getRandomNumber();	
				
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

			
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get(URL);			
				
				// step1: login to app
				LoginPage lp= new LoginPage(driver);
			lp.loginToapp(URL,USERNAME, PASSWORD);
				

				// step2: navaigate to organization module
			HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();

				// step3:click on organization button
			OrganizationsPage cnp= new OrganizationsPage(driver);
			cnp.getCreateNewOrgBtn().click(); 
			
			//step4:create new organization and enter all the details
			
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
			
							
			//verify header msg expected result
			
			OrganizationInfoPage oip= new OrganizationInfoPage(driver);
			String actOrgName = oip.getHeaderMsg().getText();
			if(actOrgName.contains(orgName)) {
				System.out.println(orgName+"name is verified==Pass");
			}
			else {
				System.out.println(orgName+"name is not verified==FAIL");
			}
			//go back to org page
			hp.getOrgLink().click();
			//search for organization
			cnp.getSearchEdt().sendKeys(orgName);
			wLib.select(cnp.getSearchDD(), "Organization Name");
			cnp.getSearchBtn().click();
			
			//in dynamic webtable select and delete org
			driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[1]/a[text()='del']")).click();
			//step5:logout
			hp.logout();
			
		driver.quit();
				
	}


	}


