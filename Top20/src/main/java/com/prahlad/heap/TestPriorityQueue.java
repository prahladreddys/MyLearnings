package com.prahlad.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class TestPriorityQueue {
	public static void test(int[] in ){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<in.length;i++)
			pq.add(in[i]);
		System.out.println("After adding to pq");
		System.out.println(pq.toString());
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[] in = new int[n];
		for(int i=0;i<n;i++){
			in[i] = r.nextInt(n);
		}
		System.out.println(Arrays.toString(in));
		test(in);
		
	}

}
