package com.prahlad.graph;

import java.util.Arrays;
import java.util.Random;

public class GraphUtils {
	public static int[][] createCompleteGraph(int n) {
		int[][] in = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				in[i][j] = in[j][i] = 1;
			}
		}
		return in;
	}

	public static void displayGraph(int[][] in) {
		for (int i = 0; i < in.length; i++) {
			System.out.println(Arrays.toString(in[i]));
		}
	}
	public static int[][] createRandomGraph(int n){
		int[][] in = new int[n][n];
		Random r = new Random();
		for(int i=0;i<n;i++){
			int u = r.nextInt(n);
			int v = r.nextInt(n);
			if(u != v)
				in[u][v] = in[v][u] = 1;
		}
		return in;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = createCompleteGraph(n);
		displayGraph(in);
		int[][] random = createRandomGraph(n);
		displayGraph(random);
	}

}
