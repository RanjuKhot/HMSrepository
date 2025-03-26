package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashBoardPage {


	WebDriver driver;
	public DoctorDashBoardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	
	@FindBy(xpath="//span[contains(text(),'Patients')]")
	 private WebElement patientlink;
	 
	 @FindBy(linkText="Add Patient")
	    private WebElement Addpateintlink;
	 
	
	@FindBy(linkText="Patients")
	 private WebElement searchlink;
	
	
	 @FindBy(xpath="//img[@src=\"assets/images/images.jpg\"]")
	    private WebElement logoutimg;
	 
	 

		@FindBy(linkText="Log Out")
		 private WebElement logoutbtn;
		
		@FindBy(xpath="//span[contains(text(),'Search')]")
		 private WebElement patientsearchlink;
 
		
		@FindBy(xpath="(//span[@class='title'])[5]")
		 private WebElement managepatienttext;
 
		
		public WebElement getManagepatienttext() {
			return managepatienttext;
		}
		public WebElement getPatientlink() {
			return patientlink;
		}



		public WebElement getAddpateintlink() {
			return Addpateintlink;
		}



	public WebElement getPatientsearchlink() {
			return patientsearchlink;
		}



		public WebElement getSearchlink() {
			return searchlink;
		}



		public WebElement getLogoutimg() {
			return logoutimg;
		}



		public WebElement getLogoutbtn() {
			return logoutbtn;
		}
		
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}



