package com.prahlad.hackerrank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConverstion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
        in.close();
	}

	private static String timeConversion(String s) {
		DateFormat df1 = new SimpleDateFormat("hh:mm:ssa");
		DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
		String out = null;
		try {
			Date date = df1.parse(s);
			out = df2.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return out;
	}
}
