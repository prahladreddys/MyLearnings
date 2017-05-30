package com.develop;

import java.util.Arrays;
import java.util.List;

public class Sample2 {

	public static void main(String[] args) {
		// double the first even nu which is greate than 3
		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);
		// passing function to function
		// Higher - order fucntions
		// Lazy and composition
		System.out.println(values.stream().filter(Sample2::isGreaterThan3)
										.filter(Sample2::isEven)
										.map(e -> e *2 )
										.findFirst());

	}
	
	private static boolean isGreaterThan3(int number){
		return number >3;
	}
	
	private static boolean isEven(int number){
		return number % 2 ==0;
	}

}
