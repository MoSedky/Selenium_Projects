package est_eval;
import java.net.MalformedURLException;
import  java.sql.Connection;		
import  java.sql.Statement;

import org.testng.annotations.BeforeClass;

import  java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import  java.sql.DriverManager;		
import  java.sql.SQLException;
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

public class Data_Access_Layer {
	String Labor_Office;
	String Sequence_no;
	String Unified_Labor_Office;
	String Unified_Sequence_No;
	
	@SuppressWarnings("null")
	
	
	public void DB_Connection() throws Exception
	{
		Login_Page login=new Login_Page();
		login.setUp();
		login.testCal();
		WriteDataExcel write=new WriteDataExcel();
		 Labor_Office=login.LaborOffice;
		 Sequence_no=login.SequenceNumber;
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:sqlserver://192.168.209.54";					

		//Database Username		
		String username = "moldbuser";	
        
		//Database Password		
		String password = "moldbuser";	
		
		String Unified_Name;
		String Total_Saudis_Unified;
		String Total_Foreigners_Unified;
		String Total_Laborers_Unified;
		String Total_Saudis_Unified_Query;
		ArrayList <String[]> Entities=new ArrayList<String[]>();
		String Unified_Labor_Office_Query;
		String Entities_Query;
		String Entities_Data_Query;
		String Entities_AVG_Query;
		String Entities_Data_Queries;
		ArrayList <String[]> Establishment_No=new ArrayList<String[]>();
		ArrayList <String[]> Establishment_Name=new ArrayList<String[]>();
		ArrayList <String[]> Establishment_Total_Laborer=new ArrayList<String[]>();
		ArrayList <String[]> Establishment_Saudis=new ArrayList<String[]>();
		ArrayList <String[]> Establishment_Foreigners=new ArrayList<String[]>();
		ArrayList <String[]> Establishment_Ajeer_Laborers=new ArrayList<String[]>();
		ArrayList <String[]> Establishment_GOSI_Paid=new ArrayList<String[]>();
		String Establishments_Query;
		ArrayList <String[]> Average_Saudis_Total_Factorized=new ArrayList<String[]>();
		ArrayList <String[]> Average_Foreigners_Total_Factorized=new ArrayList<String[]>();
		ArrayList <String[]> Entity_Color_Name=new ArrayList<String[]>();
		ArrayList <String[]> Average_Saudi_Percentage=new ArrayList<String[]>();
		ArrayList <String[]> Points_Total=new ArrayList<String[]>();
		String Entity_Evaluation_Query;
		ArrayList <String[]> result = new ArrayList<String[]>();
		ArrayList <String[]> AVG_Saudis=new ArrayList<String[]>();
		ArrayList <String[]> Average_GOSI_Disableds=new ArrayList<String[]>();
		ArrayList <String[]> Average_GOSI_Prisoners=new ArrayList<String[]>();
		ArrayList <String[]> Average_GOSI_Remote_Working=new ArrayList<String[]>();
		ArrayList <String[]> Average_GOSI_Gulf_Citizens=new ArrayList<String[]>();
		ArrayList <String[]> Average_GOSI_Special_Foreigners=new ArrayList<String[]>();
		ArrayList <String[]> Average_GOSI_Displaced_Tribes=new ArrayList<String[]>();
		ArrayList <String[]> Average_GOSI_Students=new ArrayList<String[]>();
		ArrayList <String[]> Average_GOSI_Players=new ArrayList<String[]>();
		ArrayList <String[]> Average_GOSI_Loaned=new ArrayList<String[]>();
		String Size_Query;
		String Saudis_Query;
		String Foreigners_Query;
		String Saudis_Total_Query;
		String Total_S_Query;
		//String Entity_Evaluation_Data;
		//String [] Entity_Evaluation;
		ArrayList <String[]> Average_Saudi_Percentage_p=new ArrayList<String[]>();
		ArrayList <String[]> Points_Average_Percentage=new ArrayList<String[]>();
		ArrayList <String[]> Saudi_Females_Percetnage=new ArrayList<String[]>();
		ArrayList <String[]> Saudi_Females_Points=new ArrayList<String[]>();
		ArrayList <String[]> Average_Saudis_Work_Duration=new ArrayList<String[]>();
		ArrayList <String[]> Points_Average_Saudis_Work_Duration=new ArrayList<String[]>();
		ArrayList <String[]> Salary_Saudi_Percentage=new ArrayList<String[]>();
		ArrayList <String[]> Points_Salary_Saudi_Percentage=new ArrayList<String[]>();
		ArrayList <String[]> Highly_Paid_Laborers_Saudi_Percentage=new ArrayList<String[]>();
		ArrayList <String[]> Points_Highly_Paid_Laborers_Saudi_Percentage=new ArrayList<String[]>();
		String Points_Value_Query;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
		   
	   		//Create Connection to DB		
	    	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  
	  		//Create Statement Object		
		   //Statement stmt = con.createStatement();					

				// Execute the SQL Query. Store results in ResultSet		
	 				
		//Unified No. Queries		
		Unified_Name = "Select Unified_Name "
				+ "from [Nitaqat_III_Testing].[dbo].[Establishment_Evaluation] "
				+ "Where Labor_Office_Id="+Labor_Office+" and Sequence_Number="+Sequence_no;	
		
		Statement stmt_Unified_Name = con.createStatement();	
		ResultSet rs_Unified_Name= stmt_Unified_Name.executeQuery(Unified_Name);
		
		while (rs_Unified_Name.next())
		{
    		String Unified_Name_S = rs_Unified_Name.getString(1);
    		System.out.println(Unified_Name_S);
		}
		
		
		Unified_Labor_Office_Query="Select Unified_Labor_Office_Id,Unified_Sequence_Number "
				+ "from [Nitaqat_III_Testing].[dbo].[Establishment_Evaluation] "
				+ "Where Labor_Office_Id="+Labor_Office+ "and Sequence_Number="+Sequence_no;
		
		Statement stmt_Lab_Sequence = con.createStatement();	
		ResultSet rs_Lab_Sequence= stmt_Lab_Sequence.executeQuery(Unified_Labor_Office_Query);
		
		while (rs_Lab_Sequence.next())
		{
    		 Unified_Labor_Office = rs_Lab_Sequence.getString(1);
    		 Unified_Sequence_No= rs_Lab_Sequence.getString(2);
    		System.out.println(Unified_Labor_Office+"-"+Unified_Sequence_No);
    		
		}
		
		
		
		
		
		Total_Saudis_Unified_Query="Select sum(Saudis_Total),sum(Foreigners_Total),sum(Saudis_Total)+Sum(Foreigners_Total) as Total  "
				+ "from [Nitaqat_III_Testing].[dbo].[Establishment_Evaluation] "
				+ "Where Unified_Labor_Office_Id="+Unified_Labor_Office+" and Unified_Sequence_Number="+Unified_Sequence_No;
		
		Statement stmt_Total_Unified = con.createStatement();	
		ResultSet rs_Total_Unified= stmt_Total_Unified.executeQuery(Total_Saudis_Unified_Query);
		
		while (rs_Total_Unified.next())
		{
			 Total_Saudis_Unified = rs_Total_Unified.getString(1);
    		 Total_Foreigners_Unified= rs_Total_Unified.getString(2);
    		 Total_Laborers_Unified= rs_Total_Unified.getString(3);
    		 System.out.println(Total_Saudis_Unified+'\t'+Total_Foreigners_Unified+'\t'+Total_Laborers_Unified);
		}
		
	
		
		
		
		Entities_Query="Select  (case when EC.Name='كيانات مجمعة صغيرة جداً' then 'VerySmall' when EC.Name='تجارة الجملة والتجزئة' then 'Tegaret l gomal ' when EC.Name='ورش ومحلات الصيانة' then 'Werash W Syana' when EC.Name='الخدمات الصحية' then 'L 5admat l Se7yia' end)"
				+ "  from [Nitaqat_III_Testing].[dbo].Entity E "
				+ "inner join [Nitaqat_III_Testing].[dbo].[Economic_Activity] EC "
				+ "on E.Economic_Activity_Id=EC.Id "
				+ "Where Entity_Number like'"+Labor_Office+"-"+Sequence_no+"-%'";
		//ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
		Statement stmt_Entities_Query = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet Entity_rs= stmt_Entities_Query.executeQuery(Entities_Query);		
		//ResultSetMetaData rsmd = Entity_rs.getMetaData();
		int entities_size=0;
		//int i=0
				//Entity_rs.getRow(); 
		String[] row = new String[entities_size];
		
		
		
		Print_Excel p=new Print_Excel();
		p.print(Entities_Query, dbUrl,username,password, "E:\\Automation Testing\\Establishment_Evaluation\\TestData_EstablishmentEval.xlsx","com.microsoft.sqlserver.jdbc.SQLServerDriver");
	//	entities_size = Entity_rs.getMetaData().getColumnCount();
		//Entity_rs.l
		while (Entity_rs.next())
		{
			
			
		  // for (int i=0; i <=3 ; i++)
		    //{
		    // String x= Entity_rs.getString(i);
		    //	row[i] = Entity_rs.getString(1);
		       System.out.println(Entity_rs.getString(1));
		       write.writeExcel("E:\\Automation Testing\\Establishment_Evaluation", "TestData_EstablishmentEval.xlsx", "Test_Results", Entity_rs.getString(1)+'\t');
		   // }
		    result.add(row);
		  //  String [] listofurls = result.toArray(new String[result.size()]);
		    
		}
		
		for (int j=1; j <entities_size ; j++)
	    {
		
		
		System.out.println(Arrays.deepToString(result.get(j)));
	    
	    }
		Entities_Data_Query="Select Entity_Number,S.Name,Saudis,Foreigners_Total,Saudis_Total"
				+ ",(Saudis+Foreigners_Total+GOSI_Displaced_Tribes+GOSI_Special_Foreigners+GOSI_Gulf_Citizens+Owners)"
				+ " from [Nitaqat_III_Testing].[dbo].Entity E inner join [Nitaqat_III_Testing].[dbo].[Economic_Activity] EC"
				+ " on E.Economic_Activity_Id=EC.Id"
				+ "  inner join [Nitaqat_III_Testing].[dbo].[Size] S "
				+ "on E.Size_Id=S.Id Where Entity_Number "
				+ "like'"+Labor_Office+"-"+Sequence_no+"-%'";
		
		Statement stm_Entities_Data_Query = con.createStatement();	
		ResultSet rs_Entities_Data_Query= stm_Entities_Data_Query.executeQuery(Entities_Data_Query);
		
		while (rs_Entities_Data_Query.next())
		{
			Entities_Data_Queries = rs_Entities_Data_Query.getString(1);
			 Size_Query=rs_Entities_Data_Query.getString(2);
			 Saudis_Query=rs_Entities_Data_Query.getString(2);
			 Foreigners_Query=rs_Entities_Data_Query.getString(3);
			 Saudis_Total_Query=rs_Entities_Data_Query.getString(4);
			 Total_S_Query=rs_Entities_Data_Query.getString(5);
    		 System.out.println(Entities_Data_Queries+'\t'+Saudis_Query+'\t'+Size_Query+'\t'+Foreigners_Query+'\t'+Saudis_Total_Query+'\t'+Total_S_Query);
		}
		
        
		
		Entities_AVG_Query="Select (Average_Owners+Average_GOSI_Normals)as AVG_Saudis,Average_GOSI_Disableds,Average_GOSI_Prisoners,"
				+ "Average_GOSI_Remote_Working,Average_GOSI_Gulf_Citizens,Average_GOSI_Special_Foreigners,Average_GOSI_Displaced_Tribes,"
				+ "Average_GOSI_Students,Average_GOSI_Players,Average_GOSI_Loaned "
				+ "from [Nitaqat_III_Testing].[dbo].Entity E inner join [Nitaqat_III_Testing].[dbo].[Economic_Activity] EC"
				+ " on E.Economic_Activity_Id=EC.Id  inner join [Nitaqat_III_Testing].[dbo].[Size] S "
				+ "on E.Size_Id=S.Id Where Entity_Number "
				+ "like'"+Labor_Office+"-"+Sequence_no+"-%'";
		
		Statement stm_Entities_AVG_Query = con.createStatement();	
		ResultSet rs_Entities_AVG_Query= stm_Entities_AVG_Query.executeQuery(Entities_AVG_Query);
		int AVG_size=0; 
		AVG_size = rs_Entities_AVG_Query.getMetaData().getColumnCount();
		while (rs_Entities_AVG_Query.next())
		{
			
			  String[] row2 = new String[AVG_size];
			  String[] row3 = new String[AVG_size];
			  String[] row4 = new String[AVG_size];
			  String[] row5 = new String[AVG_size];
			  String[] row6 = new String[AVG_size];
			  String[] row7 = new String[AVG_size];
			  String[] row8 = new String[AVG_size];
			  String[] row9 = new String[AVG_size];
			  String[] row10 = new String[AVG_size];
			  String[] row11 = new String[AVG_size];
			    for (int j=0; j <AVG_size ; j++)
			    {
			       row2[j] = rs_Entities_AVG_Query.getString(1);
			       AVG_Saudis.add(row2);
			       row3[j] = rs_Entities_AVG_Query.getString(2);
			       Average_GOSI_Disableds.add(row3);
			       row4[j] = rs_Entities_AVG_Query.getString(3);
			       Average_GOSI_Prisoners.add(row4);
			       row5[j] = rs_Entities_AVG_Query.getString(4);
			       Average_GOSI_Remote_Working.add(row5);
			       row6[j] = rs_Entities_AVG_Query.getString(5);
			       Average_GOSI_Gulf_Citizens.add(row6);
			       row7[j] = rs_Entities_AVG_Query.getString(6);
			       Average_GOSI_Special_Foreigners.add(row7);
			       row8[j] = rs_Entities_AVG_Query.getString(7);
			       Average_GOSI_Displaced_Tribes.add(row8);
			       row9[j] = rs_Entities_AVG_Query.getString(8);
			       Average_GOSI_Students.add(row9);
			       row10[j] = rs_Entities_AVG_Query.getString(9);
			       Average_GOSI_Players.add(row10);
			       row11[j] = rs_Entities_AVG_Query.getString(10);
			       Average_GOSI_Loaned.add(row11);
			       
			         
			    System.out.println(Arrays.deepToString(AVG_Saudis.get(j))+'\t'+Arrays.deepToString(Average_GOSI_Disableds.get(j))+'\t'+Arrays.deepToString(Average_GOSI_Prisoners.get(j))+
			    		'\t'+Arrays.deepToString(Average_GOSI_Remote_Working.get(j))+'\t'+Arrays.deepToString(Average_GOSI_Gulf_Citizens.get(j))+'\t'+Arrays.deepToString(Average_GOSI_Special_Foreigners.get(j))+
			    		'\t'+Arrays.deepToString(Average_GOSI_Displaced_Tribes.get(j))+'\t'+Arrays.deepToString(Average_GOSI_Students.get(j))+'\t'+Arrays.deepToString(Average_GOSI_Players.get(j))+'\t'+Arrays.deepToString(Average_GOSI_Loaned.get(j)));		
			    }
		}
		
		Establishments_Query="Select concat(Labor_Office_Id,'-',Sequence_Number),Name,"
				+ "(Saudis_Total+Ajeer_Companions+Ajeer_Laborers+Foreigners) As Total_Laborers,Saudis_Total,Foreigners,"
				+ "(Ajeer_Companions+Ajeer_Laborers) As Ajeer_Laborers,Is_GOSI_Paid "
				+ "from [Nitaqat_III_Testing].[dbo].Establishment_Evaluation "
				+ "Where Unified_Labor_Office_Id="+Unified_Labor_Office+" and Unified_Sequence_Number="+Unified_Sequence_No;
		Statement stm_Establishments_Query = con.createStatement();
		ResultSet Establishment_rs= stm_Establishments_Query.executeQuery(Establishments_Query);							
		int Est_size=0; 
		Est_size = Establishment_rs.getMetaData().getColumnCount(); 
 		// While Loop to iterate through all data and print results		
		while (Establishment_rs.next())
		{
			
			
			
			  String[] row12 = new String[Est_size];
			  String[] row13 = new String[Est_size];
			  String[] row14 = new String[Est_size];
			  String[] row15 = new String[Est_size];
			  String[] row16 = new String[Est_size];
			  String[] row17 = new String[Est_size];
			  
			    for (int j=0; j <Est_size ; j++)
			    {
			       row12[j] = Establishment_rs.getString(1);
			       Establishment_Name.add(row12);
			       row13[j] = Establishment_rs.getString(2);
			       Establishment_Total_Laborer.add(row13);
			       row14[j] = Establishment_rs.getString(3);
			       Establishment_Saudis.add(row14);
			       row15[j] = Establishment_rs.getString(4);
			       Establishment_Foreigners.add(row15);
			       row16[j] = Establishment_rs.getString(5);
			       Establishment_Ajeer_Laborers.add(row16);
			       row17[j] = Establishment_rs.getString(6);
			       Establishment_GOSI_Paid.add(row17);
			       
			         
			    System.out.println(Arrays.deepToString(Establishment_Name.get(j))+'\t'+Arrays.deepToString(Establishment_Total_Laborer.get(j))+'\t'+Arrays.deepToString(Establishment_Saudis.get(j))+
			    		'\t'+Arrays.deepToString(Establishment_Foreigners.get(j))+'\t'+Arrays.deepToString(Establishment_Ajeer_Laborers.get(j))+'\t'+
			    		Arrays.deepToString(Establishment_GOSI_Paid.get(j)));		
			    }
	        			
		}
		
		
		//Entity Evaluation
		Entity_Evaluation_Query="Select Average_Saudis_Total_Factorized,Average_Foreigners_Total_Factorized,concat (Ec.Name,'(','كيان ',C.Name,')')as test"
				+ ",Average_Saudi_Percentage,Points_Total "
				+ "from [Nitaqat_III_Testing].[dbo].Entity E inner join [Nitaqat_III_Testing].[dbo].[Color] C "
				+ "on E.Color_Id=C.ID inner join [Nitaqat_III_Testing].[dbo].[Economic_Activity] EC "
				+ "on E.Economic_Activity_Id=EC.Id  Where Entity_Number "
				+ "like '9-445-%'";
		
		Statement stm_Entity_Evaluation = con.createStatement();
		ResultSet Entity_Eval_rs= stm_Entity_Evaluation.executeQuery(Entity_Evaluation_Query);							
		int Ent_Ev_size=0; 
		Ent_Ev_size = Entity_Eval_rs.getMetaData().getColumnCount(); 
 		// While Loop to iterate through all data and print results		
		while (Entity_Eval_rs.next())
		{
		
			
			  String[] row22 = new String[Ent_Ev_size];
			  String[] row23 = new String[Ent_Ev_size];
			  String[] row24 = new String[Ent_Ev_size];
			  String[] row25 = new String[Ent_Ev_size];
			  String[] row26 = new String[Ent_Ev_size];
		
			    for (int j=0; j <Ent_Ev_size ; j++)
			    {
			       row22[j] = Entity_Eval_rs.getString(1);
			       Average_Saudis_Total_Factorized.add(row22);
			       row23[j] = Entity_Eval_rs.getString(2);
			       Average_Foreigners_Total_Factorized.add(row23);
			       row24[j] = Entity_Eval_rs.getString(3);
			       Entity_Color_Name.add(row24);
			       row25[j] = Entity_Eval_rs.getString(4);
			       Average_Saudi_Percentage.add(row25);
			       row26[j] = Entity_Eval_rs.getString(5);
			       Points_Total.add(row26);
			       
			         
			    System.out.println(Arrays.deepToString(Average_Saudis_Total_Factorized.get(j))+'\t'+Arrays.deepToString(Average_Foreigners_Total_Factorized.get(j))+
			    		'\t'+Arrays.deepToString(Entity_Color_Name.get(j))+'\t'+Arrays.deepToString(Average_Saudi_Percentage.get(j))+'\t'+
			    		Arrays.deepToString(Points_Total.get(j)));		
			    }
			
			
	        			
		}
		
		
		Points_Value_Query="Select Average_Saudi_Percentage,Points_Average_Saudi_Percentage,Saudi_Females_Percentage,Saudi_Females_Percentage,"
				+ "Average_Saudis_Work_Duration,Points_Average_Saudis_Work_Duration,Salary_Saudi_Percentage,Points_Average_Saudis_Salary,"
				+ "Highly_Paid_Laborers_Saudi_Percentage,Points_Highly_Paid_Laborers_Saudi_Percentage "
				+ "from [Nitaqat_III_Testing].[dbo].Entity E inner join [Nitaqat_III_Testing].[dbo].[Economic_Activity] EC"
				+ " on E.Economic_Activity_Id=EC.Id  inner join [Nitaqat_III_Testing].[dbo].[Size] S "
				+ "on E.Size_Id=S.Id "
				+ "Where Entity_Number like'"+Unified_Labor_Office+"-"+Unified_Sequence_No+"-%'";
		
		Statement stm_Points_Value = con.createStatement();
		ResultSet Entity_Points_rs= stm_Points_Value.executeQuery(Points_Value_Query);							
		int Est_Pt_size=0; 
		Est_Pt_size = Entity_Points_rs.getMetaData().getColumnCount();  
 			
		while (Entity_Points_rs.next())
		{
		
			  String[] row28 = new String[Est_Pt_size];
			  String[] row29 = new String[Est_Pt_size];
			  String[] row30 = new String[Est_Pt_size];
			  String[] row31 = new String[Est_Pt_size];
			  String[] row32 = new String[Est_Pt_size];
			  String[] row33 = new String[Est_Pt_size];
			  String[] row34 = new String[Est_Pt_size];
			  String[] row35 = new String[Est_Pt_size];
			  String[] row36 = new String[Est_Pt_size];
			  String[] row37 = new String[Est_Pt_size];
			    for (int j=0; j <Est_Pt_size ; j++)
			    {
			       row28[j] = Entity_Points_rs.getString(1);
			       Average_Saudi_Percentage_p.add(row28);
			       row29[j] = Entity_Points_rs.getString(2);
			       Points_Average_Percentage.add(row29);
			       row30[j] = Entity_Points_rs.getString(3);
			       Saudi_Females_Percetnage.add(row30);
			       row31[j] = Entity_Points_rs.getString(4);
			       Saudi_Females_Points.add(row31);
			       row32[j] = Entity_Points_rs.getString(5);
			       Average_Saudis_Work_Duration.add(row32);
			       row33[j] = Entity_Points_rs.getString(1);
			       Points_Average_Saudis_Work_Duration.add(row33);
			       row34[j] = Entity_Points_rs.getString(2);
			       Salary_Saudi_Percentage.add(row34);
			       row35[j] = Entity_Points_rs.getString(3);
			       Points_Salary_Saudi_Percentage.add(row35);
			       row36[j] = Entity_Points_rs.getString(4);
			       Highly_Paid_Laborers_Saudi_Percentage.add(row36);
			       row37[j] = Entity_Points_rs.getString(5);
			       Points_Highly_Paid_Laborers_Saudi_Percentage.add(row37);
			       
			       
			         
			    System.out.println(Arrays.deepToString(Average_Saudi_Percentage_p.get(j))+'\t'+Arrays.deepToString(Points_Average_Percentage.get(j))+
			    		'\t'+Arrays.deepToString(Saudi_Females_Percetnage.get(j))+'\t'+Arrays.deepToString(Saudi_Females_Points.get(j))+'\t'+
			    		Arrays.deepToString(Average_Saudis_Work_Duration.get(j))+'\t'+Arrays.deepToString(Points_Average_Saudis_Work_Duration.get(j))+
			    		'\t'+Arrays.deepToString(Salary_Saudi_Percentage.get(j))+'\t'+Arrays.deepToString(Points_Salary_Saudi_Percentage.get(j))+
			    		'\t'+Arrays.deepToString(Highly_Paid_Laborers_Saudi_Percentage.get(j))+'\t'+Arrays.deepToString(Points_Highly_Paid_Laborers_Saudi_Percentage.get(j)));		
			    }
			
	        			
		}
		
		
		
		
 	    //Load mysql jdbc driver		
   	   
			 // closing DB Connection		
						

	
	}
	

}
