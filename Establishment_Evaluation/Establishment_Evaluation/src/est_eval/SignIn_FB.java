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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
//Excel Sheel Jars
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class SignIn_FB {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	WebElement Name_field;
	WebElement Email_field;
	WebElement Address_field;
	WebElement Birthday_Field;
	WebElement Comments_field;
	WebElement Sign_In_first;
	
	
	String appURL = "https://docs.google.com/forms/d/e/1FAIpQLScUb9unSiZeWG89cewY36XhiwrbXje71x0fC2ZPYxXrB8JQuA/viewform";
	
	 
	//Locators
	
	
	@BeforeClass
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//Establishment_Evaluation//chromedriver.exe");
		driver=new ChromeDriver();
	//	driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 11);
		
		
	}
	

	@Test(dataProvider="empLogin")
	public void VerifyInvalidLogin(String Name, String Email, String Address, String Birthday, String Comments) {
		driver.navigate().to(appURL);
		By bySign=By.xpath("/html/body/div/div[2]/div/div/div[2]/div/content/span/div/span");
		driver.findElement(bySign).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By EmailSign=By.xpath("//*[@id='Email']");
		
		driver.findElement(EmailSign).sendKeys("sedky.cs@gmail.com");
		By Next=By.xpath("//*[@id='next']");
		driver.findElement(Next).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement signinbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signIn")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Password=wait.until(ExpectedConditions.elementToBeClickable(By.id("Passwd")));
		Password.sendKeys("Testingxyz78901");
		//By PasswordSign=By.xpath("//*[@id='Passwd']");
		//driver.findElement(PasswordSign).clear();
		//By PasswordSign=By.xpath("//*[@id='signIn']");
		//driver.findElement(PasswordSign).sendKeys("Testingxyz78901");
		signinbutton.click();
		
		
		
		By byName = By.xpath("//*[@id='mG61Hd']/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/input");
		 By byEmail = By.xpath("//*[@id='mG61Hd']/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div[1]/input");
		 By byAddress = By.xpath("//*[@id='mG61Hd']/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/textarea");
		 By byBirthday = By.xpath("//*[@id='mG61Hd']/div/div[2]/div[2]/div[4]/div[2]/div/div[2]/div[1]/div/div[1]/input");
		 By byComments = By.xpath("//*[@id='mG61Hd']/div/div[2]/div[2]/div[5]/div[2]/div[1]/div[2]/textarea");
		 By bySubmit = By.xpath("//*[@id='mG61Hd']/div/div[2]/div[3]/div[1]/div/div/content");
		 
		
		
		driver.findElement(byName).sendKeys(Name);
		driver.findElement(byEmail).sendKeys(Email);
		driver.findElement(byAddress).sendKeys(Address);
		driver.findElement(byBirthday).sendKeys(Birthday);
		driver.findElement(byComments).sendKeys(Comments);
		//wait for element to be visible and perform click
		wait.until(ExpectedConditions.visibilityOfElementLocated(bySubmit));
		driver.findElement(bySubmit).click();
		
		
		
	}
	
	@DataProvider(name="empLogin")
	public Object[][] loginData() throws BiffException {
		Object[][] arrayObject = getExcelData("D://Automation Testing//Establishment_Evaluation//Contact_Form_Data.xls","Sheet1");
		return arrayObject;
	}

	/**
	 * @param File Name
	 * @param Sheet Name
	 * @return
	 * @throws BiffException 
	 */
	public String[][] getExcelData(String fileName, String sheetName) throws BiffException {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		} 
		return arrayExcelData;
	}

	@Test
	public void tearDown() {
		//driver.quit();
	}

}
