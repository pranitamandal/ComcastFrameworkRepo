package com.crm.comcast.contacttest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

class CreateOrgTest extends BaseClass {
	
	
	@Test
	public void createOrgTest() {
		System.out.println("execute createOrgTest & verify");
	}
	@Test
	public void createOrgWithIndustries() {
		System.out.println("execute createOrgWithIndustries & verify");
	}
	
}
