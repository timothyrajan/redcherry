package org.redcherry.webelements;


import java.awt.Color;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Logger;
import org.redcherry.utilities.Page;
import org.redcherry.utilities.Timer;


public class Link extends GenericWebElement{
		
	/** The link element */
	private WebElement curWebElement;
	
	/**The Element Name */
	private String elementName;
	
	/**The page Name */
	private String pageName;
	
	
	/**
	 * This method gets the link object in the page with the help of the identifiers. The link object
	 * is identified in the page by using the identifiers mentioned either in the uiobjectlocators.xml
	 * or in the uiobjectlocators.properties file.
	 * 
	 * @param WebDriver - The driver object
	 * @param String - The name of the element. This is the logical name of the link component.
	 * @param className - The name of the class. This is the logical name which is given to the page.
	 */	
	public Link (WebDriver driver,String elementName,String className){
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
	 * This method clicks the link element.
	 * @return nothing.
	 */
	public void click(){	
		if (curWebElement!=null){
			Logger.log("Clicking link " +getElementName()+ " in "+getPageName()+" page");
			curWebElement.click();
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
	}
	
	
	/**
	 * This method verifies whether the link in the page is broken or not. This method returns a 
	 * boolean value of false if the link is broken. Else, this method will return a true.
	 * 
	 * @return boolean - The boolean value indicates whether broken status of the link
	 */
	private boolean verifyLinkbroken() {		
		
		boolean blnLinkBroken=true;
			String sURL=curWebElement.getAttribute("href");			
			int iURLcode=1;
			try {
				iURLcode=this.getResponseCode(sURL);
			} 
			
			catch (Throwable t) 
			{	
				
			}
			
			if (iURLcode==200){
				blnLinkBroken=false;	
			}
		
		return blnLinkBroken;
	}
	
	
	/**
	 * This method gets the innerHTML details of the link . This method returns a 
	 * string value which details the innerHTML of the link element in the page.
	 * 
	 * @return String - The string value which details the innerHTML of the link.
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
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		
		return innerhtml;
	}
	
	
	
	/**
	 * This method verifies whether the link is displayed in the webpage . This method returns a 
	 * boolean value which details whether the link element is displayed in the page.
	 * 
	 * @return Boolean - boolean value which details the display status of the link.
	 */
	public boolean isLinkDisplayed(){		
		boolean isDisplayed=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether the link "+getElementName()+" is displayed in the "+getPageName()+" page");
			if (curWebElement.isDisplayed()){
				isDisplayed=true;
			}else
			{
				isDisplayed=false;
			}
		}else{
			Logger.log(getElementName()+ " link "+ " is null. Hence no operation can be performed in page "+getPageName());
			isDisplayed=(Boolean) null;
		}
		return isDisplayed;
	}
	
	
	/**
	 * This method gets the outerHTML details of the link . This method returns a 
	 * string value which details the outerHTML of the link element in the page.
	 * 
	 * @return String - The string value which details the outerHTML of the link.
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
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		return outerhtml;
	}
	
	
	/**
	 * This method gets the response code of the href which is associated with the link.
	 * @return integer - An integer value which details the response code of the href 
	 * associated with the link.
	 */
	private int getResponseCode(String sUrl) throws MalformedURLException,IOException{
		int igetCode=0; 
		URL ur=new URL(sUrl);
		HttpURLConnection huc=(HttpURLConnection) ur.openConnection();		
		huc.setRequestMethod("GET"); //get the response code if not 200 then broken
		huc.connect();
		igetCode=huc.getResponseCode();	
		System.out.println(igetCode);
     	return igetCode;	
	}
	
	/**
	 * This method validates whether the link is broken or not. This method returns a FALSE if 
	 * the link is not broken, else this method returns TRUE which indicates the link is BROKEN
	 * @return Boolean - A boolean value which details the broken link status of the link.
	 */
	public boolean isLinkBroken() {
		boolean blinkBroken=true;	
		if (curWebElement!=null){
			Logger.log("Verifying whether "+getElementName()+ " link "+ "in page "+getPageName() +" is broken");
			blinkBroken=verifyLinkbroken();
		}	else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		return blinkBroken;		
	}
	
	/**
	 * This method returns the display text (linktext) of the link in the page
	 * @return String - A string detailing the display text (linktext) of the link  
	 */
	public String getDisplayText()
		{
		String strdisplayText="";
		if (curWebElement!=null){
		Logger.log("Getting display text  from "+ getElementName() +" link on Page "+getPageName() +"Page");	
		JavascriptExecutor js = null;		
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		strdisplayText=(String) js.executeScript("return arguments[0].textContent;", curWebElement);
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		return strdisplayText;
		}
	
	/**
	 * This method verifies whether the link is a redirecting link or a non-redirecting link.
	 * @return Boolean - A boolean value details whether the link is a redirecting link or not.
	 * if the link is a redirecting link, the method returns a TRUE, else it returns a FALSE
	    
	 */
	@SuppressWarnings("unused")
	private boolean isRedirectingLink() {
		boolean bRedirects=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether "+ getElementName() +" link on Page "+getPageName() +"Page id redirecting or not");
		try{
			bRedirects=verifyRedirectingLink();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		return bRedirects;
	}
	
	/**
	 * This method verifies whether the link is a redirecting link or a non-redirecting link.
	 * @return Boolean - A boolean value details whether the link is a redirecting link or not.
	 * if the link is a redirecting link, the method returns a TRUE, else it returns a FALSE
	    
	 */
	private boolean verifyRedirectingLink() throws Exception
	{
		String sUrl;		
		boolean breDirects=false;
		sUrl=curWebElement.getAttribute("href");
		System.out.println("sURL  "+sUrl);
		URL ur=new URL(sUrl);
		HttpURLConnection huc=(HttpURLConnection) ur.openConnection();
		breDirects=huc.getFollowRedirects();
		return breDirects; 
	}
	
	
	/**
	 * This method validates whether the link is enabled or not. This function returns
	 * a boolean value which indicates whether the link is enabled or not.The boolean value
	 * is TRUE if the link is enabled. The boolean value is FALSE if the link is disabled.
	 */
	public boolean isLinkEnabled(){		
		boolean isEnabled=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether the link "+getElementName()+" is enabled in the "+getPageName()+" page");
			if (curWebElement.isEnabled()){
				isEnabled=true;
			}else
			{
				isEnabled=false;
			}
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
			isEnabled=(Boolean) null;
		}
		return isEnabled;
	}
	
	
	/**
	 * This method validates whether the link object in the page is disabled or not. This function returns
	 * a boolean value which indicates whether the link is disabled or not.The boolean value
	 * is TRUE if the link is disabled. The boolean value is FALSE if the link is enabled.
	 */
	public boolean isLinkDisabled(){
		boolean isDisabled=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether the link "+getElementName()+" is disabled in the "+getPageName()+" page");
			if (curWebElement.isEnabled()){
				isDisabled=false;
			}else
			{
				isDisabled=true;
			}
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
			isDisabled=(Boolean) null;
		}
		return isDisabled;
	}
	

	/**
	 * This method gets the tooltip text when hovered over the link object in the string format.
	 * @return - String - A string representing the tooltip text. 
	 */
	public String getToolTipText()
	{
		String strTooltip="";
		if (curWebElement!=null){
			Logger.log("Getting the tooltip text value from link "+getElementName() + " in page "+getPageName());
			strTooltip=curWebElement.getAttribute("title");
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		return strTooltip;
	}
	
	/**
	 * This method verifies whether clicking on the link results in a launch of a new browser window
	 * or whether the page in the browser gets changed with a page load by clicking on the link.
	 * 
	 * @return - Boolean - Boolean value indicating that a new browser window getting launched
	 * by clicking on the link
	 */
	public boolean isOpenedNewWinow() {
        boolean blnOpenednew=false;        
        int isizeBefore=0;
        int isizeAfter=0;
        
        if (curWebElement!=null){
        
        Logger.log("Verifying whether the link "+ getElementName()+ " in page "+ getPageName()+ " opens a new window when clicked");	
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
        	Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
        }
        return blnOpenednew;
    }
	
	/**
	 * This method retrieves the href of the link object in the page
	 * @return String  - String value indicating the hyperlink (URL) of the link object.
	 */
	public String getHref() {
		String strUrl="";
		if (curWebElement!=null){
			Logger.log("Getting href value of link " +getElementName()+ " in "+getPageName()+" page");
			strUrl=curWebElement.getAttribute("href");
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		return strUrl;		
	}
	
	
	/**
	 * This method sets the focus on the link webelement in the page.
	 * This method will be implemented in future releases
	 */
	@SuppressWarnings("unused")
	private boolean	hasfocus() {
		return false;		
	}
	
	
	/**
	 * This method sets the focus on the link webelement in the page
	 * This will be implemented in the future releases
	 */
	@SuppressWarnings("unused")
	private void setFocus(){
		Actions action = new Actions(Browser.driver);
		action.moveToElement(curWebElement).perform();		
		JavascriptExecutor js = null;		
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		js.executeScript("return arguments[0].focus();", curWebElement);
		js.executeScript("setTimeout(function(){arguments[0].focus();},5000);",curWebElement);

	}
	
	
	/**
	 * This method gets the link text's text color .
	 * @return - String - A string value representing the link text's text color in hex code
	 */
	public String getLinkTextColor(){
		String hexStringColor="";
		
		if (curWebElement!=null){
			Logger.log("Getting Linktext color value of link " +getElementName()+ " in "+getPageName()+" page");
			String temp=curWebElement.getCssValue("Color").substring(4);
			temp=temp.replace("(", "");
			temp=temp.replace(")", "");
			temp=temp.replace(" ", "");
		
			String color[]=temp.split(",");
			int r=Integer.parseInt(color[0]);
			int g=Integer.parseInt(color[1]);
			int b=Integer.parseInt(color[2]);
			
			Color c = new Color(r,g,b);  
			hexStringColor = Integer.toHexString(c.getRGB() & 0x00FFFFFF);
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		return hexStringColor;	
	}
	
	
	/**
	 * This method gets the link text's text style .
	 * This method will be implemented in the upcoming release.
	 * @return - String - A string value representing the link text's text style
	 */
	@SuppressWarnings("unused")
	private String getLinkTextStyle(){
		String textStyle="";
		JavascriptExecutor js = null;		
		if (driver instanceof JavascriptExecutor) {
		   js = (JavascriptExecutor)driver;
		}
		textStyle=(String) js.executeScript("return arguments[0].style.fontStyle;", curWebElement);
		return textStyle;	
	}
	
	
	/**
	 * This method gets the tab index to reach out to the link by keypress tab action.
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
	 * This method gets the height of the link in the page. 
	 * @return int  - An int value indicating the height of the link object.
	 */
	public int getHeight(){
		
		int height=0;
		if(curWebElement!=null) {
			Logger.log("Getting height value of link " +getElementName()+ " in "+getPageName()+" page");
		
		if (curWebElement.isDisplayed()){
			 height=curWebElement.getSize().getHeight();
			 return height;
		}else{
			Logger.log("Link " +getElementName()+ " is not displayed "+ " in "+getPageName()+" page");
		}}
		else
		{
			height=Integer.parseInt("99999");
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");			
		}
		return height;
	}
	
	/**
	 * This method gets the width of the link in the page. 
	 * @return Integer  - An int value indicating the width of the link object.
	 */
	public int getWidth(){
		int width=0;
		if(curWebElement!=null) {
			Logger.log("Getting width value of link " +getElementName()+ " in "+getPageName()+" page");
		
		if (curWebElement.isDisplayed()){
			 width=curWebElement.getSize().getWidth();
			 return width;
		}else{
			Logger.log("Link " +getElementName()+ " is not displayed "+ " in "+getPageName()+" page");
		}}
		else
		{
			width=Integer.parseInt("99999");
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");			
		}
		return width;
	}
	
	/**
	 * This method simulates keypress enter action in the link component in the page.
	 */
	public void keyPressEnter(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress ENTER on link " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.ENTER);
		}
		else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");
		}
	}
	
	/**
	 * This method simulates keypress space action in the link component in the page.
	 */
	public void keyPressSpace(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress SPACE on link " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.SPACE);
		}
		else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");
		}
	}
	
