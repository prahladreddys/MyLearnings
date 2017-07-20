package com.prahlad.orbitarydisplay;

import java.util.Arrays;

public class ORbitaryDisplayBaseN {
	public static void disp(int n){
		int[] out = new int[n];
		auxDisp(n,0,out);
	}
	private static void auxDisp(int n,int d,int[] out){
		if(d == n){
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i=0;i<n;i++){
			out[d] = i;
			auxDisp(n,d+1,out);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		disp(n);
	}

}
