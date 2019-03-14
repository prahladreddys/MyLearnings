package com.prahlad.client;

import java.util.Scanner;

public class some {
	private static boolean isAVowel(char c){
		switch(c){
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u': return true;
		default: return false;
		}
	}
	private static int findSurroundedByVowelsCount(String word){
		if(word.length()<=2){
			return 0;
		}
		int n = word.length();
		int count = 0;
		//leave first and last character
		char currChar = '$';
		char prevChar = '$';
		char nextChar = '$';
		for(int i = 1;i<n-1;i++){
			currChar = word.charAt(i);
			prevChar = word.charAt(i-1);
			nextChar = word.charAt(i+1);
			if(isAVowel(currChar)){
				continue;
			}else {
				if(isAVowel(prevChar) && isAVowel(nextChar)){
					count++;
				}
			}
		}
		
		return count;
	}
	private static void printVowels(String sentence){
		
		String[] words = sentence.split(" ");
		for(String word:words){
			int count = findSurroundedByVowelsCount(word);
			if(count != 0){
				System.out.println(word+"("+count+")");
			}
		}
	}
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String sentence = sc.nextLine();
	printVowels(sentence);
	/*String sentence = "people are friendly in hyderabad";
		printVowels(sentence);
		*/
	}
}
