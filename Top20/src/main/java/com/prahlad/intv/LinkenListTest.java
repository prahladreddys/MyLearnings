package com.prahlad.intv;

public class LinkenListTest {
	Node head = null;

	Node add(int data) {
		if (getHead() == null) {
			head = new Node(data);
			return head;
		}
		Node pointer = getHead();
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		Node n = new Node(data);
		pointer.next = n;
		return head;
	}

	void display(Node head) {
		while (head.next != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.println(head.data);
	}

	Node getHead() {
		return this.head;
	}

	public static void main(String[] args) {
		System.out.println("Starting");
		LinkenListTest test = new LinkenListTest();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		Node head = test.getHead();
		test.display(head);
		System.out.println("Reverse the list");
		test.reverse(head);
		test.display(head);
		System.out.println("Done");
	}

	private void reverse(Node head) {
		Node current = head.next;
		Node previous = null;
		Node tmp;
		while (current != null) {
			tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		}
		head.next = previous;
	}
}
class Node {
	Node next = null;
	int data;
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
}