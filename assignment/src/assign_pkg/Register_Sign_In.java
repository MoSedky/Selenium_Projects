package assign_pkg;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register_Sign_In {
	
	WebDriver driver ; 
	WebDriverWait wait;
	WebElement My_Account;
	WebElement Sign_Up;
	WebElement First_Name;
	Actions actions;
	Robot robot;
	
	@BeforeClass
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\Chrome Driver Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/en");
         actions = new Actions(driver);
         robot = new Robot();
        
	}
	
	@Test
	public void testCal() throws Exception {
		m();
		reg();
		
		
	}
	
	public void m()
	{
		try
		{
			
		
		wait = new WebDriverWait(driver, 20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		My_Account=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'col-md-6 col-sm-8 col-xs-5 go-left')]/ul/li[contains(@id,'li_myaccount')]/a")));
		
		jse.executeScript("arguments[0].scrollIntoView()", My_Account);
		//actions.moveToElement(My_Account).click().perform();
		My_Account.click();
		//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		
		Sign_Up=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-md-6 col-sm-8 col-xs-5 go-left')]/ul/li[contains(@id,'li_myaccount')]/ul/li/a[contains(@href,'https://www.phptravels.net/register')]")));
		Sign_Up.click();
		}
		catch(Exception c)
		{
			m();
		}
	}
	
	public void reg()
	{
		First_Name=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='headersignupform']/div[3]/input")));
		First_Name.sendKeys("test");
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}

}
