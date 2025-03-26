package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {
	WebDriver driver;
	public AddPatientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
    @FindBy(name="patname")
    private WebElement patientnametxtfield;
    
    @FindBy(name="patcontact")
    private WebElement patientcontactnotxt;
    
    @FindBy(xpath="//input[@type='email']")
    private WebElement patientemailtxt;
    
    @FindBy(xpath="//div[@id='container']/div/div/div[1]/div/div/div/div[2]/form/div[4]/div/label[1]")
    private WebElement patientgenderRadiobutton;
    
    @FindBy(name="pataddress")
    private WebElement patientaddresstxt;
    
    @FindBy(xpath="//input[@name='patage']")
    private WebElement patientAgetxt;
   
    @FindBy(xpath="//textarea[@name='medhis']")
    private WebElement patientMedicalHistorytxt;
	
    @FindBy(id="submit")
    private WebElement Addbtn;
    
  
	public WebElement getPatientnametxtfield() {
		return patientnametxtfield;
	}

	public WebElement getPatientcontactnotxt() {
		return patientcontactnotxt;
	}

	public WebElement getPatientemailtxt() {
		return patientemailtxt;
	}

	public WebElement getPatientgenderRadiobutton() {
		return patientgenderRadiobutton;
	}

	public WebElement getPatientaddresstxt() {
		return patientaddresstxt;
	}

	public WebElement getPatientAgetxt() {
		return patientAgetxt;
	}

	public WebElement getPatientMedicalHistorytxt() {
		return patientMedicalHistorytxt;
	}

	public WebElement getAddbtn() {
		return Addbtn;
	}
    
     public void AddPatient(String PatientName,String PatientContactNo,String GmailId)
     {
    	 patientnametxtfield.sendKeys(PatientName);
    	 patientcontactnotxt.sendKeys(PatientContactNo);
    	 patientemailtxt.sendKeys(GmailId);
     }
    	 
    	public void AddPatient1(String PatientAddress,String PatientAge,String MedicalHistory)
    	{
    	 patientaddresstxt.sendKeys(PatientAddress);
    	 patientAgetxt.sendKeys(PatientAge);
    	 patientMedicalHistorytxt.sendKeys(MedicalHistory);
    	 Addbtn.click();
     }

    	 public void AddPatient2(String PatientName)
         {
        	 patientnametxtfield.sendKeys(PatientName);
}
    	 public void AddPatient3(String PatientName)
         {
        	 patientnametxtfield.sendKeys(PatientName);
        	 patientnametxtfield.clear();
}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

