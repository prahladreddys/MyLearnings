package com.prahlad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Random;

public class RandomDateBetweenDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateDate();
	}

	private static void generateDate() {
		Random random = new Random();
		LocalDate today = LocalDate.now();
		int minDay = (int) LocalDate.of(today.getYear(), today.getMonth(), 01).toEpochDay();
		int maxDay = (int) today.toEpochDay();
		
		LocalDateTime now = LocalDateTime.now();
//		System.out.println(minDay);
//		System.out.println(maxDay);
//		for (int i = 0; i < 10; i++) {
//			long randomDay = minDay + random.nextInt(maxDay - minDay);
//
//			LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
//			System.out.println(randomDay);
//			ZoneId zoneId = ZoneId.systemDefault();
//			System.out.println(randomBirthDate.atStartOfDay(zoneId).toEpochSecond());
//		}
		System.out.println(now);
		System.out.println(now.toLocalDate().minus(30, ChronoUnit.DAYS));
	}

}
