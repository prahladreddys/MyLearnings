package com.develop;

public class DefaultsInInterface {

	public static void main(String[] args) {
		Button b1 = new Button();
		b1.click();
		b1.access();

	}

}
interface Clickable{
	default void click(){
		System.out.println("click");
	}
}
interface Accessible{
	default void access(){
		System.out.println("access");
	}
}
class Button implements Clickable,Accessible{
	
}