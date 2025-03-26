package DoctorModule;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.generic.baseutility.BaseClass;
import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.fileutility.FileUtility;
import com.hms.generic.objectropositoryutility.AddPatientPage;
import com.hms.generic.objectropositoryutility.DoctorDashBoardPage;
import com.hms.generic.objectropositoryutility.DoctorManagePatientPage;
import com.hms.generic.objectropositoryutility.HomePage;
import com.hms.generic.objectropositoryutility.LoginPage;
import com.hms.generic.objectropositoryutility.SearchPatientPage;
import com.hms.generic.objectropositoryutility.UpadatePatientPage;
import com.hms.generic.webutility.JavaUtility;
import com.hms.generic.webutility.WebdriverUtility;

public class AddPatientAndSearchPatientTest extends BaseClass  {
	@Test(groups= {"smokeTest","regressionTest"})

	public void AddPatientAndSearchPatient()throws Throwable {
		

		 String PatientName=elib.getDataFromExcel("Patient", 1, 2) +jlib.getRandomNumber();
		 String PatientContactNo=elib.getDataFromExcel("Patient", 1, 3);
		 String GmailId=elib.getDataFromExcel("Patient", 1, 4) +jlib.getRandomNumber()+elib.getDataFromExcel("Patient", 1, 5);
		 String PatientAddress=elib.getDataFromExcel("Patient", 1, 8 );
		 String PatientAge=elib.getDataFromExcel("Patient", 1, 6);
		 String MedicalHistory=elib.getDataFromExcel("Patient", 1, 7);
		 
		 
		 String username1=elib.getDataFromExcel("DoctorLogin", 1, 0);
	     String password1=elib.getDataFromExcel("DoctorLogin", 1, 1);
	     
 
		HomePage hp=new HomePage(driver);
		hp.getDoctorLoginLink().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.Doctorloginapp(username1, password1);
	
		Thread.sleep(3000);
	
		   DoctorDashBoardPage ddbp1=new DoctorDashBoardPage(driver);
	    	ddbp1.getPatientlink().click();
		  Thread.sleep(3000);
		
			ddbp1.getAddpateintlink().click();
		          Thread.sleep(3000);
		   
		  AddPatientPage app=new AddPatientPage(driver);
		  app.AddPatient(PatientName, PatientContactNo, GmailId);
		          
       JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		 app.getPatientgenderRadiobutton().click();
		
         
		 app.AddPatient1(PatientAddress, PatientAge, MedicalHistory);
		
         ddbp1.getPatientsearchlink().click();
	    	
	    	SearchPatientPage spp=new SearchPatientPage(driver);
	    	spp.searchdata(PatientName);
	    	spp.getSubmitbtn().click();

	   String SearchPatientName=driver.findElement(By.xpath("//td[text()='"+PatientName+"']")).getText();
	   Assert.assertTrue(SearchPatientName.trim().contains(PatientName));

	 
        ddbp1.getLogoutimg().click();
		  ddbp1.getLogoutbtn().click();
		
}




	@Test(groups= {"smokeTest","regressionTest"})

	public void AddPatient() throws Throwable, Throwable {


		FileInputStream fis1 = new FileInputStream("C:\\Users\\abhik\\OneDrive\\Documents\\commontextscriptHMS.xlsx");
		 String PatientName=elib.getDataFromExcel("Patient", 1, 2) +jlib.getRandomNumber();
		 String PatientContactNo=elib.getDataFromExcel("Patient", 1, 3);
		 String GmailId=elib.getDataFromExcel("Patient", 1, 4) +jlib.getRandomNumber()+elib.getDataFromExcel("Patient", 1, 5);
		 String PatientAddress=elib.getDataFromExcel("Patient", 1, 8 );
		 String PatientAge=elib.getDataFromExcel("Patient", 1, 6);
		 String MedicalHistory=elib.getDataFromExcel("Patient", 1, 7);
	
		 
		 String username1=elib.getDataFromExcel("DoctorLogin", 1, 0);
	     String password1=elib.getDataFromExcel("DoctorLogin", 1, 1);


			HomePage hp=new HomePage(driver);
			hp.getDoctorLoginLink().click();
			
			LoginPage lp=new LoginPage(driver);
			lp.Doctorloginapp(username1, password1);
		
		  DoctorDashBoardPage ddbp=new DoctorDashBoardPage(driver);
         ddbp.getPatientlink().click();
		 Thread.sleep(3000);

		 ddbp.getAddpateintlink().click();
		 
		AddPatientPage app=new AddPatientPage(driver);
		app.AddPatient(PatientName, PatientContactNo, GmailId);
        
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		 app.getPatientgenderRadiobutton().click();
		
		Thread.sleep(3000);
 
		app.AddPatient1(PatientAddress, PatientAge, MedicalHistory);
		
		ddbp.getPatientlink().click();
     	
		 Thread.sleep(3000);

		  ddbp.getManagepatienttext().click();
        
		String actPatientname = driver.findElement(By.xpath("//td[text()='"+PatientName+"']")).getText();
		  Assert.assertTrue(actPatientname.trim().contains(PatientName));
			
			 ddbp.getLogoutimg().click();
			
	     
	}

	@Test(groups= {"smokeTest","regressionTest"})

	public void UpadatePatientDetails() throws Throwable {
		
		
			FileInputStream fis1 = new FileInputStream("C:\\Users\\abhik\\OneDrive\\Documents\\commontextscriptHMS.xlsx");
			 String PatientName=elib.getDataFromExcel("Patient", 1, 2) +jlib.getRandomNumber();
			 
			 String username1=elib.getDataFromExcel("DoctorLogin", 1, 0);
		     String password1=elib.getDataFromExcel("DoctorLogin", 1, 1);
			 
			   HomePage hp=new HomePage(driver);
			   hp.getDoctorLoginLink().click();
			 
				LoginPage lp=new LoginPage(driver);
				lp.Doctorloginapp(username1, password1);
			
			 
			 DoctorDashBoardPage ddbp=new DoctorDashBoardPage(driver);
			 ddbp.getPatientlink().click();
			 
		    Thread.sleep(3000);
		
		     ddbp.getManagepatienttext().click();
		    
		    DoctorManagePatientPage dmpp=new DoctorManagePatientPage(driver);
		    dmpp.getPatienteditbtn().click();
		    
		    Thread.sleep(3000);
		
           AddPatientPage app=new AddPatientPage(driver);
 		   app.AddPatient3(PatientName);
 		
	    	Thread.sleep(3000);
	     	app.AddPatient3(PatientName);
	
	     	Thread.sleep(2000);
		
		
		      app.AddPatient2(PatientName);
		 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(4000);
		UpadatePatientPage upp=new UpadatePatientPage(driver);
		upp.getUpdatebtn().click();


        String actpatientname = driver.findElement(By.xpath("//td[text()=\'"+PatientName+"']")).getText();
        Assert.assertTrue(actpatientname.trim().contains(PatientName));
		
         ddbp.getLogoutimg().click();
		
       
	}

}


