package com.prahlad.client;

import java.util.ArrayList;
import java.util.List;

public class SummOfIntergers {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(5);
		list.add(7);
		
		int sum = list.stream().mapToInt(i -> i).sum();
		
		System.out.println(sum);
		
		String s = "hi prahlad";
		
		
		
	}
}
