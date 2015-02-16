package org.redcherry.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;



import jxl.Sheet;
import jxl.Workbook;

public class TestSettings {	

	public static String filename;
	public static String reportFileName;
	public static String testFolderPath;

	public static 	void  loadUIObjectlocators(){
		Properties UIlocatorsprop;		   
		UIlocatorsprop = new Properties();
		InputStream in = TestSettings.class.getResourceAsStream("uiobjectlocators.properties");
		try {
			UIlocatorsprop.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initiateTest(String className) {
		createFolder(className);
		try {
			createTestReportFile();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static 	void  loadGlobalTestParameters(){
		Properties Testprop;		   
		Testprop = new Properties();
		InputStream in = TestSettings.class
		.getResourceAsStream("test.properties");
		try {
			Testprop.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void createFolder(String folderName){

		try {
			File file = new File("C://Users//timothyr//git//greenwork//myframework//src//org//redcherry//resources//test.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties testProperties = new Properties();
			testProperties.load(fileInput);
			fileInput.close();
			testProperties.getProperty("basefolder.path");
			File basefolderpath=new File(testProperties.getProperty("basefolder.path"));
			if (basefolderpath.exists()){

			}else
			{
				File dir = new File(basefolderpath.toString());
				dir.mkdir();				
			}
			File testFolder=new File(basefolderpath.toString()+"\\"+folderName);
			testFolderPath=testFolder.toString()+"\\";
			if (testFolder.exists()){

			}else{
				File dir = new File(testFolder.toString());
				dir.mkdir();
			}

			File csvFile=new File(testFolder.toString()+"\\"+folderName+".csv");

			if (csvFile.exists()){
				filename=csvFile.toString();				
			}else{
				csvFile.createNewFile();
				filename=csvFile.toString();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public static void createTestReportFile() throws ClassNotFoundException{

		try {
			File file = new File("C://Users//timothyr//git//greenwork//myframework//src//org//redcherry//resources//test.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties testProperties = new Properties();
			testProperties.load(fileInput);
			fileInput.close();		
			testProperties.getProperty("basefolder.path");
			File basefolderpath=new File(testProperties.getProperty("basefolder.path"));
			if (basefolderpath.exists()){

			}else
			{
				File dir = new File(basefolderpath.toString());
				dir.mkdir();				
			}
			File csvFile=new File(basefolderpath.toString()+"\\"+"TestReport"+".csv");

			if (csvFile.exists()){
				reportFileName=csvFile.toString();				
			}else{
				csvFile.createNewFile();
				reportFileName=csvFile.toString();
			}
			getClasses("org.redcherry.testcases");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	public static LinkedHashMap<String,String> loadTestData(String excelPath) {
		int rowId=1;
		LinkedHashMap<String,String> rowData = new LinkedHashMap<String,String>(); 
		try{						
			
			InputStream dtExcel = new FileInputStream(excelPath);
			Workbook xlFile = Workbook.getWorkbook(dtExcel);
			Sheet xlSheet = xlFile.getSheet(0);
			int col = 0;
			int colcnt=xlSheet.getColumns()-1;	
			while(col<=colcnt){
				rowData.put((xlSheet.getCell(col,0).getContents()),xlSheet.getCell(col,rowId).getContents());				
				col++;			
			}
			dtExcel.close();
		}catch (Exception ex)    {
										
		}
		return rowData;
	}

	/**
	 * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
	 * @param packageName The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Class[] getClasses(String packageName)
	throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		

		Report.createTestReportHeader("TEST CASE NAME", "STATUS");

		for(int i=0;i<classes.size();i++){
			String simplename=classes.get(i).getSimpleName();
			Report.currentTestStatus(simplename, "NoRun");
		}
		return classes.toArray(new Class[classes.size()]);
	}

	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 * @param directory   The base directory
	 * @param packageName The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	public static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}
}