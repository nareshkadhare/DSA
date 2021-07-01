package com.dsa.tree.binary_search_tree;

public class BinarySearchTree {

	static boolean search(Node root, int searchedValued) {
		if(root == null) return false;
		
		if(searchedValued == root.data) return true;
		
		if(searchedValued < root.data) {
			return search(root.left, searchedValued);
		} else {
			return search(root.right, searchedValued);
		}
	}
	
	public static void main(String[] args) {
		/*
		 *     		10
		 *   	5			15
		 * 	2		6	  12	18
		 * 3				11		16	
		 * */
		
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.left.left.left = new Node(2);
		
		root.right =  new Node(15);
		root.right.left =  new Node(12);
		root.right.left.left =  new Node(11);
		root.right.right =  new Node(18);
		root.right.right.left =  new Node(16);
		
		int search = 6;
		System.out.println(" SEARCH FOR "+search+" "+ search(root, search));
	}

}
