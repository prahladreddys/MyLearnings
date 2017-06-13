package com.prahlad.linkedlist;

import java.util.Random;

public class LinkedListUtils {	

	public static ListNode createList(int n) {
		ListNode head = new ListNode();
		ListNode current = head;
		Random r = new Random();
		for(int i=0;i<n;i++){
			int v = r.nextInt(n)+1;
			System.out.print(v +" ");
			ListNode tmp = new ListNode(v);
			current.next = tmp;
			current = current.next;
		}
		System.out.println();
		return head;
	}

	public static void display(ListNode head) {
		ListNode current;
		String address;
		for (current = head.next; current != null; current = current.next) {
			if (current.next != null) {
				String tmp = current.next.toString();
				address = tmp.substring(tmp.indexOf('@') + 1);
//				address = Integer.toHexString(current.next.hashCode());
			} else {
				address = "null";
			}
			System.out.print("[" + current.data + "," + address + "]");			
//			System.out.print("["+ current.data +"," + System.identityHashCode(current)+"] ");
		}
		System.out.println();
		
	}
}
