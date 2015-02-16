package org.redcherry.testcases;

import org.redcherry.pageobjects.SignInPage;
import org.redcherry.utilities.Browser;
import org.redcherry.utilities.Logger;
import org.redcherry.utilities.Report;
import org.redcherry.utilities.TestData;
import org.redcherry.utilities.TestSettings;


/*Testcase2 
 * Summary:- This test launches the webpage gmail.com and does the following actions
 * Step1:-Verifies the presence of editbox username
 * Step2:-Verifies the presence of editbox password
 * Step3:-Verifies whether the password field is a password field
 * Step4:-Check the checkbox 'stay signed in'
 * Step5:-Click the link 'Can't access your account?'
 * Step6:-Close the browser
 */	 
public class Testcase2 {

	public static void main(String args[]){		

		/** Loads the test data sheet from org.redcherry.testdata */
		TestData.loadTestData("Testcase2");

		/** Does the initial test settings for the test case Testcase1 */
		TestSettings.initiateTest("Testcase2");

		/** Variables used */
		boolean blnebUserNameDisplayed;
		boolean blnenPasswordDisabled;
		String attachedText;
		boolean isPasswordField;

			/**Start of Test case*/
		Logger.log("START of Test case2");

		/**Browser set up and launch */
		Browser.launchBrowser("firefox");		
		Browser.Maximize();
		
		/**GMAIL Landing Page */
		Browser.triggerURL("https://accounts.google.com/");

		/**CAPTURE objects in SignInPage */
		SignInPage.captureObjects();

		blnebUserNameDisplayed=SignInPage.ebUserName.isDisplayed();
		if (blnebUserNameDisplayed==true){
			Logger.log("The username field display is verified and is found in GMAIL landing page");
			Report.pass("Verify the existence of username field","The username field has to be displayed","The username field is displayed",true);
		}else{
			Logger.log("The username field display is verified and is NOT found in GMAIL landing page");
			Report.fail("Verify the existence of username field","The username field has to be displayed","The username field is not displayed",true);
		}

		blnenPasswordDisabled=SignInPage.ebPassword.isDisabled();
		if (blnenPasswordDisabled==true){
			Logger.log("The password field disabled status is verified in GMAIL landing page");
			Report.pass("Verify whether the password field is disabled","The password field has to be disabled","The password field is disabled",false);
		}else{
			Logger.log("The password field disabled status is verified in GMAIL landing page");
			Report.fail("Verify whether the password field is disabled","The password field has to be disabled","The password field is enabled",true);
		}

		/** Actions in SignIn Page */
		SignInPage.ebUserName.click();
		SignInPage.ebUserName.inputData("superbselenium");
		SignInPage.ebPassword.inputData(TestData.getTestData("FirstName"));

		attachedText=SignInPage.ebUserName.getAttachedText();		
		Logger.log("The attached text of ebUserName is "+attachedText);


		isPasswordField=SignInPage.ebPassword.isPasswordField();
		if (isPasswordField){
			Report.pass("Verify whether the ebPassword field is of type password", "The password field should be of type password", "The password field is of type password", true);	
		}else{
			Report.fail("Verify whether the ebPassword field is of type password", "The password field should be of type password", "The password field is NOT of type password", true);	
		}

		/** Actions in SignIn Page */
		SignInPage.chkbxStaySignedIn.check();
		SignInPage.lnkCannotaccessaccount.clickAndWait(10);

		Report.currentTestStatus("Testcase2",Report.getOverallexecutionStatus());
		/**End of Test case*/
		Logger.log("END of Test case2");
		Browser.closeAllBrowswers();		
	}
}	
