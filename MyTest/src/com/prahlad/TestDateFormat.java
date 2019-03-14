package com.prahlad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.TimeZone;

public class TestDateFormat {
	private static final DateTimeFormatter dtm = DateTimeFormatter.ofPattern("yyyy/MM/dd:HH:mm:ss");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Testing date format");
//		LocalDateTime ldt = LocalDateTime.now();
//		System.out.println(dtm.format(ldt));
		simpleDateFormatTest();
//		dataFormmater();
	}

	private static void dataFormmater() {
		String format = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
		String date = "2014-05-20T21:53:44.172+02:00";
		try{
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
			LocalDateTime localDateTime = LocalDateTime.parse(date,dateFormatter);
			System.out.println(localDateTime.toString());
		}catch(DateTimeParseException e){
			e.printStackTrace();
		}
		
	}

	private static void simpleDateFormatTest() {
//		String format = "ddMMMyyyy HH:mm:ss";
//		String date = "19Sep2016 6:26:13";
		String format = "Z mm/dd/yyyy hh:mm:ss";
		String date ="UTC 01/22/2019 08:10:20";
		
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			Date d1 = sdf.parse(date);
			System.out.println(d1.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(sdf.format(d.toString()));
		
	}

}
