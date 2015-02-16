package org.redcherry.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import org.redcherry.utilities.Browser;

public class GenericWebElement extends RemoteWebElement {
	
	/** The driver object*/
	public static WebDriver driver=Browser.driver;	
}
