package com.prahlad.fibonacci;

public class Fibonacci {
	// TC : O(2 ^ n)
	// SC : O(n) - Depth of stack frames
	public static long fib1(int n ){
		// Base condition
		if(n <= 2 ) return 1;
		return fib1(n-1)+fib1(n-2);		
	}
	// TC : O(2 ^ n )
	// SC : O(n)
	public static long fib2(int n){
		long[] mem = new long[(int) (n+1)];
		return auxfib(n,mem);		
	}

	private static long auxfib(int n, long[] mem) {
		// Base condition
		if (n <= 2)
			return 1;
		if(mem[n] != 0){
			return mem[n];
		} else {
			mem[n] = auxfib(n-1,mem)+auxfib(n-2,mem);
		}
		return mem[n];
	}
	
	public static long fib3(int n){
		long[] mem = new long[n+1];
		mem[1] = mem[2] = 1;
		for(int i=3;i<=n;i++){
			mem[i] = mem[i-1]+mem[i-2];
		}
		return mem[n];
	}
	public static long fib4(int n){
		long first,second,current =0;
		first = second =1;
		for(int i=3;i<=n;i++){
			current = first + second;
			first = second;
			second = current;
		}
		return current;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println("Output: "+ fib4(n));
	}
}
