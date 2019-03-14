package com.prahlad;

public class TestImmutableClass {

	public static void main(String[] args) {
		ImmutableClass ic = ImmutableClass.createInstance(1, "reddy");
		System.out.println(ic);
		tryModify(ic.getInteger(),ic.getString());
		System.out.println(ic);

	}

	private static void tryModify(Integer integer, String string) {
		integer = 200;
		string = "prahlad";
		
	}

}
