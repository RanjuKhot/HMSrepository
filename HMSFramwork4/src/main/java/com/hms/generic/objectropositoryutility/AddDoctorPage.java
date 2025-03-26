package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.webutility.WebdriverUtility;



public class AddDoctorPage {
	WebDriver driver;
	public AddDoctorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@name='Doctorspecialization']")
	private WebElement Doctorspeciltext;
	
	@FindBy(name="docname")
	private WebElement Doctornametext;
	
	@FindBy(name="docfees")
	private WebElement ConsultancyFeestext;
	
	@FindBy(name="clinicaddress")
	private WebElement DoctorAddresstext;
	
	
	@FindBy(name="doccontact")
	private WebElement DoctorContacttext;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement Doctoremailtext;
	
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	private WebElement passwordtext;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement confirmpasswordtext;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement submitbtn;
	
	public WebElement getDoctorspeciltext() {
		return Doctorspeciltext;
	}

	public WebElement getDoctornametext() {
		return Doctornametext;
	}

	public WebElement getConsultancyFeestext() {
		return ConsultancyFeestext;
	}

	public WebElement getDoctorAddresstext() {
		return DoctorAddresstext;
	}

	public WebElement getDoctorContacttext() {
		return DoctorContacttext;
	}

	public WebElement getDoctoremailtext() {
		return Doctoremailtext;
	}

	public WebElement getPasswordtext() {
		return passwordtext;
	}

	public WebElement getConfirmpasswordtext() {
		return confirmpasswordtext;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public void AddDoctor(String DoctorSpecialization,String DoctorName,String ConsultancyFees, String DoctorClinicAddress,String ContactNumber,String DoctorEmail,String Password,String ConfirmPassword)
	{
		WebdriverUtility wlib = new WebdriverUtility();
		wlib.select(Doctorspeciltext, DoctorSpecialization);
		Doctornametext.sendKeys(DoctorName);
		ConsultancyFeestext.sendKeys(ConsultancyFees);
		DoctorAddresstext.sendKeys(DoctorClinicAddress);
		DoctorContacttext.sendKeys(ContactNumber);
		Doctoremailtext.sendKeys(DoctorEmail);
		passwordtext.sendKeys(Password);
		confirmpasswordtext.sendKeys(ConfirmPassword);
		submitbtn.click();
	}
	
}

