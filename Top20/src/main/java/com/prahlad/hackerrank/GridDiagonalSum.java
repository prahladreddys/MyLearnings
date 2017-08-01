package com.prahlad.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GridDiagonalSum {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] in = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				in[i][j] = scanner.nextInt();
			}
		}
		System.out.println(solution(in));
		scanner.close();
	}

	private static int solution(int[][] in) {
		int d1 = 0;
		int d2 = 0;
		for(int i =0;i<in.length;i++){
			d1 = d1 + in[i][i];
		}
		int j = 0;
		for(int i = in.length -1;i>=0 ;i--,j++){
			d2 = d2+ in[i][j];
		}
		return Math.abs(d1-d2);
	}
	
}
