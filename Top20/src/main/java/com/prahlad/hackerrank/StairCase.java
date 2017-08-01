package com.prahlad.hackerrank;

import java.util.Scanner;

public class StairCase {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		stairCase1(n);
		s.close();
	}

	private static void stairCase1(int n) {
		int spaces = n-1;
		for(int i=1;i<=n;i++){
			for(int j=0;j<n;j++){
				if(spaces > 0)
					System.out.print(" ");
				else
					System.out.print("#");
				spaces--;
			}
			System.out.println();
			spaces = n-(i+1);
		}
	}

	private static void stairCase(int n) {
		auxDisp(0,n-1,n);
	}

	private static void auxDisp(int i, int spaces,int n) {
		if(i == n) return;
		for(int j = 0; j < spaces; ++j)
			System.out.print(' ');
		System.out.println("#");
		auxDisp(i+1,spaces-1,n);
	}
}
