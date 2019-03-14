package com.intv;

public class TestEnv {

	public static void main(String[] args) {
		String s = System.getProperty("config");
		System.out.println("Value: "+ s);
	}

}
