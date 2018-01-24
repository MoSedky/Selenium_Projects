package est_eval;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Print_Excel {
	
	public boolean isRowEmpty(Row row){

        if (row == null){
            return true;
        }
        else {
            return false;
        }
    }
	
	@SuppressWarnings({ "deprecation", "resource" })
	public void print(String Query,String URL,String Username,String Password,String FilePath,String drivername)
	{
		try {
		    Class.forName(drivername);
		    Connection con = DriverManager.getConnection(URL, Username, Password);
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(Query);
		    XSSFWorkbook workbook = new XSSFWorkbook();
		    XSSFSheet sheet = workbook.getSheetAt(1);
		    XSSFRow rowhead = sheet.createRow((short) 1);
		   // if (isRowEmpty(sheet.getRow(0))== false){
		    	//rowhead = sheet.createRow(0);
                XSSFCell cell_H = rowhead.createCell((short)0);
                cell_H.setCellType(Cell.CELL_TYPE_STRING);
                cell_H.setCellValue("Entities");
            //}   
		   // XSSFRow rowhead = sheet.createRow((short) 0);
		    //rowhead.createCell((short) 0).setCellValue("Entities");
		   // rowhead.createCell((short) 1).setCellValue("CellHeadName2");
		   // rowhead.createCell((short) 2).setCellValue("CellHeadName3");
		    int i = 1;
		    while (rs.next()){
		    	
		    	XSSFRow row = null;
			   // if (isRowEmpty(sheet.getRow(0))== false){
			    	row = sheet.createRow(i);
	                XSSFCell cell = row.createCell(i);
	                cell.setCellType(Cell.CELL_TYPE_STRING);
	                cell.setCellValue(rs.getString(1));
	           // }   
		       // XSSFRow row = sheet.createRow((short) i);
		        //row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("column1")));
		       // row.createCell((short) 1).setCellValue(rs.getString(1));
		        //row.createCell((short) 2).setCellValue(rs.getString("column3"));
		        i++;
		    }
		    String yemi = FilePath;
		    FileOutputStream fileOut = new FileOutputStream(yemi);
		    workbook.write(fileOut);
		    fileOut.close();
		    } catch (ClassNotFoundException e1) {
		       e1.printStackTrace();
		    } catch (SQLException e1) {
		        e1.printStackTrace();
		    } catch (FileNotFoundException e1) {
		        e1.printStackTrace();
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    }
	}

}
