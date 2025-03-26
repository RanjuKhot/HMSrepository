package DoctorModule;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.generic.baseutility.BaseClass;
import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.fileutility.FileUtility;
import com.hms.generic.objectropositoryutility.AddPatientPage;
import com.hms.generic.objectropositoryutility.DoctorDashBoardPage;
import com.hms.generic.objectropositoryutility.HomePage;
import com.hms.generic.objectropositoryutility.LoginPage;
import com.hms.generic.webutility.JavaUtility;
import com.hms.generic.webutility.WebdriverUtility;

public class AddPatienttest extends BaseClass{
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

}