	/**
	 * This method simulates keypress tab action in the link component in the page.
	 */
	public void keyPressTabOut(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress TAB on link " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.TAB);
		}
		else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");
		}		
	}
	
	
	
	/**
	 * This method clicks on a link in a webpage and waits for a particular period of 
	 * time indicated in seconds
	 * @param - An integer value indicating seconds to wait. 
	 */
	public void clickAndWait(int sec){
		
		if (curWebElement!=null){
			Logger.log("Clicking on link " +getElementName()+ "in "+getPageName()+" page and waiting for "+sec +" seconds");
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
	 * This method automatically scrolls the page to a particular section in the page
	 * where the link object is visible/avalable.
	 */
	public void scrollToView(){
		if (curWebElement!=null){
			Logger.log("Performing scrolling into view action in page "+getPageName()+" for element " +getElementName());
			Locatable hoverItem = (Locatable) curWebElement;
			hoverItem.getLocationOnScreenOnceScrolledIntoView();
		}
		else {
			Logger.log("Unable to perform actions on "+getElementName()+ " in "+getPageName()+ " as it is null");
		}
	}
	/**
	 * This method moves the mouse pointer and hovers over the link object in the page.
	 */ 	
	public void moveMouseOverLink(){
		if (curWebElement!=null){
			Logger.log("Performing hover operation on the link  "+getElementName() +"in page " +getPageName());
			Locatable hoverItem = (Locatable) curWebElement;
			Mouse mouse = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem.getCoordinates());
		}
		else {
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		
		
		/**
		 * This is a back up code which can be used to hover over an link. Please use the below 
		 * code snippet if the active code for moveMouseOverLink does not work.
		 */
		//Actions action = new Actions(driver); 
		//action.moveToElement(element); 
		//action.clickAndHold(element).build().perform(); 
               
    }

	/**
	 * This method right clicks on a link in a page
	*/
	public void rightClick(){	
		if(curWebElement!=null){
			Logger.log("Performing right click operation on link "+getElementName()+" in page "+getPageName());
			Actions action = new Actions(driver);
			action.contextClick(curWebElement).build().perform();
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
	}
	
	/**
	 * This method right clicks on a link in a page and selects the menu item.
	 * This method will be implemented in the next version of the framework. 
	 * @param - String - A string parameter which indicates the menu item.
	*/
	@SuppressWarnings("unused")
	private void rightClickAndSelectfromContextMenu(String menuitemName){
		
		Actions action = new Actions(driver);
		action.contextClick(curWebElement).build().perform();
		
	}
	
	/**
	 * This method details whether the link in the page is visited (clicked) or NOT
	 * This method will be implemented in the next version of the framework.
	 * @return boolean  - A boolean value indicating the link object is visited.
	 */
	@SuppressWarnings("unused")
	private boolean isLinkVisited(){
		Boolean blnLinkVisited=false;		
		return blnLinkVisited;
	}
	
	/**
	 * This method fires the event associated with the link object.
	 * @param - String- The event name in a string format.
	 */
	public void fireEvent(String eventName){	
		if (curWebElement!=null){
			Logger.log("Performing "+eventName+ "on link "+getElementName()+" in "+getPageName()+" page");
			JavascriptLibrary javascript = new JavascriptLibrary();
			javascript.callEmbeddedSelenium(driver, "triggerEvent", curWebElement,eventName);		
		}else{
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
	}
	
	
	/**
	 * This method gets the attached text of the webelement (here link). This function 
	 * cannot gets the attached text of an webelement as an text associated with an webelement
	 * varies for every webpages. The below function answers various options to get the associated
	 * text. Use any of the below options and get the attached text.
	 * @return - A string parameter which represents the attahed text.
	 */
	
	public String getAttachedText(){
		String attachedText="";
		WebElement attachedTextelement;
		if (curWebElement!=null){
			Logger.log("Retrieving  the associated text of link  "+getElementName() +"in page " +getPageName());
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
}
