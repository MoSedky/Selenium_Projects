package automated_HLS;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane; 


public class Data_Layer 
{
	int selected=0;
	
	public String[] Eng_Office(int Baladia_ID) throws SQLException, ClassNotFoundException
	 {
		//try
		//{
			
		
		
		 String[] Eng_off_values=new String[2];
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@ruhmsv-odbtest:1521:TESTDB","GSERV","gserv");  
		
		Statement  stmt_project=con.createStatement();
		
		ResultSet Project_Data=stmt_project.executeQuery("select Username,Password from ENG_OFFICE_INFO where  ID IN "
				+ "(SELECT ENG_OFFICE_ID  FROM ENG_OFFICE_ORDER where flag = '1' and status = '2') "
				+ "and BALADIA_ID="+Baladia_ID+" and StatusID=2");
		
		if(Project_Data.equals(null))
		{
			return null;
		}
		else
		{	
		while(Project_Data.next())
		{
			
				
			Eng_off_values[0]=Project_Data.getString(1);//User name
			Eng_off_values[1]=Project_Data.getString(2);//Password
				
				
			
			
				
			
		}
		
		
			return Eng_off_values;
		
		}
		
		//}catch (Exception C)
		//{
		//	System.out.println(C.getMessage());
		//	System.out.println("Problem in DB connections or results");
		//	return null;
		//}
	 }

	
	public String[] project_data(String area_d_value) throws SQLException, ClassNotFoundException
	 {
		//try
		//{
			
		
		
		 String[] Area_values=new String[8];
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@ruhmsv-odbtest:1521:TESTDB","GSERV","gserv");  
		
		Statement  stmt_project=con.createStatement();
		
		ResultSet Project_Data=stmt_project.executeQuery("Select O.ORDERID,O.Area,O.CORDX,O.CORDY,O.North,O.EAST,O.WEST,O.South "
				+ "from orders O "
				+ "Where ORDERID='"+area_d_value+"'");
		
		while(Project_Data.next())
		{
			
				
				Area_values[0]=Project_Data.getString(1);//Area Decision ID
				Area_values[1]=Project_Data.getString(2);//Land Area
				Area_values[2]=Project_Data.getString(3);//El Shamalyiat (Northes)
				Area_values[3]=Project_Data.getString(4);//El Sharkyiat (Easts)
				Area_values[4]=Project_Data.getString(5);//North
				Area_values[5]=Project_Data.getString(6);//EAST
				Area_values[6]=Project_Data.getString(7);//WEST
				Area_values[7]=Project_Data.getString(8);//South
				
			
			
				
			
		}
		return Area_values;
		
		//}catch (Exception C)
		//{
		//	System.out.println(C.getMessage());
		//	System.out.println("Problem in DB connections or results");
		//	return null;
		//}
	 }

	 public String[] connect(String License_No) throws ClassNotFoundException, SQLException
	 {
		 String[] Area_values=new String[8];
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@ruhmsv-odbtest:1521:TESTDB","GSERV","gserv");  
			
			Statement  stmt_project=con.createStatement();
			
			ResultSet Project_Data=stmt_project.executeQuery("Select O.ORDERID,O.Area,O.CORDX,O.CORDY,O.North,O.EAST,O.WEST,O.South ,L.BL_LIECENCENO,L.* from Build_LIC_ORDER L "
					+ "inner join orders O on O.ORDERID=L.BL_ORDERID "
					+ "Where L.BL_LIECENCENO='"+License_No+"' ");
			
			while(Project_Data.next())
			{
				
					
					Area_values[0]=Project_Data.getString(1);//Area Decision ID
					Area_values[1]=Project_Data.getString(2);//Land Area
					Area_values[2]=Project_Data.getString(3);//El Shamalyiat (Northes)
					Area_values[3]=Project_Data.getString(4);//El Sharkyiat (Easts)
					Area_values[4]=Project_Data.getString(5);//North
					Area_values[5]=Project_Data.getString(6);//EAST
					Area_values[6]=Project_Data.getString(7);//WEST
					Area_values[7]=Project_Data.getString(8);//South
					
				
				
					
				
			}
			return Area_values;
			
		 
		
		
		  
	 }
}


