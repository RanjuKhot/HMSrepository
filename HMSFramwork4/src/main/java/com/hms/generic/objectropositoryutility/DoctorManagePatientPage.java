package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorManagePatientPage {
	WebDriver driver;
	public DoctorManagePatientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="(//i[@class='fa fa-edit'])[1]")
	  private WebElement patienteditbtn;
	
	public WebElement getPatienteditbtn() {
		return patienteditbtn;
	}
	 
}
