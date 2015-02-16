package org.redcherry.webelements;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Logger;
import org.redcherry.utilities.Page;


public class TextBox extends GenericWebElement{
	
	
	/** The TextBox element */
	private  WebElement curWebElement;	
	
	/** The driver object */	
	private WebDriver driver=Browser.driver;
	
	/** The TextBox webelement */
	private String elementName;
	
	/** The page object */
	private String pageName;

	/**
	 * This method gets the editbox (textbox) object in the page with the help of the identifiers. The editbox object
	 * is identified in the page by using the identifiers mentioned either in the uiobjectlocators.xml
	 * or in the uiobjectlocators.properties file.
	 * 
	 * @param WebDriver - The driver object
	 * @param String - The name of the element. This is the logical name of the textbox component.
	 * @param className - The name of the class. This is the logical name which is given to the page.
	 */	
	public TextBox (WebDriver driver,String elementName,String className){
		curWebElement=Page.findElement(driver,elementName,className);
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
	 * This method keys in the data (which is a string).
	 * @param String- The string input which will be keyed in to the textbox 
	 */
	public void inputData(String strInput){
		
		if (curWebElement!=null){
			Logger.log("Keying in "+strInput+ " in "+getElementName()+" textbox"+ "in "+getPageName()+" page");
			curWebElement.click();
			curWebElement.clear();
			curWebElement.sendKeys(strInput);
		}else{
			Logger.log(getElementName()+ " textbox "+ " in page "+getPageName()+" is null. Hence no operation can be performed");
		}
	}

	
	/**
	 * This method clicks in the textbox.
	 */
	public void click(){
		
		if (curWebElement!=null){
		Logger.log("Clicking " +getElementName()+ " in "+getPageName()+" page");
		curWebElement.click();
		}else{
			Logger.log(getElementName()+ " textbox "+ " in page "+getPageName()+" is null. Hence no operation can be performed");	
		}
		
	}

	/**
	 * This method clears the data in the textbox.
	 */
	public void clearData(){	
		
		if (curWebElement!=null){
			Logger.log("Clearing the data in " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.click();
			curWebElement.clear();	
		}else{
			Logger.log(getElementName()+ " textbox "+ " in page "+getPageName()+"  is null. Hence no operation can be performed");
		}
	}


	/**
	 * This method gets the data in  the string format.
	 * @return - String - A string data which represents the data in the textbox field.
	 */
	public String getData(){
		
		String text="";
		if (curWebElement!=null){
			Logger.log("Getting value from " +getElementName()+ "textbox in "+getPageName()+" page");	
			text=curWebElement.getAttribute("value");
		}else{
			text="99999";
			Logger.log(getElementName()+ " textbox "+ " in page "+getPageName()+" is null. Hence no operation can be performed");
		}
		return text;
		
	}

	
	
	/**
	 * This method gets the attached text of the webelement (here textbox). This function 
	 * cannot gets the attached text of an webelement as an text associated with an webelement
	 * varies for every webpages. The below function answers various to get the associated
	 * text. Use any of the below options and get the attached text.
	 * @return - A string parameter which represents the attahed text.
	 */
	
	public String getAttachedText(){
		String attachedText="";
		WebElement attachedTextelement;
		if (curWebElement!=null){
			Logger.log("Retrieving  the associated text of textbox  "+getElementName() +"in page " +getPageName());
			/**Getting the curWebElement's parent node text */
	//		attachedTextelement =curWebElement.findElement(By.xpath(".."));
	//		attachedText=attachedTextelement.getText();
			
			/**Getting the curWebElement's parent node's next sibling text */		
	//		attachedTextelement =curWebElement.findElement(By.xpath("..")).findElement(By.xpath("following-sibling::*[position()=1]"));
	//		attachedText=attachedTextelement.getText();
			
			/**Getting the curWebElement's parent node's previous sibling text */
	//		attachedTextelement =curWebElement.findElement(By.xpath("..")).findElement(By.xpath("preceding-sibling::*[position()=1]"));
	//		attachedText=attachedTextelement.getText();
			
			/**Getting the curWebElement's following sibling text */
	//		attachedTextelement =curWebElement.findElement(By.xpath("following-sibling::*[position()=1]"));
	//		attachedText=attachedTextelement.getText();
			
			/**Getting the curWebElement's preceding sibling text */
			attachedTextelement =curWebElement.findElement(By.xpath("preceding-sibling::*[position()=1]"));
			attachedText=attachedTextelement.getText();			
			
		}else{
			Logger.log(getElementName()+ " button "+ "is null. Hence no operation can be performed in page "+getPageName());
		}
		return attachedText;
	}
	
	
	

	/**
	 * This method gets the tooltip text from the edit box in the string format.
	 * @return - String - A string which represents the tooltip when hovered over the textbox 
	 * object
	 */
	public String getTooltipText(){
		String TooltipText="";
		if (curWebElement!=null){ 
		Logger.log("Getting tooltip text from " +getElementName()+ "in "+getPageName()+" page");
		JavascriptExecutor js = null;		
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		}
		TooltipText=(String) js.executeScript("return arguments[0].title;", curWebElement);
		}else{
			Logger.log(getElementName()+ " textbox "+ " in page "+getPageName()+" is null. Hence no operation can be performed");
		}
		return TooltipText;
	}

	/**
	 * This method gets the max length of the edit box in the int format.
	 * @return - Integer - An int value indicating the max length of the textbox 
	 */
	public int getMaxLength(){	
		Logger.log("Getting maxlength property from " +getElementName()+ "in "+getPageName()+" page");
		String strmaxLength="";
		strmaxLength=curWebElement.getAttribute("maxlength");
		if (strmaxLength!=null){
			
		}
		else{
			strmaxLength="99999";
			Logger.log("Maxlength property for " +getElementName()+ "in "+getPageName()+" page is not defined");
		}
		return Integer.parseInt(strmaxLength);
	}

	/**
	 * This method simulates keypress enter action in the editbox.
	 */
	public void keyPressEnter(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress ENTER on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.ENTER);
		}
		else{
			Logger.log(getElementName()+ " textbox "+ "is null. Hence no operation can be performed");
		}
	}
	
	/**
	 * This method simulates keypress Space action in the editbox.
	 */
	public void keyPressSpace(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress SPACE on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.SPACE);
		}
		else{
			Logger.log(getElementName()+ " textbox "+ " in page "+getPageName()+" is null. Hence no operation can be performed");
		}
	}

	/**
	 * This method simulates keypress Tab action in the editbox.
	 */
	public void keyPressTabOut(){
		if(curWebElement!=null) {
			Logger.log("Simulating keypress TAB on " +getElementName()+ "in "+getPageName()+" page");
			curWebElement.sendKeys(Keys.TAB);
		}
		else{
			Logger.log(getElementName()+ " textbox "+ " in page "+getPageName()+" is null. Hence no operation can be performed");
		}		
	}

	/**
	 * This method validates whether the textbox is disabled or not. This function returns
	 * a boolean value which indicates whether the textbox is disabled or not.The boolean value
	 * is TRUE if the textbox is disabled. The boolean value is FALSE if the textbox is enabled.
	 */
	public boolean isDisabled(){
		boolean isDisabled=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether the textbox "+getElementName()+"is disabled in the "+getPageName()+" page");
			if (curWebElement.isEnabled()){
				isDisabled=false;
			}else
			{
				isDisabled=true;
			}
		}else{
			Logger.log(getElementName()+ " textbox "+ " in page "+getPageName()+" is null. Hence no operation can be performed");
			isDisabled=(Boolean) null;
		}
		return isDisabled;
	}

	/**
	 * This method validates whether the textbox is enabled or not. This function returns
	 * a boolean value which indicates whether the textbox is enabled or not.The boolean value
	 * is TRUE if the textbox is enabled. The boolean value is FALSE if the textbox is disabled.
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
			Logger.log(getElementName()+ " link "+ " in page "+getPageName()+" is null. Hence no operation can be performed");
			isEnabled=(Boolean) null;
		}
		return isEnabled;
	}
	
	
	/**
	 * This method returns a boolean value which indicates whether the textbox is displayed or NOT.
	 * @return - Boolean - A boolean value indicating that the text box is hidden or displayed. If
	 * the textbox is hidden, the return value is FALSE, else, the return value is TRUE.
	 */
	public boolean isDisplayed(){
		boolean isDisplayed=false;
		if (curWebElement!=null){
			Logger.log("Verifying whether the textbox "+getElementName()+" is displayed in the "+getPageName()+" page");
			if (curWebElement.isDisplayed()){
				isDisplayed=true;
			}else
			{
				isDisplayed=false;
			}
		}else{
			Logger.log(getElementName()+ " textbox "+ " is null. Hence no operation can be performed in page "+getPageName());
			isDisplayed=(Boolean) null;
		}
		return isDisplayed;
	}


	/**
	 * This method gets the innerHTML of the button object in the page.
	 * @param - String - The innerHTML of the button object.
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
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");
		}
		
		return innerhtml;
	}

	
	/**
	 * This method gets the outerHTML of the button object in the page.
	 * @param - String - The outerHTML of the button object.
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
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");
		}
		return outerhtml;
	}


	/**
	 * This method sets the focus on the textbox webelement in the page.
	 * This will be implemented in the future releases
	 */
	@SuppressWarnings("unused")
	private void setFocus(){

	}



	/**
	 * This method verifies the focus on the textbox webelement in the page
	 * This will be implemented in the future releases
	 */
	@SuppressWarnings("unused")
	private boolean hasFocus(){
		return true;
	}

	/**
	 * This method gets the tab index to reach out to the textbox by keypress tab action.
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
	 * This method validates whether the textbox field is a password field or a normal field.
	 * @return - Boolean - An boolean value indicating whether the textbox field is a password
	 * or a normal field. A boolean value of TRUE indicates that it is a password field and FALSE
	 * indicates that it is a normal field.
	 */
	public boolean isPasswordField(){
		
		
		
		
		Logger.log("Verifying whether " +getElementName()+ " is a password protected field in "+getPageName()+" page");
		boolean blnPasswordField=false;		
		
		if (curWebElement!=null){
			String strPasswordField=curWebElement.getAttribute("type");
			if (strPasswordField.contains("password")){
				blnPasswordField=true;
			}	
		}else{
			Logger.log(getElementName()+ " textbox "+ "is null. Hence no operation can be performed");
			blnPasswordField=(Boolean) null;
		}
				
		return blnPasswordField;
	}
	
	
	/**
	 * This method gets the label (String attached next to the textbox) in the page.
	 * @return - String - A string value which represents the label of the textbox
	 */
	public String getLabel(){
		String label="";
		return label;
	}
	
	
	/**
	 * This method gets the label alignment (String attached next to the textbox) of the textbox.
	 * This method will be implemented in the upoming releases.
	 * @return - String - A string value which represents the label alignment of the label 
	 * in the textbox. Possible values are RIGHT and LEFT.
	 * 
	 */
	@SuppressWarnings("unused")
	private String getLabelAlignment(){
		String labelAlignment="";
		return labelAlignment;
	}
	
	/**
	 * This method gets the height of the textbox in the page. 
	 * @return int  - An int value indicating the height of the textbox object.
	 */
	public int getHeight()
	{
		int height=0;
		if(curWebElement!=null) {
			Logger.log("Getting height value of " +getElementName()+ "in "+getPageName()+" page");
		
		if (curWebElement.isDisplayed()){
			 height=curWebElement.getSize().getHeight();
			 return height;
		}else{
			Logger.log("Link " +getElementName()+ " is not displayed "+ "in "+getPageName()+" page");
		}}
		else
		{
			height=Integer.parseInt("99999");
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");			
		}
		return height;
	}
	
	
	/**
	 * This method gets the width of the textbox in the page. 
	 * @return int  - An int value indicating the width of the textbox object.
	 */
	public int getWidth()
	{
		int width=0;
		if(curWebElement!=null) {
			Logger.log("Getting width value of " +getElementName()+ "in "+getPageName()+" page");
		
		if (curWebElement.isDisplayed()){
			 width=curWebElement.getSize().getWidth();
			 return width;
		}else{
			Logger.log("Link " +getElementName()+ " is not displayed "+ "in "+getPageName()+" page");
		}}
		else
		{
			width=Integer.parseInt("99999");
			Logger.log(getElementName()+ " link "+ "is null. Hence no operation can be performed");			
		}
		return width;
	}
}
