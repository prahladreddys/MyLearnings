package com.prahlad.tree1;

import java.util.Scanner;

public class DepthRootToLeaf {
	public static int depth(TreeNode root){
		if(root == null) return 0;
		int lh = depth(root.left);
		int rh = depth(root.right);
		return Math.max(lh, rh)+1;
	}

	public static void main(String[] args) {
		System.out.print("Enter value of n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeNode root = BTUtil.createBT(n);
		BTUtil.display(root);
		System.out.println("Depth of tree: "+depth(root));
	}

}
