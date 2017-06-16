package com.prahlad.map;
class MapNode{
	String key;
	Integer value;
	MapNode next;
	MapNode(){
		key = null;
		value = 0;
		next = null;
	}
	MapNode(String key, Integer value){
		this.key = key;
		this.value = value;
		next = null;
	}
}
public class HashMap implements Map {
	private int size;
	private MapNode[] buckets;
	private int initial_size = 3;
	
	public HashMap(){
		buckets = new MapNode[initial_size];
		for(int i=0;i<buckets.length;i++){
			buckets[i] =new MapNode();
		}
		size =0;
	}
	@Override
	public void add(String key, Integer value) {
		int bind = key.hashCode() % buckets.length;
		MapNode tmp = new MapNode(key,value);
		tmp.next = buckets[bind].next;
		buckets[bind].next = tmp;
		++size;
		
	}

	@Override
	public Integer get(String key) {
		for(int i =0;i<buckets.length;i++){
			for(MapNode current=buckets[i].next;current != null; current = current.next){
				if(current.key.equals(key)){
					return current.value;
				}
			}
		}
		return null;
	}

	@Override
	public boolean contains(String key) {
		int bind = key.hashCode() % buckets.length;
		for (MapNode current = buckets[bind].next; current != null; current = current.next) {
			if (current.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void display() {
		for(int i =0;i<buckets.length;i++){
			System.out.print("Bucket["+i+"]:");
			for(MapNode current=buckets[i].next;current != null; current = current.next){
				System.out.print("("+current.key+","+current.value+"),");
			}
			System.out.println();
		}
	}

	@Override
	public int size() {
		return size;
	}

}
