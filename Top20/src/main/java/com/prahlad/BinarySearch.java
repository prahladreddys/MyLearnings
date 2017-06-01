/**
 * 
 */
package com.prahlad;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Prahlad created on 31-May-2017
 *
 */
public class BinarySearch {
	/**
	 * <= c * n times ~ O(n)
	 * @param in
	 * @param v
	 * @return
	 */
	public static boolean binarySearch1(int[] in,int v){
		for(int i=0;i<in.length;i++){
			if(v == in[i]){ // This call will be executed n times so time complexity will be O(n) - worst case performance
				return true;
			}
		}
		return false;
	}

	public static boolean binarySearch2(int[] in, int v){
		int first = 0;
		int last = in.length;
		int middle = (first + last )/2;
		while( first <= last )
	    {
	      if ( in[middle] < v )
	        first = middle + 1;    
	      else if ( in[middle] == v ) 
	      {
	        return true;
	      }
	      else
	         last = middle - 1;
	 
	      middle = (first + last)/2;
	   }
	   if ( first > last )
	      System.out.println(v + " is not present in the list.\n");
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
		for(int i:in)
			System.out.print(i + " ");
		System.out.println("\nTo be search: "+ s);
		long start = System.currentTimeMillis();
		System.out.println(binarySearch2(in, s));
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: "+ (end - start)/1000.0 +" Seconds");
	}

}
