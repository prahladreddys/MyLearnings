package com.prahlad.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MinAndMaxSum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long max, min, sum;
	    sum = max = min = s.nextLong();

	    for(int i=1; i<5;i++){
	        long temp = s.nextLong();
	        sum += temp;
	        if(max>temp){
	            if(min > temp) {
	                min = temp;
	            }
	        } else {
	            max = temp;
	        }
	    }

	    System.out.print((sum -max) + " " + (sum - min));
		s.close();
	}

//	private static void findMinMaxSum(int[] in, int n) {
//		//Arrays.sort(in);
//		int totalSum = 0;
//		for(int i=0;i<n;i++){
//			totalSum = totalSum + in[i];
//		}
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
//		for(int i=0;i<n;i++){
//			min = Math.min(min, totalSum-in[i]);
//			max = Math.max(max, totalSum - in[i]);
//		}
//		System.out.println(min + " "+ max);
//	}

}
