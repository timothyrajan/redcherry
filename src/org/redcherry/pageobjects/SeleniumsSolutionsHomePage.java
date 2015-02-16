package org.redcherry.pageobjects;

import org.openqa.selenium.WebDriver;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Page;
import org.redcherry.webelements.Image;
import org.redcherry.webelements.Link;


public class SeleniumsSolutionsHomePage extends Page{
	
	
	/**
	 * Initial declarations required for a page. The below code sets the driver reference
	 * and assigns the page name to the pageName string */
	static WebDriver driver=Browser.driver;	
	static String pageName="SeleniumsSolutionsHomePage";
	
	
	/**
	 * WebElement declarations in the SignIn Page
	 */
	public static Link lnkPlayGround;
	public static Image imgSelenium;
	
	/**
	 * This method captures the elements based on the identifier information supplied in the 
	 * uiobjectlocators.xml or uiobjectlocator.properties file in the SignInPage	 
	 */	
	public static void captureObjects(){	
		try{			
			imgSelenium=new Image(driver,"imgSelenium",pageName);
			lnkPlayGround=new Link(driver,"lnkPlayGround",pageName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method recaptures the elements based on the identifier information supplied in the 
	 * uiobjectlocators.xml or uiobjectlocator.properties file in the SignInPage	 
	 */
	public static void refreshObjects(){
		try{
			 	  
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
	
}
