package com.prahlad.tree1;

import java.util.Random;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class BTUtil {
	public static TreeNode createBT(int n){
		TreeNode root = null ;
		Random r= new Random();
		for(int i=0;i<n;i++){
			root = addNodes(root,r.nextInt(n)+1);
		}
		return root;
	}

	private static TreeNode addNodes(TreeNode root,int data) {
		if(root == null){
			return new TreeNode(data);
		}
		TreeNode current = root,present=null;
		
		while(current != null){
			present = current;
			if(Math.random() < 0.5){
				if(current.left == null){
					present.left = new TreeNode(data);
					break;
				}
				current = current.left;
			} else {
				if(current.right == null){
					present.right = new TreeNode(data);
					break;
				}
				current = current.right;
			}
		}
		return root;
	}
	
	public static void display(TreeNode root){
		int spaces = 0;
		auxDisplay(root, spaces);
	}
	private static void auxDisplay(TreeNode root, int spaces){
		if(root == null) return;
		for(int i=0;i<spaces;i++)
			System.out.print(" ");
		System.out.println(root.data);
		auxDisplay(root.left,spaces+4);
		auxDisplay(root.right,spaces+4);
	}
}
