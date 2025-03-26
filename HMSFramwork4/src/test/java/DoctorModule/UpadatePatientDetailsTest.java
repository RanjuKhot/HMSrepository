package DoctorModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.generic.baseutility.BaseClass;
import com.hms.generic.objectropositoryutility.AddPatientPage;
import com.hms.generic.objectropositoryutility.DoctorDashBoardPage;
import com.hms.generic.objectropositoryutility.DoctorManagePatientPage;
import com.hms.generic.objectropositoryutility.HomePage;
import com.hms.generic.objectropositoryutility.LoginPage;
import com.hms.generic.objectropositoryutility.UpadatePatientPage;

public class UpadatePatientDetailsTest  extends BaseClass{
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
		    
		    Thread.sleep(2000);
		
           AddPatientPage app=new AddPatientPage(driver);
 		   app.AddPatient3(PatientName);
 		
	    	Thread.sleep(3000);
	     	app.AddPatient3(PatientName);
	
	     	Thread.sleep(3000);
		
		
		      app.AddPatient2(PatientName);
		 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		UpadatePatientPage upp=new UpadatePatientPage(driver);
		upp.getUpdatebtn().click();


        String actpatientname = driver.findElement(By.xpath("//td[text()=\'"+PatientName+"']")).getText();
        Assert.assertTrue(actpatientname.trim().contains(PatientName));
		
         ddbp.getLogoutimg().click();
		
       
	}

}
