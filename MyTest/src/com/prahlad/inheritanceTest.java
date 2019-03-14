package com.prahlad;

public class inheritanceTest {
	public static void main(String[] args) {
		Extraction e = new index();
		e.extract("");
		Extraction e1 = new cef();
		e1.extract("");
	}
	
}
class index implements Extraction{

	@Override
	public void extract(String s) {
		System.out.println("Extraction using index");
		
	}
	
}
class cef implements Extraction{
	public void getMsg(){
		System.out.println("Get Message");
	}
	@Override
	public void extract(String s) {
		System.out.println("Extraction using cef");
	}
	
}
class test1 implements Extraction{
	
}