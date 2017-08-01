package com.prahlad.hackerrank;

import java.util.Scanner;

public class input {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] ar = new int[n][n];
//		int i=0;
//		while(i < n){
//			int j=0;
//	        while(j < n)
//	            ar[i][j++] = in.nextInt();
//	        i++;
//	    }
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				ar[i][j] = in.nextInt();
			}
		}
		for(int i1=0;i1<ar.length;i1++){
			for(int j=0;j<ar.length;j++){
				System.out.print(ar[i1][j] +" ");
			}
			System.out.println();
		}
	}
	
}
