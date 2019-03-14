package com.prahlad;
/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
// Find maximum contiguous and non-contiguous subarray 
Sample Input

2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
*/

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String v1 = br.readLine();
		int noOfArrays = Integer.parseInt(v1);
		ArrayList<int[]> arr = new ArrayList<int[]>();
		for(int i=0 ;i<noOfArrays;i++){
			int size = Integer.parseInt(br.readLine());
			String values = br.readLine();
			String[] valuesArray = values.split("\\s");
			if(size != valuesArray.length)
				System.exit(1);
			int[] array = Arrays.stream(valuesArray).mapToInt(Integer::parseInt).toArray();
			arr.add(array);
		}
		for(int[] a:arr )
		System.out.println(maxContiguousSub(a)+" "+maxNonContiguousSub(a));
    }
    private static int maxContiguousSub(int[] array) {
		int max = array[0];
		int[] sum = new int[array.length];
		sum[0] = array[0];
 
		for (int i = 1; i < array.length; i++) {
			sum[i] = Math.max(array[i], sum[i - 1] + array[i]);
			max = Math.max(max, sum[i]);
		}
 
		return max;
	}

	private static int maxNonContiguousSub(int[] array) {
	     if(array == null)
	        return 0;
	        
	     int arrayLength = array.length;
	     int sum1 = array[0];
	     int sum2 = 0;
	     int sum3 = 0;
	     
	     for(int i = 1; i  <  arrayLength; i++){	     
	         sum3 = Math.max(sum1,sum2);	         
	         sum2 = sum3;
	         sum1 = sum2 + array[i];
	     }
	     
	     return Math.max(sum1, sum2);
	}
}
