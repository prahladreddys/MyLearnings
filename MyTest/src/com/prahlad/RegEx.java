package com.prahlad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
	public static void main(String[] args) {
		String cefRegex = "\\s(rt\\=.*?)(?=\\s[a-z]\\w|$)";
		
		String eventStr = "CEF:0|Websense|Security|7.7.3|113|Transaction permitted|Low|eventId=262912007 app=https in=7093 out=7616 art=1424434401000 deviceSeverity=1 act=permitted rt=1481016443500";
		
		Pattern r = Pattern.compile(cefRegex);
		
		 Matcher m = r.matcher(eventStr);
		 if(m.find()){
			 System.out.println("found");
		 }else {
			 System.out.println("Not found");
		 }
	}
}
