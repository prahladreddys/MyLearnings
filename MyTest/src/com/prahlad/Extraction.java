package com.prahlad;

public interface Extraction {
	default void extract(String s){
		System.out.println("default implementation");
	}
}
