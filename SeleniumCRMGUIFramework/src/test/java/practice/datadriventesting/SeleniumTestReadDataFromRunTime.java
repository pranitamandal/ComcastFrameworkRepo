package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTime {

	@Test
	public void seleniumTest() throws IOException {
	

				// step3:get the value based on key
				//String Browser = 
				//String Url =
				//String Username = 
				//String Password = 
		WebDriver driver = null;
		/*
		 * //if (Browser.equals("chrome")) { driver = new ChromeDriver(); } else if
		 * (Browser.equals("edge")) { driver = new EdgeDriver(); } else if
		 * (Browser.equals("firefox")) { driver = new FirefoxDriver(); } else { driver =
		 * new ChromeDriver(); }
		 */

		// driver = new ChromeDriver();
		/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// step1: login to app
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();*/
	}

	}


