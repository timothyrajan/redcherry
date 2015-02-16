package org.redcherry.webelements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Logger;
import org.redcherry.utilities.Page;

public class WebList extends GenericWebElement{
	

	
	/** The WebList element */
	public  WebElement curWebElement;
	
	/**The WebList element name*/
	private String elementName;
	
	/**The Page name*/
	private String pageName;
	
	
	
	/**
	 * This method gets the Weblist object in the page with the help of the identifiers. The weblist object
	 * is identified in the page by using the identifiers mentioned either in the uiobjectlocators.xml
	 * or in the uiobjectlocators.properties file.
	 * 
	 * @param WebDriver - The driver object
	 * @param String - The name of the element. This is the logical name of the weblist component.
	 * @param className - The name of the class. This is the logical name which is given to the page.
	 */	
	public WebList (WebDriver driver,String elementName,String className){
		curWebElement=Page.getElement(driver,elementName,className);	
		this.elementName=elementName;
		this.pageName=className;
	 }
	
	
	/**
	 * This method gets the page name
	 * @return String value which indicates the page name
	 */
	private String getPageName(){
		return this.pageName;
	}
	
	
	/**
	 * This method gets the current webelement name
	 * @return
	 */
	private String getElementName(){
		return this.elementName;
	}
	
	
	/**
	 * This method selects an option in the dropdown(WebList) element by the option value.
	 * @param-String - A string value which represents the option value in the dropdown
	 */
	 public void selectOptionByValue(String option){	
		 if (curWebElement!=null){
				Logger.log("Selecting an option by option value " + option +"from "+getElementName()+" weblist  in "+getPageName()+" page");
				Select select = new Select(curWebElement);
				select.selectByValue(option);
			}else{
				Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
			}	 
		}
	
	
	 /**
	  * This method selects an option in the dropdown(WebList) element by the index.
	  * @param-Integer - A int value which represents the index in the dropdown
	  */
	public void selectOptionByIndex(int index){
		if (curWebElement!=null){
			Logger.log("Selecting an option from "+getElementName()+" weblist  in "+getPageName()+" page by index " + index);
			Select select = new Select(curWebElement);
			select.selectByIndex(index);
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
	}
	
	/**
	  * This method selects an option in the dropdown(WebList) element by an option in the
	  * dropdown.
	  * @param-String - A String value which represents the option in the dropdown
	  */
	public void selectOptionByVisibleText(String option){
		
		if (curWebElement!=null){
			Logger.log("Selecting an option from "+getElementName()+" weblist  in "+getPageName()+" page by option " + option);
			Select select = new Select(curWebElement);
			select.selectByVisibleText(option);	
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
	}
	
	
	/**
	  * This method clicks on the weblist in the page
	  */
	public void click(){
		if (curWebElement!=null){
			Logger.log("Performing click operation  on "+getElementName()+" weblist  in "+getPageName()+" page");
			curWebElement.click();
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}		
	}
	
	/**
	  * This method traverses through the entire option in the weblist and stores the 
	  * options in an Arraylist
	  * @return-Arraylist - A arraylist which holds string values which represents the options
	  * in the dropdown
	  */
	public ArrayList<String> getAlloptions(){   //Need to modify the return type
		
		ArrayList<String>options=new ArrayList();
		Select select = new Select(curWebElement);		
        List<WebElement> selectOptions = select.getOptions();
        for (WebElement option : selectOptions) {
            options.add(option.getText());
            System.out.println(option.getText());
        }        
        return options;
	}


	
	/**
	  * This method verifies whether the weblist has the focus in the webpage or not 
	  * 
	  * @return-Boolean - A boolean value which indicates whether the weblist has focus 
	  * or not
	  */
	@SuppressWarnings("unused")
	private boolean hasFocus(){   
		
		boolean blnHasFocus=false;		
		curWebElement.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		blnHasFocus=(Boolean) js.executeScript("return arguments[0].hasFocus;", curWebElement);
		System.out.println("has focus" + blnHasFocus);
		return blnHasFocus;		
	}
	
	
	/**
	 * This method validates whether the weblist object in the page is disabled or not. This function returns
	 * a boolean value which indicates whether the weblist is disabled or not.The boolean value
	 * is TRUE if the weblist is disabled. The boolean value is FALSE if the weblist is enabled.
	 * @return - Boolean -The boolean value indicating the disabled state of weblist
	 */
	public boolean isDisabled(){
		boolean isDisabled=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether the weblist "+getElementName()+" in page "+getPageName()+ " is disabled or NOT");
			if (curWebElement.isEnabled()){
				isDisabled=false;
			}else
			{
				isDisabled=true;
			}
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
		return isDisabled;
	}
	
	
	
	/**
	 * This method validates whether the weblist is enabled or not. This function returns
	 * a boolean value which indicates whether the weblist is enabled or not.The boolean value
	 * is TRUE if the weblist is enabled. The boolean value is FALSE if the weblist is disabled.
	 * 
	 * @return - Boolean -The boolean value indicating the enabled state of weblist
	 */
	public boolean isEnabled(){
		boolean isEnabled=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether the weblist "+getElementName()+" in page "+getPageName()+ " is enabled or NOT");
			if (curWebElement.isEnabled()){
				isEnabled=true;
			}else
			{
				isEnabled=false;
			}
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
		return isEnabled;
	}
	
	/**
	 * This method gets the currently selected option from the weblist dropdown.
	 * This method returns a string value which represents the selected option in the dropdown.
	 * @return String - The string value which represents the selected option in the dropdown.
	 */
	public String getSelectedItem(){
		
		WebElement Currentoption;
		String option="";
		if (curWebElement!=null){
			Logger.log("Getting  the selected item from the weblist "+getElementName()+" in page "+getPageName()+ " is enabled or NOT");
			Select select = new Select(curWebElement);
			Currentoption= select.getFirstSelectedOption();
			option=Currentoption.getText();
	     }
		return option;
	}
	
	
	/**
	 * This method sets the focus on the webelement in the page
	 */
	public void setFocus(){
		Actions action = new Actions(Browser.driver);
		action.moveToElement(curWebElement).perform();		
		
	}
	
	/**
	 * This method gets the innerHTML details of the weblist . This method returns a 
	 * string value which details the innerHTML of the weblist element in the page.
	 * @return String - The string value which details the innerHTML of the weblist element.
	 */
	public String getInnerHTML(){
		String innerhtml="";
		if (curWebElement!=null){
			Logger.log("Getting innerHTML value from "+getElementName()+ " Weblist "+ "in page "+getPageName());
			JavascriptExecutor js = null;		
			if (driver instanceof JavascriptExecutor) {
			    js = (JavascriptExecutor)driver;
			}
			
			innerhtml=(String) js.executeScript("return arguments[0].innerHTML;", curWebElement);	
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
		
		return innerhtml;
	}
	
	
	/**
	 * This method gets the outerHTML details of the weblist . This method returns a 
	 * string value which details the outerHTML of the weblist element in the page.
	 * 
	 * @return String - The string value which details the outerHTML of the weblist.
	 */
	public String getOuterHTML(){
		String outerhtml="";
		JavascriptExecutor js = null;
		if (curWebElement!=null){
			Logger.log("Getting outerHTML value from "+getElementName()+ " link "+ "in page "+getPageName());
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		
		outerhtml=(String) js.executeScript("return arguments[0].outerHTML;", curWebElement);
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
		return outerhtml;
	}
	
	
	/**
	  * This method verifies whether the weblist is a single select weblist or a multi select 
	  * weblist. If it is a multiselect webslit, it returns a TRUE else it returns a FALSE 
	  * @param-Boolean - A boolean value which represents whether the drop down is single select
	  * or multi select
	  */	
	public Boolean isMultiselect(){
		
		Boolean blnIsMultiSelect=null;
		if (curWebElement!=null){
			Logger.log("Verifying whether the weblist "+getElementName()+ " in page "+getPageName()+ " is a multi select weblist or a single select weblist" );
			Select select = new Select(curWebElement);
			blnIsMultiSelect=select.isMultiple();
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
			blnIsMultiSelect=(Boolean) null;
		}
		return blnIsMultiSelect;
	}
	
	
	/**
	  * This method deselects an option in the dropdown(WebList) element by an option in the
	  * dropdown.
	  * @param-String - A String value which represents the option in the dropdown
	  */
	public void deSelectOptionByValue(String option){
		
		if (curWebElement!=null){
			Logger.log("Deselecting the option in the weblist "+getElementName()+ " in page "+getPageName()+ " by value "+option );
			Select select = new Select(curWebElement);
			select.deselectByValue(option);
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
	}

	
	/**
	  * This method deselects an option in the dropdown(WebList) element by the option in the
	  * dropdown.
	  * @param-String - A String value which represents the option in the dropdown
	  */
	public void deSelectByOptionVisibleText(String option){
		if (curWebElement!=null){
			Logger.log("Deselecting the option in the weblist "+getElementName()+ " in page "+getPageName()+ " by visible text "+option );
			Select select = new Select(curWebElement);
			select.deselectByVisibleText(option);
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
	}

	
	/**
	  * This method deselects an option in the dropdown(WebList) element by index in the
	  * dropdown.
	  * @param-Integer - A int value which represents the index in the dropdown
	  */	
	public void deSelectOptionByIndex(int index){
		
		if (curWebElement!=null){
			Logger.log("Deselecting the option in the weblist "+getElementName()+ " in page "+getPageName()+ " by index " +index );
			Select select = new Select(curWebElement);
			select.deselectByIndex(index);
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
		
		
		
	}
	
	/**
	  * This method deselects all the options in the dropdown(WebList). 
	  */
	public void deSelectAll(){
		
		if (curWebElement!=null){
			Logger.log("Deselecting the all the selected options in the weblist "+getElementName()+ " in page "+getPageName());
			Select select = new Select(curWebElement);
			select.deselectAll();
		}else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
	}
	
	
	/**
	 * This method gets the tab index to reach out to the weblist by keypress tab action.
	 * @return - Integer - An integer value representing the tab press count.
	 */
	public int getTabIndex(){
		String strTabIndex="";
		int tabindex=99999;
		
		if (curWebElement!=null){
			Logger.log("Getting the tab index value of "+getElementName()+ " in page"+getPageName());
			strTabIndex=curWebElement.getAttribute("tabindex");
			if (strTabIndex.length()>0){ 
				tabindex=Integer.parseInt(strTabIndex);
			}else
			{
			Logger.log("Tab Index is not set for the link "+getElementName()+" in the page "+getPageName());
			}
		}
		return tabindex;
	}
	
	
	/**
	 * This method gets the attached text of the webelement (here weblist). This function 
	 * cannot gets the attached text of an webelement as an text associated with an webelement
	 * varies for every webpages. The below function answers various to get the associated
	 * text. Use any of the below options and get the attached text.
	 * @return - A string parameter which represents the attahed text.
	 */
	
	public String getAttachedText(){
		String attachedText="";
		WebElement attachedTextelement;
		if (curWebElement!=null){
			Logger.log("Retrieving  the associated text of weblist  "+getElementName() +"in page " +getPageName());
			/**Getting the curWebElement's parent node text */
			attachedTextelement =curWebElement.findElement(By.xpath(".."));
			attachedText=attachedTextelement.getText();
			
			/**Getting the curWebElement's parent node's next sibling text */		
			attachedTextelement =curWebElement.findElement(By.xpath("..")).findElement(By.xpath("following-sibling::*[position()=1]"));
			attachedText=attachedTextelement.getText();
			
			/**Getting the curWebElement's parent node's previous sibling text */
			attachedTextelement =curWebElement.findElement(By.xpath("..")).findElement(By.xpath("preceding-sibling::*[position()=1]"));
			attachedText=attachedTextelement.getText();
			
			/**Getting the curWebElement's following sibling text */
			attachedTextelement =curWebElement.findElement(By.xpath("following-sibling::*[position()=1]"));
			attachedText=attachedTextelement.getText();
			
			/**Getting the curWebElement's preceding sibling text */
			attachedTextelement =curWebElement.findElement(By.xpath("preceding-sibling::*[position()=1]"));
			attachedText=attachedTextelement.getText();			
			
		}else{
			Logger.log(getElementName()+ " button "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		return attachedText;
	}
	
	

	/**
	 * This method simulates keypress enter action in the WebList component in the page.
	 */
	public void keyPressEnter(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress ENTER on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.ENTER);
		}
		else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
	}
	
	/**
	 * This method simulates keypress down arrow action in the WebList component in the page.
	 */
	public void keyPressDown(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress Down key on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.ARROW_DOWN);
		}
		else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
	}
	
	/**
	 * This method simulates keypress up arrow action in the WebList component in the page.
	 */
	public void keyPressUp(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress Up key on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.ARROW_UP);
		}
		else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
	}
	
	
	/**
	 * This method simulates keypress space action in the WebList component in the page.
	 */
	public void keyPressSpace(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress SPACE on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.SPACE);
		}
		else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}
	}
	
	/**
	 * This method simulates keypress tab action in the WebList component in the page.
	 */
	public void keyPressTabOut(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress TAB on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.TAB);
		}
		else{
			Logger.log(getElementName()+ " weblist "+ "is null. Hence no operation can be performed");
		}	
	}

    /**
	 * This method automatically scrolls the page to a particular section in the page
	 * where the WebList object is visible/avalable.
	 */
	public void scrollToView(){
		if (curWebElement!=null){
			Logger.log("Performing scrolling into view action in page "+getPageName()+"for element " +getElementName());
			Locatable hoverItem = (Locatable) curWebElement;
			hoverItem.getLocationOnScreenOnceScrolledIntoView();
		}
		else {
			Logger.log("Unable to perform actions on "+getElementName()+ "in "+getPageName()+ " as it is null");
		}
	}
}
