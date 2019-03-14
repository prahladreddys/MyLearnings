package com.prahlad;

public class TreeHeight {
	public static void main(String[] args) {
		MyNode root = new MyNode(5);
		root.left = new MyNode(10);
		root.right = new MyNode(15);
		root.left.left = new MyNode(20);
		root.left.right = new MyNode(25);
		root.left.left.left = new MyNode(30);
		root.left.right.left = new MyNode(35);
		root.left.right.left.left = new MyNode(40);
		root.left.right.left.left.right = new MyNode(45);
		root.left.right.left.left.right.left = new MyNode(50);
		
		TreeHeight i = new TreeHeight();
		System.out.println(i.height(root));
	}

	private int height(MyNode root) {
		if(root == null)
			return 0;
		
		return (1+Math.max(height(root.left), height(root.right)));
	}
}
class MyNode{
	int data;
	MyNode left;
	MyNode right;
	public MyNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}