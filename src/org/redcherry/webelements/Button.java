package org.redcherry.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Logger;
import org.redcherry.utilities.Page;

public class Button extends GenericWebElement{

	/** The Button element */
	private  WebElement curWebElement;

	/**The button name*/
	private String elementName;

	/**The Page name*/
	private String pageName;


	/**
	 * This method gets the button object in the page with the help of the identifiers. The button object
	 * is identified in the page by using the identifiers mentioned either in the uiobjectlocators.xml
	 * or in the uiobjectlocators.properties file.
	 * 
	 * @param WebDriver - The driver object
	 * @param String - The name of the element. This is the logical name of the button component.
	 * @param className - The name of the class. This is the logical name which is given to the page.
	 */	
	public Button (WebDriver driver,String elementName,String className){
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
		 * This method clicks on the button in the page.
		 */
	public void click(){
		if (curWebElement!=null){
			Logger.log("Performing click operation  on "+getElementName()+" button  in "+getPageName()+" page");
			curWebElement.click();
		}else{
			Logger.log(getElementName()+ " button "+ " is null. Hence no operation can be performed");
		}

	}

	/**
	 * This method simulates keypress enter action in the editbox.
	 */
	public void keyPressEnter(){
		if (curWebElement!=null){
			Logger.log("Simulating keypress ENTER on " +getElementName()+ " in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.ENTER);
		}else{
			Logger.log(getElementName()+ " button "+ " is null. Hence no operation can be performed");	
		}
	}

	/**
	 * This method simulates keypress Space action in the editbox.
	 */
	public void keyPressSpace(){
		if (curWebElement!=null){
			Logger.log("Simulating keypress SPACE on " +getElementName()+ " in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.SPACE);
		}else{
			Logger.log(getElementName()+ " button "+ " is null. Hence no operation can be performed");	
		}
	}

	/**
	 * This method simulates keypress Tab action in the editbox.
	 */
	public void keyPressTabOut(){
		if (curWebElement!=null){
			Logger.log("Simulating keypress TAB on " +getElementName()+ " in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.TAB);
		}else{
			Logger.log(getElementName()+ " button "+ " is null. Hence no operation can be performed");	
		}
	}

	/**
	 * This function gets the height of the button which is displayed in the page.
	 * @return - String - A int value representing the height of the image.
	 */
	public int getHeight(){

		int height=0;
		if(curWebElement!=null) {
			Logger.log("Getting height value of " +getElementName()+ " in "+getPageName()+" page");

			if (curWebElement.isDisplayed()){
				height=curWebElement.getSize().getHeight();
				return height;
			}else{
				height=0;
				Logger.log("Button " +getElementName()+ " is not displayed "+ "in "+getPageName()+" page");
			}}
		else
		{
			height=Integer.parseInt("99999");
			Logger.log(getElementName()+ " button "+ " is null. Hence no operation can be performed");			
		}
		return height;
	}

	/**
	 * This function gets the width of the button which is displayed in the page.
	 * @return - String - A string value representing the width of the image.
	 */
	public int getWidth(){
		int width=0;
		if(curWebElement!=null) {
			Logger.log("Getting width value of " +getElementName()+ " in "+getPageName()+" page");

			if (curWebElement.isDisplayed()){
				width=curWebElement.getSize().getWidth();
				return width;
			}else{
				width=0;
				Logger.log("Button " +getElementName()+ " is not displayed "+ "in "+getPageName()+" page");
			}}
		else
		{
			width=Integer.parseInt("99999");
			Logger.log(getElementName()+ " button "+ "is null. Hence no operation can be performed");			
		}
		return width;
	}

	/**
	 * This method automatically scrolls the page to a particular section in the page
	 * where the button object is visible/avalable.
	 */
	public void scrollIntoView(){
		if (curWebElement!=null){
			Logger.log("Performing scrolling into view action in page "+getPageName()+"for element " +getElementName());
			Locatable hoverItem = (Locatable) curWebElement;
			hoverItem.getLocationOnScreenOnceScrolledIntoView();
		}
		else {
			Logger.log("Unable to perform actions on "+getElementName()+ "in "+getPageName()+ " as it is null");
		}
	}


	/**
	 * This method gets the attached text of the webelement (here button). This function 
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
	 * This method moves the mouse pointer and hovers over the button object in the page.
	 */ 
	public void hover(){
		if (curWebElement!=null){
			Logger.log("Performing hover operation on the button  "+getElementName() +"in page " +getPageName());
			Locatable hoverItem = (Locatable) curWebElement;
			Mouse mouse = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem.getCoordinates());
		}
		else {
			Logger.log(getElementName()+ " button "+ "is null. Hence no operation can be performed in page "+getPageName());
		}


		/**
		 * This is a back up code which can be used to hover over an button. Please use the below 
		 * code snippet if the active code for moveMouseOverLink does not work.
		 */
		//Actions action = new Actions(driver); 
		//action.moveToElement(element); 
		//action.clickAndHold(element).build().perform(); 
	}


	/**
	 * This method gets the tab index to reach out to the button by keypress tab action.
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
				Logger.log("Tab Index is not set for the button "+getElementName()+" in the page "+getPageName());
			}
		}
		return tabindex;
	}


	/**
	 * This method gets the innerHTML details of the button . This method returns a 
	 * string value which details the innerHTML of the button element in the page.
	 * @return String - The string value which details the innerHTML of the button.
	 */
	public String getInnerHTML(){
		String innerhtml="";
		if (curWebElement!=null){
			Logger.log("Getting innerHTML value from "+getElementName()+ " button "+ "in page "+getPageName());
			JavascriptExecutor js = null;		
			if (driver instanceof JavascriptExecutor) {
				js = (JavascriptExecutor)driver;
			}

			innerhtml=(String) js.executeScript("return arguments[0].innerHTML;", curWebElement);	
		}else{
			Logger.log(getElementName()+ " button "+ "is null. Hence no operation can be performed");
		}

		return innerhtml;
	}


	/**
	 * This method gets the outerHTML details of the button . This method returns a 
	 * string value which details the outerHTML of the button element in the page.
	 * @return String - The string value which details the outerHTML of the button.
	 */
	public String getOuterHTML(){
		String outerhtml="";
		JavascriptExecutor js = null;
		if (curWebElement!=null){
			Logger.log("Getting outerHTML value from "+getElementName()+ " button "+ "in page "+getPageName());
			if (driver instanceof JavascriptExecutor) {
				js = (JavascriptExecutor)driver;
			}

			outerhtml=(String) js.executeScript("return arguments[0].outerHTML;", curWebElement);
		}else{
			Logger.log(getElementName()+ " button "+ "is null. Hence no operation can be performed");
		}
		return outerhtml;
	}


	/**
	 * This method gets the tooltip text from the button object in the string format.
	 * @return - String - A string value indicating tooltip text.
	 */
	public String getTooltipText(){
		String strTooltip="";
		if (curWebElement!=null){
			Logger.log("Getting the tooltip text value from "+getElementName() + " in page "+getPageName());
			strTooltip=curWebElement.getAttribute("title");
		}else{
			Logger.log(getElementName()+ " button "+ "is null. Hence no operation can be performed");
		}
		return strTooltip;
	}


	/**
	 * This method gets the label text from the button object in the string format.
	 * @return - String - A string value indicating label text of the button object.
	 */
	public String getLabel(){
		String strLabel="";
		if (curWebElement!=null){
			Logger.log("Getting the label text value from "+getElementName() + " in page "+getPageName());
			strLabel=curWebElement.getAttribute("value");
		}else{
			Logger.log(getElementName()+ " button "+ " is null. Hence no operation can be performed");
		}
		return strLabel;
	}




	/**
	 * This method sets the focus on the image webelement in the page.
	 * This will be implemented in the coming releases
	 */	
	@SuppressWarnings("unused")
	private boolean setFocus(){
		boolean focus=false;
		return focus;
	}


	/**
	 * This method verifies the focus on the button webelement in the page.
	 * This will be implemented in the coming releases
	 */	
	@SuppressWarnings("unused")
	private boolean	hasfocus() {
		boolean hasFocus=false;
		return hasFocus;
	}


}
