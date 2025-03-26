package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpadatePatientPage {

	WebDriver driver;
	public UpadatePatientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	  @FindBy(xpath="//button[@type='submit']")
	    private WebElement Updatebtn;
	    
	  public WebElement getUpdatebtn() {
			return Updatebtn;
		}

}
