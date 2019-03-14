package com.test.inheritance;

public class SubClass extends BaseClass{

	private int n;
	public SubClass(int i, int j, int k,int n) {
		super(i, j, k);
		this.n = n;
	}
	public void display(){
		System.out.println(super.getI()+super.getJ()+super.getK()+this.n);
	}
}
