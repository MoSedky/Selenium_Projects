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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
//Excel Sheel Jars
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class h_One {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//Establishment_Evaluation//chromedriver.exe");
        WebDriver driver = new ChromeDriver(); 
        driver.get("http://10.1.2.193:7011/Area/faces/ShowAreaAccept?_adf.ctrl-state=jdoqtqwku_19");
        WebElement login_button=driver.findElement(By.xpath("//*[@id='pt1:r1:0:s1:it1::content']"));
        login_button.click();
		// TODO Auto-generated method stub

	}

}
