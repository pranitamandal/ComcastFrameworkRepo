package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustriesTest {

	public static void main(String[] args) throws IOException {
		// read common data from properties file
		// step 1: get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(".\\configAppData\\commomdata.properties");
		// step2:using properties class,load all the keys
		Properties pobj = new Properties();
		pobj.load(fis);

		// step3:get the value based on key
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");

		// generate the random number
		Random random = new Random();
		int randomint = random.nextInt(1000);
		System.out.println(randomint);

		// read test script data from excel file

		FileInputStream fis1 = new FileInputStream(".\\SeleniumCRMGUIFramework\\testdata\\testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(4);
		String orgName = row.getCell(2).toString() + randomint;
		String industries = row.getCell(3).toString();
		String type = row.getCell(4).toString();
		wb.close();

		System.out.println(orgName);
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
		driver.findElement(By.linkText("Organizations")).click();

		// step3:click on organization button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// step4: enter all the details and create organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);

		// logout from the app
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		WebElement wbsel = driver.findElement(By.name("industry"));
		Select sel = new Select(wbsel);
		sel.selectByVisibleText(industries);

		WebElement wbsel2 = driver.findElement(By.name("accounttype"));
		Select sel2 = new Select(wbsel2);
		sel2.selectByVisibleText(type);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		// driver.findElement(By.linkText("Sign Out")).click();

		// Verify the industries and type info
		String actIndustries = driver.findElement(By.xpath("dtlview_Industry")).getText();
		if (actIndustries.equals(industries)) {
			System.out.println(industries + " information is verified==PASS");
		} else {
			System.out.println(industries + " information is not verified==FAIL");
		}
		
		String actType = driver.findElement(By.xpath("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + " information is verified==PASS");
		} else {
			System.out.println(type + " information is not verified==FAIL");
		}
//step5:logout
		 driver.quit();
	}

}
