package com.dsa.tree.binary_tree;

public class DeleteNode {

	//Find number of childs of any root node
	static int degreeOfNode(IntNode root) {

		if (root.left == null && root.right == null)
			return 0;

		if ((root.left == null && root.right != null) || (root.left != null && root.right == null))
			return 1;

		return 2;
	}
	
	//Find min node root node prev from right sub tree
	static IntNode findMinPrev(IntNode root) {
		if(root.left != null && root.left.left == null) return root;
		return findMinPrev(root.left);
	}

	//Delete Leaf , One Child , 2 Child Nodes
	static boolean deleteNode(IntNode root, int value) {

		//If no node avail
		if (root == null)
			return false;

		boolean result = false;
		
		//If node has 2 child
		if(root.data == value && degreeOfNode(root) == 2) {
			
			//If right child has no leaf node
			if(root.right.left == null) {
				root.data = root.right.data;
				root.right = null;
				return true;
			}
			
			//Find min node root node prev from right sub tree
			IntNode minLeftPrev = findMinPrev(root.right);
			
			//Replace data of deletion node with min node of right subtree
			root.data = minLeftPrev.left.data;
			
			//Delete that min node
			minLeftPrev.left = null;
			
			return true;
		}
		
		//If value is less than root data then traverse through left side
		if (value < root.data ) {
			
			//Delete left Leaf node
			if (root.left != null && root.left.data == value & degreeOfNode(root.left) == 0) {
				root.left = null;
				return true;
			} 
			//Delete node with single leaf node
			else if (root.left != null && root.left.data == value && degreeOfNode(root.left) == 1) {
				if (root.left.left == null)
					root.left = root.left.right;
				else
					root.left = root.left.left;
				return true;
			} 
			
			result = deleteNode(root.left, value);
		} else {
			
			//Delete right Leaf node
			if (root.right != null && root.right.data == value & degreeOfNode(root.right) == 0) {
				root.right = null;
				return true;
			} 
			//Delete node with single right leaf node
			else if (root.right != null && root.right.data == value && degreeOfNode(root.right) == 1) {
				if (root.right.left == null)
					root.right = root.right.right;
				else
					root.right = root.right.left;
				return true;
			}  
			result = deleteNode(root.right, value);			
		}

		return result;
	}
	
	
	static void inOrder(IntNode root) {
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		
		IntNode root = new IntNode(5);
		root.left = new IntNode(2);
		root.left.left = new IntNode(1);
		root.left.right = new IntNode(3);
		
		root.right = new IntNode(12);
		root.right.left = new IntNode(9);
		root.right.right = new IntNode(21);
		root.right.right.right = new IntNode(25);
		root.right.right.left = new IntNode(19);
		root.right.right.left.left = new IntNode(18);
		inOrder(root);
		System.out.println("\n1 deletion :  "+deleteNode(root, 12));
		System.out.println(root.left.data);
		inOrder(root);
		
//		IntNode minRoot = findMin(root.right.right); 
//		System.out.println("\nmin ROOT :"+minRoot.left.data);
		
		/*		
		 * 		5
		 *  2       12
		 *  
		 *1   3	  9	    21    
		 * 			 19		25
		 *  		
		 *          18 
		 *  
		 *  
		 * 
		 * in =  1 2 3 5 9 12 18 19 21 25
		 * 
		 * in = 1 2 3 5 9 18 19 21 25
		 * 
		 * 
		 * 1. Has no child
		 * - done
		 * 2. Has one child
		 * - done
		 * 3. Has two child
		 * - 
		 * 
		 */
	}
}
