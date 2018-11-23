package com.prahlad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTestSl4j {

	static Logger logger = LoggerFactory.getLogger(MyTestSl4j.class);
	
	public static void main(String[] args) {
		logger.info("In Main method");
		logger.info("INFO Statment");
		logger.debug("DEBUG");
		logger.warn("warn");
		logger.error("ERROR");
	}

}
