package com.prahlad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Timezone {
	private static final DateTimeFormatter dtm = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LocalTime time = LocalTime.now();
		System.out.println(time);
		System.out.println("Timezone:: "+ ZoneId.systemDefault().getId());
		
		LocalTime time1 = LocalTime.now();
		System.out.println(time1);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("One Time log agent starting at : " + dtm.format(ldt) + "for Tenant :");
		//Thread.sleep(60000);
		System.out.println("One Time log agent processing completed at : " + dtm.format(LocalDateTime.now()));
		System.out.println(System.currentTimeMillis());
		
		System.out.println("ldt " + Math.toIntExact(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond()));
		System.out.println("ctm " + System.currentTimeMillis()/1000);
		
		System.out.println("Current time in long format : "+ Math.toIntExact(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond()));
	}

}
