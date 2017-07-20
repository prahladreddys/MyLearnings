package com.prahlad.segmenttree;

import java.util.Arrays;
import java.util.Random;

public class RangeSum {
	private int[] in;
	private int[] segment_tree;

	RangeSum(int[] in) {
		this.in = in;
		segment_tree = new int[2 * in.length];
	}

	// Building segment tree
	private void buildSegmentTree() {
		for (int i = 0; i < in.length; ++i) {
			segment_tree[i + in.length] = in[i];
		}
		for (int i = in.length - 1; i > 0; --i) {
			segment_tree[i] = segment_tree[2 * i] + segment_tree[2 * i + 1];
		}
		System.out.println(Arrays.toString(segment_tree));
	}

	private int range_sum(int i, int j) {
		int l = i + in.length;
		int r = j + in.length;
		int rsum = 0;
		while (l <= r) {
			if (l % 2 == 1) {
				rsum += segment_tree[l];
				++l;
			}
			if (r % 2 == 0) {
				rsum += segment_tree[r];
				--r;
			}
			l = l / 2;
			r = r / 2;
		}
		return rsum;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(2016);
		int[] in = new int[n];
		for (int i = 0; i < n; i++) {
			in[i] = r.nextInt(n) + 1;
		}
		System.out.println(Arrays.toString(in));
		RangeSum range = new RangeSum(in);
		range.range_sum1(1, 3);
		range.buildSegmentTree();
		System.out.println(range.range_sum(1, 3));

	}

	// Adhoc
	public void range_sum1(int i, int j) {
		int sum = 0;
		int start = i;
		for (; i <= j; i++) {
			sum = sum + in[i];
		}
		System.out.println("Sum of range (" + start + "," + j + ") = " + sum);
	}
}
