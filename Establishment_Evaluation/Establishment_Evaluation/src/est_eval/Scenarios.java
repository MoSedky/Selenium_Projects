package est_eval;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.sun.jna.platform.win32.Sspi.TimeStamp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
//Excel Sheel Jars
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.james.mime4j.field.datetime.DateTime;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.security.SecureRandom;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.math.BigInteger;
public class Scenarios {
	
	WebDriver driver;
	WebElement content;
	WebElement link_press_here_login;
	WebElement Username_textfield;
	WebElement Password_textfield;
	WebElement captcha_textfield;
	WebElement Sign_In_Button;
	WebElement New_Voc_Request;
	WebElement North_Area;
	WebElement North_Municipility;
	WebElement North_Sub_Municipility;
	WebElement Agreements_Link;
	WebElement Apply_Service;
	Select Eng_Off;
	WebElement Area_Decision_Number;
	WebElement Year_Hijri;
	WebElement Upload_Img_ID;
	WebElement Upload_Img_Sak;
	WebElement Approve_Agreement_Chckbox;
	WebElement Send_Button;
	WebElement Confirm_Request_Number;
	WebElement Img_Map;
	WebElement Next_Button;
	String Username="citizen";
	String Password="P@ssw0rd";
	String Captcha;
	String Area_Decision_Number_text;
	String Year_Hijri_text="1438";
	String LaborOffice;
	String SequenceNumber;
	String Random_String;
	String Random_SP;
	BigInteger Random_no;
	String Random_DateTime;
	String Request_No_And_Confirmation;
	int Muncipility_No;
	int coordinates_x;
	int coordinates_y;
	WebElement Image;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, AWTException{
		//Set up desired capabilities and Identify ChromeDriver
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//New folder (2)//chromedriver_win32//chromedriver.exe");
         driver = new ChromeDriver();              
        driver.get("http://baladyapps.momra.gov.sa/Eservices/Pages/MyRequests.aspx");
        //http://192.168.209.55:3334/
        Robot r = new Robot(); 
        r.keyPress(KeyEvent.VK_ESCAPE); 
        r.keyRelease(KeyEvent.VK_ESCAPE);
        
        
       // content=driver.findElement(By.xpath("/html/body/div[2]"));
        
        //content.sendKeys(Keys.ESCAPE);
        
      //*[@id="map_AlHudud"]
        
	}
	
	
	
	
	
	
	@Test
	public void testCal() throws Exception {
		driver.manage().window().maximize();
		
		link_press_here_login=driver.findElement(By.xpath("//*[@id='lnkNativ']"));
		link_press_here_login.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Username_textfield=driver.findElement(By.xpath("//*[@id='txtUserName']"));
        Password_textfield=driver.findElement(By.xpath("//*[@id='txtPassword']"));
        
        Username_textfield.sendKeys(Username);
        Password_textfield.sendKeys(Password);
        String cap_text= JOptionPane.showInputDialog("Please insert Captcha text: ");
        
        captcha_textfield=driver.findElement(By.xpath("//*[@id='ucCaptcha_txtCaptcha']"));
        captcha_textfield.sendKeys(cap_text);
        Sign_In_Button=driver.findElement(By.xpath("//*[@id='btnLogin']"));
        
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElementValue(captcha_textfield, cap_text));
        Area_Decision_Number_text=Calendar.getInstance().getTimeInMillis() + "";
        
        System.out.println(Area_Decision_Number_text);
        
        Sign_In_Button.click();
        
        
        
        New_Voc_Request=driver.findElement(By.xpath("//*[@id='wucSideMenu1_Menu1']/ul/li[6]/a"));
        New_Voc_Request.click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
       // Img_Map=driver.findElement(By.xpath("//*[@src='/Style Library/Balady/images/map_AlHudud_ar.png']"));
         Img_Map = driver.findElement(By.xpath("//*[@id='ctl00_Html1']/body"));
         //Img_Map.click();
         
        // WebDriverWait wait22 = new WebDriverWait(driver, 300);
        
        // WebElement element = wait.until(ExpectedConditions
                    // .elementToBeClickable(By.id("node_0_item")));
       /*
         switch(Muncipility_No)
        {
         case 1:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
        	 
         case 2:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 3:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 4:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 5:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 6:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 7:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 8:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 9:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 10:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 11:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 12:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
         case 13:
        	 coordinates_x=1181;
        	 coordinates_y=505;
        	 
        	 break;
        	 
        	 
        }
        */
      //  WebDriverWait wait3 = new WebDriverWait(driver, 30);
        WebElement m=driver.findElement(By.xpath("//*[@id='map']"));
        
        WebElement area=m.findElement(By.xpath("//area[contains(@data-id, '9')]"));
        coordinates_x=area.getLocation().getX();
        coordinates_y=area.getLocation().getY();
        
        WebElement Imag_Area=driver.findElement(By.xpath("//*[@id='ctl00_MSO_ContentDiv']/div/div[2]/div[1]/div[2]"));
        Image=Imag_Area.findElement(By.xpath("//*[@id='map']"));
       // Image=driver.findElement(By.xpath("//*[@id='mapimage']"));
        WebElement Imag=driver.findElement(By.xpath("//*[@id='mapimage']"));
      //*[@id="map"]
        Image.getLocation();
        System.out.println("x of image="+Image.getLocation().x+'\t'+"y of image="+Image.getLocation().getY());
     //   System.out.println("x of body="+Img_Map.getLocation().getX()+'\t'+"y of body="+Img_Map.getLocation().getY());
        
