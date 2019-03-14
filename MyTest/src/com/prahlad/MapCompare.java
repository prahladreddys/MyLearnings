package com.prahlad;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Object> m1 = new HashMap<>();
		m1.put("k1", "1");
		m1.put("k2", "2");
		Map<String,Object> m2 = new HashMap<>();
		m2.put("k1", "11");
		m2.put("k2", "2");
		for(Entry<String, Object> entry:m1.entrySet()){
//			System.out.println(entry.getKey()+"\t"+entry.getValue());
			if(m2.containsKey(entry.getKey())){
				if(!entry.getValue().equals(m2.get(entry.getKey()))){
					System.out.println(entry.getValue() +"\t" + m2.get(entry.getKey()));
				}
			}
		}
	}

}
