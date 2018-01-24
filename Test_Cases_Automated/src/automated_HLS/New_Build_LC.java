package automated_HLS;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class New_Build_LC {
	
	WebDriver driver;
	//Access_Excel c=new Access_Excel();
	WebElement username;
	WebElement password;
	WebElement sign_In_button;
	WebElement Balady_Requests;
	WebElement tasweer_License;
	WebElement update_Requests;
	String [] values;
	WebElement balady_one_req_ID;
	WebElement Apply_new_LC;
	WebElement transfer_LIC_Req;
	String Baladyia_value;
	Data_Layer d;
	
	@BeforeClass
	public void setUp() throws Exception{
		
		//Set up desired capabilities and Identify ChromeDriver
		//Create Request from Balady 1.0
        //create_Voc_request cr=new create_Voc_request();
	//	cr.setUp();
		//values=cr.testCal();
		 Baladyia_value= JOptionPane.showInputDialog("Please insert Baladyia Number from these values 1,2,8,9,13");
		d=new Data_Layer();
		values=d.Eng_Office(Integer.parseInt(Baladyia_value));
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\Chrome Driver Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://10.180.140.19:7012/EnOffice/faces/Enlogin?_adf.ctrl-state=lgkte47q7_3");
		
        
	}
	
	@Test
	public void testCal() throws Exception {
		if(d.Eng_Office(Integer.parseInt(Baladyia_value)) == null)
		{
			
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "No Eng_Off exists in this Baladyia");
			driver.quit();
			
		}
		else
		{
			
		
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		
		Robot r=new Robot();

		
		//-------------Login Page--------------------
		
		username=driver.findElement(By.xpath("//*[@id='it1::content']"));
		
		username.sendKeys(String.valueOf(values[0]));
			
		password=driver.findElement(By.xpath("//*[@id='it2::content']"));
	    
		password.clear();
		password.sendKeys("");
		password.sendKeys(String.valueOf(values[1]));
		
		sign_In_button=driver.findElement(By.xpath("//*[@id='cb1']"));
		//wait.until(ExpectedConditions.textToBePresentInElement(password, "123"));
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		sign_In_button.click();
		
		//-------------Open Balady Requests-------------------
		
		Apply_new_LC=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:cl72']")));
		Apply_new_LC.click();
		
		try
		{
		
		transfer_LIC_Req=driver.findElement(By.xpath("//button/span[contains(text(), 'نقل ملكية رخصة بناء')]"));
		System.out.println("Exists");
		transfer_LIC_Req.click();
		
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Transfer Ownership Request Exists");
		
		
		} catch(Exception c)
		{
			c.getMessage();
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Transfer Ownership Request NOT Exists");
			System.out.println("Not Exists");
		}
		
		/*
		Balady_Requests=driver.findElement(By.xpath("//*[@id='pt1:cl22']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(Balady_Requests)).click();
		
		update_Requests=driver.findElement(By.xpath("//*[@id='ppt1:r1:0:pc1:ctb1']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(update_Requests)).click();
		
		balady_one_req_ID=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ppt1:r1:0:pc1:t2:_afrFltrc1::content']")));
		
		Thread.sleep(50000);
		balady_one_req_ID.sendKeys(values[1]);
		
		r.keyPress(KeyEvent.VK_ENTER);
		
		*/
		//r.keyRelease(KeyEvent.VK_ENTER);
	}
	}

}
