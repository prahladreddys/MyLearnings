package com.prahlad;

import java.util.Base64;

public class TestEnv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getenv("test"));
		System.out.println(System.getProperty("test"));
		encodieAndDecode();
	}

	private static void encodieAndDecode() {
		Base64.Encoder encode = Base64.getEncoder();
		Base64.Decoder decode = Base64.getDecoder();
		
		String s = "26/03/2018 10:50:23";
		
		String encodedStr = encode.encodeToString(s.getBytes());
		System.out.println("Encoded Str: "+encodedStr);
		try{
			String decodeStr = new String(decode.decode(encodedStr));
			System.out.println("Decoded Str:"+ decodeStr);
		}catch(Exception e){
			
		}
	}

}
