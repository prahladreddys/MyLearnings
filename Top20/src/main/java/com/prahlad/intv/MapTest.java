package com.prahlad.intv;

public class MapTest {

}
class MapNode{
	String	 key;
	Integer value;
	MapNode next;
	MapNode(){
		key = null;
		value = 0;
		next = null;
	}
	MapNode(String key,Integer value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
}