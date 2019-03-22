package com.prahlad.pyramid;

import java.util.Scanner;

public class Pyramid1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no of rows : ");
		int n = s.nextInt();
		pyramid(n);
		s.close();
	}

	private static void pyramid(int n) {
		for(int i=1 ;i <= n;i++){
			int whiteSpaces = n - i;
			printString(" ",whiteSpaces);
			printString(i+" ",i);
			System.out.println();
		}
	}

	private static void printString(String s, int whiteSpaces) {
		for(int j=0;j<whiteSpaces;j++){
			System.out.print(s);
		}
	}

}
