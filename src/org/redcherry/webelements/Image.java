package org.redcherry.webelements;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.redcherry.utilities.Logger;
import org.redcherry.utilities.Page;
import org.redcherry.utilities.Timer;

public class Image extends GenericWebElement{
	
	/** The Image element */
	public  WebElement curWebElement;
	
	/**The Image element name*/
	private String elementName;
	
	/**The Page name*/
	private String pageName;
	
	
	/**
	 * This method gets the Image object in the page with the help of the identifiers. The image object
	 * is identified in the page by using the identifiers mentioned either in the uiobjectlocators.xml
	 * or in the uiobjectlocators.properties file.
	 * 
	 * @param WebDriver - The driver object
	 * @param String - The name of the element. This is the logical name of the image component.
	 * @param className - The name of the class. This is the logical name which is given to the page.
	 */	
	public Image (WebDriver driver,String elementName,String className){
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
	 * @return String value which indicates the element name
	 */
	private String getElementName(){
		return this.elementName;
	}
	
	
	/**
	 * This method clicks the image element.
	 * @return nothing.
	 */
	public void click(){
		if (curWebElement!=null){
			Logger.log("Performing click operation  on "+getElementName()+" image  in "+getPageName()+" page");
			curWebElement.click();
		}else{
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");
		}		
	}
	
	
	/**
	 * This method gets the tooltip text when hovered over the image object in the string format.
	 * @return - String - A string representing the tooltip text.
	 */
	public String getToolTipText(){
		String ToolTipText="";
		if (curWebElement!=null){
			Logger.log("Getting the tooltip text value from "+getElementName() + "image in page "+getPageName());
			ToolTipText=curWebElement.getAttribute("title");
			if (ToolTipText.length()>0){
			}else
			{
				ToolTipText=curWebElement.getAttribute("alt");
			}
		}else{
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");
		} 
		return ToolTipText;
	}
	
	
	/**
	 * This function verifies whether the image object is displayed in the page  
	 * or not. The function returns TRUE if the image object is displayed in the page,
	 * else it will return a FALSE
	 * @return - Boolean - A boolean value indicating whether the image object is displayed or not.
	 */
	public boolean isDisplayed(){
		boolean isDisplayed;
		if (curWebElement!=null){
			Logger.log("Verifying whether the  "+getElementName() + "image in page "+getPageName()+ " is displayed");
			isDisplayed=curWebElement.isDisplayed();
		}else{
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");
			isDisplayed=(Boolean) null;
		}
		return isDisplayed;
	}
	
	
	/**
	 * This function gets the height of the image which is displayed in the page.
	 * @return - String - A string value representing the height of the image.
	 */
	public int getHeight(){
		int height=0;
		if(curWebElement!=null) {
			Logger.log("Getting height value of " +getElementName()+ " in "+getPageName()+" page");
		
		if (curWebElement.isDisplayed()){
			 height=curWebElement.getSize().getHeight();
			 return height;
		}else{
			height=Integer.parseInt("99999");
			Logger.log("Link " +getElementName()+ " is not displayed "+ " in "+getPageName()+" page");
		}}
		else
		{
			height=Integer.parseInt("99999");
			Logger.log(getElementName()+ " image "+ " is null. Hence no operation can be performed");			
		}
		return height;
	}
	
	
	/**
	 * This function gets the width of the image which is displayed in the page.
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
			width=Integer.parseInt("99999");
			Logger.log("Link " +getElementName()+ " is not displayed "+ " in "+getPageName()+" page");
		}}
		else
		{
			width=Integer.parseInt("99999");
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");			
		}
		return width;
	}

	
	/**
	 * This method gets the innerHTML details of the image . This method returns a 
	 * string value which details the innerHTML of the image element in the page.
	 * @return String - The string value which details the innerHTML of the image.
	 */
	public String getInnerHTML(){
		String innerhtml="";
		if (curWebElement!=null){
			Logger.log("Getting innerHTML value from "+getElementName()+ " link "+ "in page "+getPageName());
			JavascriptExecutor js = null;		
			if (driver instanceof JavascriptExecutor) {
			    js = (JavascriptExecutor)driver;
			}
			
			innerhtml=(String) js.executeScript("return arguments[0].innerHTML;", curWebElement);	
		}else{
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");
		}
		
		return innerhtml;
	}
	
	
	/**
	 * This method gets the outerHTML details of the image . This method returns a 
	 * string value which details the outerHTML of the image element in the page.
	 * @return String - The string value which details the outerHTML of the image.
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
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");
		}
		return outerhtml;
	}
	
	
	/**
	 * This method gets the attached text of the webelement (here image). This function 
	 * cannot gets the attached text of an webelement as an text associated with an webelement
	 * varies for every webpages. The below function answers various options to get the associated
	 * text. Use any of the below options and get the attached text.
	 * @return - A string parameter which represents the attahed text.
	 */
	
	public String getAttachedText(){
		String attachedText="";
		WebElement attachedTextelement;
		if (curWebElement!=null){
			Logger.log("Retrieving  the associated text of image  "+getElementName() +"in page " +getPageName());
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
	 * This method gets the tab index to reach out to the image by keypress tab action.
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
			Logger.log("Tab Index is not set for the image "+getElementName()+" in the page "+getPageName());
			}
		}
		return tabindex;
	}
	
	
	
		
	
	
	/**
	 * This method retrieves the border thickness of the image.
	 * @return Integer  - An integer value indicating the the border thickness of the image.
	 */
	public int getBorderThickness(){
		int borderThickness=0;
		return borderThickness;
	}
	
	
	/**
	 * This method retrieves the href of the image object in the page
	 * @return String  - String value indicating the hyperlink (URL) of the image object.
	 */
	public String getHref() {
		
		String strUrl="";
		if(curWebElement!=null) {
			Logger.log("Getting href value of " +getElementName()+ "in "+getPageName()+" page");
		
		if (curWebElement.isDisplayed()){
			strUrl=curWebElement.getAttribute("href");	
			
		}else{
			Logger.log("Image " +getElementName()+ " is not displayed "+ "in "+getPageName()+" page");
		}}
		else
		{
			strUrl="";
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");			
		}
				
		return strUrl;		
	}
	
	
	/**
	 * This method retrieves the src value of the image in the page. 
	 * @return String value detailing the src value
	 */
	public String getImageSrc(){
		
		String imageSrc="";
		JavascriptExecutor js = null;
		if (curWebElement!=null){
			Logger.log("Getting image src value from "+getElementName()+ " link "+ "in page "+getPageName());
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		
		imageSrc=(String) js.executeScript("return arguments[0].attributes['src'].value;", curWebElement).toString();
		}else{
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");
		}
		return imageSrc;
		
	}
	
	
	/**
	 * This method fires the event associated with the link object.
	 * @param - String- The event name in a string format.
	 */
	public void fireEvent(String eventName){
		
		if (curWebElement!=null){
			Logger.log("Performing "+eventName+ "on image "+getElementName()+" in "+getPageName()+" page");
			JavascriptLibrary javascript = new JavascriptLibrary();
			javascript.callEmbeddedSelenium(driver, "triggerEvent", curWebElement,eventName);		
		}else{
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");
		}
	}	
		
	
	
	
	/**
	 * This method verifies whether clicking on the image results in a launch of a new browser window
	 * or whether the page in the browser gets changed with a page load by clicking on the image.
	 * 
	 * @return - Boolean - Boolean value indicating that a new browser window getting launched
	 * by clicking on the image
	 */
	public boolean isOpenedNewWinow() {
		boolean blnOpenednew=false;        
        int isizeBefore=0;
        int isizeAfter=0;
        
        if (curWebElement!=null){
        
        Logger.log("Verifying whether the image "+ getElementName()+ " in page "+ getPageName()+ " opens a new window when clicked");	
        /** get the window handles before click on the link */
        Set<String> sBefore=driver.getWindowHandles();
        String curWindowandle=driver.getWindowHandle();
        isizeBefore=sBefore.size();
        
        /** click on the link */
        curWebElement.click();        
        
        /** get the window handles after click on the link */
        Set<String> sAfter=driver.getWindowHandles();
        isizeAfter=sAfter.size();
        
        /** If number of window handles after click is greater than number of 
         * window handles before the click,blnOpenednew is set to TRUE
         */
        if (isizeAfter>isizeBefore) {
            blnOpenednew=true;
            if (sAfter.size()>1){
            	
            	for (String handle : driver.getWindowHandles()) {
            		if (!(curWindowandle.contains(handle))) {
            			driver.switchTo().window(handle);
            			driver.close();
            			driver.switchTo().window(curWindowandle);
            			break;
            		}
            	}	
            }
         }
        }else{
        	Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed in page "+getPageName());
        }
        return blnOpenednew;
    }
	
	
	/**
	 * This method sets the focus on the image webelement in the page.
	 * This will be implemented in the coming releases
	 */	
	@SuppressWarnings("unused")
	private boolean hasFocus(){
		boolean hasFocus=false;
		return hasFocus;
	}
	
