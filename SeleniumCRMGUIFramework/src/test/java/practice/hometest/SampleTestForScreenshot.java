package practice.hometest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://amazon.com");
		
		//step1:create an object of EventFiring webdriver
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		//step2:use getScrenshotAs method to get file type of screenshot
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		//store screenshot in local driver
		FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
		
		
	}

}
