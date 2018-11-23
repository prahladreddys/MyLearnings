package com.prahlad.logger;

import org.apache.log4j.Logger;


public class MyLogger {

	static Logger log = Logger.getLogger(MyLogger.class);
	
	public static void main(String[] args) {
		log.info("INFO Statment");
		log.debug("DEBUG");
		log.warn("warn");
		log.error("ERROR");
		
		String value1 = "sdfsd";
		String value2 = "sdfsdfdsasdasdasds";
		
		log.info("first:: "+value1+"\n second:"+value2);
		meth(value1,value2);
	}

	private static void meth(String value1, String value2) {
		log.info("Started executing the meth() with parameters value1: "+ value1 + " value2:" + value2);
		// business process
	}

}
