package com.prahlad.intv;

public class PrototypeDesignPattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A(1);

		for(int i=2;i<10;i++){
			prototype temp = a.clone();
			temp.setSize(i);
			temp.printSize();
		}
	}
}
interface prototype{
	void setSize(int i);
	void printSize();
}
class A implements prototype,Cloneable{
	int i;
	public A(int i){
		this.i = i;
	}
	@Override
	public void setSize(int i) {
		this.i = i;
	}

	@Override
	public void printSize() {
		System.out.println("Size: "+ i);
	}
	
	public A clone() throws CloneNotSupportedException{
		return (A) super.clone();
	}
}