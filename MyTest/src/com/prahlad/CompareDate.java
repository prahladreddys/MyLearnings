package com.prahlad;

import java.time.LocalDate;
import java.util.Date;

public class CompareDate {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.compareTo(d) == 0);
		
		// tephen Colebourne created a library of his own. He later released it to public as Joda API. 
		// The Java 8 package java.time is largely derived from the Joda API
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate todayAgain = LocalDate.now();
		System.out.println(todayAgain);
		System.out.println(today.compareTo(todayAgain) == 0);
	}
}
