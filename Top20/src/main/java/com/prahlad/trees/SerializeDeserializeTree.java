package com.prahlad.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserializeTree {
	public static  void serialize(TreeNode root, int[] inOrder, int[] preOrder){
		List<Integer> list = new ArrayList<Integer>();
		inorder(root,list);
		int i =0;
		for(Integer e:list){
			inOrder[i++] = e;
		}
		System.out.println("Inorder Of Tree: "+ Arrays.toString(inOrder));
		list.clear();
		preorder(root,list);
		i =0;
		for(Integer e:list){
			preOrder[i++] = e;
		}
		System.out.println("preorder Of Tree: "+ Arrays.toString(preOrder));
	}
	private static void inorder(TreeNode root, List<Integer> list) {
		if(root == null) return;
		inorder(root.left,list);
		list.add(root.data);
		inorder(root.right, list);
	}
	private static void preorder(TreeNode root,List<Integer> list){
		if(root == null) return;
		list.add(root.data);
		preorder(root.left, list);
		preorder(root.right, list);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		int[] inOrder =new int[n+1];
		int[] preOrder = new int[n+1];
		serialize(root,inOrder,preOrder);
	}

}
