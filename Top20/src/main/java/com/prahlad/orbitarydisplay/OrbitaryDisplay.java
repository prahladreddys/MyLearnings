/**
 * 
 */
package com.prahlad.orbitarydisplay;

import java.util.Arrays;

/**
 * @author Prahlad created on 07-Jul-2017
 *
 */
public class OrbitaryDisplay {
	public static void disp(int n){
		for(int i=0;i<=1;i++){
			for(int j=0;j<=1;j++){
				System.out.println(i + " " + j);
			}
		}
	}
	public static void disp1(int n){
		auxDisp1(new int[n], 0, n);
	}
	private static void auxDisp1(int[] out,int d,int n){
		if(d == n){
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i=0;i<=1;i++){
			out[d] = i;
			auxDisp1(out,d+1,n);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		disp1(n);
	}

}
