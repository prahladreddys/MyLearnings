package com.ravi;

public class MyHashMap {
	int size = 16;
	Entry[] table = new Entry[size];
	class Entry{
		String key;
		String value;
		Entry next;
		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
		public String getKey(){
			return this.key;
		}
	}
	public void put(String key,String value){
		Entry entry = new Entry(key,value);
		int hash = key.hashCode() % size;
		table[hash] = entry;
	}
	public Entry get(String key){
		int hash = key.hashCode() % size;
		Entry e = table[hash];
		while(e.next != null){
			if(e.key.equals(key)){
				return e;
			}
			e = e.next;
		}
		return null;
	}
	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		
		System.out.println(map.get("2").getValue());
	}
}
