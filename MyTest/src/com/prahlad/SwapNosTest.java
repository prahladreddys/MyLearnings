package com.prahlad;

public class SwapNosTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		firstMethod();
		secodnMethod();
	}

	private static void secodnMethod() {
		int a = 30;
		int b = 10;
		
		System.out.println("Before: a= "+a+"\tb= "+b);
		a = a ^ b;
		b = a ^ b ;
		a = a ^ b ;
		
		System.out.println("After: a= "+a+"\tb= "+b);
		
	}

	private static void firstMethod() {
		int a = 30;
		int b = 10;
		
		System.out.println("Before: a= "+a+"\tb= "+b);
		a = a + b ; //a =40
		b = a - b; // b = 30
		a = a - b; // a = 10
		
		System.out.println("After: a= "+a+"\tb= "+b);
		
		
	}

}
