package com.my.testDirectory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //repleaseString("\"[29/Aug/2017:08:45:33 +0100]\"");
        splitBytes("366/380/3392/6721");
        
    }

	private static void splitBytes(String s) {
		// TODO Auto-generated method stub
		if(s.contains("/")){
			String li[] = s.split("/");
			if(li.length ==4){
				System.out.println("Done");
				int in = Integer.parseInt(li[0])+Integer.parseInt(li[1]);
				int out = Integer.parseInt(li[2])+Integer.parseInt(li[3]);
				System.out.println(in + ","+ out);
			}
		}
	}

	private static void repleaseString(String s) {
		s= s.replaceAll("[\\[|\"|\\]]", "");
//		s = s.replaceAll("\\[", "");
		System.out.println(s);
		dateConversion(s);
	}

	private static void dateConversion(String date) {
		String pattern = "dd/MMM/yyyy:HH:mm:ss Z";
		try{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
			LocalDateTime ldt = LocalDateTime.parse(date,dtf);
			System.out.println(ldt.toString());
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
