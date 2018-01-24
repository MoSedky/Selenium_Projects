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


public class Compare_IsIc {
	WebDriver driver;
	String Username;
	String Password;
	String LaborOffice;
	String SequenceNumber;
	String MunicipalityId;
	String SubMunicipalityId;
	
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and Identify ChromeDriver
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//Establishment_Evaluation//chromedriver.exe");
         driver = new ChromeDriver();              
        
        
	}
	
	
	
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

	    //Create a object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook TestData = null;

	    //Find the file extension by spliting file name in substring and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    	TestData = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class

	    	TestData = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet guru99Sheet = TestData.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	  /*  for (int i = 1; i < rowCount+1; i++) {

	        Row row = guru99Sheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 1; j < row.getLastCellNum(); j++) {

	            //Print excel data in console
	        	
	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	            Username=row.getCell(j).getStringCellValue();
	        }

	        System.out.println();

	    }*/
	    
	    Row row = guru99Sheet.getRow(1);
	    DataFormatter formatter = new DataFormatter();
	    Username=formatter.formatCellValue(row.getCell(0));
	    	//	row.getCell(1).getStringCellValue();
	    Password=formatter.formatCellValue(row.getCell(1));
	    		//row.getCell(2).getStringCellValue();
	    MunicipalityId=formatter.formatCellValue(row.getCell(2));
	    		//row.getCell(3).getStringCellValue();
	    SubMunicipalityId=formatter.formatCellValue(row.getCell(3));
	    		//row.getCell(4).getStringCellValue();
	    
	    System.out.println("Username= "+Username+"Password="+Password+"LaborOffice="+MunicipalityId+"SequenceNumber="+SubMunicipalityId);

	}
	
	
	@Test
	public void testCal() throws Exception {
		
		

	    String filePath = "D:\\Automation Testing\\Establishment_Evaluation\\";

	    //Call read file method of the class to read data

	    readExcel(filePath,"TestData_EstablishmentEval.xlsx","Test_Data");
	    driver.get("http://baladyapps.momra.gov.sa/Eservices/Pages/VocationalLicense/InstantPermit/CreateRequest.aspx?MunicipalityId="+MunicipalityId+"&"+"SubMunicipalityId="+SubMunicipalityId+"#");//http://192.168.209.55:3334/
        driver.manage().window().maximize();
        Robot r = new Robot();
        WebElement Verification_Code=driver.findElement(By.xpath("/html/body/div[2]"));
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
