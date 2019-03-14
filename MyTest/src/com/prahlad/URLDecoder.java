package com.prahlad;

import java.io.UnsupportedEncodingException;

public class URLDecoder {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		System.out.println(java.net.URLDecoder.decode("cef", "UTF-8"));
		String s = "1468828800.000||6679||192.104.158.50||TCP_HIT/200||7533||https://lms.latitudelearning.com||CONNECT||User423||DIRECT/68.232.44.42||-0||proxy9 ";
		String[] events = s.split("||");
		
		for(String s1 : events)
			System.out.println(s1);
	}

}
