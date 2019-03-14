package com.prahlad;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		System.out.println("Starting..");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter value of n: ");
		int n = scanner.nextInt();
		long startTime = System.currentTimeMillis();
		System.out.println("Factorial of "+n+" is:: "+itertaionFactorial(n));
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken :: "+ (endTime - startTime));
		scanner.close();
		
		long startTime1 = System.currentTimeMillis();
		System.out.println(recursive(n));
		long endTime1 = System.currentTimeMillis();
		System.out.println("Time taken :: "+ (endTime1 - startTime1));
	}

	private static int recursive(int n) {
		if(n == 0)
			return 1;
		return n * recursive(n-1);
	}

	private static int itertaionFactorial(int n) {
		int value =1;
		for(int i=1;i<=n;i++){
			value = value * i;
		}
		return value;
	}

}
