package automated_HLS;
import java.awt.AWTException;
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
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Environment;
//Excel Sheel Jars

public class Create_Request {
	
	WebDriver driver;
	//Access_Excel c=new Access_Excel();
	WebElement username;
	WebElement password;
	WebElement sign_In_button;
	WebElement apply_License;
	WebElement tasweer_License;
	WebElement national_ID;
	WebElement check_ID;
	Select building_Type;
	WebElement next_One;
	Select municipility;
	WebElement province;
	WebElement plan_No;
	WebElement land_No;
	WebElement plan_txt;
	WebElement land_txt;
	WebElement next_two;
	WebElement decision_number;
	WebElement decision_date;
	WebElement sak_ownership;
	WebElement sak_Date;
	WebElement sak_Source;
	WebElement Northes;
	WebElement easten;
	WebElement land_Area;
	WebElement north_one;
	WebElement north_two;
	WebElement north_three;
	WebElement north_four;
	WebElement east_one;
	WebElement east_two;
	WebElement east_three;
	WebElement east_four;
	WebElement south_one;
	WebElement south_two;
	WebElement south_three;
	WebElement south_four;
	WebElement west_one;
	WebElement west_two;
	WebElement west_three;
	WebElement west_four;
	WebElement wall_Height;
	WebElement no_Of_Elements;
	Select usage;
	WebElement Area;
	WebElement next_three;
	WebElement img_Decision;
	WebElement img_Sak;
	WebElement img_ID;
	WebElement img_Google;
	WebElement img_Site;
	WebElement img_Keroky;
	WebElement img_Decision_att_btn;
	WebElement img_Sak_att_btn;
	WebElement img_ID_att_btn;
	WebElement img_Google_att_btn;
	WebElement img_Site_att_btn;
	WebElement img_Keroky_att_btn;
	WebElement request_No;
	int Northes_value;
	int easten_value;
	int North_value;
	int east_value;
	int south_value;
	int west_value;
	int Land_area_value;
	String [] area_values;
	
	




	
	
	@BeforeClass
	public void setUp() throws Exception{
		
		//Set up desired capabilities and Identify ChromeDriver
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\Chrome Driver Selenium\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("http://10.180.140.19:7012/EnOffice/faces/Enlogin?_adf.ctrl-state=lgkte47q7_3");
       
	}
	
	
	@Test
	public void testCal() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			
		
