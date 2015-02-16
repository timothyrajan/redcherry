package org.redcherry.utilities;

import java.util.ArrayList;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class Browser  {

	/**The WebDriver object */
	public  static WebDriver driver;

	/**The browser reference */
	private static Browser browserRef;

	/**Constructor */
	public Browser(){

	}


	public static synchronized Browser getBrowserReference()
	{
		if (browserRef == null)          
			browserRef = new Browser();
		return browserRef;
	}	


	/**
	 * This function launches the browser based on the argument which is supplied to the function. The three possible
	 * browser types covered in this function are ie,firefox and chrome. Modify this function to add any browsers to your need.
	 * @param browsertpye
	 */
	public static void launchBrowser(String browsertpye){

		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (browsertpye.equalsIgnoreCase("firefox")) {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile firefoxProfile = profile.getProfile("default");
			firefoxProfile.setEnableNativeEvents(true);
			capabilities.setPlatform(Platform.ANY);
			capabilities.setJavascriptEnabled(true);
			driver = new FirefoxDriver(firefoxProfile);		
			Logger.log("Launched firefox browser");

		}else if (browsertpye.equalsIgnoreCase("ie") || browsertpye.equalsIgnoreCase("internet explorer") || browsertpye.equalsIgnoreCase("internetexplorer")) {
			driver = new InternetExplorerDriver();
			Logger.log("Launched IE browser");

		}else if (browsertpye.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			driver = new ChromeDriver(capabilities);
			Logger.log("Launched Chrome browser");

		}else if (browsertpye.equalsIgnoreCase("htmlunitdriver")) {
			driver = new HtmlUnitDriver(true);
			Logger.log("Launched Chrome browser");
		}else{			

		}

	}


	/**
	 * This function triggers the URL in the browser
	 * @param URL - The web URL 
	 */
	public static void triggerURL(String URL){
		if (driver!=null) {
			driver.get(URL);
		}else{

		}

	}


	/**
	 * This function maximizes the browser screen
	 */
	public static void Maximize(){
		if ((driver!= null) && (driver instanceof ChromeDriver)) {
			driver.manage().window().maximize();
		}else
			if ((driver!= null) && (driver instanceof FirefoxDriver)) {
				driver.manage().window().maximize();
			}else if ((driver!= null) && (driver instanceof InternetExplorerDriver)) {
				driver.manage().window().maximize();
			}

	}


	/**
	 * This method closes all the browser windows opened in the current test session
	 */
	public static void closeAllBrowswers(){
		if (driver!=null) {
			driver.quit();
		}
	}


	/**
	 * This method deletes a particular cookie which is passed as an argument
	 * @param - Cookie - The cookie to delete
	 */
	public static void deleteCookie(Cookie cookie){

		if (driver!=null) {
			driver.manage().deleteCookie(cookie);
			Logger.log("The cookie" + cookie.toString() +" is deleted");
		}else{
			Logger.log("The cookie" + cookie.toString() +" cannot be deleted");
		}

	}


	/**
	 * This method deletes all the cookies. 
	 */
	public static void deleteAllCookies(){

		if (driver!=null) {
			driver.manage().deleteAllCookies();
			Logger.log("All the cookies are deleted"); 
		}else{
			Logger.log("Unable to delete all the cookies"); 
		}

	}

	/**
	 * This function gets the current window handle of the browser window to which driver is pointed to
	 * @return string - The current window handle in string format
	 */
	public static String getCurrentWindowHandle(){

		String strHandle="";
		if (driver!=null) {
			strHandle=driver.getWindowHandle();
		}else
		{
			Logger.log("Unable to get the driver window handle as the driver object is NULL");
		}

		return strHandle; 


	}


	/**This function gets all the window handles of the current driver
	 * @return ArrayList<String> -An arraylist which indicates the window handles collection
	 */
	@SuppressWarnings("null")
	public static ArrayList<String> getAllWindowHandles(){
		
		ArrayList<String> windowHandles=null;
		if (driver!=null) {						
			for (String handle : driver.getWindowHandles()) {
				windowHandles.add(handle);
			}
		}else{
			Logger.log("Unable to get all the window handles as the driver object is null");
		}
		return windowHandles;
	}

	/**
	 * This function switches the current window handle to a frame. 
	 * @param String - The frame object in string format
	 */
	public static void switchToFrame(String frame){
		if (driver!=null) {
			driver.switchTo().frame(frame);
		}else {
			Logger.log("Unable to switch to a frame as the driver object is null");

		}
	}

	/**
	 * This function switches the current window handle to a frame. 
	 * @param frame - The frame object in int format
	 */
	public static void switchToFrame(int frame){
		if (driver!=null) {
			driver.switchTo().frame(frame);
		}else {
			Logger.log("Unable to switch to a frame as the driver object is null");
		}
	}


	/**
	 * This function switches the current window handle to a frame. 
	 * @param frame - The webElment object 
	 */
	public static void switchToFrame(WebElement element){
		if (driver!=null) {
			driver.switchTo().frame(element);
		}else {
			Logger.log("Unable to switch to a frame as the driver object is null");
		}
	}


	/**
	 * This function switches the driver to the alert window, accepts the alert and
	 * switches the driver once again to the browser window
	 */
	public static void switchToAlertWindowAndAcceptAlert(){
		if (driver!=null) {
			String strcurrentWindowHandle=getCurrentWindowHandle();
			driver.switchTo().alert().accept();
			driver.switchTo().window(strcurrentWindowHandle);
		}else {
			Logger.log("Unable to accept the alert window");
		}

	}


	/**
	 * This function switches the driver to the alert window, cancels the alert and
	 * switches the driver once again to the browser window
	 */
	public static void switchToAlertWindowAndCancelAlert(){
		if (driver!=null) {
			String strcurrentWindowHandle=getCurrentWindowHandle();
			driver.switchTo().alert().dismiss();
			driver.switchTo().window(strcurrentWindowHandle);
		}else {
			Logger.log("Unable to cancel the alert window");			
		}

	}


	/**
	 * This function resizes the browser window. This function will be implemented in
	 * the upcoming release.
	 */
	@SuppressWarnings("unused")
	private static void reSize(){		
		if (driver!=null) {			

		}
	}
}