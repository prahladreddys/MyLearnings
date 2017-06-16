package com.prahlad;

public class Test1 {

	public static void main(String[] args) {
		int s = 0;
		for(int i=0;i <5 ;s= i++){
			System.out.print(s + " " );
		}
		System.out.println();
		int t =0;
		for(int j=0 ; j<5;t = ++j)
			System.out.print(t + " ");
		System.out.println();
		int k =5 ;
		int l = ++k;
		System.out.println("K value : "+ k + "\t L value: "+l);
		
		int m = 5;
		int n = m++;
		System.out.println("M Value : "+ m + "\t n value: "+ n);
		
		int a =7;
		System.out.println(a++);
		int b =7;
		System.out.println(++b);
	}
	

}
