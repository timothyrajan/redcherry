package org.redcherry.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Timer {	
	
	/** The date format.This is used for Logging and Reporting purpose */
	private static String DATE_FORMAT_NOW = "yyyy-MM-dd";

	/** The time format.This is used for Logging and Reporting purpose */
	private static String TIME_FORMAT_NOW = "HH:mm:ss";
	
	
	/**
	 * This method instructs the current execution flow to wait for a specified time 
	 * mentioned in the argument.
	 * @param number of seconds to wait.
	 * @return the current system time.
	 */
	public static void wait(int seconds) {
		int millisec=seconds*1000;		
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * This method gets the current system time and returns it.
	 * @return the current system time.
	 */
	public static String timeNow() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT_NOW);	
		return sdf.format(cal.getTime());
	}

	/**
	 * This method gets the current system date and returns it.
	 * @return the current system date.
	 */
	public static String dateNow() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);	
		return sdf.format(cal.getTime());
	}
	
	
	/**
	 * This method gets the current system date and time.
	 * @return the current system date and time in string format.
	 */
	public static String getDateAndTime(){
		return dateNow()+"  "+timeNow();
	}

}
