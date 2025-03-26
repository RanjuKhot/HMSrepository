package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BetweenReportPage {

	WebDriver driver;
	public BetweenReportPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="fromdate")
	private WebElement Fromdatetext;
	

	@FindBy(id="todate")
	private WebElement Todatetext;
	 
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement submitbtn;
	
	public WebElement getFromdatetext() {
		return Fromdatetext;
	}

	public WebElement getTodatetext() {
		return Todatetext;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
		
		public void BetweenReport(String fromDate,String ToDate)
		{
			Fromdatetext.sendKeys(fromDate);
			Todatetext.sendKeys(ToDate);
			submitbtn.click();
		}
	
}
