package est_eval;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
public class Establishment_Eval_Page {
	
	
	WebDriver driver;
	String Labor_Office;
	String Sequence_no;
	String Unified_Number_Name;
	String Unified_Number_No;
	String Total_Laborers_Unified;
	String Saudis_Unified;
	String Foreigners_Unified;
	String Entity_Name;
	String Entity_Name_AC_Field;
	String Entity_Number;
	String Entity_Size;
	String Total_Labors_Size;
	String Saudis_Size;
	String Foreigners_Size;
	String Saudis_GOSI_Distr;
	String Establishment_No;
	String Establishment_Name;
	String Establishment_Total_Laborers;
	String Establishment_Saudis_GOSI_Distr;
	String Establishment_Foreigners;
	String Establishment_Ajeer;
	int No_Of_Establishments;
	String GOSI_Paid_Status;
	String AVG_Entity_Total_Saudi_Normals_Owner;
	String AVG_Entity_Disables;
	String AVG_Entity_Prisoners;
	String AVG_Remotely;
	String AVG_Gulf_Citizen;
	String AVG_Special_Foreigners;
	String AVG_Displaced_Tripes;
	String AVG_Students;
	String AVG_Players;
	String AVG_Loaneds;
	String AVG_Total_Saudi_Factorized;
	String AVG_Total_Foreigners_Factorized;
	String Entity_Color;
	String Tawteen_Percentage;
	String Entity_Total_Points;
	String Tawteen_Percentage_Value;
	String Female_Percentage_Value;
	String AVG_Saudi_Salaries_Value;
	String AVG_Staying_Period_Value;
	String Highly_Paid_Value;
	String Tawteen_Percentage_Points;
	String Female_Percentage_Points;
	String AVG_Saudi_Salaries_Points;
	String AVG_Staying_Period_Points;
	String Highly_Paid_Points;
	String Tawteen_Percentage_Points_Max;
	String Female_Percentage_Points_Max;
	String AVG_Saudi_Salaries_Points_Max;
	String AVG_Staying_Period_Points_Max;
	String Highly_Paid_Points_Max;
	
	
	@BeforeClass
	public void setUp() throws Exception{
		
		Dashboard_Page dashboard=new Dashboard_Page();
		dashboard.setUp();
		//login.readExcel("E:\\Automation Testing\\Establishment_Evaluation", "TestData_EstablishmentEval.xlsx", "Login_Page");
		dashboard.testCal();
		driver=dashboard.driver;
		 Labor_Office=dashboard.Labor_Office;
		 Sequence_no=dashboard.Sequence_no;
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	private static void print(String msg, Object... args) {
	    try {
	        PrintStream ps = new PrintStream(System.out, true, "UTF-8");
	        ps.println(String.format(msg, args));
	    } catch (UnsupportedEncodingException error) {
	        System.err.println(error);
	        System.exit(0);
	    }
	}
	
	@Test
	public void testCal() throws Exception {
		//Unified Number Data
		
		Data_Access_Layer a=new Data_Access_Layer();
		a.DB_Connection();
		WebElement Unified_No_Name=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/span"));
		Unified_Number_Name=Unified_No_Name.getText();
		
		print("Unified_Number_Name: "+Unified_Number_Name);
		
		WebElement Unified_No_Number=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span"));
		Unified_Number_No=Unified_No_Number.getText();
		
		print("Unified_Number_No: "+Unified_Number_No);
		
		WebElement Total_Lab_Unified=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/span"));
		Total_Laborers_Unified=Total_Lab_Unified.getText();
		
		print("Total_Laborers_Unified: "+Total_Laborers_Unified);
		
		WebElement Saudis_Unified_GOSI=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/span"));
		Saudis_Unified=Saudis_Unified_GOSI.getText();
		
		print("Saudis_Unified: "+Saudis_Unified);
		
		WebElement Foreign_Unified=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[4]/span"));
		Foreigners_Unified=Foreign_Unified.getText();
		
		print("Foreigners_Unified: "+Foreigners_Unified);
		
		//Entity Number Data
		WebElement Entity_Name_AC=driver.findElement(By.xpath("//*[@id='select2-ddlEntities-container']"));
		Entity_Name_AC_Field=Entity_Name_AC.getText();
		
		print("Entity_Name_AC_Field: "+Entity_Name_AC_Field);
		
		WebElement Entity_Number=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span"));
		Entity_Name=Entity_Number.getText();
		
		print("Entity_Name: "+Entity_Name);
		
		WebElement Size=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[4]/span"));
		Entity_Size=Size.getText();
		
		print("Entity_Size: "+Entity_Size);
		
		WebElement Total_Size_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/span"));
		Total_Labors_Size=Total_Size_Field.getText();
		
		print("Total_Labors_Size: "+Total_Labors_Size);
		
		WebElement Saudis_Size_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/span"));
		Saudis_Size=Saudis_Size_Field.getText();
		
		print("Saudis_Size: "+Saudis_Size);
		
		WebElement Foreigners_Size_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/span"));
		Foreigners_Size=Foreigners_Size_Field.getText();
		
		print("Foreigners_Size: "+Foreigners_Size);
		
		WebElement Saudis_GOSI_Distr_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/span"));
		Saudis_GOSI_Distr=Saudis_GOSI_Distr_Field.getText();
		
		print("Saudis_GOSI_Distr: "+Saudis_GOSI_Distr);
		
		//Establishment Data
		WebElement table_element = driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/table"));
        List<WebElement> tr_collection=table_element.findElements(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/table/thead/tr"));

        print("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
        int row_num,col_num;
        row_num=1;
        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            No_Of_Establishments=td_collection.size();
            
            col_num=1;
            for(WebElement tdElement : td_collection)
            {
                print("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
                if(col_num==1 )
                {
                	Establishment_No=tdElement.getText();
                	print("EstablishmentNo: "+Establishment_No);
                }
                else if (col_num==2)
                {
                	Establishment_Name=tdElement.getText();
                	print("EstablishmentName: "+Establishment_Name);
                }
                else if (col_num==3)
                {
                	Establishment_Total_Laborers=tdElement.getText();
                	print("Establishment_Total_Laborers: "+Establishment_Total_Laborers);
                }
                else if (col_num==4)
                {
                	Establishment_Saudis_GOSI_Distr=tdElement.getText();
                	print("Establishment_Saudis_GOSI_Distr: "+Establishment_Saudis_GOSI_Distr);
                }
                else if (col_num==5)
                {
                	Establishment_Total_Laborers=tdElement.getText();
                	print("Establishment_Total_Laborers: "+Establishment_Total_Laborers);
                }
                else if (col_num==6)
                {
                	Establishment_Ajeer=tdElement.getText();
                	print("Establishment_Ajeer: "+Establishment_Ajeer);
                }
                else if (col_num==7)
                {
                	GOSI_Paid_Status=tdElement.getText();
                	print("GOSI_Paid_Status: "+GOSI_Paid_Status);
                }
                col_num++;
            }
            row_num++;
        } 
        print("No_Of_Establishments: "+No_Of_Establishments);
	
		
		//Entity Evaluation Data
		WebElement AVG_Entity_Total_Saudi_Normals_Owner_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[1]"));
		AVG_Entity_Total_Saudi_Normals_Owner=AVG_Entity_Total_Saudi_Normals_Owner_Field.getText();
		
		print("AVG_Entity_Total_Saudi_Normals_Owner: "+AVG_Entity_Total_Saudi_Normals_Owner);
		
		WebElement AVG_Entity_Disables_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[2]"));
		AVG_Entity_Disables=AVG_Entity_Disables_Field.getText();
		
		print("AVG_Entity_Disables: "+AVG_Entity_Disables);
		
		WebElement AVG_Entity_Prisoners_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[3]"));
		AVG_Entity_Prisoners=AVG_Entity_Prisoners_Field.getText();
		
		print("AVG_Entity_Prisoners: "+AVG_Entity_Prisoners);
		
		WebElement AVG_Remotely_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[4]"));
		AVG_Remotely=AVG_Remotely_Field.getText();
		
		print("AVG_Remotely: "+AVG_Remotely);
		
		WebElement AVG_Gulf_Citizen_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[5]"));
		AVG_Gulf_Citizen=AVG_Gulf_Citizen_Field.getText();
		
		print("AVG_Gulf_Citizen: "+AVG_Gulf_Citizen);
		
		WebElement AVG_Special_Foreigners_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[6]"));
		AVG_Special_Foreigners=AVG_Special_Foreigners_Field.getText();
		
		print("AVG_Special_Foreigners: "+AVG_Special_Foreigners);
		
		WebElement AVG_Displaced_Tripes_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[7]"));
		AVG_Displaced_Tripes=AVG_Displaced_Tripes_Field.getText();
		
		print("AVG_Displaced_Tripes: "+AVG_Displaced_Tripes);
		
		WebElement AVG_Students_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[8]"));
		AVG_Students=AVG_Students_Field.getText();
		
		print("AVG_Students: "+AVG_Students);
		
		WebElement AVG_Players_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[9]"));
		AVG_Players=AVG_Players_Field.getText();
		
		
		print("AVG_Players: "+AVG_Players);
		
		WebElement AVG_Loaneds_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/div/div/table/tbody/tr[2]/td[10]"));
		AVG_Loaneds=AVG_Loaneds_Field.getText();
		
		print("AVG_Loaneds: "+AVG_Loaneds);
		//Entity Evaluation
		WebElement AVG_Total_Saudi_Factorized_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[1]/div[2]/span"));
		AVG_Total_Saudi_Factorized=AVG_Total_Saudi_Factorized_Field.getText();
		
		print("AVG_Total_Saudi_Factorized: "+AVG_Total_Saudi_Factorized);
		
		WebElement AVG_Total_Foreigners_Factorized_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[1]/div[4]/span"));
		AVG_Total_Foreigners_Factorized=AVG_Total_Foreigners_Factorized_Field.getText();
		
		print("AVG_Total_Foreigners_Factorized: "+AVG_Total_Foreigners_Factorized);
		
		WebElement Entity_Color_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[2]/div[2]/span"));
		Entity_Color=Entity_Color_Field.getText();
		
		System.out.println("Entity_Color: "+Entity_Color);
		
		WebElement Tawteen_Percentage_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[2]/div[4]/span"));
		Tawteen_Percentage=Tawteen_Percentage_Field.getText();
		
		print("Tawteen_Percentage: "+Tawteen_Percentage);
		
		WebElement Entity_Total_Points_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[3]/div[2]/span"));
		Entity_Total_Points=Entity_Total_Points_Field.getText();
		
		print("Entity_Total_Points: "+Entity_Total_Points);
		
		//Points Table -- Values
		WebElement Tawteen_Percentage_Value_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[1]/td[2]/span"));
		Tawteen_Percentage_Value=Tawteen_Percentage_Value_Field.getText();
		
		print("Tawteen_Percentage_Value: "+Tawteen_Percentage_Value);
		
		WebElement Female_Percentage_Value_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[2]/td[2]/span"));
		Female_Percentage_Value=Female_Percentage_Value_Field.getText();
		
		print("Female_Percentage_Value: "+Female_Percentage_Value);
		
		WebElement AVG_Saudi_Salaries_Value_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[4]/td[2]/span"));
		AVG_Saudi_Salaries_Value=AVG_Saudi_Salaries_Value_Field.getText();
		
		print("AVG_Saudi_Salaries_Value: "+AVG_Saudi_Salaries_Value);
		
		WebElement AVG_Staying_Period_Value_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[3]/td[2]/span"));
		AVG_Staying_Period_Value=AVG_Staying_Period_Value_Field.getText();
		
		print("AVG_Staying_Period_Value: "+AVG_Staying_Period_Value);
		
		WebElement Highly_Paid_Value_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[5]/td[2]/span"));
		Highly_Paid_Value=Highly_Paid_Value_Field.getText();
		
		print("Highly_Paid_Value: "+Highly_Paid_Value);
		
		//Points Table -- Points
		WebElement Tawteen_Percentage_Points_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[1]/td[3]/span"));
		Tawteen_Percentage_Points=Tawteen_Percentage_Points_Field.getText();
		
		print("Tawteen_Percentage_Points: "+Tawteen_Percentage_Points);
		
		WebElement Female_Percentage_Points_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[2]/td[3]/span"));
		Female_Percentage_Points=Female_Percentage_Points_Field.getText();
		
		print("Female_Percentage_Points: "+Female_Percentage_Points);
		
		WebElement AVG_Saudi_Salaries_Points_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[4]/td[3]/span"));
		AVG_Saudi_Salaries_Points=AVG_Saudi_Salaries_Points_Field.getText();
		
		print("AVG_Saudi_Salaries_Points: "+AVG_Saudi_Salaries_Points);
		
		WebElement AVG_Staying_Period_Points_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[3]/td[3]/span"));
		AVG_Staying_Period_Points=AVG_Staying_Period_Points_Field.getText();
		
		print("AVG_Staying_Period_Points: "+AVG_Staying_Period_Points);
		
		WebElement Highly_Paid_Points_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[5]/td[3]/span"));
		Highly_Paid_Points=Highly_Paid_Points_Field.getText();
		
		print("Highly_Paid_Points: "+Highly_Paid_Points);
		
		//Points Table -- Notes contains Max points for each factor
		WebElement Tawteen_Percentage_Points_Max_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[1]/td[4]/span"));
		Tawteen_Percentage_Points_Max=Tawteen_Percentage_Points_Max_Field.getText();
		
		print("Tawteen_Percentage_Points_Max: "+Tawteen_Percentage_Points_Max);
		
		WebElement Female_Percentage_Points_Max_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[2]/td[4]/span"));
		Female_Percentage_Points_Max=Female_Percentage_Points_Max_Field.getText();
		
		print("Female_Percentage_Points_Max: "+Female_Percentage_Points_Max);
		
		WebElement AVG_Saudi_Salaries_Points_Max_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[4]/td[4]/span"));
		AVG_Saudi_Salaries_Points_Max=AVG_Saudi_Salaries_Points_Max_Field.getText();
		
		print("AVG_Saudi_Salaries_Points_Max: "+AVG_Saudi_Salaries_Points_Max);
		
		WebElement AVG_Staying_Period_Points_Max_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[3]/td[4]/span"));
		AVG_Staying_Period_Points_Max=AVG_Staying_Period_Points_Max_Field.getText();
		
		print("AVG_Staying_Period_Points_Max: "+AVG_Staying_Period_Points_Max);
		
		WebElement Highly_Paid_Points_Max_Field=driver.findElement(By.xpath("//*[@id='form2']/section/div[3]/div[2]/div[3]/div[2]/div[4]/div[2]/div/table/tbody/tr[5]/td[4]/span"));
		Highly_Paid_Points_Max=Highly_Paid_Points_Max_Field.getText();
		
		print("Highly_Paid_Points_Max: "+Highly_Paid_Points_Max);
		
}

}