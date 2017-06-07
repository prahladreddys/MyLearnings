package com.prahlad.list;
//Implementor of list , acting as alternative player for list 
class ListNode {	
	int data;
	ListNode next;
	public ListNode(){
		
	}
	public ListNode(Integer e) {
		data = e;
		next = null;
	}
}
public class LinkedList implements List {
	private ListNode head;
	// Maintain last node pointer so that we can achieve O(1) while adding elements, 
	// else adding element to list will be O(n), extra step required to traverse to end and add
	private ListNode last;
	private ListNode current;
	private int size;
	public LinkedList() {		
		size = 0;
		current = new ListNode();
		head = last = current;
	}
	@Override
	public void add(Integer e) {
		ListNode tmp = new ListNode(e);
		current.next = tmp;
		current = current.next;
		last = tmp;
		size++;
	}

	@Override
	public void display() {
		for(ListNode i = head; i.next !=null;i = i.next){
			System.out.print(i.data + " ");
		}
	}

}
