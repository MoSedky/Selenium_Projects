package pfs_System;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Upload_BOQ {
	static WebDriver driver;
	WebDriverWait wait;
	Actions action;
	WebElement BOQ_button;
	WebElement BOQ_prj_number;
	WebElement BOQ_prj_name;
	WebElement BOQ_site_number;
	WebElement BOQ_contract_value;
	WebElement BOQ_contract_after_edit_value;
	WebElement BOQ_contract_name;
	WebElement BOQ_additional_value;
	WebElement BOQ_contractor_name;
	Data_Layer data=new Data_Layer();
	String[] query_result;
	WebElement upload_BOQ_button;
	WebElement excel_input;
	WebElement yes_upload;
	WebElement no_upload;
	List<WebElement> no_of_items_uploaded;
	JavascriptExecutor jse;
	WebElement items_sum;
	int sum_from_uploaded_items;
	int contract_value_after_edit;
	WebElement pending_Approval;
	WebElement save_button;
	WebElement back_button;
	WebElement confirm_button;
	WebElement not_equal_items;
	WebElement approve;
	
	
	
	@BeforeClass
	public void setUp() throws Exception{
		Open_Contract open=new Open_Contract();
		driver=open.pass_driver();
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
		jse = (JavascriptExecutor)driver;
		
	}
	
	@Test
	public void testCal() throws Exception {
		
		query_result=data.project_data();
		open_BOQ();
		System.out.println("Table of Amounts opens successfully");
		System.out.println("Executing validation on Table of Amounts page");
		validate_BOQ_data();
		System.out.println("All data validated properly");
		upload_excel_BOQ();
		System.out.println("Excel Sheet uploaded successfully");
		validate_uploaded_BOQ();
		
	}
	
	public void open_BOQ()
	{
		try
		{
			BOQ_button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:1:t1::db']/table/tbody/tr/td[7]/nobr/span/button[contains(text(),'جداول الكميات')]")));
			BOQ_button.click();
		}catch(Exception c)
		{
			open_BOQ();
		}
		
	}
	
	public void validate_BOQ_data()
	{
		try
		{
			 BOQ_prj_number=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:ot6::content']")));
			 BOQ_prj_name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:ot7::content']")));
			 BOQ_site_number=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:ot8::content']")));
			 BOQ_contract_value=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:ot10::content']")));
			 BOQ_contract_after_edit_value=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:ot12::content']")));
			 BOQ_contract_name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:ot9::content']")));
			 BOQ_additional_value=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:ot11::content']")));
			 BOQ_contractor_name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:ContractorName01::content']")));
		}catch(Exception c)
		{
			validate_BOQ_data();
		}
		
		try
		{
			
			Assert.assertEquals(BOQ_prj_number.getAttribute("value"), String.valueOf(query_result[0]),"Project ID doesn't match DB results ");
			Assert.assertEquals(BOQ_prj_name.getAttribute("value"), String.valueOf(query_result[1]),"Project Name doesn't match DB results ");
			Assert.assertEquals(BOQ_site_number.getAttribute("value"), String.valueOf(query_result[3]),"Project Sector doesn't match DB results ");
			Assert.assertEquals(BOQ_contract_value.getAttribute("value"), String.valueOf(query_result[5]),"Contract Value doesn't match DB results ");
			Assert.assertEquals(BOQ_contract_after_edit_value.getAttribute("value"), String.valueOf(query_result[7]),"Contract value after edit doesn't match DB results ");
			Assert.assertEquals(BOQ_contract_name.getAttribute("value"), String.valueOf(query_result[2]),"Contract Name doesn't match DB results ");
			//Assert.assertEquals(BOQ_additional_value.getAttribute("value"), String.valueOf(query_result[0]),"Project ID doesn't match DB results ");
			Assert.assertEquals(BOQ_contractor_name.getAttribute("value"), String.valueOf(query_result[6]),"Contractor Name doesn't match DB results ");
			
		}catch (Exception c)
		{
			System.out.println("Some fields doesn't match DB results ... ");
		}
		 
	}
	
	public void upload_excel_BOQ()
	{
		try
		{
			upload_BOQ_button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'رفع ملف جدول كميات')]")));
			upload_BOQ_button.click();
			
			excel_input=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:if1::content']")));
			excel_input.sendKeys("C:\\Users\\msedky\\Downloads\\sheet (18).xls");
			yes_upload=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:ins101']")));
			yes_upload.click();
			no_upload=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:2:no212']")));
		}catch(Exception c)
		{
			System.out.println(c.getMessage());
			upload_excel_BOQ();
		}
		
	}
	
	public void validate_uploaded_BOQ()
	{
		no_of_items_uploaded=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='pt1:r1:2:t1::db']/table/tbody/tr")));
		System.out.println("No of Items uploaded are : "+no_of_items_uploaded.size());
		
		jse.executeScript("window.scrollBy(0,250)", "");
		items_sum=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@summary,'يحتوي هذا الجدول على عناوين أعمدة تتوافق مع جدول نص البيانات الموجود أدناه')]/tbody/tr/td[contains(@_d_index,'5')]/span")));
		sum_from_uploaded_items=Integer.parseInt(items_sum.getText().replaceAll("\\D+",""));
		contract_value_after_edit=Integer.parseInt(query_result[7]);
		
		if(sum_from_uploaded_items!=contract_value_after_edit)
		{
			System.out.println("Contract Value should be equal to Item sum");
			pending_Approval=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:0:bool::content']")));
			pending_Approval.click();
			save_button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'حفظ')]")));
			save_button.click();
			
			confirm_button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:0:app']")));
			confirm_button.click();
			
			not_equal_items=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'يجب أن يكون إجمالي مجموع البنود مساوي لقيمة العقد بعد التعديل')]")));
			
			
			if(not_equal_items.isDisplayed())
			{
				System.out.println("Negative scenario of Sum of uploaded items to Contract value passed successfully");
				approve=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pt1:r1:0:yes22']")));
				approve.click();
			}
		}
		
	}
	
	
	
	
	
	
	@AfterClass
	public void teardown(){
		
	}

}
