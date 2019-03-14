package com.prahlad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * int n =5
 * 
 * o/p: 0 1 1 2 3 5
 * 
 * @author CipherCloud
 *
 */

public class fibnaciseries {
	public static int n1=0,n2=1,n3=0;
	public static void main(String[] args) {
		try(BufferedReader br =new BufferedReader(new InputStreamReader(System.in))){
			String value = br.readLine();
			int i = Integer.parseInt(value);
			long startTime = System.currentTimeMillis();
			iteration(i);
			long endTime = System.currentTimeMillis();
			System.out.println("\n Time taken :: "+ (endTime - startTime));
			
			long startTime1 = System.currentTimeMillis();
			long endTime1 = System.currentTimeMillis();
			System.out.print(n1+" "+n2);
			recursive(i-2);
			System.out.println("\nTime taken :: "+ (endTime1 - startTime1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void recursive(int i) {
		if ( i > 0) {
		n3 = n1+n2;
		n1=n2;
		n2=n3;
		System.out.print(" "+n3);
		recursive(i-1);
		}
	}

	private static void iteration(int n) {
		int n1 = 0;
		int n2 = 1;
		int n3;
		System.out.print(n1+" "+n2);
		for(int i = 2 ; i < n ;i++ ){
			n3 = n2 +n1;
			System.out.print(" "+n3);
			n1 = n2;
			n2 = n3;
		}
		
		
	}

}
