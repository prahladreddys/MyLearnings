package com.prahlad;

public class LinkedList_insert_sortedway {
	static Node head;
	class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	Node newNode(int d){
		Node x = new Node(d);
		return x;
	}
	void sortedInsert(Node new_node){
		Node current;
		if(head == null || head.data >= new_node.data){
			new_node.next = head;
			head = new_node;
		} else {
			current = head;
			while (current.next != null && current.next.data < new_node.data){
				current = current.next;
			}
			new_node.next = current.next;
            current.next = new_node;
		}
	}
	void printList(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data +"-->");
			temp = temp.next;
		}
	}
	

	public static void main(String[] args) {
		LinkedList_insert_sortedway llist = new LinkedList_insert_sortedway();
		Node new_node;
        new_node = llist.newNode(5);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(10);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(7);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(3);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(1);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(9);
        llist.sortedInsert(new_node);
        System.out.println("Created Linked List");
        llist.printList();

	}

}
