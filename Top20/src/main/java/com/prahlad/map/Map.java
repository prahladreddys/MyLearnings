package com.prahlad.map;

public interface Map {
	public void add(String key,Integer value);
	public Integer get(String key);
	public boolean contains(String key);
	public void display();
	public int size();
}
