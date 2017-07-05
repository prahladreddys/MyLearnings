package com.prahlad.tree;

public class ExploreAllPaths {
	public static void explorePaths(TreeNode root){
		auxPath(root," ");
	}

	private static void auxPath(TreeNode root,String prefix) {
		if(root == null ) return;
		if(root.left ==null && root.right == null){
			System.out.println(prefix+root.data);
			return;
		}
		auxPath(root.left,prefix + root.data+" - ");
		auxPath(root.right,prefix+ root.data+" - ");
	}
}
