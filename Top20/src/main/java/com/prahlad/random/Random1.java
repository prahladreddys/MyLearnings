package com.prahlad.random;

import java.util.Random;

public class Random1 {
	public static void getRandomJava(int n){
		Random r = new Random();
		for(int i=0 ;i <10;i++){
			System.out.println(r.nextInt(n));
		}
	}
	public static void getRandom(int n){
		for(int i=0;i<10;i++){
			System.out.println(System.nanoTime() % n);
		}
	}
	public static void main(String[] args) {
		//getRandomJava(10);
		getRandom(10);
	}
}
