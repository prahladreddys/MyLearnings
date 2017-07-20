package com.prahlad.file;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class MinumOrderInMergeFiles {
	// Using priority queue
	// Removing top 2 elements and add it to sum
	// add sum to priority queue
	// TC : ( 3 * O(log n))
	public static int minMergeFilesOperation1(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < in.length; i++) {
			pq.add(in[i]);
			//System.out.println(pq);
		}
		// System.out.println(pq);
		int minSum = 0;
		while (pq.size() > 1) {
			int min1 = pq.remove();
			int min2 = pq.remove();
			minSum += (min1 + min2);
			pq.add(minSum);
		}

		return minSum;
	}

	// Using sorting on linked list
	private static int minMergeFilesOperation2(int[] in) {
		java.util.LinkedList<Integer> ll = new java.util.LinkedList<>();
		for (int i = 0; i < in.length; i++) {
			ll.add(in[i]);
		}
//		System.out.println(ll);
		int minSum = 0;
		while (ll.size() > 1) {
			Collections.sort(ll);
			int min1 = ll.removeFirst();
			int min2 = ll.removeFirst();
			minSum += (min1 + min2);
			ll.add(minSum);
		}
		return minSum;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(2016);
		int[] in = new int[n];
		for (int i = 0; i < n; i++) {
			in[i] = r.nextInt(n) + 1;
		}
		//System.out.println(Arrays.toString(in));
		System.out.println(LocalDateTime.now());
		System.out.println("Minimum no of order to merge: " + minMergeFilesOperation1(in));
		System.out.println(LocalDateTime.now());
		System.out.println("Minimum of order to merge the files: " + minMergeFilesOperation2(in));
		System.out.println(LocalDateTime.now());
	}

}
