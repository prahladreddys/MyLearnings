package com.prahlad.intv;

public class HeightOfTree {

	public static void main(String[] args) {
		TNode root = new TNode(5);
		root.left = new TNode(10);
		root.right = new TNode(15);
		root.left.left = new TNode(7);
		root.left.right = new TNode(5);
		root.right.left = new TNode(17);
		root.right.left.left = new TNode(20);
		System.out.println(treeHeight(root));
	}

	private static int treeHeight(TNode root) {
		if(root == null)
			return 0;
		return(1+Math.max(treeHeight(root.left),treeHeight(root.right)));
	}

}
class TNode{
	int data;
	TNode left;
	TNode right;
	TNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}