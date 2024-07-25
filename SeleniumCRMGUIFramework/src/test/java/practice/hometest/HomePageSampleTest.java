package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");


		
		//SoftAssert assertObj= new SoftAssert();
		System.out.println("step_1");
		System.out.println("step_2");
		//Assert.assertEquals("Home","Home");
		System.out.println("step_3");
		//assertObj.assertEquals("Title", "Title");
		System.out.println("step_4");
		//assertObj.assertAll();
		System.out.println(mtd.getName()+"Test End");
	}
		@Test
		public void verifyLogoHomePageTest(Method mtd) {
			System.out.println(mtd.getName()+"Test Start");
			
			SoftAssert assertObj= new SoftAssert();
			
			System.out.println("step_1");
			System.out.println("step_2");
			assertObj.assertTrue(true);
			System.out.println("step_3");
			System.out.println("step_4");
			assertObj.assertAll();
			System.out.println(mtd.getName()+"Test End");
		}

}
