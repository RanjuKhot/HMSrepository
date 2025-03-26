package AdminModule;

import java.io.FileInputStream;




import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.generic.baseutility.BaseClass;
import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.fileutility.FileUtility;
import com.hms.generic.objectropositoryutility.AddDoctorPage;
import com.hms.generic.objectropositoryutility.AdminDashBoradPage;
import com.hms.generic.objectropositoryutility.BetweenReportPage;
import com.hms.generic.objectropositoryutility.HomePage;
import com.hms.generic.objectropositoryutility.LoginPage;
import com.hms.generic.objectropositoryutility.ViewPatientReportpage;
import com.hms.generic.webutility.JavaUtility;
import com.hms.generic.webutility.WebdriverUtility;


public class AddDoctorNametest extends BaseClass
{
	@Test(groups= {"smokeTest","regressionTest"})
	public  void AddDoctorName() throws Throwable {
		

     	FileInputStream fis1 = new FileInputStream("C:\\Users\\abhik\\OneDrive\\Documents\\commontextscriptHMS.xlsx");
		 String DoctorName=elib.getDataFromExcel("Admin", 1, 2);
		 String ConsultancyFees=elib.getDataFromExcel("Admin", 1, 3);
		 String ContactNumber=elib.getDataFromExcel("Admin", 1, 4);
		 String DoctorEmail=elib.getDataFromExcel("Admin", 1, 5)+jlib.getRandomNumber()+elib.getDataFromExcel("Admin", 1, 6);
		 String DoctorClinicAddress=elib.getDataFromExcel("Admin", 1, 7);
		 String Password=elib.getDataFromExcel("Admin", 1, 8);
		 String ConfirmPassword=elib.getDataFromExcel("Admin", 1, 9);
		 String DoctorSpecialization=elib.getDataFromExcel("Admin", 1, 10);
		 
		 String username=elib.getDataFromExcel("AdminLogin", 1, 0);
	     String password=elib.getDataFromExcel("AdminLogin", 1, 1);
		 
		 HomePage hp=new HomePage(driver);
		 hp.getAdminLoginlink().click();
	  
		 LoginPage lp1=new LoginPage(driver);
		 lp1.Adminloginapp(username, password);
		 
		 AdminDashBoradPage adbp=new AdminDashBoradPage(driver);
		 adbp.getDoctorlink().click();

			adbp.getAddDoctorlink().click();
		 
		    Thread.sleep(3000);
		
		 AddDoctorPage adp=new AddDoctorPage(driver);
	     adp.AddDoctor(DoctorSpecialization, DoctorName, ConsultancyFees, DoctorClinicAddress, ContactNumber, DoctorEmail, Password, ConfirmPassword);
		
    	Thread.sleep(7000);
    	wlib.switchToAlertAndAccept(driver);
      
    	String actDoctorname = driver.findElement(By.xpath("//td[text()='"+DoctorName+"']")).getText();
    	Assert.assertTrue(actDoctorname.trim().contains(DoctorName));

	        adbp.getLogoutimg();
      
    
   
		
		}
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

