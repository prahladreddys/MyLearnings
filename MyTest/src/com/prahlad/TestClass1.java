package com.prahlad;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* IMPORTANT: Multiple classes and nested static classes are supported */


/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
Sample Input

4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
Sample Output

5
*/

class TestClass1 {
	public static boolean[][] read;
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
		*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter value of m:");
        String mvalue = br.readLine();
        System.out.println("Enter value on n:");
        String nvalue = br.readLine();
        int m = Integer.parseInt(mvalue);
        int n = Integer.parseInt(nvalue);
        
        int input[][] = new int[m][n];
        read = new boolean[m][n];
        
		for (int i = 0; i < m; i++) {
			String value = br.readLine();
			String values[] = value.split("\\s");
			if(values.length != n)
				System.exit(1);
			for (int j = 0; j < n; j++) {
				input[i][j] = Integer.parseInt(values[j]);	
				read[i][j] = false;
			}			
		}
        
        int count = 0;
        for(int k = 0; k < m; k++) {
            for(int l = 0; l < n; l++) {
                if(!read[k][l]) count = Math.max(count, findPath(input, k, l, 0, m, n));
            }
        }
        System.out.println("count: "+ count);
        System.out.println("Done");
    }
    public static int findPath(int[][] grid, int i, int j, int count, int M, int N) {
        if(i < 0 || j < 0 || i >= M || j >= N) return 0;
        
        if(read[i][j]) return 0;
                
        read[i][j] = true;
        
        if(grid[i][j] == 0) return 0;
        else return 1 +
            findPath(grid, i-1, j-1, count, M, N) +
            findPath(grid, i-1, j, count, M, N) + 
            findPath(grid, i-1, j+1, count, M, N) + 
            findPath(grid, i, j-1, count, M, N) + 
            findPath(grid, i, j, count, M, N) + 
            findPath(grid, i, j+1, count, M, N) + 
            findPath(grid, i+1, j-1, count, M, N) + 
            findPath(grid, i+1, j, count, M, N) + 
            findPath(grid, i+1, j+1, count, M, N);
    }
}