			int selected_scenario=Integer.parseInt(JOptionPane.showInputDialog("Please insert (1) for test new License scenario OR (0) for old License scenario"));
			if(selected_scenario==1)
			{
				new_license();
			}
			else
			{
				old_license();
			}
			
			  	 
			  
			  
	    
	}
	
	public void old_license() throws AWTException, ClassNotFoundException, SQLException
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		Robot r=new Robot();
		Data_Layer D=new Data_Layer();
		String Area_value= JOptionPane.showInputDialog("Please insert License Number value");
		area_values=D.connect(Area_value);
		//-------------Login Page--------------------
		
		username=driver.findElement(By.xpath("//*[@id='it1::content']"));
		
		username.sendKeys("alshabil");
			
		password=driver.findElement(By.xpath("//*[@id='it2::content']"));
	    
		password.clear();
		password.sendKeys("");
		password.sendKeys("123");
		
		sign_In_button=driver.findElement(By.xpath("//*[@id='cb1']"));
		//wait.until(ExpectedConditions.textToBePresentInElement(password, "123"));
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		sign_In_button.click();
		
		//-------------Apply License-------------------
		
		apply_License=driver.findElement(By.xpath("//*[@id='pt1:cl72']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(apply_License)).click();
		
		tasweer_License=driver.findElement(By.xpath("//*[@id='pt1:r1:0:cb7']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(tasweer_License)).click();
		
		WebElement Lic_Number=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:it1::content']")));
		
		Lic_Number.sendKeys(Area_value);
		
		WebElement Check_License=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:cb3']")));
		Check_License.click();
		
		WebElement get_Area_D_No=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:cb3']")));
		WebElement get_Northes_No=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:cb3']")));
		WebElement get_Easts_No=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:cb3']")));
		WebElement get_North_No=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:cb3']")));
		WebElement get_East_No=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:cb3']")));
		WebElement get_West_No=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:cb3']")));
		WebElement get_south_No=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:cb3']")));
		
		
		building_Type= new Select(driver.findElement(By.xpath("//*[@id='pt1:r1:1:soc1::content']")));
		//wait.until(ExpectedConditions.visibilityOf((WebElement) building_Type));
		building_Type.selectByIndex(1);//Sakny
		
		national_ID=driver.findElement(By.xpath("//*[@id='pt1:r1:1:it14::content']"));
		
		wait.until(ExpectedConditions.visibilityOf(national_ID)).sendKeys("2402616946");
		
		check_ID=driver.findElement(By.xpath("//*[@id='pt1:r1:1:cb2']"));
		check_ID.click();
		
		
		
		
		
		//-------------First Page -----------------------------
		municipility=new Select (driver.findElement(By.xpath("//*[@id='pt1:r1:2:soc2::content']")));
		municipility.selectByIndex(1);//North Area

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement province_web=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='pt1:r1:2:soc1::content']/option[2]")));
		//select[@id='pt1:r1:2:soc1::content']/option[text()='Item x']
		province_web.click();//selectByIndex(5);//North Area
		//pt1:r1:2:soc_map::content
		plan_No=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='pt1:r1:2:soc_map::content']/option[1]")));
		plan_No.click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		plan_txt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:it1::content']")));
		plan_txt.sendKeys("test");
		//
		land_No=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='pt1:r1:2:soc_land::content']/option[1]")));
		land_No.click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		land_txt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:it2::content']")));
		land_txt.sendKeys("test");
		
		next_two=driver.findElement(By.xpath("//*[@id='pt1:r1:2:cb4']"));
		next_two.click();
		
		//------------------------Identify Page 2 Elements------------
		
		 decision_number=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it1::content']"));
		 decision_number.sendKeys(Area_value);
		 decision_date=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it24HijriCAL::content']"));
		 decision_date.sendKeys(Keys.ENTER);
		 sak_ownership=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it5::content']"));
		 sak_ownership.sendKeys("5899");
		 sak_Date=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it2HijriCAL::content']"));
		 sak_Date.sendKeys(Keys.ENTER);
		 sak_Source=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it6::content']"));
		 sak_Source.sendKeys("Riyadh");
		 Northes=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it4::content']"));
		
		 easten=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it8::content']"));
		
		 land_Area=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:3:it7::content']")));
		 
		 
		// land_Area.clear();
		// land_Area.sendKeys("8002");
		 
		 north_one=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it9::content']"));
		 
		 
		 north_two=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it12::content']"));
		 north_two.sendKeys("450");
		 
		 north_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it3::content']"));
		 north_three.sendKeys("450");
		 
		 north_four=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it10::content']"));
		 north_four.sendKeys("450");
		 
		 east_one=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it13::content']"));
		
		 east_two=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it11::content']"));
		 east_two.sendKeys("450");
		 
		 east_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it25::content']"));
		 east_three.sendKeys("450");
		 
		 east_four=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it16::content']"));
		 east_four.sendKeys("450");
		 
		 south_one=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it15::content']"));
		
		 south_two=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it14::content']"));
		 south_two.sendKeys("450");
		 
		 south_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it26::content']"));
		 south_three.sendKeys("450");
		 
		 south_four=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it17::content']"));
		 south_four.sendKeys("450");
		 
		 west_one=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it19::content']"));
		
		 west_two=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it18::content']"));
		 west_two.sendKeys("450");
		 
		 west_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it27::content']"));
		 west_three.sendKeys("450");
		 
		 west_four=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it20::content']"));
		 west_four.sendKeys("450");
		 
		 wall_Height=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it21::content']"));
		 wall_Height.sendKeys("450");
		 
		 no_Of_Elements=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it22::content']"));
		 no_Of_Elements.sendKeys("33");
		 
		 usage=new Select (driver.findElement(By.xpath("//*[@id='pt1:r1:3:soc1::content']")));
		 usage.selectByIndex(1);
		 Area=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it23::content']"));
		 Area.sendKeys("20");
		 //-----------------------Get Area decision values-----------------------
		 if(Northes.equals("")||easten.equals("")||north_one.equals("")||east_one.equals("")||south_one.equals("")||west_one.equals("")||land_Area.equals(""))
		 {
			 System.out.println("Empty String returns");
		 }
		 else
		 {
			 Northes_value=(int) Float.parseFloat(Northes.getAttribute("value"));
			 easten_value=(int) Float.parseFloat(easten.getAttribute("value"));
			 
			 North_value=(int) Float.parseFloat(north_one.getAttribute("value"));
			 east_value=(int) Float.parseFloat(east_one.getAttribute("value"));
			 south_value=(int) Float.parseFloat(south_one.getAttribute("value"));
			 west_value=(int) Float.parseFloat(west_one.getAttribute("value"));
			 Land_area_value=(int) Float.parseFloat(land_Area.getAttribute("value"));
			 /*
			 	area_values[0]=Project_Data.getString(1);//Area Decision ID
				area_values[1]=Project_Data.getString(2);//Land Area
				area_values[2]=Project_Data.getString(3);//El Shamalyiat (Northes)
				area_values[3]=Project_Data.getString(4);//El Sharkyiat (Easts)
				area_values[4]=Project_Data.getString(5);//North
				area_values[5]=Project_Data.getString(6);//EAST
				area_values[6]=Project_Data.getString(7);//WEST
				area_values[7]=Project_Data.getString(8);//South
			 */
			 
			 System.out.println("Northes="+Northes_value+'\n'+"Easts="+easten_value);
			 
			 System.out.println("North="+North_value+'\n'+"East="+east_value+'\n'+"South="+south_value+'\n'+"West="+west_value);
		  }
		
		 
		 
		  //------------------Assert all values --------------------------------------//
		 try
		  {
			 if(area_values[0].equals(null)||area_values[1].equals(null)||area_values[2].equals(null)||area_values[3].equals(null)||area_values[4].equals(null)||area_values[5].equals(null)||area_values[6].equals(null)||area_values[7].equals(null))
			 {
				 System.out.println("Some results are with null values");
			 }
			 else
			 {
		  
	     Assert.assertEquals(area_values[0],Area_value ,"Area Decision ID exists in DB ");
		 Assert.assertEquals(area_values[2],String.valueOf(Northes_value) ,"Northes in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[3],String.valueOf(easten_value) ,"Eastes in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[4],String.valueOf(North_value) ,"North in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[5],String.valueOf(east_value) ,"East in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[6],String.valueOf(west_value) ,"West in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[7],String.valueOf(south_value) ,"South in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[1],String.valueOf(Land_area_value) ,"Land Area in DB doesn't match displayed value  ");
		 
		/* 
		 next_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:cb2']"));
		 next_three.click();

		//------------------------Identify Attachments Page Elements------------
		String filepath=Reader.extract("Autocad_upload_again.png");
		 
		  img_Decision=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if2::content']"));
	      img_Decision.sendKeys(filepath);  
		  img_Decision_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb7']"));
		  img_Decision_att_btn.click();
		  
	      img_Sak=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if3::content']"));
	      img_Sak.sendKeys(filepath);
	      img_Sak_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb6']"));
		  img_Sak_att_btn.click();
		  
		  img_ID=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if6::content']"));
		  img_ID.sendKeys(filepath);
		  img_ID_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb11']"));
		  img_ID_att_btn.click();
		  
		  img_Google=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if8::content']"));
		  img_Google.sendKeys(filepath);
		  img_Google_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb13']"));
		  img_Google_att_btn.click();
		  
		  img_Site=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if9::content']"));
		  img_Site.sendKeys(filepath);
		  img_Site_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb14']"));
		  img_Site_att_btn.click();
		  
		  img_Keroky=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if31::content']"));
		  img_Keroky.sendKeys(filepath);
		  img_Keroky_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb39']"));
		  img_Keroky_att_btn.click();
		  
		  next_three=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb5']"));
		  next_three.click();
		  
		  request_No=driver.findElement(By.xpath("//*[@id='pt1:r1:5:pgl1']/div[2]/span"));
		  System.out.println(request_No.getText());
		  
		  */
		  
			 }
				 
		  }catch (Exception error)
		  {
			  System.out.println("Not all values matches");
			  String results_failed=error.getMessage();
			  String[] first_line=results_failed.split("\r\n|\r|\n", 2);
			 // System.out.println(results_failed);
			  JFrame frame=new JFrame("Results");
			  JOptionPane.showMessageDialog(frame, first_line[0]);
		  }
	}
	
	public void new_license() throws AWTException, ClassNotFoundException, SQLException
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		Robot r=new Robot();
		Data_Layer D=new Data_Layer();
		String Area_value= JOptionPane.showInputDialog("Please insert Area Decision value");
		area_values=D.project_data(Area_value);
		//-------------Login Page--------------------
		
		username=driver.findElement(By.xpath("//*[@id='it1::content']"));
		
		username.sendKeys("alshabil");
			
		password=driver.findElement(By.xpath("//*[@id='it2::content']"));
	    
		password.clear();
		password.sendKeys("");
		password.sendKeys("123");
		
		sign_In_button=driver.findElement(By.xpath("//*[@id='cb1']"));
		//wait.until(ExpectedConditions.textToBePresentInElement(password, "123"));
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		sign_In_button.click();
		
		//-------------Apply License-------------------
		
		apply_License=driver.findElement(By.xpath("//*[@id='pt1:cl72']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(apply_License)).click();
		
		tasweer_License=driver.findElement(By.xpath("//*[@id='pt1:r1:0:cb3']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(tasweer_License)).click();
		
		building_Type= new Select(driver.findElement(By.xpath("//*[@id='pt1:r1:1:soc1::content']")));
		//wait.until(ExpectedConditions.visibilityOf((WebElement) building_Type));
		building_Type.selectByIndex(1);//Sakny
		
		national_ID=driver.findElement(By.xpath("//*[@id='pt1:r1:1:it14::content']"));
		
		wait.until(ExpectedConditions.visibilityOf(national_ID)).sendKeys("2402616946");
		
		check_ID=driver.findElement(By.xpath("//*[@id='pt1:r1:1:cb2']"));
		check_ID.click();
		
		
		
		next_One=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:cb1']")));
		//driver.findElement(By.xpath("//*[@id='pt1:r1:1:cb1']"));
		
		
		//wait.until(ExpectedConditions.stalenessOf(next_One));
		next_One.click();
		
		//-------------First Page -----------------------------
		municipility=new Select (driver.findElement(By.xpath("//*[@id='pt1:r1:2:soc2::content']")));
		municipility.selectByIndex(1);//North Area

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement province_web=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='pt1:r1:2:soc1::content']/option[2]")));
		//select[@id='pt1:r1:2:soc1::content']/option[text()='Item x']
		province_web.click();//selectByIndex(5);//North Area
		//pt1:r1:2:soc_map::content
		plan_No=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='pt1:r1:2:soc_map::content']/option[1]")));
		plan_No.click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		plan_txt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:it1::content']")));
		plan_txt.sendKeys("test");
		//
		land_No=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='pt1:r1:2:soc_land::content']/option[1]")));
		land_No.click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		land_txt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:it2::content']")));
		land_txt.sendKeys("test");
		
		next_two=driver.findElement(By.xpath("//*[@id='pt1:r1:2:cb4']"));
		next_two.click();
		
		//------------------------Identify Page 2 Elements------------
		
		 decision_number=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it1::content']"));
		 decision_number.sendKeys(Area_value);
		 decision_date=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it24HijriCAL::content']"));
		 decision_date.sendKeys(Keys.ENTER);
		 sak_ownership=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it5::content']"));
		 sak_ownership.sendKeys("5899");
		 sak_Date=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it2HijriCAL::content']"));
		 sak_Date.sendKeys(Keys.ENTER);
		 sak_Source=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it6::content']"));
		 sak_Source.sendKeys("Riyadh");
		 Northes=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it4::content']"));
		
		 easten=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it8::content']"));
		
		 land_Area=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:3:it7::content']")));
		 
		 
		// land_Area.clear();
		// land_Area.sendKeys("8002");
		 
		 north_one=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it9::content']"));
		 
		 
		 north_two=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it12::content']"));
		 north_two.sendKeys("450");
		 
		 north_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it3::content']"));
		 north_three.sendKeys("450");
		 
		 north_four=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it10::content']"));
		 north_four.sendKeys("450");
		 
		 east_one=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it13::content']"));
		
		 east_two=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it11::content']"));
		 east_two.sendKeys("450");
		 
		 east_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it25::content']"));
		 east_three.sendKeys("450");
		 
		 east_four=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it16::content']"));
		 east_four.sendKeys("450");
		 
		 south_one=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it15::content']"));
		
		 south_two=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it14::content']"));
		 south_two.sendKeys("450");
		 
		 south_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it26::content']"));
		 south_three.sendKeys("450");
		 
		 south_four=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it17::content']"));
		 south_four.sendKeys("450");
		 
		 west_one=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it19::content']"));
		
		 west_two=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it18::content']"));
		 west_two.sendKeys("450");
		 
		 west_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it27::content']"));
		 west_three.sendKeys("450");
		 
		 west_four=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it20::content']"));
		 west_four.sendKeys("450");
		 
		 wall_Height=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it21::content']"));
		 wall_Height.sendKeys("450");
		 
		 no_Of_Elements=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it22::content']"));
		 no_Of_Elements.sendKeys("33");
		 
		 usage=new Select (driver.findElement(By.xpath("//*[@id='pt1:r1:3:soc1::content']")));
		 usage.selectByIndex(1);
		 Area=driver.findElement(By.xpath("//*[@id='pt1:r1:3:it23::content']"));
		 Area.sendKeys("20");
		 //-----------------------Get Area decision values-----------------------
		 if(Northes.equals("")||easten.equals("")||north_one.equals("")||east_one.equals("")||south_one.equals("")||west_one.equals("")||land_Area.equals(""))
		 {
			 System.out.println("Empty String returns");
		 }
		 else
		 {
			 Northes_value=(int) Float.parseFloat(Northes.getAttribute("value"));
			 easten_value=(int) Float.parseFloat(easten.getAttribute("value"));
			 
			 North_value=(int) Float.parseFloat(north_one.getAttribute("value"));
			 east_value=(int) Float.parseFloat(east_one.getAttribute("value"));
			 south_value=(int) Float.parseFloat(south_one.getAttribute("value"));
			 west_value=(int) Float.parseFloat(west_one.getAttribute("value"));
			 Land_area_value=(int) Float.parseFloat(land_Area.getAttribute("value"));
			 /*
			 	area_values[0]=Project_Data.getString(1);//Area Decision ID
				area_values[1]=Project_Data.getString(2);//Land Area
				area_values[2]=Project_Data.getString(3);//El Shamalyiat (Northes)
				area_values[3]=Project_Data.getString(4);//El Sharkyiat (Easts)
				area_values[4]=Project_Data.getString(5);//North
				area_values[5]=Project_Data.getString(6);//EAST
				area_values[6]=Project_Data.getString(7);//WEST
				area_values[7]=Project_Data.getString(8);//South
			 */
			 
			 System.out.println("Northes="+Northes_value+'\n'+"Easts="+easten_value);
			 
			 System.out.println("North="+North_value+'\n'+"East="+east_value+'\n'+"South="+south_value+'\n'+"West="+west_value);
		 }
		
		 
		 
		  //------------------Assert all values --------------------------------------//
		 try
		  {
			 if(area_values[0].equals(null)||area_values[1].equals(null)||area_values[2].equals(null)||area_values[3].equals(null)||area_values[4].equals(null)||area_values[5].equals(null)||area_values[6].equals(null)||area_values[7].equals(null))
			 {
				 System.out.println("Some results are with null values");
			 }
			 else
			 {
		  
	     Assert.assertEquals(area_values[0],Area_value ,"Area Decision ID exists in DB ");
		 Assert.assertEquals(area_values[2],String.valueOf(Northes_value) ,"Northes in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[3],String.valueOf(easten_value) ,"Eastes in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[4],String.valueOf(North_value) ,"North in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[5],String.valueOf(east_value) ,"East in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[6],String.valueOf(west_value) ,"West in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[7],String.valueOf(south_value) ,"South in DB doesn't match displayed value   ");
		 Assert.assertEquals(area_values[1],String.valueOf(Land_area_value) ,"Land Area in DB doesn't match displayed value  ");
		 
		/* 
		 next_three=driver.findElement(By.xpath("//*[@id='pt1:r1:3:cb2']"));
		 next_three.click();

		//------------------------Identify Attachments Page Elements------------
		String filepath=Reader.extract("Autocad_upload_again.png");
		 
		  img_Decision=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if2::content']"));
	      img_Decision.sendKeys(filepath);  
		  img_Decision_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb7']"));
		  img_Decision_att_btn.click();
		  
	      img_Sak=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if3::content']"));
	      img_Sak.sendKeys(filepath);
	      img_Sak_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb6']"));
		  img_Sak_att_btn.click();
		  
		  img_ID=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if6::content']"));
		  img_ID.sendKeys(filepath);
		  img_ID_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb11']"));
		  img_ID_att_btn.click();
		  
		  img_Google=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if8::content']"));
		  img_Google.sendKeys(filepath);
		  img_Google_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb13']"));
		  img_Google_att_btn.click();
		  
		  img_Site=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if9::content']"));
		  img_Site.sendKeys(filepath);
		  img_Site_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb14']"));
		  img_Site_att_btn.click();
		  
		  img_Keroky=driver.findElement(By.xpath("//*[@id='pt1:r1:4:if31::content']"));
		  img_Keroky.sendKeys(filepath);
		  img_Keroky_att_btn=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb39']"));
		  img_Keroky_att_btn.click();
		  
		  next_three=driver.findElement(By.xpath("//*[@id='pt1:r1:4:cb5']"));
		  next_three.click();
		  
		  request_No=driver.findElement(By.xpath("//*[@id='pt1:r1:5:pgl1']/div[2]/span"));
		  System.out.println(request_No.getText());
		  
		  */
		  
			 }
				 
		  }catch (Exception error)
		  {
			  System.out.println("Not all values matches");
			  String results_failed=error.getMessage();
			  String[] first_line=results_failed.split("\r\n|\r|\n", 2);
			 // System.out.println(results_failed);
			  JFrame frame=new JFrame("Results");
			  JOptionPane.showMessageDialog(frame, first_line[0]);
		  }
	}
	
	
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}





}
