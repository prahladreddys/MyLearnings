package com.prahlad.trees;

public class ExploreAllPaths {
	public static void exploreAllPaths(TreeNode root){
		explore(root," ");
	}

	private static void explore(TreeNode root, String prefix) {
		if(root == null) return;
		if(root.left == null && root.right == null){
			System.out.println(prefix+ root.data);
			return;
		}
		explore(root.left, prefix+root.data+"-");
		explore(root.right, prefix+root.data+"-");
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		exploreAllPaths(root);
	}

}
