package org.redcherry.pageobjects;

import org.openqa.selenium.WebDriver;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Page;
import org.redcherry.webelements.CheckBox;
import org.redcherry.webelements.Link;
import org.redcherry.webelements.TextBox;


public class SignInPage extends Page{

	/**
	 * Initial declarations required for a page. The below code sets the driver reference
	 * and assigns the page name to the pageName string */
	static WebDriver driver=Browser.driver;	
	static String pageName="SignInPage";

	/**
	 * WebElement declarations in the SignIn Page
	 */
	public static TextBox ebUserName;
	public static TextBox ebPassword;
	public static CheckBox chkbxStaySignedIn;
	public static Link lnkCannotaccessaccount;


	/**
	 * This method captures the elements based on the identifier information supplied in the 
	 * uiobjectlocators.xml or uiobjectlocator.properties file in the SignInPage	 
	 */	
	public static void captureObjects(){	
		try{
			ebUserName=  new TextBox(driver,"ebUserName",pageName);
			ebPassword=  new TextBox(driver,"ebPassword",pageName);//			
			chkbxStaySignedIn = new CheckBox(driver,"chkbxStaySignedIn",pageName);
			lnkCannotaccessaccount = new Link(driver,"lnkCannotaccessaccount",pageName);
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
			lnkCannotaccessaccount= new Link(driver,"lnkCannotaccessaccount",pageName); 	  
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * This method logins to the gmail account based on the login details supplied in the
	 * TestData sheet	 
	 */
	public static void loginToYourAccount(){
		ebUserName.inputData("demo of user defined function");
		ebPassword.inputData("superbselenium");
		chkbxStaySignedIn.check();
	}
}
