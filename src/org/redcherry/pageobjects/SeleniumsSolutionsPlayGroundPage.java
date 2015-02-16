package org.redcherry.pageobjects;

import org.openqa.selenium.WebDriver;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Page;
import org.redcherry.webelements.Button;
import org.redcherry.webelements.CheckBox;
import org.redcherry.webelements.Link;
import org.redcherry.webelements.TextBox;
import org.redcherry.webelements.WebList;


public class SeleniumsSolutionsPlayGroundPage extends Page{
	
	
	/**
	 * Initial declarations required for a page. The below code sets the driver reference
	 * and assigns the page name to the pageName string */
	static WebDriver driver=Browser.driver;	
	static String pageName="SeleniumsSolutionsPlayGroundPage";
	
	
	/**
	 * WebElement declarations in the PlayGround Page
	 */
		
	public static TextBox ebEnterYourName;
	public static WebList wlSelectYourCity;
	public static Link lnkGoodLink;
	public static Link lnkBrokenLink;
	public static CheckBox chkbxYourAgeGroup;
	public static Button btnClear;
	
	
	
	
	/**
	 * This method captures the elements based on the identifier information supplied in the 
	 * uiobjectlocators.xml or uiobjectlocator.properties file in the SignInPage	 
	 */	
	public static void captureObjects(){	
		try{			
			lnkGoodLink=new Link(driver,"lnkGoodLink",pageName);	
			lnkBrokenLink=new Link(driver,"lnkBrokenLink",pageName);
			ebEnterYourName=new TextBox(driver,"ebEnterYourName",pageName);
			wlSelectYourCity=new WebList(driver,"wlSelectYourCity",pageName);
			chkbxYourAgeGroup=new CheckBox(driver,"chkbxYourAgeGroup",pageName);			
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
			btnClear=new Button(driver,"btnClear",pageName);	  
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	



	public static void resubaleFunctionDemo() {
		SeleniumsSolutionsPlayGroundPage.chkbxYourAgeGroup.check();
		SeleniumsSolutionsPlayGroundPage.lnkGoodLink.click();
		SeleniumsSolutionsPlayGroundPage.lnkBrokenLink.click();
	}


	
}
