package area_decision;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Area_get {
	WebDriver driver ; 
	WebElement ID_text;
	WebElement verify_button;
	WebElement Next_button;
	Select Is_Mobatra;
	Select Is_more_than_five;
	Select has_neighbours;
	WebElement Next_two;
	WebElement Cancel;
	WebElement agree_button_msg;
	Select Muncipility;
	WebElement Province;
	WebElement Mokhtat;
	WebElement Land_no;
	WebElement Sak_no;
	WebElement Sak_Date;
	WebElement Land_area;
	WebElement Next_three;
	Select attachments_types;
	WebElement upload_image_file;
	WebElement upload_button;
	WebElement Next_four;
	WebElement Next_last;
	WebElement request_field_number;
	String request_number;
	WebDriverWait wait;
	Robot r;
	JavascriptExecutor jse;
	@BeforeClass
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\Chrome Driver Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://10.180.140.19:7012/Area/faces/ShowAreaAccept?_adf.ctrl-state=1czv15ra18_3");
	}
	
	@Test
	public void testCal() throws Exception {
		 wait = new WebDriverWait(driver, 11);
		 r = new Robot();
		 jse = (JavascriptExecutor)driver;
		
		
		 cases();
		
		
	}
	
	public void cases()
	{
		try
		{
			Random rand = new Random();
			int  n = rand.nextInt(5000-1) + 1;
			
		ID_text=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:0:s1:it1::content']")));
		ID_text.sendKeys("2402616946");
		
		verify_button=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:0:s1:cb3']")));
		verify_button.click();
		
		Next_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'التالي')]")));
		Next_button.click();
		
		Is_Mobatra=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:soc_mobtra::content']"))));
		Is_Mobatra.selectByIndex(0);
		
		Is_more_than_five=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:soc_size::content']"))));
		Is_more_than_five.selectByIndex(1);
		
		has_neighbours=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:soc_besides::content']"))));
		has_neighbours.selectByIndex(1);
		
		Next_two=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'التالي')]")));
		Next_two.click();
		
		Muncipility=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:soc2::content']"))));
		Muncipility.selectByValue("100");
		
		driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
		
		Province=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='pt1:r1:2:soc_dist::content']/option[2]")));
		Province.click();
		//driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		//Province.sendKeys("ا");
		//r.keyPress(KeyEvent.VK_DOWN);
		//r.keyPress(KeyEvent.VK_DOWN);
		//r.keyRelease(KeyEvent.VK_DOWN);
		//r.keyPress(KeyEvent.VK_ENTER);
		//r.keyRelease(KeyEvent.VK_ENTER);
		
		
		Mokhtat=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:2:it5::content']")));
		
		Mokhtat.sendKeys(String.valueOf(n));
		
		Land_no=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:2:it_land::content']")));
		
		Land_no.sendKeys(String.valueOf(n));
		
		Sak_no=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:2:it7::content']")));
		
		Sak_no.sendKeys(String.valueOf(n));
		
		Sak_Date=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:2:it8HijriCAL::content']")));
		Sak_Date.click();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Land_area=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:2:it11::content']")));
		Land_area.sendKeys("2500");
		
		Next_three=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'التالي')]")));
		Next_three.click();
		
		attachments_types=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:3:soc1::content']"))));
		attachments_types.selectByVisibleText("صورة الهوية");
		
		upload_image_file=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type,'file')]")));
		upload_image_file.sendKeys("C:\\Users\\msedky\\Desktop\\3.jpg");
		
		upload_button=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:3:cb3']")));
		upload_button.click();
		
		attachments_types.selectByVisibleText("صورة الصك");
		upload_image_file=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type,'file')]")));
		upload_image_file.sendKeys("C:\\Users\\msedky\\Desktop\\3.jpg");
		upload_button.click();
		
		attachments_types.selectByVisibleText("صورة الوكالة");
		upload_image_file=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type,'file')]")));
		upload_image_file.sendKeys("C:\\Users\\msedky\\Desktop\\3.jpg");
		upload_button.click();
		
		attachments_types.selectByVisibleText("المخطط");
		upload_image_file=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type,'file')]")));
		upload_image_file.sendKeys("C:\\Users\\msedky\\Desktop\\22 .dxf");
		upload_button.click();
		
		attachments_types.selectByVisibleText("صورة الرفع المساحي");
		upload_image_file=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type,'file')]")));
		upload_image_file.sendKeys("C:\\Users\\msedky\\Desktop\\3.jpg");
		upload_button.click();
		
		attachments_types.selectByVisibleText("الرفع المساحي (ملف تصميم )");
		upload_image_file=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type,'file')]")));
		upload_image_file.sendKeys("C:\\Users\\msedky\\Desktop\\22 .dxf");
		upload_button.click();
		
		jse.executeScript("window.scrollBy(0,250)", "");
		
		Next_four=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'التالي')]")));
		Next_four.click();
		jse.executeScript("window.scrollBy(0,250)", "");
		
		Next_last=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:4:cb2']")));
		Next_last.click();
		
		request_field_number=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:5:ot5']")));
		if(request_field_number.isDisplayed())
		{
			request_number=request_field_number.getText();
			System.out.println("Decision Area created with ID: "+request_number);
		}
		else
		{
			System.out.println("Request not created properly ");
		}
		}catch (Exception c)
		{
			//cases();
			System.out.println(c.getMessage()+"An Exception occurs");
		}
	}
	
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}
	

}
