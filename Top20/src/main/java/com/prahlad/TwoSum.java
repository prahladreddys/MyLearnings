/**
 * 
 */
package com.prahlad;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Prahlad created on 31-May-2017
 * 
 * i/p : Sorted Array of n nos and sum value
 * o/p: if sum of two nos in the array is present then true else false
 *
 */
public class TwoSum {
	/**
	 * <= n * n ~ c * n2 ~ O(n2)
	 * @param in
	 * @param s
	 * @return
	 */
	public static boolean twoSum1(int[] in,int s){
		for(int i=0;i<in.length;i++){
			for(int j=0;j<in.length;j++){
				if(s == in[i]+in[j]){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * take one element and search in remaining elements
	 * 
	 * @param in
	 * @param s
	 * @return
	 */
	public static boolean twoSum2(int[] in , int s){
		for(int i=0;i<in.length;i++){
			if(Arrays.binarySearch(in, i+1, in.length, s-in[i]) <= 0){
				return true;
			}
		}
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int[] in = new int[size];
		Random r = new Random();
		for(int i=0;i<size;i++){
			in[i]=r.nextInt(size)+1;
		}
		int s = r.nextInt(size);
		Arrays.sort(in);
//		for(int i:in)
//			System.out.print(i + " ");
		System.out.println("\nSum: "+ s);
		long start = System.currentTimeMillis();
		System.out.println(twoSum2(in, s));
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: "+ (end - start)/1000.0 +" seconds");
	}

}
