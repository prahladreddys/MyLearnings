package com.prahlad.lawofbrahma;

public class Brahma {
	public static void brahma(int n, char src, char aux, char tar){
		if(n == 1){
			System.out.println(src +"-->"+ tar);
			return;
		}
		brahma(n-1,src,tar,aux);
		System.out.println(src +"-->"+tar);
		brahma(n-1,aux,src,tar);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		brahma(40,'A','B','C');
	}

}
