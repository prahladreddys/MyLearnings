package com.prahlad;

import java.util.Arrays;

public class TestString {

	public static void main(String[] args) {
		System.out.println("Testing string manipulation problems");
		// finding is string is unique character string or not
		System.out.println(isUniqueChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ^"));
		System.out.println(isUniqueChars("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(isUniqueChars("ravi"));
		System.out.println(isUniqueChars("hi prald"));
		
		//Sorting a string 		
		System.out.println(sort("prahlad"));
		
		// two string are permutation of other
		// s1 = "god" s2="dog"
		// permutation : they have character but in different order
		System.out.println(permutation("god","dog"));
		System.out.println(permutation("reddy", "prahlad"));
		
		//i/p="hi this is prahlad"
		//o/p="hi%20this%20is%20prahlad"
		String input = "hi this is prahlad";
		System.out.println(replaceSpace(input.toCharArray(),input.length()));
		
		//ip="aabbbcdddd"
		//op="a2b3c1d4
		System.out.println(printCount("aabbbcdddd"));
	}
	private static String printCount(String s) {
		String output = "";
		char last = s.charAt(0);
		int count=1;
		for(int i=1;i<s.length();i++){
			//System.out.println(s.charAt(i));
			if(s.charAt(i) == last){
				count++;
			}else {
				output = output+ last + "" +count;
				count = 1;
				last = s.charAt(i);
			}
		}
		output = output + last + "" +count;
		return output;
	}
	private static String replaceSpace(char[] s,int length) {
		int spaceCount = 0,newLength,i;
		for(i=0;i<length;i++){
			if(s[i] == ' ')
				spaceCount++;
				
		}
		newLength = length + (spaceCount*2);
		char[] newArray = new char[newLength+1];
	    newArray[newLength] = '\0';
	    System.out.println(new String(newArray));
		for(i=length-1;i>=0;i--){
			if(s[i] == ' '){
				newArray[newLength-1]='0';
				newArray[newLength-2]='2';
				newArray[newLength-3]='%';
				newLength = newLength -3;
			} else {
				newArray[newLength-1]=s[i];
				newLength = newLength-1;
			}
		}
		return new String(newArray);
	}
	/**
	 * permutation of two strings
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean permutation(String s1, String s2) {
		
		return sort(s1).equals(sort(s2));
	}

	/**
	 * Method to find the string having unique characters or not 
	 * 
	 * @param string
	 */
	private static boolean isUniqueChars(String s) {
		if(s.length() > 128) return false;
		boolean[] char_set = new boolean[256];
		for(int i=0;i<s.length();i++){
			int val = s.charAt(i);
			System.out.print(val +" ");
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	/**
	 * Sorting string using arrays
	 * @param string
	 * @return
	 */
	private static String sort(String string) {
		char[] char_s = string.toCharArray();
		Arrays.sort(char_s);
		return new String(char_s);
	}

}
