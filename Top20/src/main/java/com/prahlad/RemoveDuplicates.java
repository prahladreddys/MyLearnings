package com.prahlad;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicates {

	public static void main(String[] args) {
		//Integer[] intArr = {10,20,30,10,20,40,50,50,40,30};
		
		int size = Integer.parseInt(args[0]);
		Integer[] intArr = new Integer[size];
		Random r = new Random();
		for(int i=0;i<size;i++){
			intArr[i] = r.nextInt(size);
		}
//		for(int i=0;i<intArr.length;i++){
//			System.out.print(intArr[i]+" ");
//		}
		long start = System.currentTimeMillis();
		//solution1(intArr);
		//solution2(intArr);
//		Integer[] out = solution3(intArr);
		Integer[] out = solution4(intArr);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken : "+ (end-start)/1000.0 + " seconds");
//		for(Integer i:out){
//			System.out.print(i+ " ");
//		}
	}
	/**
	 * Sorting input array and compare the elements 
	 * @param intArr
	 * @return
	 * Time: o n logn + cn
	 * 			c n logn = O(n logn)
	 */
	private static Integer[] solution4(Integer[] intArr) {
		// n logn comparisions
		Arrays.sort(intArr);
		int i=0,j,ndistinct=1;
		// c * n = O(n)
		for(j=i+1;j<intArr.length;++j){
			if(intArr[i]==intArr[j]){
				intArr[j]=Integer.MAX_VALUE;
			} else {
				i = j;
				++ndistinct;
			}
		}
		Integer[] out = new Integer[ndistinct];
		int k =0;
		for(Integer e : intArr){
			if(e != Integer.MAX_VALUE){
				out[k++] = e;
			}
		}
		return out;
	}

	/**
	 * using data structure solving remove duplicate problem
	 * @param intArr
	 * @return
	 * Time:2n
	 * Space:
	 */
	private static Integer[] solution3(Integer[] intArr) {
		Set<Integer> set = new HashSet<Integer>();
		// 2n + O(1)
		for(Integer i:intArr){
			if(!set.contains(i)){
				set.add(i);
			}
		}
		Integer[] out = new Integer[set.size()];
		int i=0;
		for(Integer s:set){
			out[i++]=s;
		}
		return out;
	}


	private static void solution1(Integer[] intArr) {
//		System.out.println("\nSolution 1 Started");
//		Stream<Integer> streams = Arrays.stream(intArr).distinct();
		Arrays.stream(intArr).distinct().forEach(System.out::print);
//		Iterator<Integer> it = streams.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
//		List<Object> list = streams.collect(Collectors.toList());
		//list.forEach(System.out::print);
//		System.out.println("\nSolution 1 Completed");
	}
	private static void solution2(Integer[] intArr) {
		Set<Integer> set = new LinkedHashSet<Integer>(Arrays.asList(intArr));
//		System.out.println("\nSolution 2 started ..");
		for(Integer i :set){
			System.out.print(i);
		}
//		System.out.println("\nSolution 2 Done");
	}

}
