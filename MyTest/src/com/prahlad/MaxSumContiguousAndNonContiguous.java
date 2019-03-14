package com.prahlad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 */
/*
2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
 */
public class MaxSumContiguousAndNonContiguous {

	public static void main(String[] args) {
		System.out.println("Finding maximum contiguous and non-contiguous subarray");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int noOfArrays = Integer.parseInt(br.readLine());
			List<int[]> list = new ArrayList<>();
			for(int i = 0 ; i<noOfArrays;i++){
				int noOfElements = Integer.parseInt(br.readLine());
				String values = br.readLine();
				String[] elements = values.split("\\s");
				if(noOfElements != elements.length){
					System.out.println("Inputs not match");
					System.exit(1);
				}
				int[] intElements = Arrays.stream(elements).mapToInt(Integer::parseInt).toArray();
				list.add(intElements);
			}
			for(int[] elements:list){
				System.out.println(maxSubArraySum(elements));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done..");
	}

	private static int maxSubArraySum(int[] elements) {
		// TODO Auto-generated method stub
		int sum = elements[0];
		for(int i=1;i<elements.length;i++){
			sum = sum + elements[i];
		}
		
		return sum;
	}

}
