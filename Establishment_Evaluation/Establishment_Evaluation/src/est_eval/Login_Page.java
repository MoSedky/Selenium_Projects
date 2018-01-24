package est_eval;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Login_Page   {
	WebDriver driver;
	String National_ID;
	String Password;
	String LaborOffice;
	String SequenceNumber;
	WebElement Player_Name;
	WebElement Submit_Button;
	WebElement Add_Another_Player;
	String[] Names = { "محمد عبده,",",نور بهاء","محمد صدقي,",",أحمد سيد", ",عبد السلام عثمان", "اسامة ياسر,","ابراهيم عابدين,", "ميدو (صدقي),"};
	WebElement Messages;
	WebElement Msg_txt;
	WebElement Search;
	WebElement search_txt;
	WebElement search_results;
	WebElement results_date;
	String msg_date;
	WebElement founded_url;
	String URL="7mdelah 3ala el salama";
	//https://docs.google.com/forms/d/e/1FAIpQLSdMl_LDuHAzhCcA2XVk7lsafw2S3kFgHmS_404rnhwfbRMy0g/viewform?c=0&w=1
	
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		
		//Set up desired capabilities and Identify ChromeDriver
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//Establishment_Evaluation//chromedriver.exe");
         driver = new ChromeDriver();   
       /*  driver.get("https://web.whatsapp.com/");
         Messages=driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div/div[3]"));
       
         Search=driver.findElement(By.xpath("//*[@id='main']/header/div[3]/div/div[1]/button/span"));
         
         search_txt=driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/span[3]/div/div/div[1]/div/label/input"));
         search_txt.sendKeys("https://docs.google.com/");
         search_results=driver.findElement(By.xpath("//*[@id='pane-side']/div/div/div/div[11]/div/div/div"));
       
         results_date=driver.findElement(By.xpath("//*[@id='pane-side']/div/div/div/div[11]/div/div/div/div[1]/div[2]/span"));
         msg_date=results_date.getText();
         if(msg_date.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$"))
         {
        	 results_date.click();
         }
    
        		   WebElement text_URL=driver.findElement(By.xpath("//*[@id='main']/div[span[text()='"+URL+"']]"));
        		   text_URL.click();
        	
        		
         */
         
        driver.get("https://goo.gl/forms/6pFQLfiqfxZMpJr53");
     
        Player_Name=driver.findElement(By.xpath("//*[@id='mG61Hd']/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[1]/input"));
                                                 
        Submit_Button=driver.findElement(By.xpath("//*[@id='mG61Hd']/div/div[2]/div[3]/div[1]/div/div/content/span"));
                                                   
        
      
	}

	
	
	
	public void fillData()
	{
		//for(int i=0;i<Names.length;i++)
		//{
			WebDriverWait wait3 = new WebDriverWait(driver, 30);
	        
			Player_Name=driver.findElement(By.xpath("//*[@id='mG61Hd']/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[1]/input"));
	        wait3.until(ExpectedConditions.visibilityOf(Player_Name));
	        
	      
			Player_Name.sendKeys(Names);
			
			Submit_Button=driver.findElement(By.xpath("//*[@id='mG61Hd']/div/div[2]/div[3]/div[1]/div/div/content/span"));
	        wait3.until(ExpectedConditions.visibilityOf(Submit_Button));
	        
			Submit_Button.click();
			
			//Add_Another_Player=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[3]/a"));
	       // wait3.until(ExpectedConditions.visibilityOf(Add_Another_Player));
			
			//Add_Another_Player.click();
		//}
		
		
	}
	
	
	@Test
	public void testCal() throws Exception {
		
		
		
        
	    
		/*Player_Name.sendKeys(" عبده");
		Submit_Button.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
        
		Add_Another_Player=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[3]/a"));
        wait2.until(ExpectedConditions.visibilityOf(Add_Another_Player));
		Add_Another_Player.click();
		*/
		fillData();
		
		
		
		
		
		
		
		
		/*String filePath = "D:\\Automation Testing\\Establishment_Evaluation\\";

	    //Call read file method of the class to read data

	//    readExcel(filePath,"TestData_EstablishmentEval.xlsx","Test_Data");
	    
	    
	    
	    WebElement Natioanl_ID_field=driver.findElement(By.xpath("//*[@id='pt1:r1:0:s1:it1::content']"));
	    WebElement Verify_Button=driver.findElement(By.xpath("//*[@id='pt1:r1:0:s1:cb3']"));
	    Natioanl_ID_field.sendKeys(National_ID);
	    Verify_Button.click();
	   
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    */
	}
	
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}



	/*@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			setUp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			testCal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	*/
}