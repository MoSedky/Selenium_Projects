package pfs_System;

import java.awt.AWTException;
import java.awt.Robot;


import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Projects_Contractor {
	static WebDriver driver;
	WebDriverWait wait;
	Actions action;
	WebElement main_menu;
	WebElement projects_link;
	WebElement projects_table;
	WebElement first_row;
	
	@BeforeClass
	public void setUp() throws Exception{
	Login_Module login=new Login_Module();
	driver=login.pass_driver();
	//login.testCal();
	wait = new WebDriverWait(driver, 10);
	action = new Actions(driver);
	
	}
	
	@Test
	public void testCal() throws Exception {
		open_projects();
		//get_projects();
		
	}
	public void get_projects() throws AWTException
	{
		try
		{
			
		
		 //first_row=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:0:t1::db']/table/tbody/tr[1]/td[1]")));
		
		//first_row.click();
		Robot r = new Robot();
		int [] a=new int[100];
		
		for(int i=1;i<=100;i++)
		{
			first_row=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:0:t1::db']/table/tbody/tr["+i+"]/td[1]")));
			
			if(i>=25)
			{
				r.keyPress(KeyEvent.VK_DOWN);
				first_row=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:r1:0:t1::db']/table[2]/tbody/tr["+i+"]/td[1]")));
				first_row.click();
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				
			}
			first_row.click();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			//first_row.sendKeys(Keys.DOWN);
			//first_row.sendKeys(Keys.RETURN);
	        a[i]=i;
		}
		
		}catch(Exception c)
		{
			get_projects();
			System.out.println("Exception thrown");
		}
		
	}
	public void open_projects()
	{
		try
		{
			main_menu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:HomeMenuItem']")));
			action.moveToElement(main_menu).perform();
			
			projects_link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:pt12_c1']")));
			projects_link.click();
		
			System.out.println("waiting all elements ===");
			
			
			/*
			List<WebElement> cells = new ArrayList<>(200);
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='pt1:r1:0:t1::db']/table/tbody/tr/td[1]")));
			
					
			
			    for (WebElement cell : cells) 
			    { 
			    	
			        System.out.println(cell.getText());
			        cell.click();
			        
			        if(cells.get(24).equals(cell))
			        {
			        	cells.add(cell);
			        }
			    }
			
			
			*/
		}
		catch(Exception c)
		{
			System.out.println("Exception is :   "+c.getMessage());
			//open_projects();
			open_projects();
		}
		
	}
	
	public WebDriver pass_driver() throws MalformedURLException, ClassNotFoundException, AWTException, SQLException
	{
		
		return driver;
		
	}
	
	
	
	@AfterClass
	public void teardown(){
		
	}
	

}
