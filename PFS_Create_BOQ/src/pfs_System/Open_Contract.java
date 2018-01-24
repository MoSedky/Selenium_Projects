package pfs_System;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;


import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

public class Open_Contract {
	
	static WebDriver driver;
	WebDriverWait wait;
	Actions action;
	WebElement Project_ID;
	String[] query_result;
	Data_Layer data=new Data_Layer();
	WebElement contracts_assoicated_Projects;
	WebElement Project_ID_txt;
	WebElement project_Name;
	WebElement Project_Type_Sector;
	WebElement Project_Sector;
	WebElement contract_Name;
	WebElement contract_value;
	WebElement contractor_name;
	WebElement table_of_Contracts;
	boolean contracts_exists;
	WebElement table_rows;
	int row_count;
	
	

	
	@BeforeClass
	public void setUp() throws Exception{
		Projects_Contractor c=new Projects_Contractor();
		driver=c.pass_driver();
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
		
	}
	
	
	@Test
	public void testCal() throws Exception {
		query_result=data.project_data();
		Robot r = new Robot();
		
		Project_ID=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:0:t1:_afrFltrc1::content']")));
		
		
		Project_ID.sendKeys(String.valueOf(query_result[0]));
		
		r.keyPress(KeyEvent.VK_ENTER);
		
		get_filtered_results();
		System.out.println("Filtering Result is done");
		
		validate_project_data();
		System.out.println("Validating Project Data is done");
		
		contracts_exists=validate_contracts();
		
		if(contracts_exists=false)
		{
			System.out.println("No Contracts exists");
		}
		else if(contracts_exists=true)
		{
			System.out.println("Executing SQL Query results .... ");
			get_contracts_data();
		}
		
	}
	
	public void get_filtered_results()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try
		{
			List<WebElement> cells = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='pt1:r1:0:t1::db']/table/tbody/tr/td[1]")));
			
			if(cells.size()>1)
			{
				System.out.println("There are more than one project found"); 
			}
			else
			{
				cells.get(0).click();
				contracts_assoicated_Projects=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'العقود المرتبطة بالمشروع')]")));
				contracts_assoicated_Projects.click();
				
			}
		}catch (Exception c)
		{
			System.out.println("Cannot find project results");
			System.out.println(c.getMessage());
			get_filtered_results();
		}
		
		
	}
	
	public void validate_project_data()
	{
		try
		{
			Project_ID_txt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:ot6::content']")));
			project_Name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:ot7::content']")));
			Project_Type_Sector=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:ot125::content']")));
		}catch (Exception c)
		{
			validate_project_data();
		}
		
		try
		{
			
			Assert.assertEquals(Project_ID_txt.getAttribute("value"), String.valueOf(query_result[0]),"Project ID doesn't match DB results ");
			Assert.assertEquals(project_Name.getAttribute("value"), String.valueOf(query_result[1]),"Project Name doesn't match DB results ");
			Assert.assertEquals(Project_Type_Sector.getAttribute("value"), String.valueOf(query_result[3]),"Project Sector doesn't match DB results ");
		}catch (Exception c)
		{
			System.out.println("Some fields doesn't match DB results ... ");
		}
		
		
		
	}
	
	public boolean validate_contracts()
	{
		try{
			table_of_Contracts=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'No data to display.')]/table")));
			
			System.out.println(table_of_Contracts.getText());
			return false;
			//*[@id='pt1:r1:1:t1::db']
			//div/div[contains(text(), 'No data to display.')]
		//	if(table_of_Contracts.isDisplayed())
			//{
				//return false;
			//}
			//else
			//{
				//return true;
			//}
			
		}catch(Exception c)
		{
			
			validate_contracts();
			System.out.println(c.getMessage());
			return true;
		}
		
	}
	
	public void get_contracts_data() throws ClassNotFoundException, SQLException
	{
		try
		{
			table_rows=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'db')]/table")));
			row_count=Integer.parseInt(table_rows.getAttribute("_rowcount"));
			Project_Sector=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:t1::db']/table/tbody/tr/td[1]/nobr")));
			contract_Name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:t1::db']/table/tbody/tr/td[2]/nobr")));
			contract_value=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:t1::db']/table/tbody/tr/td[3]/nobr")));
			contractor_name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:t1::db']/table/tbody/tr/td[4]/nobr")));
		}catch(Exception c)
		{
			get_contracts_data();
		}
		
		
		
		
		System.out.println("Number of Contracts="+row_count);
		String[] contracts_BQ_Invoice=data.project_data();
		
		try
		{
			
			
			Assert.assertEquals(Project_Sector.getText(), String.valueOf(query_result[4]),"Project Sector doesn't match DB results ");
			Assert.assertEquals(contract_Name.getText(), String.valueOf(query_result[2]),"Contract Name doesn't match DB results ");
			Assert.assertEquals(contract_value.getText().replaceAll("\\D+",""), String.valueOf(query_result[5]),"Contract Value doesn't match DB results ");
			Assert.assertEquals(contractor_name.getText(), String.valueOf(query_result[6]),"Contractor Name doesn't match DB results ");
			
		}catch (Exception c)
		{
			System.out.println("Some fields doesn't match DB results ... ");
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
