package org.redcherry.utilities;


import java.io.FileWriter;
import java.io.IOException;

public class Report{	

	public static String fileName=TestSettings.filename;
	public static String reportFileName=TestSettings.reportFileName;
	public static FileWriter writer;
	static boolean blnFail=false;

	/**
	 * This function sends a fail status to the report file describing the test scenario,expected result
	 * actual result and screenshot if applicable.
	 * @param Description
	 * @param expectedResult
	 * @param actualResult
	 * @param takeScreenShot
	 */
	public static void fail(String Description,String expectedResult, String actualResult, Boolean takeScreenShot){
		blnFail=true;
		try {
			writer = new FileWriter(fileName,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			writer.append(Timer.getDateAndTime());
			writer.append(',');
			writer.append(Description);
			writer.append(',');
			writer.append(expectedResult);
			writer.append(',');
			writer.append(actualResult);
			writer.append(',');
			writer.append("Fail");
			if (takeScreenShot==true){
				expectedResult=expectedResult.replaceAll("\\s","");
				Page.takescreenshot(expectedResult);			
				writer.append('\n');
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This function writes the test execution result status to the TestReport.csv file. Initially, 
	 * the status of the test execution result in the TestReport.csv file is 'NoRun'. After the 
	 * execution is completed,based on the execution status the test result will be overridden from NoRun
	 * to either pass or fail.
	 * @param testname - The test case name.
	 * @param status - The Test execution result. 
	 */
	public static void currentTestStatus(String testname, String status){
		if (status.contains("NoRun")){
			try {
				writer = new FileWriter(reportFileName,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				writer.append(testname);
				writer.append(',');
				writer.append(status);
				writer.append(',');
				if (status.contains("NoRun")){
					writer.append("Awaiting Execution");	
				}else{
					writer.append(Timer.getDateAndTime());
				}
				writer.append('\n');
				writer.flush();
				writer.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			/** Include the logic to scan the reportFileName excelsheet and
			 * overwrite the NoRun status to either pass or fail
			 */
		}
	}



	/**
	 * This function writes the test execution header to the TestReport.csv file.
	 * @param testname - The test case name.
	 * @param status - The Test execution result. 
	 */
	public static void createTestReportHeader(String testname, String status){

		try {
			writer = new FileWriter(reportFileName,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			writer.append(testname);
			writer.append(',');
			writer.append(status);
			writer.append(',');
			writer.append("EXECUTION TIME");
			writer.append('\n');
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * This function sends a pass status to the report file describing the test scenario,expected result
	 * actual result and screenshot if applicable. 
	 * @param description
	 * @param expectedResult
	 * @param actualResult
	 * @param takeScreenShot
	 */
	public static void pass(String description,String expectedResult, String actualResult, Boolean takeScreenShot){

		try {
			writer = new FileWriter(fileName,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			writer.append(Timer.getDateAndTime());
			writer.append(',');
			writer.append(description);
			writer.append(',');
			writer.append(expectedResult);
			writer.append(',');
			writer.append(actualResult);
			writer.append(',');
			writer.append("Pass");
			if (takeScreenShot==true){
				expectedResult=expectedResult.replaceAll("\\s","");
				Page.takescreenshot(expectedResult);
				writer.append('\n');
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**This function gets the current execution status of the test case
	 * @param -A string value which indicates the overall execution status
	 */
	
	public static String getOverallexecutionStatus(){
		String testStatus="PASS";
		if(blnFail){
			testStatus="FAIL";
		}		
		return testStatus;
	}

}
