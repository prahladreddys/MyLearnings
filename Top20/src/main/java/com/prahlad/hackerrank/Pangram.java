package com.prahlad.hackerrank;

import java.util.Scanner;
import java.util.Set;


public class Pangram {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String in =  s.nextLine();
		in = in.replaceAll("\\s", "");
		in = in.toLowerCase();
		if(in.length() < 26){
			System.out.println("not pangram");
			return;
		}
		//System.out.println(in);
		Set<Character> set = new java.util.HashSet<Character>();
		for(int i=0;i<in.length();i++){
			set.add(in.charAt(i));
		}
		if(set.size() == 26){
			System.out.println("pangram");
		} else {
			System.out.println("not pangram");
		}
		s.close();
	}

}
