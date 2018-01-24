package automated_HLS;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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
import java.io.PrintStream;
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

public class create_Voc_request {
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
	String Eng_Office;
	String Eng_Off_ID;
	String [] values=new String[2];
	
	@BeforeClass
	public void setUp() throws MalformedURLException, AWTException{
		//Set up desired capabilities and Identify ChromeDriver
		String filepath_driver=Reader.extract("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", filepath_driver);
         driver = new ChromeDriver();              
        driver.get("http://baladyapps.momra.gov.sa/Eservices/Pages/MyRequests.aspx");
        
        Robot r = new Robot(); 
        r.keyPress(KeyEvent.VK_ESCAPE); 
        r.keyRelease(KeyEvent.VK_ESCAPE);
        
        
       
        
	}
	
	
	
	
	
	
	@Test
	public String[] testCal() throws Exception {
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
        
       
        
        
        int years=1408 + (int)(Math.random() * ((1439 - 1408) + 1));
        
        Area_Decision_Number_text=Calendar.getInstance().getTimeInMillis() + "";
        
        System.out.println(Area_Decision_Number_text);
        
        Sign_In_Button.click();
        
        
        
        New_Voc_Request=driver.findElement(By.xpath("//*[@id='wucSideMenu1_Menu1']/ul/li[6]/a"));
        New_Voc_Request.click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
     
         Img_Map = driver.findElement(By.xpath("//*[@id='ctl00_Html1']/body"));
         
       
      
        WebElement m=driver.findElement(By.xpath("//*[@id='map']"));
        
        WebElement area=m.findElement(By.xpath("//area[contains(@data-id, '9')]"));
        coordinates_x=area.getLocation().getX();
        coordinates_y=area.getLocation().getY();
        
        WebElement Imag_Area=driver.findElement(By.xpath("//*[@id='ctl00_MSO_ContentDiv']/div/div[2]/div[1]/div[2]"));
        Image=Imag_Area.findElement(By.xpath("//img[contains(@src, '/Style Library/Balady/images/map_ar.png')]"));
     
        Image.getLocation();
        System.out.println("x of image="+Image.getLocation().x+'\t'+"y of image="+Image.getLocation().getY());
     
        System.out.println("width="+Image.getSize().getWidth()+"height="+Image.getSize().getHeight());
        System.out.println(driver.manage().window().getSize());
       
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        WebDriverWait wait2 = new WebDriverWait(driver, 50);
        
   
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        
        String[] Municipality = { "أمانة الاحساء", "أمانة منطقة الجوف", "أمانة الطائف",
        		"أمانة محافظة جدة", "أمانة منطقة حائل", "أمانة العاصمة المقدسة","أمانة منطقة عسير",
        		"أمانة منطقة الحدود الشمالية","أمانة منطقة القصيم","أمانة منطقة المدينة المنورة",
        		"أمانة المنطقة الشرقية","أمانة منطقة الباحة","أمانة منطقة نجران","أمانة منطقة الرياض",
        		"أمانة منطقة تبوك","أمانة منطقة جازان" };
        
        String Mun_String="";
        String SubMun_String="";
        String Mun = (String) JOptionPane.showInputDialog(null, "Choose now...",
            "Select Municipality", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                            // default
                                                                            // icon
            Municipality, // Array of choices
            Municipality[1]); // Initial choice
        
        
        
        
        
        switch(Mun)
        {
         case "أمانة الاحساء":
        	 Mun_String="FBE6DD4A-8DD3-4B38-A652-1D16C4944B51";
        	 
        	 break;
        	 
         case "أمانة منطقة الجوف":
        	 Mun_String="7E324D33-C281-4830-867E-2C652EC7E029";
        	 
        	 break;
        	 
         case "أمانة الطائف":
        	 Mun_String="B65EC706-882F-492B-9EDA-2E00B894CB11";
        	 
        	 break;
         case "أمانة محافظة جدة":
        	 Mun_String="957A3362-FDF1-4103-AAE2-2FB6366D2DB5";
        	 
        	 break;
        	 
         case "أمانة منطقة حائل":
        	 Mun_String="F5BBF80F-1B10-497C-A69C-5C6337ECDD57";
        	 
        	 break;
        	 
         case "أمانة العاصمة المقدسة":
        	 Mun_String="7861FCDD-4C80-410A-8F18-6D28E029DC21";
        	 
        	 break;
         case "أمانة منطقة عسير":
        	 Mun_String="066BD4BB-7AF2-40B4-ABD5-788059A5F6F5";
        	 
        	 break;
        	 
         case "أمانة منطقة الحدود الشمالية":
        	 Mun_String="4CFDD701-45B1-4A25-99B8-99ED0ED4588C";
        	 
        	 break;
        	 
         case "أمانة منطقة القصيم":
        	 Mun_String="ED748DC1-4713-4B41-B27A-ADAB264C88C1";
        	 
        	 break;
         case "أمانة منطقة المدينة المنورة":
        	 Mun_String="48F81BF1-5C74-4FFC-AEC2-B18B341DE73F";
        	 
        	 break;
        	 
         case "أمانة المنطقة الشرقية":
        	 Mun_String="9753822B-F759-4F7A-8D79-B388224DC1EB";
        	 
        	 break;
        	 
         case "أمانة منطقة الباحة":
        	 Mun_String="3F6B6C49-AF7E-4B46-9E6C-DDCB15D062E2";
        	 
        	 break;
         case "أمانة منطقة نجران":
        	 Mun_String="209F48C5-E258-4FE1-94B6-E2E0C749D9E6";
        	 
        	 break;
        	 
         case "أمانة منطقة الرياض":
        	 Mun_String="C0F04FE0-84D1-47F2-842D-E3261B44DED6";
        	 
        	 break;
        	 
         case "أمانة منطقة تبوك":
        	 Mun_String="AD079E2D-7577-409E-BA03-E7BAA1BB41D6";
        	 
        	 break;
        	 
         case "أمانة منطقة جازان":
        	 Mun_String="6FBF11DC-2620-4F9A-ACFC-F9413CC48174";
        	 
        	 break;
        }
        
        
        
        String[] SubMunicipality = { "القصيم", "بلدية وادي جازان", "أمانة الطائف",
        		"أمانة جدة", "أمانة منطقة عسير", "أمانة منطقة الرياض","امانة منطقة تبوك",
        		"أمانة المدينة المنورة","أمانة منطقة الحدود الشمالية","بلدية الخبر",
        		"أمانة المنطقة الشرقية","أمانة الإحساء","بلدية مدينة الظهران"};
        
        String subMun = (String) JOptionPane.showInputDialog(null, "Choose now...",
            "Select Sub-Municipality", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                            // default
                                                                            // icon
            SubMunicipality, // Array of choices
            SubMunicipality[1]); // Initial choice
        
        
        switch(subMun)
        {
         case "القصيم":
        	 SubMun_String="32361390-E181-4EF7-8237-039DAA0DCE24";
        	 
        	 break;
        	 
         case "بلدية وادي جازان":
        	 SubMun_String="01D2898E-F62C-45F5-9D40-1D468EC63BD1";
        	 
        	 break;
        	 
         case "أمانة الطائف":
        	 SubMun_String="778D00F0-96DB-494C-A3E9-4281DE9E8A5E";
        	 
        	 break;
         case "أمانة جدة":
        	 SubMun_String="2E9DE37C-AC51-4B29-B3C7-7AA16EB828E6";
        	 
        	 break;
        	 
         case "أمانة منطقة عسير":
        	 SubMun_String="0DD79D23-B06E-476A-9FB5-8705B897E5D2";
        	 
        	 break;
        	 
         case "أمانة منطقة الرياض":
        	 SubMun_String="976E1E5D-02A5-4A1D-BB18-8B68C40705BC";
        	 
        	 break;
         case "امانة منطقة تبوك":
        	 SubMun_String="93E08423-DF03-4362-832E-914DE84BB227";
        	 
        	 break;
        	 
         case "أمانة المدينة المنورة":
        	 SubMun_String="8FC66110-990F-4BDD-8198-AA8892C6162E";
        	 
        	 break;
        	 
         case "أمانة منطقة الحدود الشمالية":
        	 SubMun_String="781F1B38-F843-75DF-AEF0-AF48299C5AB4";
        	 
        	 break;
         case "بلدية الخبر":
        	 SubMun_String="5CF7AAF7-3B7E-4193-9E0C-BF10D7AD38BD";
        	 
        	 break;
        	 
         case "أمانة المنطقة الشرقية":
        	 SubMun_String="79BB36B5-D2A4-4AD2-BA9C-F5910467BA76";
        	 
        	 break;
        	 
         case "أمانة الإحساء":
        	 SubMun_String="EDC4D290-1615-41D8-833F-FDAC4160CA5A";
        	 
        	 break;
         case "بلدية مدينة الظهران":
        	 SubMun_String="BCE978E0-C140-4FF6-B3CF-FF920867A6AA";
        	 
        	 break;
        	 
         
        }
        
        
        
        
        
       driver.navigate().to("http://balady.momra.gov.sa/terms/Arar/Arar/pages/construction.aspx?srv=construction&MunicipalityId="+Mun_String+"&SubMunicipalityId="+SubMun_String);
     
       jse.executeScript("scroll(0, 1200)");
       
       Apply_Service= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='applyservice']")));
     
