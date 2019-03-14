package com.prahlad;

import java.util.Collections;

public class SortStrings {

	public static void main(String[] args) {
		String[] strings = {"c","b","a","d"};
		System.out.println("Before : "+ strings);
		for(String s : strings)
			System.out.print(s+"\t");
	//	Collections.sort(strings, (String a, String b) -> a.compareTo(b));
	}
}
