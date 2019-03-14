package com.test.inheritance;

public class BaseClass {
	private int i;
	public int j;
	private int k;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public BaseClass(int i,int j, int k) {
		this.i=i;this.j=j;this.k=k;
	}
}