        Apply_Service.click();
        
      
        Next_Button=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_RequestSubmitterAndOwnerInfo_btnNext']"));
        Next_Button.click();
        
    //    WebElement formElement = driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_divMain']"));
        List<WebElement> allFormChildElements = driver.findElements(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_divMain']//*"));
       // @SuppressWarnings("unchecked")
		List<WebElement> test = 
		 wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_divMain']/ul[1]//*")));
		
		List<WebElement> runtime_elements=new ArrayList<WebElement>();
		for (int j=0;j<=test.size()-1;j++)
        {
        	System.out.println("Old WebElements --------------"+'\n'+test.get(j).getTagName()+'\n'+"End ");
        } 
		
		
        for(WebElement item : test )
        {
        	 
        	//System.out.println(item.getTagName()+'\n'+item.getText());
        
        	try
        	{
        		String length_original;
        		
        		
                if(item.getTagName().equals("input")) 
                {
                	
                    switch(item.getAttribute("type")) {
                    case "text": 
                    	length_original=item.getAttribute("maxlength");
           			 
                        
                		 if(length_original.equals(String.valueOf(4)))
                		 {
                			item.sendKeys(String.valueOf(years)); 
                		 }
                		 else
                		 {
                			item.sendKeys(String.valueOf(Area_Decision_Number_text));
                		 }
                  
                        break;
                        
                    case "radio":
                        
                    	item.click();
                    	//driver.navigate().to(driver.getCurrentUrl()); 
                    	
                    	runtime_elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_divMain']/ul[1]//Input")));
                    	test=new ArrayList<>(runtime_elements);
                    	
                    	 for(WebElement new_element : runtime_elements )
                    	 {
                    		// test.set(test.indexOf(item)+1,new_element);
                    		 if(new_element.getTagName().equals("input")) 
                             {
                             	
                                // switch(new_element.getAttribute("type")) 
                                 //{
                                 	// case "text": 
                    			 System.out.println("This is length:"+new_element.getAttribute("maxlength"));
                    			 String length;
                            
                    			 try
                    			 {
                    				  length=new_element.getAttribute("maxlength");
                    			 
                           
                                 		 if(length.equals(String.valueOf(4)))
                                 		 {
                                 			new_element.sendKeys(String.valueOf(years)); 
                                 		 }
                                 		 else
                                 		 {
                                 			new_element.sendKeys(String.valueOf(Area_Decision_Number_text));
                                 		 }
                                 		 
                    			 }
                    			 catch(NullPointerException e)
                    			 {
                    				 e.getMessage();
                    			 }
                   
                                	
                                	 
                                	 
                                 //}
                             }
                    		 
                    	 }
                    
                    
                   
                    }
                }
                
                
                else if(item.getTagName().equals("select")) 
                {
                    
                	Select DDL=new Select(item);
                	
                	List<WebElement> Number_of_elements=DDL.getOptions();
                    Random rand = new Random();
                    int max=Number_of_elements.size();
                    int  n = rand.nextInt(max-1) + 1;
                    DDL.selectByIndex(n);
                    WebElement option = DDL.getFirstSelectedOption();
                    Eng_Office=option.getText();
                    Eng_Off_ID=option.getAttribute("value");
                }  
            
               
        
        }catch(StaleElementReferenceException  | NullPointerException e)
            {
        	  System.out.println(e);
        	  wait.until(ExpectedConditions.stalenessOf(item));
            }

        
        }
        
        
  
        String filepath=Reader.extract("Autocad_upload_again.png");
        Upload_Img_ID=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_fuIdentity_fileUpload']"));
        Upload_Img_ID.sendKeys(filepath);
        
        Upload_Img_Sak=driver.findElement(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_fuContract_fileUpload']"));
        Upload_Img_Sak.sendKeys(filepath);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        
        jse.executeScript("scroll(0, 500)");
        Approve_Agreement_Chckbox= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_cbConfirmRequest']")));
        
        Approve_Agreement_Chckbox.click();
        
        Send_Button=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainContentPlaceHolder_ctl00_btnSend']")));
        		
        Send_Button.click();
        
        driver.switchTo().alert().accept();
        
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        
        Confirm_Request_Number=driver.findElement(By.xpath("//*[@id='main_content']/div[4]/div/div"));
        
        String Confirm_Msg=Request_No_And_Confirmation=Confirm_Request_Number.getText();
        String Request_Balady_No = Confirm_Msg.replaceAll("\\D+","");
        
        JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Balady Voc Request created successfully with ID : "+ Request_Balady_No+ "By Eng Office: "+Eng_Office+ "With ID: "+Eng_Off_ID);
        
        System.out.println("Balady Request No is : "+ Request_Balady_No);
        
        
        values[0]=Eng_Off_ID;
        values[1]=Request_Balady_No;
        return values;
	
		
		
	}
	
	
	
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}
	
	

}
