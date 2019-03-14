package com.prahlad;

import java.util.Arrays;

public class AnagramsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isAnagram("car", "arc"));
		System.out.println(isAnagram("boss", "bass"));
		System.out.println(isAnagram("Boss","Ossb"));
	}
	public static boolean isAnagram(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		char[] s1_char = s1.toLowerCase().toCharArray();
		char[] s2_char = s2.toLowerCase().toCharArray();
		Arrays.sort(s1_char);
		Arrays.sort(s2_char);
		
		return Arrays.equals(s1_char, s2_char);
	}

}
