package com.prahlad.designpatterns;

public class SingleTon {
	private static SingleTon instance;
	private static int i =0;
	private SingleTon(){
		
	}
	public static SingleTon getInstance(){
		if(null == instance){
			synchronized (SingleTon.class) {
				if(null == instance){
					System.out.println("getInstance(): First time getInstance was invoked!");
					instance = new SingleTon();
				}
			}
			
		}
		return instance;
	}
	public static void meth(){
		System.out.println("Accessed the instance: "+i+",\t instance:"+instance);
		i++;
	}
}
