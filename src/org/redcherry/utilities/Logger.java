package org.redcherry.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	
	
    public static void log(String message) { 
      
    	String currentTime=Timer.timeNow();
    	String currentDate=Timer.dateNow();
    	String dateandtime=currentDate+"  "+currentTime;
    	PrintWriter out;
      
	try {
		out = new PrintWriter(new FileWriter("C:\\SeleniumSolutions\\ExecutionLogs.txt",true), true);
		String newLine = System.getProperty("line.separator");
		out.write(dateandtime+"  "+message+newLine);
	    out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
    }
}
