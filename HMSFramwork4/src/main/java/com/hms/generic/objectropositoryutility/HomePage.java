package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//div[@class=\"listview_1_of_3 images_1_of_3\"])[3]")
	  private WebElement AdminLoginlink;
	
	@FindBy(xpath="//div[@class=\"listview_1_of_3 images_1_of_3\"]/..")
	  private WebElement DoctorLoginLink;
	
	public WebElement getAdminLoginlink() {
		return AdminLoginlink;
	}

	public WebElement getDoctorLoginLink() {
		return DoctorLoginLink;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
