package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPatientPage {

	WebDriver driver;
	public SearchPatientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="searchdata")
	private WebElement searchtextfild;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement submitbtn;
	
	
	public WebElement getSearchtextfild() {
		return searchtextfild;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public void searchdata(String PatientName)
	{
		searchtextfild.sendKeys(PatientName);
		submitbtn.click();
	}
	
	
	
	
	
	
	
}
