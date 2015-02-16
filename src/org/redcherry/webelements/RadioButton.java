package org.redcherry.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Logger;
import org.redcherry.utilities.Page;

public class RadioButton  extends GenericWebElement{
	
	
	/** The driver object */
	static WebDriver driver=Browser.driver;	
	
	/** The RadioButton element */
	public  WebElement curWebElement;
	
	/**The RadioButton element name*/
	private String elementName;
	
	/**The Page name*/
	private String pageName;
	
	
	/**
	 * This method gets the RadioButton object in the page with the help of the identifiers. The RadioButton
	 * object is identified in the page by using the identifiers mentioned either in the uiobjectlocators.xml
	 * or in the uiobjectlocators.properties file. 
	 * @param WebDriver - The driver object.
	 * @param String - The name of the element. This is the logical name of the radiobutton component.
	 * @param className - The name of the class. This is the logical name which is given to the page.
	 */	
	public RadioButton (WebDriver driver,String elementName,String className){
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
	 * This method selects a radiobutton in the page by clicking on the radio button
	 */
	public void select(){
		if (curWebElement!=null){
			Logger.log("Selecting " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.click();
		}else{
			Logger.log(getElementName()+ " radiobutton "+ "is null. Hence no operation can be performed");
		}
	}
	
	
	/**
	 * This method returns the status of the radio button. Whether it is selected or NOT
	 * @return - String - A string value which represents whethe the radio button is
	 * selected or Not Selected.
	 */
	public String getRadioButtonStatus(){
		String radioButtonStatus="NotSelected";		
		if (curWebElement!=null){
			Logger.log("Retrieving the select status of radiobutton " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.isSelected();
			radioButtonStatus="Selected";			
		}else{
			Logger.log(getElementName()+ " radiobutton "+ "is null. Hence no operation can be performed");
			radioButtonStatus="";
		}
		return radioButtonStatus;
	}
	
	/**
	 * This method returns a boolean value indicating whether it is selected or NOT
	 * @return - String - A boolean vaue which represents whethe the radio button is
	 * selected or Not Selected.
	 */
	public boolean isSelected(){
		boolean isSelected=false;
		if (curWebElement!=null){
			Logger.log("Retrieving the select status of radiobutton " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.isSelected();
			isSelected=true;			
		}else{
			Logger.log(getElementName()+ " radiobutton "+ "is null. Hence no operation can be performed");
			isSelected=false;
		}
		return isSelected;
	}
	

	
	/**
	 * This method gets the attached text of the webelement (here radiobutton). This function 
	 * cannot gets the attached text of an webelement as an text associated with an webelement
	 * varies for every webpages. The below function answers various to get the associated
	 * text. Use any of the below options and get the attached text.
	 * @return - A string parameter which represents the attahed text.
	 */
	
	public String getAttachedText(){
		String attachedText="";
		WebElement attachedTextelement;
		if (curWebElement!=null){
			Logger.log("Retrieving  the associated text of button  "+getElementName() +"in page " +getPageName());
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
	 * This method validates whether the radio button object in the page is disabled or not.
	 * This function returns a boolean value which indicates whether the radiobutton is disabled 
	 * or not.The boolean value is TRUE if the radiobutton is disabled. The boolean value is FALSE 
	 * if the radiobutton is enabled.
	 * 
	 * * @return - Boolean -The boolean value indicating the disabled state of radiobutton
	 */
	public boolean isDisabled(){
		boolean isDisabled=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether the radiobutton "+getElementName()+"is disabled in the "+getPageName()+" page");
			if (curWebElement.isEnabled()){
				isDisabled=false;
			}else
			{
				isDisabled=true;
			}
		}else{
			Logger.log(getElementName()+ " radiobutton "+ "is null. Hence no operation can be performed");
			isDisabled=(Boolean) null;
		}
		return isDisabled;
	}
	
	/**
	 * This method validates whether the radio button object in the page is enabled or not.
	 * This function returns a boolean value which indicates whether the radiobutton is enabled 
	 * or not.The boolean value is TRUE if the radiobutton is enabled. The boolean value is FALSE 
	 * if the radiobutton is disabled.
	 * 
	 * * @return - Boolean -The boolean value indicating the enabled state of radiobutton
	 */
	public boolean isEnabled(){
		boolean isEnabled=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether the link "+getElementName()+"is enabled in the "+getPageName()+" page");
			if (curWebElement.isEnabled()){
				isEnabled=true;
			}else
			{
				isEnabled=false;
			}
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");
			isEnabled=(Boolean) null;
		}
		return isEnabled;
	}
	
	/**
	 * This method returns the label of the radio button in a string format
	 * @return - String - A string value which represents the label of the radio button.
	 */
	public String getRadioButtonlabel(){
		String radioButtonlabel="";
		return radioButtonlabel;
	}
	
	/**
	 * This method gets the innerHTML details of the radiobutton . This method returns a 
	 * string value which details the innerHTML of the radiobutton element in the page.
	 * @return String - The string value which details the innerHTML of the radiobutton element.
	 */
	public String getInnerHTML(){
		String innerhtml="";
		if (curWebElement!=null){
			Logger.log("Getting innerHTML value from "+getElementName()+ " radiobutton "+ "in page "+getPageName());
			JavascriptExecutor js = null;		
			if (driver instanceof JavascriptExecutor) {
			    js = (JavascriptExecutor)driver;
			}
			
			innerhtml=(String) js.executeScript("return arguments[0].innerHTML;", curWebElement);	
		}else{
			Logger.log(getElementName()+ " radiobutton "+ "is null. Hence no operation can be performed");
		}
		
		return innerhtml;
	}
	
	/**
	 * This method gets the outerHTML details of the radiobutton. This method returns a 
	 * string value which details the outerHTML of the radiobutton element in the page.
	 * 
	 * @return String - The string value which details the outerHTML of the radiobutton.
	 */
	public String getOuterHTML(){
		String outerhtml="";
		JavascriptExecutor js = null;
		if (curWebElement!=null){
			Logger.log("Getting outerHTML value from "+getElementName()+ " radiobutton "+ "in page "+getPageName());
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		
		outerhtml=(String) js.executeScript("return arguments[0].outerHTML;", curWebElement);
		}else{
			Logger.log(getElementName()+ " radiobutton "+ "is null. Hence no operation can be performed");
		}
		return outerhtml;
	}
	
	/**
	 * This method gets the tab index to reach out to the RadioButton by keypress tab action.
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
			Logger.log("Tab Index is not set for the radiobutton "+getElementName()+" in the page "+getPageName());
			}
		}
		return tabindex;
	}
	
	

	/**
	 * This method sets the focus on the webelement in the page
	 */
	@SuppressWarnings("unused")
	private void setFocus(){
	
		}
		
	
	/**
	  * This method verifies whether the radiobutton has the focus in the webpage or not 
	  * 
	  * @return-Boolean - A boolean value which indicates whether the radiobutton has focus 
	  * or not
	  */
	@SuppressWarnings("unused")
	private boolean hasFocus(){
		boolean hasFocus=false;
		return hasFocus;
	}

	/**
	 * This method simulates keypress enter action in the RadioButton component in the page.
	 */
	public void keyPressEnter(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress ENTER on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.ENTER);
		}
		else{
			Logger.log(getElementName()+ " radiobutton "+ "is null. Hence no operation can be performed");
		}
	}

	/**
	 * This method simulates keypress space action in the RadioButton component in the page.
	 */
	public void keyPressSpace(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress SPACE on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.SPACE);
		}
		else{
			Logger.log(getElementName()+ " radiobutton "+ "is null. Hence no operation can be performed");
		}
	}

	/**
	 * This method simulates keypress tab action in the RadioButton component in the page.
	 */
	public void keyPressTabOut(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress TAB on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.TAB);
		}
		else{
			Logger.log(getElementName()+ " radiobutton "+ "is null. Hence no operation can be performed");
		}		
	}
	


}
