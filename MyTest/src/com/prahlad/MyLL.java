package com.prahlad;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLL {
	static Node head;
	static class Node {
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	/* Utility function to print a linked list */
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }
	
	void retrieve(Node n){
		while(n != null){
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
	void deteleNode(Node node,Node n){
		Node prev = node;
        while (prev.next != null && prev.next != n) {
            prev = prev.next;
        }
     // Remove node from Linked List
        prev.next = prev.next.next;
	}
	
	public static void main(String[] args) {
		MyLL ll = new MyLL();
		ll.head = new Node(1);
		ll.head.next = new Node(2);
		ll.head.next.next = new Node(3);
		ll.head.next.next.next = new Node(4);
		
		System.out.println("LL :" );
		ll.retrieve(head);
		
		System.out.println("delete");
		ll.deteleNode(head, head.next.next);
		
		System.out.println("LL :" );
		ll.retrieve(head);
		
		LinkedList<String> jLL = new LinkedList<>();
		jLL.add("reddy");
		jLL.add("prahlad");
		jLL.addFirst("s");
		jLL.addLast("enginner");
		
		Iterator<String> it = jLL.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		jLL.remove("prahlad");
		
		Iterator<String> it1 = jLL.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
	}

}
