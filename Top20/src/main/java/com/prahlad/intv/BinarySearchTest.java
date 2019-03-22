package com.prahlad.intv;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearchTest {
	public static void main(String[] args) {
		int n = 6;
		int[] in = new int[n];
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		for(int i=0;i<n;i++){
			in[i] = r.nextInt(9) +1;
		}
		Arrays.sort(in);
		for(int i:in)
			System.out.print(i + " ");
		System.out.println("Enter number to search :");
		int search = s.nextInt();
		binarySearch(in,search);
		s.close();
	}

	private static void binarySearch(int[] in, int search) {
		int low = 0;
		int high = in.length ;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			if (in[mid] < search) {
				low = mid + 1;
			} else if (in[mid] > search) {
				high = mid - 1;
			} else if (in[mid] == search) {
				System.out.println("Found element : " + search + " in position: " + mid);
				return;
			}
		}
		
		
	}
}	
