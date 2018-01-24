package Selenium_Package;
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


public class Login_Page {
	WebDriver driver;
	String Area;
	String Municipilty;
	String Requestor;
	
	
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
	/*	Set up desired capabilities and Identify ChromeDriver
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//Establishment_Evaluation//chromedriver.exe");
         driver = new ChromeDriver();              
        driver.get("http://10.1.2.193:7011/Area/faces/ShowAreaAccept");
       
        driver.manage().window().maximize();
        driver.navigate().refresh();
    */    
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
	    
	    Row row = guru99Sheet.getRow(1);
	    DataFormatter formatter = new DataFormatter();
	    Area=formatter.formatCellValue(row.getCell(0));
	    	//	row.getCell(1).getStringCellValue();
	    Municipilty=formatter.formatCellValue(row.getCell(1));
	    		//row.getCell(2).getStringCellValue();
	    Requestor=formatter.formatCellValue(row.getCell(2));
	    		//row.getCell(3).getStringCellValue();
	   
	    
	    System.out.println("Username= "+Area+"Password="+Municipilty+"LaborOffice="+Requestor);
	    
	    
	    

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
	    
	    

	}
	
	
	@Test
	public void testCal() throws Exception {
		
		

	   /* String filePath = "D:\\Automation Testing\\Establishment_Evaluation\\";

	    //Call read file method of the class to read data

	    readExcel(filePath,"TestData_EstablishmentEval.xlsx","Test_Data");
	    
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
}
