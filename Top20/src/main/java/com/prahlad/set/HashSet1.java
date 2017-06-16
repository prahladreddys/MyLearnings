package com.prahlad.set;
class SetNode{
	int data;
	SetNode next;
	SetNode(){
		
	}
	SetNode(int data){
		this.data = data;
		this.next = null;
	}
}
public class HashSet1 implements ISet {
	private int size;
	private SetNode[] buckets;
	private int initial_size = 3;
	private int THRESHOLD = 2;
	public HashSet1(){
		buckets = new SetNode[initial_size];
		for(int i=0 ; i < buckets.length ;i++){
			buckets[i] = new SetNode();
		}
		size =0;
	}
	@Override
	public boolean add(Integer e) {
		if(contains(e)){
			return false;
		}
		float avgSize = size /buckets.length;
//		System.out.println(avgSize + "\t" + THRESHOLD);
		if(avgSize > THRESHOLD) {
			rehash();
		}
		int bind = e.hashCode() % buckets.length;
		SetNode tmp = new SetNode(e);
		tmp.next = buckets[bind].next;
		buckets[bind].next = tmp;
		++size;
		return true;
	}

	private void rehash() {
		System.out.println("Performing rehasing of set");
		SetNode[] buckets_new = new SetNode[2*buckets.length];
		for(int i=0;i<buckets_new.length;i++){
			buckets_new[i] = new SetNode();
		}
		SetNode tmp;
		for(int i=0;i<buckets.length;i++){
			for(SetNode current = buckets[i].next;current !=null; current = tmp){
				int bind = current.data % buckets_new.length;
				tmp = current.next;
				current.next = buckets_new[bind].next;
				buckets_new[bind].next = current;
			}
		}
		buckets = buckets_new;
	}
	@Override
	public boolean contains(Integer e) {
		for(int i=0;i<buckets.length;i++){
//			System.out.println("Bucket: "+i + " ");
			for(SetNode current = buckets[i].next;current !=null ; current = current.next){
				if(current.data == e){
					return true;
				}
			}			
		}
		return false;
	}

	@Override
	public void display() {
		for(int i=0;i<buckets.length;i++){
			System.out.print("Bucket [ "+i + "]:: ");
			for(SetNode current = buckets[i].next;current !=null ; current = current.next){
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
		if(!contains(e)){
			return false;
		}
		int bind = e.hashCode() % buckets.length;
		for(SetNode current = buckets[bind];current.next != null ; current = current.next){
			if(current.next.data == e){
				current.next = current.next.next;
				--size;
				return true;
			}
		}
		return false;
	}

}
