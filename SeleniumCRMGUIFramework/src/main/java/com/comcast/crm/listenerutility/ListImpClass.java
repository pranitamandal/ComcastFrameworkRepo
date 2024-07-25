package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.comcast.crm.basetest.BaseClass;
public class ListImpClass implements ITestListener,ISuiteListener {
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Report Configuration");

	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");

	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====>"+result.getMethod().getMethodName()+">=======START===========");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====>"+result.getMethod().getMethodName()+">=======END===========");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName=result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+"/test.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	

}
