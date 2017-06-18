package com.prahlad.power;

public class PowerOfN {
	// TC : O(n)
	// SC : O(1)
	public static long power1(int x,int n){
		long res=1;
		for(int i=0;i<n;i++){
			res = res * x;
		}
		return res;
	}
	// TC : O(log n)
	// SC : O(log n) 
	// Pushing and popping stack frame is over head in each recursion call
	public static long power2(int x, int n){
		if(n == 1) return x;
		long res = power2(x,n/2);
		if( n % 2 == 0){
			res = res * res;
		} else {
			res = res * res * x;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(power2(3,3));
	}
}
