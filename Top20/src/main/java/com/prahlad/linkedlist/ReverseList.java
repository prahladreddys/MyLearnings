package com.prahlad.linkedlist;

public class ReverseList {
	public static void reverseList1(ListNode head) {
		ListNode current = head.next;
		ListNode previous = null;
		ListNode tmp;
		while (current != null) {
			tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		}
		head.next = previous;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		reverseList1(head);
		LinkedListUtils.display(head);
	}
}