      //  System.out.println("full image x="+(Image.getLocation().getX()+Image.getSize().getHeight())+'\n'+"full image Y="+(Image.getLocation().getY()+Image.getSize().getWidth()));
        
        System.out.println("width="+Imag.getSize());
        //System.out.println("width="+Imag.getSize().getWidth()+"height="+Imag.getSize().getHeight());
        System.out.println(driver.manage().window().getSize());
      
        
      //  wait3.until(ExpectedConditions.elementToBeClickable(area));
        
      //area/td[contains(text(), 'TEST CUSTOMER 2')]
      //*[@id="map_ArRiyad"]
       // area.click();
        Actions builder = new Actions(driver);
       // Action action = builder.moveToElement(Image,100,200).click().build();
        //143,459
        //20,163
          Action action = builder.moveToElement(Img_Map, 1181, 505).click().build();
          
         action.perform();
         
         System.out.println("x="+area.getLocation().getX()+'\t'+"y="+area.getLocation().getY());
         
         builder.release();
      //  " 457,142,406,139,363,120,366,86,343,85,338,70,219,7,191,0,180,9,138,22,133,39,135,46,143,54,147,61,158,61,180,57,216,60,223,69,243,70,253,68,266,76,275,76,281,80,286,89,296,97,251,131,249,147,242,155,251,160,274,154,286,158,294,155,315,162,322,171,328,171,336,167,340,172,342,176,359,180,370,176,382,202,400,206,414,218,419,215,416,210,415,206,428,193,443,159,453,153"
         
       // WebElement baseTable = driver.findElement(By.xpath("//*[@id='map']"));
       // List<WebElement> areas_elements = baseTable.findElements(By.tagName("area"));
       // areas_elements.get(3).click();
        
        //North_Area=driver.findElement(By.xpath("//*[@id='map_AlHudud']"));
        //North_Area.click();
        North_Municipility=driver.findElement(By.xpath("//*[@id='4cfdd701-45b1-4a25-99b8-99ed0ed4588c']"));
        North_Municipility.click();
        
      //  JavascriptExecutor jse = (JavascriptExecutor)driver;
      //  jse.executeScript("scroll(0, 250)");
        
        //action = builder.moveToElement(Img_Map, 1181, 505).release().build();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        
        North_Sub_Municipility=driver.findElement(By.xpath("//*[@id='781f1b38-f843-75df-aef0-af48299c5ab4']"));
        
        wait2.until(ExpectedConditions.elementToBeClickable(North_Sub_Municipility));
     //   Robot r2 = new Robot(); 
    //    r2.keyPress(KeyEvent.VK_SPACE); 
    //    r2.keyRelease(KeyEvent.VK_SPACE);
        
        
        North_Sub_Municipility.click();
        
        
        
        Agreements_Link=driver.findElement(By.xpath("//*[@id='constructionservice']"));
        Agreements_Link.click();
        Apply_Service=driver.findElement(By.xpath("//*[@id='applyservice']"));
        Apply_Service.click();
        
      
        Next_Button=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_RequestSubmitterAndOwnerInfo_btnNext']"));
        Next_Button.click();
        
        
        Eng_Off=new Select(driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_ddlEngOffice']")));
      //  Eng_Off=(Select) driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_ddlEngOffice']"));
        Eng_Off.selectByValue("4456");
        
        
        Area_Decision_Number=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_txtGeoSurveyNumber']"));
        Area_Decision_Number.sendKeys(Area_Decision_Number_text);
        
        Year_Hijri=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_txtGeoSurveyYear']"));
        Year_Hijri.sendKeys(Year_Hijri_text);
        
        Upload_Img_ID=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_fuIdentity_fileUpload']"));
        Upload_Img_ID.sendKeys("D:\\Projects_ADF_Project\\Request_Date.png");
        
        Upload_Img_Sak=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_fuContract_fileUpload']"));
        Upload_Img_Sak.sendKeys("D:\\Projects_ADF_Project\\Request_Date.png");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        
        Approve_Agreement_Chckbox=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_cbConfirmRequest']"));
        Approve_Agreement_Chckbox.click();
        
        Send_Button=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_btnSend']"));
        Send_Button.click();
        
        driver.switchTo().alert().accept();
        
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        
        Confirm_Request_Number=driver.findElement(By.xpath("//*[@id='main_content']/div[4]/div/div"));
        
        String Confirm_Msg=Request_No_And_Confirmation=Confirm_Request_Number.getText();
        String Request_Balady_No = Confirm_Msg.replaceAll("\\D+","");
        
        System.out.println("Balady Request No is : "+ Request_Balady_No);
        
      //*[@id="mainContentPlaceHolder_ucAddRequest_txtGeoSurveyNumber"]
        
        //
        
		
		/*System.out.println("Random String is :"+Random_String);
		System.out.println("Random Special Character is :"+Random_SP);
		System.out.println("Random Number is :"+Random_no);
		System.out.println("Random Date is :"+Random_DateTime);
  		*/
	}
	
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}

}
