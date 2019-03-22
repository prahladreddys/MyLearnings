package com.prahlad.intv;

public class SingleTon {

	private SingleTon(){}
	
	private static class SingleTonHelper{
		private static final SingleTon instance = new SingleTon();
	}
	
	public static SingleTon getInstance(){
		return SingleTonHelper.instance;
	}
	public static void main(String[] args) {
		SingleTon i1 = SingleTon.getInstance();
		System.out.println(i1.hashCode());
		
		SingleTon i2 = SingleTon.getInstance();
		System.out.println(i2.hashCode());
		
		SingleTon i3 = SingleTon.getInstance();
		System.out.println(i3.hashCode());
		
	}
}
