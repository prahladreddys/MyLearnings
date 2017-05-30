package com.develop;

import java.util.stream.IntStream;

public class sample {

	public static void main(String[] args) {
		System.out.println("Working on jdk 8 features");
		System.out.println(isPrime(1));
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		System.out.println(isPrime(4));
	}

	private static boolean isPrime(int number) {
		// Checking number is prime or not
		// imperative - saying how 
		// mutability
//		for(int i=2;i<number;i++){
//			if(number % i == 0) return false;
//		}
//		return number > 1;
		
		//Declarative style of coding - what
		// immutability
		
		return number > 1 && IntStream.range(2, number)
										.noneMatch(index -> number % index == 0);
	}

}
