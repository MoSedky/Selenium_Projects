package est_eval;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
//Excel Sheel Jars
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Dashboard_Page {
	
	WebDriver driver;
	String Labor_Office;
	String Sequence_no;
	@BeforeClass
	public void setUp() throws Exception{
		
		Login_Page login=new Login_Page();
		login.setUp();
		//login.readExcel("E:\\Automation Testing\\Establishment_Evaluation", "TestData_EstablishmentEval.xlsx", "Login_Page");
		login.testCal();
		driver=login.driver;
		 Labor_Office=login.LaborOffice;
		 Sequence_no=login.SequenceNumber;
	}
	
	@Test
	public void testCal() throws Exception {
		WebElement Close_PopUp=driver.findElement(By.xpath("//*[@id='closeLnk1']"));
	    Close_PopUp.click();
	    
	    driver.switchTo().defaultContent();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	    WebElement Establishment_DDL=driver.findElement(By.xpath("//*[@id='select2-MainContent_EstablishmentFilter1_ddlEstablishments-container']"));
	    Establishment_DDL.click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	//  WebElement Establishments=driver.findElement(By.xpath("//*[@id='select2-MainContent_EstablishmentFilter1_ddlEstablishments-container']"));

	  WebElement Selected_Establishment=driver.findElement(By.xpath("//li[starts-with(@title,'"+Labor_Office+" "+"-"+" "+Sequence_no+"')]"));
	  Selected_Establishment.click();
	  
	  
	  WebElement Start_Btn=driver.findElement(By.xpath("//*[@id='MainContent_EstablishmentFilter1_lnkDisplayServices']/div/div/div[1]"));
	  Start_Btn.click();
	  
	  WebElement Verify_Read=driver.findElement(By.xpath("//*[@id='nofificationForm']/div[7]/center/a"));
	  Verify_Read.click();
	  
	  WebElement Est_Eval_Mawzoon=driver.findElement(By.xpath("//*[@id='div3']/li[6]/div[1]"));
	  Est_Eval_Mawzoon.click();
	  
	  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	  WebElement Start_Nitaqat_Serv=driver.findElement(By.xpath("//*[@id='MainContent_ServiceList1_rptCategories_rptServices_0_lnkStartService_5']"));
	  Start_Nitaqat_Serv.click();
	  
	}
}
