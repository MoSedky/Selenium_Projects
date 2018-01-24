package pfs_System;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Module {
	WebElement contractor_radio_btn;
	WebElement employee_radio_btn;
	WebElement username_txt;
	WebElement password_txt;
	WebElement login_btn;
	WebElement forget_password;
	WebElement create_New_User;
	static WebDriver driver;
	Data_Layer d=new Data_Layer();
	String [] credentials;
	WebElement main_menu;
	WebDriverWait wait;
	int employee_type=1;
	
	
	
	@BeforeClass
	public WebDriver setUp() throws MalformedURLException, AWTException, ClassNotFoundException, SQLException{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\Chrome Driver Selenium\\chromedriver.exe");
        driver = new ChromeDriver();              
        driver.get("http://fusionapps-dev:7003/PFS/faces/PFSLoginPage.jspx?_adf.ctrl-state=u959nof62_3");
        return driver;
       
	}
	
	public void initiate_elements()
	{
		 wait = new WebDriverWait(driver, 30);
		
		contractor_radio_btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sor1:_1']")));
		employee_radio_btn=driver.findElement(By.xpath("//*[@id='sor1:_0']"));
		
		username_txt=driver.findElement(By.xpath("//*[@id='it1::content']"));
		password_txt=driver.findElement(By.xpath("//*[@id='it2::content']"));
		
		login_btn=driver.findElement(By.xpath("//*[@id='cb1']"));
		
		forget_password=driver.findElement(By.xpath("//*[@id='linkfrgt']"));
		create_New_User=driver.findElement(By.xpath("//*[@id='linkNew']"));
	}
	
	public void tst_contract_login() throws ClassNotFoundException, SQLException
	{
		credentials=d.connect();
		contractor_radio_btn.click();
		username_txt.sendKeys(String.valueOf(credentials[0]));
		password_txt.sendKeys(String.valueOf(credentials[1]));
		login_btn.click();
		try
		{
			main_menu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:HomeMenuItem']")));
			System.out.println("Login Module passed successfully");
			
		}catch(Exception c)
		{
			
			System.out.println("System have an issue in Login Module");
		}
		
	}
	
	public void tst_employee_login() throws ClassNotFoundException, SQLException
	{
		credentials=d.connect();
		employee_radio_btn.click();
		username_txt.sendKeys(String.valueOf(credentials[0]));
		password_txt.sendKeys(String.valueOf(credentials[1]));
		login_btn.click();
		try
		{
			main_menu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:HomeMenuItem']")));
			System.out.println("Login Module passed successfully");
			
		}catch(Exception c)
		{
			
			System.out.println("System have an issue in Login Module");
		}
		
	}
	
	
	@Test
	public void testCal() throws Exception {
		
		try
		{
			initiate_elements();
		}
		
		catch(Exception c)
		{
			System.out.println(c.getMessage());
		//	initiate_elements();
		}
		
		if(employee_type==1)
		{
			tst_contract_login();
		}
		else
		{
			tst_employee_login();
		}
		
		
	}
	
	public WebDriver pass_driver() throws MalformedURLException, ClassNotFoundException, AWTException, SQLException
	{
		
		return driver;
		
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}

}
