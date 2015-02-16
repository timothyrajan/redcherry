package org.redcherry.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Page {

	/**The Driver object */
	public static WebDriver driver = Browser.driver;

	/**The current webelement */
	public static WebElement curWebElement;	


	/**
	 * This function stops the page loading. This function can be used in places where the webpages
	 * loading is too slow and rendering is not fast enough. 
	 */
	public static void stopPageLoading(){

		if (driver!=null) {
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("window.stop();");
		}
	}



	/**
	 * This function takes the screenshot of the current page.
	 * @param screenShotName - The name of the screenshot.
	 */
	public static void takescreenshot(String screenShotName){

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("FILE"+TestSettings.testFolderPath+screenShotName+Timer.getDateAndTime()+".jpg");
			FileUtils.copyFile(scrFile, new File(TestSettings.testFolderPath+screenShotName+Timer.getDateAndTime().replace(":","").replace("-", "")+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * This method retrieves the page title in the string format
	 * @return - String - A string detailing the page title.
	 */
	public static String getPageTitle(){		
		return driver.getTitle();
	}


	/**
	 * This method simulates the back button press in the browser
	 */
	public static void navigateBack(){
		driver.navigate().back();
	}

	/**
	 * This method simulates the forward button press in the browser
	 */
	public static void navigateForward(){
		driver.navigate().forward();
	}

	/**
	 * This method simulates the page down action by clicking on the page down key in the 
	 * browser window
	 * This function has to be tweaked according to specific scenarios 
	 */
	public static void pageDown(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}

	/**
	 * This method simulates the page down action by clicking on the page up key in the 
	 * browser window
	 * This function has to be tweaked according to specific scenarios 
	 */
	public static void pageUp(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-300)", "");
	}


	/**
	 * This method closes the current page and pass on the driver handle to the adjacent 
	 * browser window 
	 */
	public static void close(){		
		Set <String> handles = driver.getWindowHandles();
		if (handles.size()>1){
			handles.remove(driver.getWindowHandle());
			driver.close();
			driver.switchTo().window(driver.getWindowHandles().iterator().next());
		} else {
			driver.close();
		}
	}
	
	
	/**
	 * This method pauses the execution for a predefined time as set in the parameter
	 * and waits for an Ajax element 
	 * @return Integer - An integer holding the timer value in milliseconds
	 */
	public static void waitForAjaxElement(int milliseconds) {
		WebDriverBackedSelenium selenium  = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		selenium.waitForCondition("selenium.browserbot.getCurrentWindow().jQuery.active == 0", milliseconds+"");
	}


	/**
	 * This method returns the page source code 
	 * @return String - A string which indicates the page source code
	 */
	public static String getPageSource(){		
		return driver.getPageSource();
	}

	/**
	 * This method returns the current URL the browser holds currently
	 * @return String - A string which indicates the URL the browser holds currently
	 */
	public static String getCurrentURL(){
		return driver.getCurrentUrl();
	}


	/**
	 * This method will be implemented in the upcoming releases.
	 */
	@SuppressWarnings("unused")
	private static void waitForPageLoad(){

	}


	/**
	 * This method will be implemented in the upcoming releases.
	 */
	@SuppressWarnings("unused")
	private static void waitForPageLoad(int i){

	}

	/**
	 * This method rereshes the  current page which the browser holds.
	 */
	public static void refreshPage(){		
		driver.navigate().refresh();
	}


	/**
	 * This method traverses through the entire page and collects all the WebList in a ArrayList.
	 * @return - Integer - An int which represents the total number of dropdowns in the page.
	 */
	public int getWebListCount(){		

		List<WebElement> webList= driver.findElements(By.tagName("select"));

		if (webList.size()>0) {
			return webList.size();	
		}else{
			Logger.log("There is no link in page kind of message");
			return 0;
		}
	}

	/**
	 * This method gets the identifier information of a webelement in addition to the 
	 * page name and the element name and scans the page for the webelement with the 
	 * input from the uiobjectlocators.XML and returns the webelement if it is found. 
	 * If the webelement is not found in the page, it returns a null.
	 * 
	 * @param driver- The WebDriver object
	 * @param elementName - The name of the web component
	 * @param pageName - The name of the page
	 * @return WebElement - The element which is matching the identifiers.
	 */
	public static WebElement getElement(WebDriver driver,String elementName,String pageName ){

		String findby="";
		String findbyvalue="";
		String name = "";
		String value = "";
		WebElement curWebElement=null;

		try {
			File fXmlFile = new File("C://Users//timothyr//git//greenwork//myframework//src//org//redcherry//resources//uiobjectlocators.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);		 
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(pageName);
			Node myNode = nList.item(0);
			NodeList myNodelist= myNode.getChildNodes();

			for (int temp = 0; temp < myNodelist.getLength(); temp++) {
				Node myElementNode = myNodelist.item(temp);		
				if (myElementNode.getNodeName().contains(elementName)){
					NamedNodeMap nl = myElementNode.getAttributes();
					int length = nl.getLength();
					for( int i=0; i<length; i++) {
						Attr attr = (Attr) nl.item(i);
						name = attr.getName();
						value = attr.getValue();
						if (name.contains("findby")){						    	
							findby=value;
						}						    
						if (name.contains("id")){
							findbyvalue=value;
						}

						if (name.contains("linkText")){
							findbyvalue=value;
						}

						if (name.contains("xpath")){
							findbyvalue=value;
						}

						if (name.contains("className")){
							findbyvalue=value;
						}

						if (name.contains("cssSelector")){
							findbyvalue=value;
						}

						if (name.contains("name")){
							findbyvalue=value;
						}

						if (name.contains("partialLinkText")){
							findbyvalue=value;
						}

						if (name.contains("tagName")){
							findbyvalue=value;
						}

					}

				}
			}


			if (findby.contains("linkText")){ 
				curWebElement=driver.findElement(By.linkText(findbyvalue));
				Logger.log("Found "+elementName+" in page "+pageName);
			}else 			

				if (findby.contains("id")){ 
					curWebElement=driver.findElement(By.id(findbyvalue));
					Logger.log("Found "+elementName+" in page "+pageName);
				}else 

					if (findby.contains("xpath")){
						curWebElement=driver.findElement(By.xpath(findbyvalue));
						Logger.log("Found "+elementName+" in page "+pageName);
					}else 

						if (findby.contains("className")){
							curWebElement=driver.findElement(By.className(findbyvalue));
							Logger.log("Found "+elementName+" in page "+pageName);
						}else 

							if (findby.contains("cssSelector")){
								curWebElement=driver.findElement(By.cssSelector(findbyvalue));
								Logger.log("Found "+elementName+" in page "+pageName);
							}else 

								if (findby.contains("name")){
									curWebElement=driver.findElement(By.name(findbyvalue));
									Logger.log("Found "+elementName+" in page "+pageName);
								}else 

									if (findby.contains("partialLinkText")){
										curWebElement=driver.findElement(By.partialLinkText(findbyvalue));
										Logger.log("Found "+elementName+" in page "+pageName);
									}else 

										if (findby.contains("tagName")){
											curWebElement=driver.findElement(By.tagName(findbyvalue));
											Logger.log("Aborting associating an webelement object for "+elementName +" from page "+pageName);
										}else {
											Logger.log("The identifier supplied for searching webelement "+elementName +" in page "+pageName +" is invalid" );
											Logger.log("Aborting associating an webelement object for "+elementName);
										}
		}
		catch(Throwable t){
			Logger.log("Unable to locate and associate an webelement "+elementName +" using the identifier value " +findbyvalue + " which falls under "+findby + " identifer and the exception is "+t.getClass().toString());

		}
		if (curWebElement!=null)
		{
			return curWebElement;
		}else
		{
			return null;
		}
	}

	/**
	 * This method gets the identifier information of a webelement in addition to the 
	 * page name and the element name and scans the page for the webelement with the 
	 * input from the uiobjectlocators.properties and returns the webelement if it is found. 
	 * If the webelement is not found in the page, it returns a null.
	 * 
	 * @param driver- The WebDriver object
	 * @param elementName - The name of the web component
	 * @param pageName - The name of the page
	 * @return WebElement - The element which is matching the identifiers.
	 */
	public static WebElement findElement(WebDriver driver,String elementName,String pageName ){

		String searchKey=pageName+"."+elementName;
		WebElement curWebElement=null;			
		Properties prp=new Properties();
		try {
			prp.load((new FileInputStream("C://Users//timothyr//git//greenwork//myframework//src//org//redcherry//resources//uiobjectlocators.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String byid=searchKey+".id";		
		String byLinkText=searchKey+".linktext";
		String byxpath=searchKey+".xpath";
		String byclassName=searchKey+".classname";
		String bycssSelector=searchKey+".cssselector";
		String byname=searchKey+".name";
		String bypartialLinkText=searchKey+".partiallinktext";
		String bytagName=searchKey+".name";

		try{
			if (prp.containsKey(byid)){				
				curWebElement=driver.findElement(By.id(prp.getProperty(byid)));
				Logger.log("Found "+elementName+" in page "+pageName);
			}

			if (prp.containsKey(byLinkText)){				
				curWebElement=driver.findElement(By.linkText(prp.getProperty(byid)));
				Logger.log("Found "+elementName+" in page "+pageName);
			}

			if (prp.containsKey(byxpath)){				
				curWebElement=driver.findElement(By.xpath(prp.getProperty(byid)));
				Logger.log("Found "+elementName+" in page "+pageName);
			}

			if (prp.containsKey(bycssSelector)){				
				curWebElement=driver.findElement(By.cssSelector(prp.getProperty(byid)));
				Logger.log("Found "+elementName+" in page "+pageName);
			}

			if (prp.containsKey(byclassName)){				
				curWebElement=driver.findElement(By.className(prp.getProperty(byid)));
				Logger.log("Found "+elementName+" in page "+pageName);
			}

			if (prp.containsKey(byname)){				
				curWebElement=driver.findElement(By.name(prp.getProperty(byid)));
				Logger.log("Found "+elementName+" in page "+pageName);
			}

			if (prp.containsKey(bypartialLinkText)){				
				curWebElement=driver.findElement(By.partialLinkText(prp.getProperty(byid)));
				Logger.log("Found "+elementName+" in page "+pageName);
			}

			if (prp.containsKey(bytagName)){				
				curWebElement=driver.findElement(By.tagName(prp.getProperty(byid)));
				Logger.log("Found "+elementName+" in page "+pageName);
			}
		}

		catch(Throwable t){
			Logger.log("Unable to locate and associate an webelement "+elementName +" using the identifier value " +" and the exception is "+t.getClass().toString());
		}

		if (curWebElement!=null)
		{
			return curWebElement;
		}else
		{
			return null;
		}			
	}

}