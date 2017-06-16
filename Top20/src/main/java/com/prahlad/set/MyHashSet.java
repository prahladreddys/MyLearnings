package com.prahlad.set;

import com.prahlad.linkedlist.ListNode;

public class MyHashSet implements ISet {
	
	private ListNode[] buckets;
	private int size;
	private int INITIAL_BUCKETS = 7;
	private int THRESHOLD = 10;
	
	public MyHashSet(){
		buckets = new ListNode[INITIAL_BUCKETS];
		for(int i=0;i<buckets.length;i++){
			buckets[i] = new ListNode();
		}
		size = 0;
	}

	@Override
	public boolean add(Integer e) {
		if (contains(e)) {
			return false;
		}
		float avgSize = size / buckets.length;
		if (avgSize > THRESHOLD) {
			rehash();
		}
		int bindex = e.hashCode() % buckets.length;
		System.out.println("Element to be Add : " + e + "\t Bucket index : " + bindex);
		// ListNode current = buckets[bindex];
		// for(; current.next !=null; current = current.next){
		// }
		// current.next = new ListNode(e);
		// add the element at start of bucket
		ListNode tmp = new ListNode(e);
		tmp.next = buckets[bindex].next;
		buckets[bindex].next = tmp;
		++size;
		return true;
	}

	private void rehash() {
		System.out.println("rehashing ....");
		ListNode[] tmp_buckets = new ListNode[2*buckets.length];
		for(int i=0 ;i < tmp_buckets.length;i++){
			tmp_buckets[i] = new ListNode();
		}
		ListNode tmp;
		for(int i=0;i< buckets.length;i++){
			for(ListNode current = buckets[i].next;current != null; current = current.next){
				int indb = current.hashCode() % tmp_buckets.length;
				tmp = current.next;
				current.next = tmp_buckets[indb].next;
				tmp_buckets[indb].next = current;
			}
			buckets = tmp_buckets;
		}
	}

	@Override
	public boolean contains(Integer e) {
		int indb = e.hashCode() % INITIAL_BUCKETS;
		for(ListNode current = buckets[indb]; current != null ; current = current.next){
			if(current.data == e){
				return true;
			}
		}
		return false;
	}

	@Override
	public void display() {
		for(int i =0 ;i < buckets.length ; i++){
			System.out.print("bucket["+i+"] :");
			for(ListNode current = buckets[i].next;current != null ; current = current.next){
				System.out.print(current.data + " ");
			}
			System.out.println();
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean remove(Integer e) {
		// TODO Auto-generated method stub
		return false;
	}

}
