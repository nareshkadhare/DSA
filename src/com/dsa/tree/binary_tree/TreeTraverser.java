package com.dsa.tree.binary_tree;

import java.util.Scanner;

public class TreeTraverser {
	static Scanner sc = new Scanner(System.in);
	
	static Node create() {
		Node root = null;
		System.out.println("Enter data : ");
		char data = sc.next().charAt(0);
		
		if(data == '0') return null;
		
		root = new Node(data);
		
		System.out.println("Enter left child for "+data);
		root.left = create();
		
		System.out.println("Enter right child for "+data);
		root.right = create();
				
		return root;
	}
	
	static void inOrder(Node root) {
		if(root == null) 
			return;
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	static void preOrder(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void postOrder(Node root) {
		if(root == null) 
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");		 
	}
	
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = create();
		
		/*
		Node root = new Node(1);
		root.right = new Node(9);
		root.left = new Node(12);
		root.left.left = new Node(5);
		root.left.right = new Node(6);
		*/
		
		System.out.println("In order");
		inOrder(root);
		System.out.println("\n\nPre order");		
		preOrder(root);
		System.out.println("\n\nPost order");		
		postOrder(root);
	}

}
