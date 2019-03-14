package com.prahlad.client;

import java.util.Arrays;
import java.util.Scanner;

public class PrintAEIOU {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();
		String[] aSt = st.split("\\s");
		if(aSt.length <= 10 ){
			for(String s1:aSt){
				checkVowels(s1);
			}
		}
		
		s.close();
	}

	private static void checkVowels(String s1) {
		int vowels = 0;
		
		char[] ch = s1.toCharArray();
		if(ch.length > 20){
			return;
		}
		char current = '$';
		char previous = '$';
		char next = '$';
				
		for(int i =1;i<ch.length-1;i++){
			current = ch[i];
			previous = ch[i-1];
			next = ch[i+1];
			if(isVowel(current)){
				continue;
			} else{
				if(isVowel(previous) && isVowel(next)){
					vowels ++;
				}
			}
			
		}		
		if(vowels != 0){
			System.out.println(s1+"("+vowels+")");
		}
		
	}
	private static boolean isVowel(char ch) 
	{ 
	    if (ch == 'a' || ch == 'e' || ch == 'i' || 
	            ch == 'o' || ch =='u') 
	        return true; 
	    return false; 
	} 
}
