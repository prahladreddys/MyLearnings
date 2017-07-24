package com.prahlad.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class BinaryTreeUtils {
	public static TreeNode createBinaryTree(int n){
		Random r = new Random(17);
		TreeNode root = null;
		for(int i=0;i<n;i++){
			int data = r.nextInt(n)+1;
			root = add(root,data);
		}
		return root;
	}

	private static TreeNode add(TreeNode root, int data) {
		if(root == null){
			root = new TreeNode(data);
		}
		TreeNode current = root,parent;
		while (current != null) {
			parent = current;
			if (Math.random() < 0.5) {
				if (current.left == null) {
					parent.left = new TreeNode(data);
					break;
				}
				current = current.left;
			} else {
				if(current.right == null){
					parent.right = new TreeNode(data);
					break;
				}
				current = current.right;
			}
		}
		return root;
	}
	public static void displayTree(TreeNode root){
		auxDisplay(root,0);
	}

	private static void auxDisplay(TreeNode root, int i) {
		if(root == null) return;
		for(int j=0;j<i;j++)
			System.out.print(" ");
		System.out.println(root.data);
		auxDisplay(root.left, i+4);
		auxDisplay(root.right, i+4);
	}
	
	public static void preorder(TreeNode root){
		if(root == null) return ;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void inorder(TreeNode root){
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	public static void postOrder(TreeNode root){
		if(root == null) return ;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = createBinaryTree(n);
		displayTree(root);
		System.out.println("PreOrder");
		preorder(root);
		System.out.println("\nInorder");
		inorder(root);
		System.out.println("\nPost Order");
		postOrder(root);
	}
	public static void displayTree1(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		TreeNode dummy = new TreeNode(-1);
		while(true) {
			TreeNode tmp = q.remove();
			if(tmp == null) {
				System.out.println();
				if(! q.isEmpty())
					q.add(null);
				else 
					break;
			} else {				
				System.out.print(tmp.data+ " ");
				if(tmp == dummy)  continue;
				if(tmp.left != null) q.add(tmp.left);
				else q.add(dummy);
				if(tmp.right != null) q.add(tmp.right);
				else q.add(dummy);
			}
		}	
	}
}
