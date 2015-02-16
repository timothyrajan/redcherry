package org.redcherry.testcases;

import org.redcherry.pageobjects.SeleniumsSolutionsHomePage;
import org.redcherry.pageobjects.SeleniumsSolutionsPlayGroundPage;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Logger;
import org.redcherry.utilities.Report;
import org.redcherry.utilities.TestData;
import org.redcherry.utilities.TestSettings;
import org.redcherry.utilities.Timer;

/*Testcase1 
 * Summary:- This test launches the webpage seleniumsolutions.com and does the following actions
 * Step1:-Verifies the tooltip text in the Selenium Image in HomePage
 * Step2:-Clicks the Selenium Image in the HomePage
 * Step3:-Clicks on PLAY GROUND link available in the top section of the page
 * Step4:-Enter value in ebEnterYourName edit box. The value is from the Testcase1 xls which is in testdata folder 
 * Step5:-Select MELBOURNE as the city option in the Select Your City dropdown
 * Step6:-Check the checkbox Above 30
 * Step7:-Navigate Backby pressing the back key
 * Step8:-Navigate Forward by pressing the forward key
 * Step9:-Capture objects in playground page
 * Step10:-Check the status of the checkbox 'Above 30'
 * Step11:-Uncheck the checkbox Above 30
 * Step12:-Call resuable function resubaleFunctionDemo
 * Step13:-Close all browsers
 */	 
public class Testcase1 {
	
	public static void main(String args[]){		
		
		Logger.log("Started executing test case Testcase1");
		
		/** Loads the test data sheet from org.redcherry.testdata */
		 TestData.loadTestData("Testcase1");			
		
		/** Does the initial test settings for the test case seleniumsolution_playground */
		 TestSettings.initiateTest("Testcase1");	
		
		/**Start of Test case*/
		
		/**Browser set up and launch */
		Browser.launchBrowser("firefox");
		Browser.Maximize();		
		Browser.triggerURL("http://seleniumsolutions.com/");
		
		
		/**SeleniumSolution HomePage */
		SeleniumsSolutionsHomePage.captureObjects();		
		//SeleniumsSolutionsHomePage.lnkPlayGround.click();
		
		
		SeleniumsSolutionsPlayGroundPage.resubaleFunctionDemo();
		
		/**SeleniumSolution Playground Page*/
		SeleniumsSolutionsPlayGroundPage.refreshObjects();
		
		SeleniumsSolutionsPlayGroundPage.ebEnterYourName.inputData(TestData.getTestData("FirstName"));
		SeleniumsSolutionsPlayGroundPage.wlSelectYourCity.selectOptionByVisibleText("MELBOURNE");
		SeleniumsSolutionsPlayGroundPage.chkbxYourAgeGroup.check();
		SeleniumsSolutionsPlayGroundPage.navigateBack();		
		SeleniumsSolutionsPlayGroundPage.navigateForward();
		
		
		Timer.wait(5);
		
		/**Recapturing obects  */		
		SeleniumsSolutionsPlayGroundPage.captureObjects();
		String chkbxstatus=SeleniumsSolutionsPlayGroundPage.chkbxYourAgeGroup.getCheckboxStatus();
		
		if (chkbxstatus.contains("check")){
			Report.pass("Verify the status of the checkbox","The checkbox has to be checked", "The checkbox is checked",true);
		}else{
			Report.fail("Verify the status of the checkbox","The checkbox has to be checked", "The checkbox is NOT checked",true);
		}
		
		boolean blnBrokenLink=SeleniumsSolutionsPlayGroundPage.lnkBrokenLink.isLinkBroken();
		
		if (blnBrokenLink){
			Report.pass("Verify whether the link is broken","The link has to be a broken link", "The link is a broken link",true);
		}else{
			Report.pass("Verify whether the link is broken","The link has to be a broken link", "The link is NOT a broken link",true);
		}
		
		SeleniumsSolutionsPlayGroundPage.chkbxYourAgeGroup.check();
		SeleniumsSolutionsPlayGroundPage.resubaleFunctionDemo();	
		
		/**End of Test case*/ 
		Browser.closeAllBrowswers();	
		Logger.log("End of Testcase1");		
	}
		
	
}	
