package com.prahlad;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class IsValidURL {
	
	
	public static void main(String[] args) {
		String url = "https://www.google.co.in/";

		System.out.println("The URL is valid: " + urlValidator(url));

		String url1 = "http://localhost:8081///ping";
		System.out.println("The URL is valid: " + urlValidator(url1));
	}

	
//	public static boolean urlValidator(String url) {
//
//		/* Try creating a valid URL */
//		try {
//			new URL(url).toURI();
//			return true;
//		}
//
//		// If there was an Exception
//		// while creating URL object
//		catch (Exception e) {
//			return false;
//		}
//	}
	public static boolean urlValidator(String name){
		
		InputStream i = null;
		try {
			URL url = new URL(name);
			 i = url.openStream();
		} catch (IOException e) {
			//System.err.println("Invalid URL");
		}
		return (i==null)?false:true;
	}
}
