package com.prahlad.intv;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiTest {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);l.add(5);l.add(10);l.add(15);l.add(20);l.add(25);l.add(30);
		
		System.out.println(l);
		
		List<Integer> l1 = l.stream().filter(i -> (i % 2 == 0))
											  .collect(Collectors.toList());
		System.out.println(l1);
		
		int noOfodd = (int) l.stream().filter(i -> i % 2 == 0).count();
		System.out.println(noOfodd);
	}
}