	/**
	 * This method clicks on a image in a webpage and waits for a particular period of 
	 * time indicated in seconds
	 */
	public void clickAndWait(int sec){
		if (curWebElement!=null){
			Logger.log("Clicking on " +getElementName()+ " in "+getPageName()+" page and waiting for "+sec +" seconds");
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
	 * This method simulates keypress enter action in the image component in the page.
	 */
	public void keyPressEnter(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress ENTER on " +getElementName()+ " in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.ENTER);
		}
		else{
			Logger.log(getElementName()+ " image "+ "is null. Hence no operation can be performed");
		}
	}
	
	
	/**
	 * This method simulates keypress space action in the image component in the page.
	 */
	public void keyPressSpace(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress SPACE on " +getElementName()+ " in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.SPACE);
		}
		else{
			Logger.log(getElementName()+ " image "+  " is null. Hence no operation can be performed");
		}
	}
	
	/**
	 * This method simulates keypress tab action in the image component in the page.
	 */
	public void keyPressTabOut(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress TAB on " +getElementName()+ " in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.TAB);
		}
		else{
			Logger.log(getElementName()+ " image "+ " is null. Hence no operation can be performed");
		}		
	}

	/**
	 * This method sets the focus on the image webelement in the page
	 * This will be implemented in the coming releases
	 */
	@SuppressWarnings("unused")
	private void setFocus(){
		JavascriptExecutor js = null;		
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}		
		js.executeScript("return arguments[0].focus();", curWebElement);
	}
}
