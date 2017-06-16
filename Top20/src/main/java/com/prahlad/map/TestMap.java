package com.prahlad.map;

import java.util.Random;

public class TestMap {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Map map = new HashMap();
		testCase1(map,n);
	}
	public static void testCase1(Map map,int n){
		Random r = new Random();
		for(int i=0;i<n;i++){
			map.add(""+i, r.nextInt(n)+1);
		}
		System.out.println(map.size());
		map.display();
	}

}
