package com.prahlad.trees;

public class LongestLeafToLeafPathSum {
	public static void maxSum(TreeNode root){
		MyInteger maxSum = new MyInteger();
		auxSum(root,maxSum);
		System.out.println("Logest Leaf to Leaf Path: "+ maxSum.get());
	}

	private static int auxSum(TreeNode root, MyInteger maxSum) {
		if(root == null) return 0;
		int lh = auxSum(root.left,maxSum);
		int rh = auxSum(root.right,maxSum);
		maxSum.set(Math.max(lh+rh+1,maxSum.get()));
		return Math.max(lh, rh)+1;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree1(root);
		BinaryTreeUtils.displayTree(root);
		maxSum(root);
	}

}
