package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPatientReportpage {
	WebDriver driver;
	public ViewPatientReportpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h5[@align=\"center\"]")
	  private WebElement FromDateTotoDate;
	
	public WebElement getFromDateTotoDate() {
		return FromDateTotoDate;
	}
}
