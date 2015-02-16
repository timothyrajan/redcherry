package org.redcherry.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Logger;
import org.redcherry.utilities.Page;
import org.redcherry.utilities.Timer;

public class CheckBox extends GenericWebElement{ 
	
	/**The driver object */
	public WebDriver driver=Browser.driver;
	
	/** The Checkbox element */
	public  WebElement curWebElement;
	
	/**The Checkbox element name*/
	private String elementName;
	
	/**The Page name*/
	private String pageName;
	
	
	/**
	 * This method gets the checkbox object in the page with the help of the identifiers. The checkbox object
	 * is identified in the page by using the identifiers mentioned either in the uiobjectlocators.xml
	 * or in the uiobjectlocators.properties file.
	 * 
	 * @param WebDriver - The driver object
	 * @param String - The name of the element. This is the logical name of the checkbox component.
	 * @param className - The name of the class. This is the logical name which is given to the page.
	 */	
	public CheckBox (WebDriver driver,String elementName,String className){
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
	 * This method checks the checkbox which is in the page. This method checks if the status of the
	 * checkbox is unchecked,else it will not perform any action on the checkbbox
	 */
	public void check(){
		boolean CheckboxStatus;
		if (curWebElement!=null){
			Logger.log("Performing check operation in checkbox "+getElementName() + " in page "+getPageName());
			JavascriptExecutor js = null;		
			if (driver instanceof JavascriptExecutor) {
			    js = (JavascriptExecutor)driver;
			}
			CheckboxStatus= (Boolean) js.executeScript("return arguments[0].checked;", curWebElement);
			if (CheckboxStatus==true){
				Logger.log("Checkbox "+getElementName() + " in page "+getPageName()+" is already checked");
			}else{
				curWebElement.click();
			}
		}else{
			Logger.log(getElementName()+ " checkbox "+ "is null. Hence no operation can be performed");
		}
	}
	
	
	
	/**
	 * This method uncheck's the checkbox which is in the page. This method unchecks if the status of the
	 * checkbox is checked,else it will not perform any action on the checkbbox
	 */
	public void unCheck(){
		boolean CheckboxStatus;
			if (curWebElement!=null){
				Logger.log("Performing uncheck operation in checkbox "+getElementName() + " in page "+getPageName());
			JavascriptExecutor js = null;		
			if (driver instanceof JavascriptExecutor) {
			    js = (JavascriptExecutor)driver;
			}
			CheckboxStatus= (Boolean) js.executeScript("return arguments[0].checked;", curWebElement);
			
			if (CheckboxStatus==true){
				curWebElement.click();
			}else{
				
			}
			}else{
				Logger.log(getElementName()+ " checkbox "+ "is null. Hence no operation can be performed");
			}
	}
	
	/**
	 * This method gets the checkbox status and returns in the string format. If the status of the
	 * checkbox is checked,this method returns a status of Checked, else this method returns a 
	 * status of unchecked.
	 * @return - A string representing the status of the checkbox status.
	 */
	public String getCheckboxStatus(){
		String strCheckboxStatus="";
		boolean CheckboxStatus;
		if (curWebElement!=null){
			Logger.log("Getting the status from checkbox "+getElementName() + " in page "+getPageName());
			JavascriptExecutor js = null;		
			if (driver instanceof JavascriptExecutor) {
				js = (JavascriptExecutor)driver;
			}
			CheckboxStatus= (Boolean) js.executeScript("return arguments[0].checked;", curWebElement);
			if (CheckboxStatus==true){
				strCheckboxStatus="Checked";
			}else{
				strCheckboxStatus="UnChecked";
			}
			}
			else{
				Logger.log(getElementName()+ " checkbox "+ "is null. Hence no operation can be performed");
			}
		return strCheckboxStatus;
	}
	
	
	/**
	 * This method validates whether the checkbox is disabled or not. If the checkbox is disabled,
	 * this method returns a TRUE else will return a FALSE.
	 * @return - Boolean - A boolean value which indicates whether the checkbox is disabled or not.
	 */
	
	public boolean isDisabled(){
		boolean blnIsDisabled; 
		if (curWebElement!=null){
		blnIsDisabled=curWebElement.isEnabled();
		if (blnIsDisabled){
			blnIsDisabled=false;
		}else
		{
			blnIsDisabled=true;
		}
		}
		else{
			Logger.log(getElementName()+ " checkbox "+ " is null. Hence no operation can be performed");
			blnIsDisabled=(Boolean) null;
		}
		return blnIsDisabled;
		}
	
	
	/**
	 * This method validates whether the checkbox is enabled or not. If the checkbox is enabled,
	 * this method returns a TRUE else will return a FALSE.
	 * @return - Boolean - A boolean value which indicates whether the checkbox is enabled or not.
	 */
	public boolean isEnabled(){
		boolean blnIsEnabled; 
		if (curWebElement!=null){
			blnIsEnabled=curWebElement.isEnabled();
		if (blnIsEnabled){
			blnIsEnabled=true;
		}else
		{
			blnIsEnabled=false;
		}
		}
		else{
			Logger.log(getElementName()+ " checkbox "+ " is null. Hence no operation can be performed");
			blnIsEnabled=(Boolean) null;
		}
		return blnIsEnabled;
	}
	
	
		
	/**
	 * This method gets the innerHTML details of the checkbox . This method returns a 
	 * string value which details the innerHTML of the checkbox element in the page.
	 * @return String - The string value which details the innerHTML of the checkbox.
	 */
	public String getInnerHTML(){
		String innerhtml="";
		if (curWebElement!=null){
			Logger.log("Getting innerHTML value from "+getElementName()+ " link "+ " in page "+getPageName());
			JavascriptExecutor js = null;		
			if (driver instanceof JavascriptExecutor) {
			    js = (JavascriptExecutor)driver;
			}
			
			innerhtml=(String) js.executeScript("return arguments[0].innerHTML;", curWebElement);	
		}else{
			Logger.log(getElementName()+ " checkbox "+ " is null. Hence no operation can be performed");
		}
		
		return innerhtml;
	}
	
	
	
	/**
	 * This method gets the outerHTML details of the checkbox . This method returns a 
	 * string value which details the outerHTML of the checkbox element in the page.
	 * @return String - The string value which details the outerHTML of the checkbox.
	 */
	public String getOuterHTML(){
		String outerhtml="";
		JavascriptExecutor js = null;
		if (curWebElement!=null){
			Logger.log("Getting outerHTML value from "+getElementName()+ " link "+ " in page "+getPageName());
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		
		outerhtml=(String) js.executeScript("return arguments[0].outerHTML;", curWebElement);
		}else{
			Logger.log(getElementName()+ " checkbox "+ " is null. Hence no operation can be performed");
		}
		return outerhtml;
	}
	
	
	/**
	 * This method gets the attached text of the webelement (here checkbox). This function 
	 * cannot gets the attached text of an webelement as an text associated with an webelement
	 * varies for every webpages. The below function answers various options to get the associated
	 * text. Use any of the below options and get the attached text.
	 * @return - A string parameter which represents the attahed text.
	 */
	
	public String getCheckboxlabel(){
		String attachedText="";
		WebElement attachedTextelement;
		if (curWebElement!=null){
			Logger.log("Retrieving  the associated text of checkbox  "+getElementName() +"in page " +getPageName());
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
	 * This method gets the tab index to reach out to the checkbox by keypress tab action.
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
			Logger.log("Tab Index is not set for the checkbox "+getElementName()+" in the page "+getPageName());
			}
		}
		return tabindex;
	}
	
	
	/**
	 * This method gets the tooltip text when hovered over the checkbox object in the string format.
	 * @return - String - A string representing the tooltip text.
	 */
	 public String getToolTipText()
	{
		
		 String strTooltip="";
			if (curWebElement!=null){
				Logger.log("Getting the tooltip text value from "+getElementName() + " in page "+getPageName());
				strTooltip=curWebElement.getAttribute("title");
			}else{
				Logger.log(getElementName()+ " checkbox "+ " is null. Hence no operation can be performed");
			}
			return strTooltip;
	}
	
