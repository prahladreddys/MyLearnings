package com.prahlad;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Integer[] intArr = {10,20,30,10,20,40,50,50,40,30};
		//System.out.println(intArr.length);
		//Solution 1
		solution1(intArr);
		solution2(intArr);
	}

	
	private static void solution1(Integer[] intArr) {
		System.out.println("Solution 1 Started");
		Stream<Integer> streams = Arrays.stream(intArr).distinct();
//		Iterator<Integer> it = streams.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		List<Object> list = streams.collect(Collectors.toList());
		list.forEach(System.out::println);
		System.out.println("Solution 1 Completed");
	}
	private static void solution2(Integer[] intArr) {
		Set<Integer> set = new LinkedHashSet<Integer>(Arrays.asList(intArr));
		System.out.println("Solution 2 started ..");
		for(Integer i :set){
			System.out.println(i);
		}
		System.out.println("Solution 2 Done");
	}

}
