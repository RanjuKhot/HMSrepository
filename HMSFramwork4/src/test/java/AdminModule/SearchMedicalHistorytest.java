package AdminModule;

import java.awt.RenderingHints.Key;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.hms.generic.baseutility.BaseClass;
import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.fileutility.FileUtility;
import com.hms.generic.objectropositoryutility.AddPatientPage;
import com.hms.generic.objectropositoryutility.AdminDashBoradPage;
import com.hms.generic.objectropositoryutility.DoctorDashBoardPage;
import com.hms.generic.objectropositoryutility.HomePage;
import com.hms.generic.objectropositoryutility.LoginPage;
import com.hms.generic.webutility.JavaUtility;
import com.hms.generic.webutility.WebdriverUtility;

public class SearchMedicalHistorytest  extends BaseClass{
	@Test(groups= {"smokeTest","regressionTest"})
public  void  SearchMedicalHistory() throws Throwable {
	
		
			FileInputStream fis1 = new FileInputStream("C:\\Users\\abhik\\OneDrive\\Documents\\commontextscriptHMS.xlsx");
			 String PatientName=elib.getDataFromExcel("Admin", 4, 2) +jlib.getRandomNumber();
			 String PatientContactNo=elib.getDataFromExcel("Admin", 4, 3) +jlib.getRandomNumber();
			 String GmailId=elib.getDataFromExcel("Admin", 4, 4) +jlib.getRandomNumber()+elib.getDataFromExcel("Admin", 1, 5);
			 String PatientAddress=elib.getDataFromExcel("Admin", 4, 8 );
			 String PatientAge=elib.getDataFromExcel("Admin", 4, 6);
			 String MedicalHistory=elib.getDataFromExcel("Admin", 4, 7);
			 
			 String username1=elib.getDataFromExcel("DoctorLogin", 1, 0);
		     String password1=elib.getDataFromExcel("DoctorLogin", 1, 1);
			 String username=elib.getDataFromExcel("AdminLogin", 1, 0);
		     String password=elib.getDataFromExcel("AdminLogin", 1, 1);
			 
		     HomePage hp=new HomePage(driver);
			 hp.getDoctorLoginLink().click();
			 
			 LoginPage lp=new LoginPage(driver);
			 lp.Doctorloginapp(username1, password1);
			
	
			 DoctorDashBoardPage ddbp1=new DoctorDashBoardPage(driver);
		    	ddbp1.getPatientlink().click();
			
		    	Thread.sleep(3000);
		    	
		    DoctorDashBoardPage ddbp2=new DoctorDashBoardPage(driver);
	    	ddbp2.getAddpateintlink().click();
                 Thread.sleep(3000);
      
                 AddPatientPage app=new AddPatientPage(driver);
       		  app.AddPatient(PatientName, PatientContactNo, GmailId);
       		  
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		 
			
			app.getPatientgenderRadiobutton().click();
		
	   
			 app.AddPatient1(PatientAddress, PatientAge, MedicalHistory);
			
	        
			 DoctorDashBoardPage ddbp=new DoctorDashBoardPage(driver);
		       ddbp.getLogoutimg().click();
				
		  
		       ddbp.getLogoutbtn().click();
				
		       HomePage hp1=new HomePage(driver);
				 hp1.getAdminLoginlink().click();
		
				 LoginPage lp1=new LoginPage(driver);
				 lp1.Adminloginapp(username, password);
				 Thread.sleep(4000);
				 

		         
		         AdminDashBoradPage adbp=new AdminDashBoradPage(driver);
		         adbp.getPatientlink().click();
		         
				 adbp.getManagelinklink().click();
		
			js.executeScript("window.scrollBy(0,500)");
			driver.findElement(By.xpath("//a[@href='view-patient.php?viewid=1']//i[@class='fa fa-eye']")).click();
			
			Thread.sleep(3000);
	
            adbp.getLogoutimg();
       
		
   }
}