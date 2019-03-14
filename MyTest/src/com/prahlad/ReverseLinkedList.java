package com.prahlad;

public class ReverseLinkedList {

	public static void main(String[] args) {
		System.out.println("test");
		LinkedListT a = new LinkedListT();
		a.addAtBegin(5);
		a.addAtBegin(10);
		a.addAtBegin(15);
		a.addAtBegin(20);
		a.addAtBegin(25);
		a.addAtBegin(30);
		a.display(a.head);
	}
}

class LinkedListT {
		public Node1 head;
		public LinkedListT(){
			head = null;
		}
		public void addAtBegin(int data){
			Node1 n = new Node1(data);
			n.next = head;
			head = n;
		}
		
		public void display(Node1 head){
			//
			Node1 currNode = head;
			while(currNode!=null){
				System.out.print("->" + currNode.data);
				currNode=currNode.next;
			}
		}
}

class Node1 {
	int data;
	Node1 next;
	public Node1(int data){
		this.data = data;
		this.next = null;
	}
}
	