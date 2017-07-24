package com.prahlad.trees;

public class LongestRootToLeafPathSum {
	public static void maxSum(TreeNode root){
		MyInteger maxSum = new MyInteger();
		auxSum(root,0," ",maxSum);
		System.out.println("Max sum of root to leaf path: "+ maxSum.get());
	}

	private static void auxSum(TreeNode root,int sum,String prefix,MyInteger maxSum) {
		if(root == null) return;
		if(root.left == null && root.right == null){
			System.out.print(prefix+root.data+": ");
			sum = sum+root.data;
			System.out.println(sum);
			maxSum.set(Math.max(sum, maxSum.get()));
			sum = 0;
			return;
		}
		auxSum(root.left,sum+root.data,prefix+root.data+"-",maxSum);
		auxSum(root.right,sum+root.data,prefix+root.data+"-",maxSum);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree1(root);
		BinaryTreeUtils.displayTree(root);
		maxSum(root);
	}

}
