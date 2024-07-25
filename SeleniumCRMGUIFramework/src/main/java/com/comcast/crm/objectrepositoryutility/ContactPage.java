package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='OrganizationsPage']")
	private WebElement createNewOrgBtn;

	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name="search_field")
	private WebElement searchDD;

	@FindBy(name="submit")
	private WebElement searchBtn;


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getSearchDD() {
		return searchDD;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	}



