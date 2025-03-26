package com.hms.generic.objectropositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.webutility.WebdriverUtility;

public class LoginPage  extends WebdriverUtility{
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@type='text']")
	private WebElement Ausernametxtfield;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement Apasswordtxtfeild;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement Aloginbtn;
	
	@FindBy(name="username")
	private WebElement Dusername1txtfield;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	private WebElement Dpassword1txtfield;
	
	@FindBy(name="submit")
	private WebElement Dloginbtn1;
	
	
	public WebElement getUsername1txtfield() {
		return Dusername1txtfield;
	}


	public WebElement getPassword1txtfield() {
		return Dpassword1txtfield;
	}


	public WebElement getLoginbtn1() {
		return Dloginbtn1;
	}


	public WebDriver getDriver() {
		return driver;
	}

	
	public WebElement getUsernametxtfield() {
		return Ausernametxtfield;
	}

	public WebElement getPasswordtxtfeild() {
		return Apasswordtxtfeild;
	}

	public WebElement getLoginbtn() {
		return Aloginbtn;
	}
	
	public void Adminloginapp(String username,String password)
	{  
	    
	    Ausernametxtfield.sendKeys(username);
		Apasswordtxtfeild.sendKeys(password);
		Aloginbtn.click();
	}
	
	public void Doctorloginapp(String username1,String password1)
	{  
	 
		Dusername1txtfield.sendKeys(username1);
		Dpassword1txtfield.sendKeys(password1);
		Dloginbtn1.click();
	}

}
