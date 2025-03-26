package com.hms.generic.baseutility;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hms.generic.databaseutility.DatabaseUtility;
import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.fileutility.FileUtility;
import com.hms.generic.objectropositoryutility.LoginPage;
import com.hms.generic.webutility.JavaUtility;
import com.hms.generic.webutility.WebdriverUtility;


public class BaseClass {
	public DatabaseUtility dblib=new DatabaseUtility();
	public FileUtility flib=new FileUtility ();
	public JavaUtility jlib=new JavaUtility();
	public ExcelUtility elib=new ExcelUtility();
    public WebdriverUtility wlib=new WebdriverUtility();
    
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("=====connect to database,report config=========");
		dblib.getDbconnection();
	
		
}
	
	@Parameters("BROWSER")
	
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws Throwable
	{
		System.out.println("=========Launch Browser=======");
		String BROWSER=flib.getDataFromPropertiesFile("browser");
	
		 if(BROWSER.equals("chrome"))
		 {
			 driver=new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 
			 driver=new FirefoxDriver();
		 }else if(BROWSER.equals("edge"))
		 {
			 driver=new EdgeDriver();
		 }
		 else
		 {
			 driver=new ChromeDriver();
		 }
		 sdriver=driver;
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable
	{
		System.out.println("=====Login To Application======");
		wlib.WaitForPageToLoad(driver);
		driver.manage().window().maximize();
		String URL=flib.getDataFromPropertiesFile("url");
		driver.get(URL);
		
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM()
	{ 
		System.out.println("===Logout===");
	   
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("======Close The Browser=======");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS()
	{
		System.out.println("======Close The Database,report backup=======");
		dblib.closeDbconnection();
		
	}
	
	

}
