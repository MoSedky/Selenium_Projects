package pfs_System;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Create_BQ {
	
	
	@BeforeClass
	public void setUp() throws MalformedURLException, AWTException, ClassNotFoundException, SQLException{
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\Chrome Driver Selenium\\chromedriver.exe");
        
	}
	
	
	@Test
	public void testCal() throws Exception {
		Login_Module login=new Login_Module();
		login.setUp();
		login.testCal();
		
		Projects_Contractor co=new Projects_Contractor();
		
		co.setUp();
		System.out.println("setUp func of project contract is done");
		co.testCal();
		System.out.println("testCal func of project contract is done");
		
		Open_Contract open=new Open_Contract();
		open.setUp();
		System.out.println("setUp func of Open Contract is done");
		open.testCal();
		System.out.println("testCal func of Open Contract is done");
		Upload_BOQ upload=new Upload_BOQ();
		upload.setUp();
		System.out.println("setUp func of Upload BOQ is done");
		upload.testCal();
		System.out.println("testCal func of Uload BOQ is done");
		
		
		
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}

}
