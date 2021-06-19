package com.dsa.tree.binary_tree;


public class InsertNode {
	
	static boolean insertNode(IntNode root, int data) {
		
		//If root data & provided data is same then no node will insert
		if(root.data == data) return false;
	
		boolean result = false;
		
		//If provided data is less than root node data then it will inserted in left sub tree
		if(data < root.data) {
			
			//Reached at last node of left sub tree then insert node
			if(root.left == null) {
				root.left = new IntNode(data);
				return true;
			}
			//if not reached at end make recursive call again to go left
			result = insertNode(root.left, data);			
		}
		//If provided data is greater than root node data then it will inserted in right sub tree
		else {
			//Reached at last node of left sub tree then insert node
			if(root.right == null) {				
				root.right = new IntNode(data);
				return true;
			}
			//if not reached at end make recursive call again to go right			
			result = insertNode(root.right, data);
		}				
		return result;
	}
	
	static void inOrder(IntNode root) {
		
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(root.data+ " ");
		inOrder(root.right);
	}
	
	static void preOrder(IntNode root) {
		if(root == null) return;
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void postOrder(IntNode root) {
		if(root == null) return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		
		
		IntNode root = new IntNode(2); 
		System.out.println("1 insertion => "+insertNode(root, 1));
		System.out.println("5 insertion => "+insertNode(root, 5));
		System.out.println("0 insertion => "+insertNode(root, 0));			
		System.out.println("10 insertion => "+insertNode(root, 10));			
		System.out.println("4 insertion => "+insertNode(root, 4));			
		System.out.println("3 insertion => "+insertNode(root, 3));			
		System.out.println("3 insertion => "+insertNode(root, 3));		
					
		System.out.println("\nIn Order Traversal");
		inOrder(root);

		System.out.println("\n\nPre Order Traversal");
		preOrder(root);

		System.out.println("\n\nPost Order Traversal");
		postOrder(root);
		
		/*      2
		 * 	 1	    5
		 * 0	  4  10
		 *       3
		 * 
		 * in  = 0 1 2 3 4 5 10
		 * pre = 2 1 0 5 4 3 10
		 * post = 0 1 3 4 10 5 2
		 * 
		 *  1. Make tree
		 * 
		 *  2. fun(root,val)
		 *  	
		 *  	if(roo.val == val) 
		 *  		return null
		 *  
		 *      	
		 *  	if(val < root.val)
		 *  		if root.left == null		 *  
		 *  			root.left = val Node
		 *  			return root
		 *  		
		 *  		root = fun(root.left,val)
		 * 		else 
		 * 			if root.right == null
		 * 				root.right = val Node
		 *  			return root
		 * 			root = fun(root.right,val)
		 * 
		 * 		return root
		 * 
		 * */
	}
}
