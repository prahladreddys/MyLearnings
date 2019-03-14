package com.intv;

import java.util.HashMap;
import java.util.Map;

public class TestEqualsOverride {

	public static void main(String[] args) {
		Map<key, String> m = new HashMap<>();
		m.put(new key(1), "one");
		m.put(new key(2), "two");
		m.put(new key(3), "three");
		
		System.out.println(m);
		
		System.out.println(m.get(new key(2)));
	}

}
class key{
	int i = 1;
	
	key(int i){
		this.i = i;
	}
	
	@Override
	public int hashCode() {
	    System.out.println("calling hascode method of Employee");
	    return 1;
	}
}