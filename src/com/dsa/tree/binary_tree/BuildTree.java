package com.dsa.tree.binary_tree;

public class BuildTree {

	static int preIndex = 0;

	static Node buildTree(String preOrder, String inOrder) {

		if (preIndex == preOrder.length()) return null;
		
		char rootData = preOrder.charAt(preIndex++);
		Node root = new Node(rootData);
		
		int rootIndex = inOrder.indexOf(rootData);
		
		if(rootIndex  == 0 || rootIndex == -1) 
			return root;
				
		String leftSubTree = inOrder.substring(0, rootIndex);
		String rightSubTree = "";
		
		if(rootIndex + 1 == inOrder.length()) {			
			rightSubTree = inOrder.substring(rootIndex + 1);
		} else {
			rightSubTree = inOrder.substring(rootIndex + 1, inOrder.length() - 1);
		}
		
		root.left = buildTree(preOrder, leftSubTree);
		root.right = buildTree(preOrder, rightSubTree);
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
		String inOrder = "DBEAFCG";
		String preOrder = "ABDECFG";
		
		Node root = buildTree(preOrder,inOrder);
		System.out.println("\n\n======= Print In Order =======\n");
		inOrder(root);
		System.out.println("\n\n======= Print Pre Order =======\n");
		preOrder(root);
		System.out.println("\n\n======= Print Post Order =======\n");
		postOrder(root);
		
		//printInOrder(root);
		/*
		 * 1. get First node from preOrder - create as root node
		 * 
		 * 2. Find index of that node into inOrder
		 * 
		 * 3. create subString of Left SubTree ( 0 , index - 1 )
		 * 
		 * 4. create substring of Right SubTree ( index + 1 , length - 1)
		 * 
		 */
	}
}
