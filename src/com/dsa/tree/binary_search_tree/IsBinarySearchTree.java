package com.dsa.tree.binary_search_tree;

public class IsBinarySearchTree {
	
	static boolean leftTraverse(Node root, int value) {
		if(root == null) return true;
		if(root.data >= value) return false;
		return leftTraverse(root.left, root.data);
	}

	static boolean rightTraverse(Node root, int value) {
		if(root == null) return true;
		if(root.data <= value) return false;
		return rightTraverse(root.right, root.data);
	}
	
	static boolean isBinarySearchTree(Node root) {
		if(root == null) return true;
		
		boolean result = true;
	
		result = leftTraverse(root.left, root.data);
		
		if(result) {			
			result =  rightTraverse(root.right, root.data);
		}
		return result;
	}

	static void inOrder(Node root) {
		if(root == null) 
			return;
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void main(String[] args) {
		
		/* 		10
		 * 	7		20
		 *5   9    15	22
		 * 
		 * in = 5 7 9 10 15 20 22
		 * 
		 * */
		
		
		Node root = new Node(10);
		root.left = new Node(6);
		root.left.left = new Node(5);
		root.left.right = new Node(9);
		
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(22);
		inOrder(root);
		System.out.println("\n\nIS BST " + isBinarySearchTree(root));
	}
}