	/**
	 * This method fires the event associated with the checkbox object.
	 * @param - String- The event name in a string format.
	 */
	public void fireEvent(String eventName){
		if (curWebElement!=null){
			Logger.log("Performing "+eventName+ "on checkbox "+getElementName()+" in "+getPageName()+" page");
			JavascriptLibrary javascript = new JavascriptLibrary();
			javascript.callEmbeddedSelenium(driver, "triggerEvent", curWebElement,eventName);		
		}else{
			Logger.log(getElementName()+ " checkbox "+ " is null. Hence no operation can be performed");
		}
	}	
	
	
	
	
	/**
	 * This method verifies the focus on the checkbox webelement in the page.
	 * This will be implemented in the coming releases
	 */	
	@SuppressWarnings("unused")
	private boolean hasFocus(){
		boolean hasFocus=false;
		return hasFocus;
	}
	
	
	/**
	 * This method clicks on the checkbox and waits for a predefined period of time which is 
	 * passed as an parameter
	 * @param - Integer - An integer value which denotes the time in seconds.
	 * This will be implemented in the coming releases
	 */
	public void clickAndWait(int sec){
		
		if (curWebElement!=null){
			Logger.log("Clicking on " +getElementName()+ "in "+getPageName()+" page and waiting for "+sec +" seconds");
			curWebElement.click();
			try {
				Timer.wait(sec);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Logger.log("Unable to perform actions on "+getElementName()+ " in "+getPageName()+ " as it is null");
		}
	}
	
	
	/**
	 * This method simulates keypress enter action in the checkbox component in the page.
	 */
	public void keyPressEnter(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress ENTER on " +getElementName()+ " in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.ENTER);
		}
		else{
			Logger.log(getElementName()+ " checkbox "+ " is null. Hence no operation can be performed");
		}
	}
	
	/**
	 * This method simulates keypress space action in the checkbox component in the page.
	 */
	public void keyPressSpace(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress SPACE on " +getElementName()+ " in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.SPACE);
		}
		else{
			Logger.log(getElementName()+ " checkbox "+ " is null. Hence no operation can be performed");
		}
	}
	
	/**
	 * This method simulates keypress tab action in the checkbox component in the page.
	 */
	public void keyPressTabOut(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress TAB on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.TAB);
		}
		else{
			Logger.log(getElementName()+ " checkbox "+ " is null. Hence no operation can be performed");
		}				
	}
	

	/**
	 * This method sets the focus on the checkbox webelement in the page.
	 * This will be implemented in the coming releases
	 */	
	@SuppressWarnings("unused")
	private void setFocus(){
	}
}