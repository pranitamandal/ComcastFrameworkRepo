package practice.contacttest;

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

public class CreateContactTest {

	public static void main(String[] args) throws IOException {
		//read common data from properties file
		// step 1: get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\Bijay\\Documents\\data\\commomdata.properties");
		// step2:using properties class,load all the keys
		Properties pobj = new Properties();
		pobj.load(fis);

		// step3:get the value based on key
		String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");
		String Username = pobj.getProperty("username");
		String Password = pobj.getProperty("password");

		//generate the random number
		Random random= new Random();
		int randomint = random.nextInt(1000);
		System.out.println(randomint);

		
		//read test script data from excel file
		
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(1);
		String lastName = row.getCell(2).toString()+randomint;
		wb.close();
		
		//System.out.println(orgName);
		WebDriver driver = null;
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		// driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// step1: login to app
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		// step2: navaigate to organization module
		driver.findElement(By.linkText("Contacts")).click();

		// step3:click on organization button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step4: enter all the details and create organization
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		

		/*
		 * // logout from the app Actions action = new Actions(driver);
		 * action.moveToElement(driver.findElement(By.xpath(
		 * "//img[@src='themes/softed/images/user.PNG']"))).perform();
		 * driver.findElement(By.linkText("Sign Out")).click(); driver.quit();
		 */
					
	//verify header msg expected result
	String lastname = driver.findElement(By.id("dtlview_Last Name")).getText();
	if(lastname.contains(lastName)) 
	{
		System.out.println(lastname+"is created==PASS");
		}
	else {
		System.out.println(lastname+"is not created==FAIL");
	}
	

	}

}
