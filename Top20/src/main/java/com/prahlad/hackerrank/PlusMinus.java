package com.prahlad.hackerrank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class PlusMinus {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++){
			in[i] = s.nextInt();
		}
		plusMinus(in,n);
		s.close();
	}

	private static void plusMinus(int[] in, int n) {
		float po = 0;
		float ne = 0;
		float de = 0;
		for(int i =0 ;i<n;i++){
			if(in[i] > 0){
				po++;
			} else if (in[i] < 0){
				ne++;
			} else {
				de++;
			}
		}
		DecimalFormat df = new DecimalFormat("#.######");
		System.out.println(df.format(po/n));
		System.out.println(df.format(ne/n));
		System.out.println(df.format(de/n));
	}
}
