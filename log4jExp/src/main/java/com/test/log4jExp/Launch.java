package com.test.log4jExp;

import org.apache.log4j.Logger;

public class Launch {
	private static Logger log = Logger.getLogger(Launch.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.info("Starting launcher ..");
		log.debug("Debug Message ");
		log.info("Ending..");
		log.error("ERROR");
	}

}
