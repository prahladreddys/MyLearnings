package com.prahlad.tree;

import java.util.Random;

public class BinaryTreeUtils {
	/**
	 * Generating binay tree of n nodes
	 * Randomly generating left and right nodes by using toss
	 * programmatically we have to use to through a toss using Math random function
	 * 
	 * @param n
	 * @return
	 */
	public static TreeNode createBinaryTree(int n){
		Random r = new Random(10);
		TreeNode root = null;
		for(int i=0;i<n;i++){
			root = add(root,r.nextInt(n)+1);
		}
		return root;
	}
	private static TreeNode add(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		TreeNode current = root, parent = null;
		while (current != null) {
			parent = current;
			if (Math.random() < 0.5) {
				if(current.left == null) {
					parent.left = new TreeNode(data);
					break;
				}
				current = current.left;
			}
			else {
				if(current.right == null) {
					parent.right = new TreeNode(data);
					break;
				}
				current = current.right;
			}
		}		
		return root;
	}
	/**
	 * 
	 * @param root
	 */
	private static TreeNode addLeafs1(TreeNode root,int data) {
		TreeNode current = root;
		boolean isLeft = false;
		while (true) {
			if(current == null) break;
			if (Math.random() < 0.5) {
				// Add to left
				current = current.left;
				isLeft = true;
			} else {
				// Add to right
				current = current.right;
				isLeft = false;
			}
		}
		TreeNode tmp = new TreeNode(data);
		if(isLeft){
			current.left = tmp;
		} else {
			current.right = tmp;
		}
		return root;
	}
	public static void displayBinaryTree(TreeNode root){
		auxDisplay(root,0);
	}
	private static void auxDisplay(TreeNode root, int nspaces) {
		if(root == null) return;
		for(int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data);
		auxDisplay(root.left, nspaces+4);
		auxDisplay(root.right, nspaces+4);
		
	}
	
}
