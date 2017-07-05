package com.prahlad.tree;

public class DepthOfTree {
	public static int depthOfTree1(TreeNode root){
		if(root == null) return 0;
		int lh = depthOfTree1(root.left);
		int rh= depthOfTree1(root.right);
		
		return Math.max(lh, rh)+1;
	}
	public static int depthOfTree2(TreeNode root){
		return 0;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayBinaryTree(root);
		System.out.println("Height of Tree: "+ depthOfTree1(root));
		ExploreAllPaths.explorePaths(root);
	}

}
