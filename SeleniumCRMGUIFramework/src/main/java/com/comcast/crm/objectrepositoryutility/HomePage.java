package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	public WebElement getProductLink() {
		return productLink;
	}
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLnk;
	
	@FindBy(linkText="More")
	private WebElement moreLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignsLnk() {
		return CampaignsLnk;
	}
	
	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	public void navigateToCampaignPage() {
		Actions act= new Actions(driver);
		act.moveToElement(moreLnk).perform();
		CampaignsLnk.click();
	}
	public void logout() {
		Actions act= new Actions(driver);
		act.moveToElement(adminImg).perform();
		signoutLnk.click();
	}
}
