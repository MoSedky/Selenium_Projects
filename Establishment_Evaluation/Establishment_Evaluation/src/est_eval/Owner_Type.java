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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Owner_Type {
	
	WebDriver driver;
	String Username;
	String Password;
	String LaborOffice;
	String SequenceNumber;
	String MunicipalityId;
	String SubMunicipalityId;
	WebElement Building_License_No;
	WebElement Building_License_Date;
	WebElement Area;
	WebElement Holes_No;
	WebElement Height;
	WebElement Width;
	WebElement Land_Piece_No;
	WebElement Previous_1;
	WebElement Next_2;
	WebElement Save_1;
	WebElement Cancel_1;
	
	@BeforeClass
	public void setUp() throws Exception{
		//Set up desired capabilities and Identify ChromeDriver
	Compare_IsIc C=new Compare_IsIc();
	driver=C.driver;
	C.testCal();
        
        
	}
	
	
	
	
	@Test
	public void testCal() throws Exception {
		
		

	    String filePath = "D:\\Automation Testing\\Establishment_Evaluation\\";

	    //Call read file method of the class to read data

        Robot r = new Robot();
        WebElement Next_1=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_WizardFooter_btnNext']"));
        Next_1.click();
        
        //Values in Wizard Step 2
         Building_License_No=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_ucShopDetail_txtLicensingNumber']"));
    	 Building_License_Date=driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_ucShopDetail_calLicensingDate_popupDatepicker']"));
    	 Area=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_ucShopDetail_txtArea']"));
    	 Holes_No=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_ucShopDetail_txtArea']"));
    	 Height=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_ucShopDetail_txtLength']"));
    	 Width=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_ucShopDetail_txtWidth']"));
    	 Land_Piece_No=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_ucShopDetail_txtPlotNo']"));
    	 Previous_1=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_WizardFooter_btnBack']"));
    	 Next_2=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_WizardFooter_btnNext']"));
    	 Save_1=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_WizardFooter_btnSave']"));
    	 Cancel_1=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_InstantPermitRouter_FullProcessWizard_WizardFooter_btnCancel']"));
        
        
        //Set Values in Wizard Step 2 
    	 
    	 Building_License_No.sendKeys("");
    	 Building_License_Date.sendKeys("");
    	 Area.sendKeys("");
    	 Holes_No.sendKeys("");
    	 Height.sendKeys("");
    	 Width.sendKeys("");
    	 Land_Piece_No.sendKeys("");
    	 
    	 
        WebElement Login_button=driver.findElement(By.xpath("//*[@id='lnkNativ']"));
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
        
        
        WebDriverWait wait = new WebDriverWait(driver, 50);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]")));
	    //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Login_button.click();
       
	    
	    WebElement User_Name_field=driver.findElement(By.xpath("//*[@id='txtUserName']"));
	    WebElement Password__field=driver.findElement(By.xpath("//*[@id='txtPassword']"));
	    WebElement Sign_In_field=driver.findElement(By.xpath("//*[@id='btnLogin']"));
	    
	    WebDriverWait wait2 = new WebDriverWait(driver, 50);
	    WebElement Password_set_value = wait2.until(ExpectedConditions.elementToBeClickable(Password__field));
	 
	    User_Name_field.sendKeys(Username);
	    Password__field.sendKeys(Password);
	    
	   
	  //  WebDriverWait wait2 = new WebDriverWait(driver, 30);
	  //  wait2.until(ExpectedConditions.textToBePresentInElement(Verification_Code,""));
	    
	     
	     {
            
                if (driver.findElement(By.xpath("//*[@id='ucCaptcha_txtCaptcha']")).getText().length()==0)
                {
                	Thread.sleep(10000);
                }
	     }  
       
	    
	    
	    
	    /*(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	d=driver;
                return d.findElement(By.xpath("//*[@id='ucCaptcha_txtCaptcha']")).getText().length()!=10;
            }
        });*/
	    Sign_In_field.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 /*   WebElement Another_Logged_User=driver.findElement(By.xpath("//*[@id='MainContent_Login1_pnlLoginStep3']/div[1]"));
	    
	    if(Another_Logged_User.isDisplayed())
	    {
	    	Password__field=driver.findElement(By.xpath("//*[@id='MainContent_Login1_txtConfirmPassword']"));
	    	Sign_In_field=driver.findElement(By.xpath("//*[@id='MainContent_Login1_btnConfirmPassword']"));
	    	Password__field.sendKeys(Password);
		    Sign_In_field.click();
	    }
	    
	   */ 
	    
	    
	}
	
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}

}
