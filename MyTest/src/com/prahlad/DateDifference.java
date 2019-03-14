package com.prahlad;

public class DateDifference {

	public static void main(String[] args) {
		long msgPublishedTime = 1511355734000L;
		long current = System.currentTimeMillis();
		
		long diff = current - msgPublishedTime;
		
		System.out.println(diff);
		int noOfDays = (int) (diff/(24 * 60 * 60 * 1000));
		if(noOfDays > 30){
			System.out.println("Days:"+diff/(24 * 60 * 60 * 1000));
		}
		
		
		int noOfMin = (int)(diff/(60 * 1000));
		
		System.out.println(noOfMin);
		System.out.println(diff);
		if(diff > (60 * 1000)){
			System.out.println("TRUE");
		}
		
	}

}
