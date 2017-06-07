package com.prahlad;

public class CountZeros {
	
	public static int countZeros1(int[] in){
		int count =1;
		for(int i=1;i<in.length;i++){
			if(in[0] == in[i]){
				count ++;
			} else {
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int [] in = {0,0,0,0,0,0,0};
		System.out.println("Count of zeroes : "+ countZeros1(in));
	}

}
