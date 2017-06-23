package com.prahlad.random;

public class Random2 {
	private long seed;
	private static final long multiplier = 7;
	private static final long add = 3;
	private static final long modulus= (1 << 21) -1;
	public Random2(){
		seed = System.nanoTime();
	}
	public Random2(long seed){
		this.seed = seed;
	}
	public  long nextInt(int n){
		long tmp = (seed * multiplier + add) % modulus;
		seed = tmp;
		return tmp % n;
	}
	public static void main(String[] args) {
		Random2 r = new Random2();
		for(int i=0;i<5;i++){
			System.out.println(r.nextInt(10));
		}
	}
}
