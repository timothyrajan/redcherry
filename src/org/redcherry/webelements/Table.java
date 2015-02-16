package org.redcherry.webelements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Page;

public class Table extends GenericWebElement{
	
	/** The Table element */
	private  WebElement curWebElement;
	
	
	/**
	 * This method gets the link object in the page with the help of the identifiers. The Table object
	 * is identified in the page by using the identifiers mentioned either in the uiobjectlocators.xml
	 * or in the uiobjectlocators.properties file.
	 * 
	 * @param WebDriver - The driver object
	 * @param String - The name of the element. This is the logical name of the Table component.
	 * @param className - The name of the class. This is the logical name which is given to the page.
	 */	
	public Table (WebDriver driver,String elementName,String className){
		curWebElement=Page.getElement(driver,elementName,className);	
	}

	
	/**
	 * This method sets the focus on the table object in the page. 
	 * @return List - A list holding all the tables.
	 */
	private void setFocus(){
	
	}

	
	/**
	 * This method clicks on a particular cell in a table based on the row and the column 
	 * input data 
	 * @param Integer - rownumber indicating the rownumber in the table
	 * @param Integer - columnnumber indicating the columnnumber in the table
	 */
	private void click(int rownumber,int columnnumber){
		
		
	}
	
	
	/**
	 * This method retrieves the column names of the table in the page
	 * @return List - A list holding all the column names in the table.
	 */
	private ArrayList getColumnHeaders(){
		ArrayList tableHeaders= null;
		return tableHeaders;
	}	
	
		
	/**
	 * This method traverses through the entire page and collects all the table objects
	 * in the page in an list. 
	 * @return List - A list holding all the tables.
	 */
	private List<WebElement> getallTables() {	
		List<WebElement> Tables= driver.findElements(By.tagName(""));			
		return Tables;		
	}
	
	
	/**
	 * This method details whether the table is in focus or not by a boolean value. The
	 * boolean value of TRUE indicates that the table has focus.Boolean value of FALSE 
	 * indicates that the table does not have focus 
	 * @return Integer - Integer value indicating the total number of rows in the table
	 */
	private boolean hasFocus(){
		boolean hasFocus=false;
		return hasFocus;
		
	}
	
	/**
	 * This method returns the row count of the table in  a integer format
	 * @return Integer - Integer value indicating the total number of rows in the table
	 */
	private int getRowCount(){
		int rowcnt=0;
		return rowcnt;
	}
	
	
	/**
	 * This method returns the column count of the table in  a integer format
	 * @return Integer - Integer value indicating the total number of columns in the table
	 */
	private int getColumnCount(){
		int columncnt=0;
		return columncnt;
	}

	/**
	 * This method returns the data content in a cell which is identified by row and column numbers
	 * in the table in  a string format
	 * @param Integer - Row value indicating the row number
	 * @param Integer - Columnm Name - The column number of the table
	 * @return String - The string value representing the cell data
	 */
	private String getValue(int row, int col){
		String cellData="";
		return cellData;
	}
	
	
	/**
	 * This method returns the data content in a cell which is identified by row and colname in the
	 * table in  a string format
	 * @param Integer - Row value indicating the row number
	 * @param String - Columnm Name - The column header name of the table
	 * @return String - The string value representing the cell data
	 */
	private String getValue(int row, String colname){
		String cellData="";
		return cellData;
	}	
}
