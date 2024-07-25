package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	ExtentReports report;

	@BeforeSuite
	public void configBS() {
		// Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-10");

	}

	@AfterSuite
	public void configAs() {
		report.flush();

	}

	@Test
	public void createContactTest() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		TakesScreenshot ts = (TakesScreenshot) driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("createContactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to app");
		test.log(Status.INFO, "create contact");
		if ("HDFCd".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
		driver.close();
	}

	@Test
	public void createContactWithOrg() {
		ExtentTest test = report.createTest("createContactWithOrg");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to app");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}

	}

	@Test
	public void createContactWithPhoneNumber() {
		ExtentTest test = report.createTest("createContactWithPhoneNumber");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to app");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
	}

}
