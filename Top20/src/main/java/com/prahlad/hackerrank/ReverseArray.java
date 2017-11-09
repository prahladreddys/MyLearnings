package com.prahlad.hackerrank;

import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++)
			in[i] = s.nextInt();
		for(int i=n-1;i>=0;i--){
			System.out.print(in[i]+" ");
		}
		s.close();
	}

}
