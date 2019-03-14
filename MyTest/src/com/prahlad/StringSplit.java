package com.prahlad;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringSplit {
	public static void main(String[] args) {
		String s = "12321\n"
				+ "12312312\n"
				+ "12";
		String[] s1 = s.split("[\\r\\n]+");
		for(String s2:s1){
			//System.out.println(s2);
		}
		
		testMethod();
	}

	private static void testMethod() {
		String s = "1468828800.000:6679:192.104.158.50!TCP_HIT/200!7533!https://lms.latitudelearning.com!CONNECT!User423!DIRECT/68.232.44.42!-0!proxy9";
		
		String regex = ":";
		
		String[] str = s.split(regex);
		
		for(String s1 : str)
			System.out.println(s1);
		
	}
}
