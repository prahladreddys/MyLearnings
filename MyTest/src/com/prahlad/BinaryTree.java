package com.prahlad;

public class BinaryTree {
	private static int index =0;
	private static int sum =0;
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right.left = new Node(12);
		root.right.right = new Node(20);
		BinaryTree bt = new BinaryTree();
		System.out.println(bt.treeHeight(root));
		System.out.println(bt.checkBST(root));
		System.out.println("Inorder");
		bt.inorder(root);
		System.out.println("\n Preorder");
		bt.preorder(root);
		System.out.println("\n postorder");
		bt.postorder(root);
		
		// greater sum tree
		bt.greaterTree(root);
		System.out.println("After greate sum");
		bt.inorder(root);
	}
	public void inorder(Node root){
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data+ " ");
		inorder(root.right);
	}
	public void preorder(Node root){
		if(root ==null )return;
		System.out.print(root.data+ " ");
		preorder(root.left);
		preorder(root.right);
	}
	public void postorder(Node root){
		if(root ==null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+ " ");
	}
	public int treeHeight(Node root){
		if(root == null) return 0;
		return (1+Math.max(treeHeight(root.left),treeHeight(root.right)));
	}
	public void greaterTree(Node root){
		if(root == null)return;
		greaterTree(root.right);
		int temp =root.data;
		root.data = sum;
		sum= sum+temp;
		greaterTree(root.left);
	}
	public boolean checkBST(Node root){
		int[] a = new int[7];
		copyBST(root,a);
		for(int i=1;i<a.length;i++){
			if(a[i] <= a[i-1]) return false;
		}
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
		return true;
	}
	
	private void copyBST(Node root, int[] a) {
		if(root == null) return;
		copyBST(root.left,a);
		a[index] = root.data;
		index++;
		copyBST(root.right, a);
	}

}
class Node{
	int data;
	Node left;
	Node right;
	Node(int d){
		this.data =d;
		this.left = null;
		this.right = null;
	}
}