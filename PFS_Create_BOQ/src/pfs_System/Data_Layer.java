package pfs_System;
import java.sql.*; 


public class Data_Layer 
{
	int selected=0;
	
	public String[] project_data() throws ClassNotFoundException, SQLException
	 {
		
		 String[] project_Ids=new String[8];
		 String[] project_name=new String[2];
		 String[] contract_name=new String[2];
		 String[] sector_type=new String[2];
		 String[] project_sectors=new String[2];
		 String[] contract_val=new String[2];
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@10.80.160.17:1521:PRODXDEV","PRJADF","adf");  
		
		Statement  stmt_project=con.createStatement();
		
		ResultSet Project_Data=stmt_project.executeQuery("Select P.PROJECT_ID, P.PROJECT_NAME,P.APPROVED_YEAR,P.PROJECT_PERIOD,"
				+ "C.CONTRACT_NAME,C.CONTRACTOR_REGNO,P.SECTOR_ID,C.SITE_CONTRACT_ID,C.CONTRACT_VALUE,C.CONTRACT_STATUS_ID,"
				+ "T.CONTRACT_VAL_AFTRUPD,T.NOTE"
				+ ",L.LOOKUP_DID_DESC,T.VAL_TRANS_AMT,T.VAL_TRANS_TYPEID,T.TRANS_STATUS_ID,T.TRANS_DATE,C.*,P.* "
				+ "from PRJ_CONTRACT_INFO C "
				+ "inner join PRJ_PROJECT_INFO P on C.PROJECT_ID = P.PROJECT_ID "
				+ "left outer join PRJ_CONTRACT_TRANSACTION T on C.CONTRACT_ID=T.CONTRACT_ID and T.SITE_M_ID_FIN=P.SITE_M_ID_FIN and T.SITE_S_ID_FIN=P.SITE_S_ID_FIN "
				+ "left outer join PRJ_LOOKUP_DETAIL L on L.LOOKUP_DID=T.VAL_TRANS_TYPEID "
				+ "Where  C.CONTRACTOR_REGNO='4030005320' and P.Site_M_ID_FIN=006 and P.PROJECT_ID='019/006/202/401150000/31129'  "
				+ "order by C.Site_Contract_ID");
		
		while(Project_Data.next())
		{
			//for(int i=0;i<Project_Data.getFetchSize()-1;i++)
			//{
				//Project_Data.absolute(i+1);
				System.out.println("Project_ID="+Project_Data.getString(1)+" "+"Contract_Value="+Project_Data.getString(9));
				project_Ids[0]=Project_Data.getString(1);//ID
				project_Ids[1]=Project_Data.getString(2);//Name
				project_Ids[2]=Project_Data.getString(5);//Contract_Name
				project_Ids[3]=Project_Data.getString(7);//Sector_Type_ID
				project_Ids[4]=Project_Data.getString(8);//Project_Sectors
				project_Ids[5]=Project_Data.getString(9);//Contract_value
				project_Ids[6]=Project_Data.getString(55);// Contractor Name
				project_Ids[7]=Project_Data.getString(30);//Contract_val_after_update
			//}
			
				
			
		}
		return project_Ids;//new Object[]{project_Ids, project_name,contract_name,sector_type,project_sectors,contract_val};
	 }

	 public String[] connect() throws ClassNotFoundException, SQLException
	 {
		 String[] results=new String[2];
		 
		 
	 
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@10.80.160.17:1521:PRODXDEV","PRJADF","adf");  
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		Statement stmt_employee=con.createStatement(); 
		
		//step4 execute query  
		ResultSet contract_result=stmt.executeQuery("Select CMP_Commercial_ID,Rec_Pass from Sys_AMANA_Contractor where CMP_Commercial_ID in ('4030005320')"); 
		
		ResultSet Amana_result=stmt_employee.executeQuery("Select User_ID,User_Password from SYS_USER_MASTER where User_ID=9308"); 
		
		
		
		if(selected==0)
		{
			while(contract_result.next())
			{
				for(int i=0;i<=1;i++)
				{
					System.out.println("Username="+contract_result.getString(1)+" "+"Password="+contract_result.getString(2));
					results[0]=contract_result.getString(1);
					results[1]=contract_result.getString(2);
				}
				
			}
		}
		else
		{
			while(Amana_result.next())
			{
				for(int i=0;i<=1;i++)
				{
					System.out.println("Username="+Amana_result.getString(1)+" "+"Password="+Amana_result.getString(2));
					results[0]=Amana_result.getString(1);
					results[1]=Amana_result.getString(2);
				}
				
			}
		}
		
		
		
		
		
		
		
		
		  
		  
		//step5 close the connection object  
		con.close();
		return results;  
		  
	 }
}


