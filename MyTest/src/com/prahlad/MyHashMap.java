package com.prahlad;

public class MyHashMap {
	private static final int size = 16;
	private MyEntry[] table = new MyEntry[size];
	
	class MyEntry {
		String key;
		String value;
		MyEntry next;
		MyEntry(String key,String value){
			this.key = key;
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
		public String getKey(){
			return this.key;
		}
		public void setKey(String key){
			this.key = key;
		}
	}
	public MyEntry get(String key){
		int hash = key.hashCode() % size;
		MyEntry e = table[hash];
		// Bucket is identified by hashCode and traversed the bucket
        // till element is not found.
		while( e != null ){
			if(e.key.equals(key)){
				return e;
			}
			e = e.next;
		}
		return null;
	}
	public void put(String key,String value){
		int hash = key.hashCode()%size;
		MyEntry e= table[hash];
		if(e != null){
			// If we will insert duplicate key-value pair,
            // Old value will be replaced by new one.
			if(e.key.equals(key)){
				e.value = value;
			} else {
				// Collision: insert new element at the end of list
                // in the same bucket
				while(e.next != null){
					e = e.next;
				}
				MyEntry entry = new MyEntry(key, value);
				e.next = entry;
			}
		} else {
			// create new bucket for new element in the map.
			MyEntry entry = new MyEntry(key,value);
			table[hash] = entry;
		}
	}
	public static void main(String[] args) {
		MyHashMap myHashMap = new MyHashMap();

        myHashMap.put("Awadh", "SSE");
        myHashMap.put("Rahul", "SSE");
        myHashMap.put("Sattu", "SE");
        myHashMap.put("Gaurav", "SE");

        MyEntry e = myHashMap.get("Awadh");
        System.out.println(""+e.getValue());
	}
}
