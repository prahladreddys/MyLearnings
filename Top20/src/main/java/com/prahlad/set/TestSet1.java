package com.prahlad.set;

import java.util.Random;

public class TestSet1 {
	public static void testCase1(ISet set,int n){
		Random r = new Random();
		int e;
		for(int i=0;i<n;i++){
			e = r.nextInt(n)+1;
			//System.out.println("Element to be add : "+ e);
			set.add(e);
		}
		System.out.println("Size of Set : "+ set.size());
		set.display();
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ISet set = new HashSet1();
		testCase1(set, n);
	}
}
