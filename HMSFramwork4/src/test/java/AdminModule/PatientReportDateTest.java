package AdminModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.generic.baseutility.BaseClass;
import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.fileutility.FileUtility;
import com.hms.generic.objectropositoryutility.AdminDashBoradPage;
import com.hms.generic.objectropositoryutility.BetweenReportPage;
import com.hms.generic.objectropositoryutility.HomePage;
import com.hms.generic.objectropositoryutility.LoginPage;
import com.hms.generic.objectropositoryutility.ViewPatientReportpage;
import com.hms.generic.webutility.JavaUtility;
import com.hms.generic.webutility.WebdriverUtility;

public class PatientReportDateTest extends BaseClass {

	@Test(groups= {"smokeTest","regressionTest"})
	public void PatientReportDate() throws Throwable {
		
		String username=elib.getDataFromExcel("AdminLogin", 1, 0);
	     String password=elib.getDataFromExcel("AdminLogin", 1, 1);
		
		 HomePage hp=new HomePage(driver);
		 hp.getAdminLoginlink().click();
		 
		 LoginPage lp1=new LoginPage(driver);
		 lp1.Adminloginapp(username, password);
		
		  Thread.sleep(2000);
		  AdminDashBoradPage adp=new AdminDashBoradPage(driver);
		  adp.getReportlink().click();
		
			    
				 adp.getBetweendateslink().click();
				 
				String fromDate=jlib.getSystemDateYYYYDDMM();
				String ToDate=jlib.getRequiredDateYYYYDDMM(30);
				
				BetweenReportPage brp=new BetweenReportPage(driver);
				brp.BetweenReport(fromDate, ToDate);
			      
				ViewPatientReportpage vprp=new ViewPatientReportpage(driver);
				String ReportfromStartAndLastDate=vprp.getFromDateTotoDate().getText();
	            if(ReportfromStartAndLastDate .trim().contains(fromDate+" to "+ToDate))
				{
					System.out.println( fromDate+ToDate +  "Report date is verified ==PASS");
				}
				else
				{
					System.out.println( fromDate+ToDate+  " Report date is not verified ==FAIL");
					 Assert.assertTrue(ReportfromStartAndLastDate.contains(fromDate+ToDate));
				}
				
	            
	            adp.getLogoutimg();
	            
	          
	         

				
	}

}