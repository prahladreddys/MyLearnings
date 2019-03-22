package com.prahlad.intv;

public class TestBits {
	public static void main(String[] args) {
		int a = 7;
		int num_1 = 1;
		int count = 0;
		while(a > 0){
			if((a & num_1) > 0)
				count++;
			a = a >> 1;
			System.out.println(a);
		}
		System.out.println("Count :"+count);
	}
}
