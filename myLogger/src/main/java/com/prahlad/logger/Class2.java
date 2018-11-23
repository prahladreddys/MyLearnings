package com.prahlad.logger;

import org.apache.log4j.Logger;

public class Class2 {

	static Logger LOG = Logger.getLogger("MYLOGGER".getClass());
	
	public static void main(String[] args) {
		LOG.warn("WARRNING MESSAGE...");

	}

}
