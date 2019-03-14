package com.prahlad;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class hashGenerataion {
	private String color;
	public hashGenerataion(String color) {
		this.color = color;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "prahlad";
		System.out.println(s.hashCode());
		String s1 = s;
		System.out.println(s1.hashCode());
		String s2 = "reddy";
		System.out.println(s2.hashCode());
		
		hashGenerataion h1= new hashGenerataion("black");
		System.out.println(h1.hashCode());
		
		hashGenerataion h2 = new hashGenerataion("black");
		System.out.println(h1.hashCode());
		
		System.out.println(h1.equals(h2));
		
		hashGenerataion h3 = new hashGenerataion("orange");
		System.out.println(h3.hashCode());
		
		System.out.println(h1.equals(h3));
		
		Map<hashGenerataion, String> map = new HashMap<>();
		
		map.put(h1, "first");
		map.put(h2, "second");
		map.put(h3, "third");
		
		for(Entry<hashGenerataion, String> entry:map.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		System.out.println(map.get(h1));
	}
	@Override
	public int hashCode() {
		int hash = 3;
		return 7*hash;
	}
	@Override
	public boolean equals(Object obj) {
		hashGenerataion h = (hashGenerataion) (obj);
		if(this.color.equals(h.color))
			return true;
		
		return false;
	}

}
