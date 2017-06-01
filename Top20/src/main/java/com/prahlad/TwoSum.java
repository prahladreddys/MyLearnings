/**
 * 
 */
package com.prahlad;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
	 *  TC : log n + log (n-1) + ... +1
	 *  	~ n log n
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
	 * TC : O(n)
	 * SC: O(1)
	 * @param in
	 * @param s
	 * @return
	 */
	public static boolean twoSum3(int[] in, int s){
		for(int i=0,j=in.length-1;i<j;){
			if(in[i]+in[j] == s){
				return true;
			} else if (in[i]+in[j] < s){
				i++;
			} else{
				j--;
			}
			
		}
		return false;
	}
	/**
	 * TC: n * c ~ O(n)
	 * SC: O(n)
	 * 
	 * @param in
	 * @param s
	 * @return
	 */
	public static boolean twoSum4(int[] in , int s){
		Set<Integer> set = new HashSet<Integer>();
		for(int i =0;i<in.length;i++){
			if(set.contains(s-in[i])){
				return true;
			} else {
				set.add(in[i]);
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
//		int[] in = {2,5,7,8,10};
//		int s = 0;
		//Arrays.sort(in);
//		for(int i:in)
//			System.out.print(i + " ");
		System.out.println("\nSum: "+ s);
		executeTestCase(in,s);
		
	}
	private static void executeTestCase(int[] in, int s) {
		execute(in,s,4);
		Arrays.sort(in);
		execute(in,s,1);
		execute(in,s,2);
		execute(in,s,3);
	}
	
	private static void execute(int[] in,int s,int i){
		
		String methodName = "twoSum"+i;
		System.out.println("executing method : "+ methodName);
        
		Method method;
		try {
			Class<TwoSum> obj = (Class<TwoSum>) Class.forName("com.prahlad.TwoSum");
			method = obj.getMethod(methodName,int[].class,int.class);
			long start = System.currentTimeMillis();
			System.out.println(method.invoke(obj,in, s));
			long end = System.currentTimeMillis();
			System.out.println("Time Taken: "+ (end - start)/1000.0 +" seconds");		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
