package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoradPage {
	WebDriver driver;
	public AdminDashBoradPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getBetweendateslink() {
		return betweendateslink;
	}

	@FindBy(xpath="(//div[@class='item-inner'])[2]")
	private WebElement Doctorlink;
	
	
	@FindBy(linkText="Add Doctor")
	private WebElement AddDoctorlink;
	
	@FindBy(xpath="//img[@src='assets/images/images.jpg']")
	private WebElement logoutimg;
	
	@FindBy(linkText="Log Out")
     private WebElement logoutbtn;
	
	@FindBy(xpath="(//span[@class='title'])[16]")
	 private WebElement Reportlink;
 	  
	public WebElement getReportlink() {
		return Reportlink;
	}

	@FindBy(xpath="(//span[@class='title'])[17]")
    private WebElement betweendateslink;
	 
	@FindBy(xpath="(//div[@class='item-inner'])[4]")
    private WebElement patientlink;
	
	@FindBy(xpath="//span[contains(text(),'Manage Patients')]")
	private WebElement managelinklink;
	
	public WebElement getPatientlink() {
		return patientlink;
	}

	public WebElement getManagelinklink() {
		return managelinklink;
	}

	public WebElement getLogoutimg() {
		return logoutimg;
	}


	


	public WebElement getLogoutbtn() {
		return logoutbtn;
	}


	public WebElement getDoctorlink() {
		return Doctorlink;
	}


	public WebElement getAddDoctorlink() {
		return AddDoctorlink;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
