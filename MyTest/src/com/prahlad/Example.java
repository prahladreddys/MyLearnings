package com.prahlad;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Example {
   public static void main(String[] args) 
   {
       //Using Date class
       Date date = new Date();
       //Pattern for showing milliseconds in the time "SSS"
       DateFormat sdf = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss.SSSZ,");
       String stringDate = sdf.format(date);
       System.out.println(stringDate);
      
       //Using Calendar class
       Calendar cal = Calendar.getInstance();
       String stringDate2 = sdf.format(cal.getTime());
       System.out.println(stringDate2);
   }
}
