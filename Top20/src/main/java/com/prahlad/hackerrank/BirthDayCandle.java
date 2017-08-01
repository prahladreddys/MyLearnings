package com.prahlad.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class BirthDayCandle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
        in.close();
	}

	private static int birthdayCakeCandles(int n, int[] ar) {
		int maxHeight = Arrays.stream(ar).max().getAsInt();
		int count = (int) Arrays.stream(ar).filter(max -> max == maxHeight).count();
		return count;
	}

}
