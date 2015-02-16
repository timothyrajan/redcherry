package org.redcherry.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import jxl.Sheet;
import jxl.Workbook;

public class TestData {
	
	
	/** The HashMap which holds the data of the test case */
	static LinkedHashMap<String, String>  dataRow = new LinkedHashMap<String, String>();
	
	
	/**
	 * 
	 * @param testName
	 * @return LinkedHashMap which holds the data available in the 
	 */
	public static LinkedHashMap<String,String> loadTestData(String testName){
				
		try{
			InputStream dtExcel = new FileInputStream("C://Users//timothyr//git//greenwork//myframework//src//org//greentest//testdata//TestData.xls");
			Workbook xlFile = Workbook.getWorkbook(dtExcel);			
			Sheet xlSheet = xlFile.getSheet("TestData");
			int colcnt=xlSheet.getColumns()-1;	
			int col=0;
			while(col<=colcnt){
				dataRow.put(xlSheet.getCell(col,0).getContents(),xlSheet.getCell(col,1).getContents());
				col++;			
			}
			dtExcel.close();
			}
		
		catch (Throwable e)    {
			System.out.println(e.getMessage());
		}
		
		return dataRow;
	}
	
	
	
	public static String getTestData(String columnName){
		return dataRow.get(columnName);
	}
	
}
