package com.das.llist.doubly;

public class DoublyLinkedList {

	static boolean isEmpty(Node head) {
		if (head == null) {
			System.out.println("\nList is empty");
			return true;
		}
		return false;
	}

	static void displayForword(Node head) {

		if (!isEmpty(head)) {

			System.out.println("\n===========================");

			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
			if(temp == null) {
				System.out.println("null"); 
			}
		}
	}

	static void displayBackword(Node head) {
		if (!isEmpty(head)) {

			System.out.println("\n===========================");

			// Go to End
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}

			// Iterate using prev right to left
			while (temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.prev;
			}
		}
	}

	// Add at beg
	static Node insertAtBeg(Node head, int data) {

		if (head == null) {
			return new Node(data);
		}

		Node node = new Node(data);
		node.next = head;
		head.prev = node;
		head = node;

		return head;
	}

	// Add at end
	static Node insertAtEnd(Node head, int data) {

		Node newNode = new Node(data);

		// Empty
		if (head == null) {
			return newNode;
		}

		// Has Element
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.prev = temp;

		return head;
	}

	// Add at position
	static Node insertAtPosition(Node head, int position, int data) {

		/*
		 * if (head == null && position > 1) { System.out.println("Invalid position. - "
		 * + position); return null; }
		 * 
		 * Node node = new Node(data); if (head == null && position == 1) { return node;
		 * } else if (head != null && position == 1) { node.next = head; head.prev =
		 * node; head = node; } else { Node temp = head; int counter = 1;
		 * 
		 * while (counter < position - 1) { temp = temp.next; counter++;
		 * 
		 * if (temp == null) { break; } }
		 * 
		 * if (temp == null) { System.out.println("Invalid position. - " + position);
		 * return head; } else { Node next = temp.next; node.prev = temp; node.next =
		 * next; temp.next = node; if (next != null) { next.prev = node; } } }
		 */

		Node node = new Node(data);
		if (position < 1) {
			System.out.println("Invalid position");
		} else if (position == 1) {
			node.next = head;
			if (head != null) {
				head.prev = node;
			}
			head = node;
		} else {

			Node temp = head;
			Node prev = null;
			int counter = 1;
			// 1->2->3->null
			while (counter < position) {
				prev = temp;
				temp = temp.next;
				if (temp == null) {
					break;
				}
				counter++;
			}
			if (temp == null && counter + 1 == position) {
				prev.next = node;
				node.prev = prev;
				return head;
			}
			if (temp != null) {
				prev = temp.prev;
				node.prev = prev;
				prev.next = node;
				node.next = temp;
				temp.prev = node;
			} else {
				System.out.println("Invalid position");
			}
		}

		return head;
	}

	// Remove at beg
	static Node removeAtBeg(Node head) {

		if (head == null) {
			return null;
		} else {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
		}
		return head;
	}

	// Remove at end
	static Node removeAtEnd(Node head) {

		if (head == null) {
			return null;
		} else {

			Node temp = head;

			while (temp.next != null && temp.next.next != null) {
				temp = temp.next;
			}
			if (temp.next != null) {
				temp.next = null;
			} else {
				return null;
			}
		}

		return head;
	}

	// Remove at position
	static Node removeAtPosition(Node head, int position) {

		/*
		 * if position < 1 invalid
		 * 
		 * if position 1 head = head.next if(head != null) head.prev = null
		 * 
		 * 1->2->3->4->5->null
		 * 
		 * if position > 1 traverse to n Node next = n.next Node prev = n.prev
		 * 
		 * prev.next = next; if next != null next.prev = prev;
		 * 
		 */
		if (head == null || position < 1) {
			System.out.println("\nInvalid position");
			return head;
		} else if (position == 1) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
		} else {

			Node temp = head;
			int counter = 1;
			while (counter < position) {
				temp = temp.next;
				counter++;
				if (temp == null) {
					System.out.println("\nInvalid position");
					return head;
				}
			}
			Node next = temp.next;
			Node prev = temp.prev;

			prev.next = next;
			if (next != null) {
				next.prev = prev;
			}
		}
		return head;
	}

	// Reverse
	static Node reverse(Node head) {

		/*
		 * if(head == null || head.next == null) { return head; }
		 * 
		 * Node temp = head; Node revList = null; Node next = null; Node prev = null;
		 * while(temp != null) {
		 * 
		 * if(temp.next == null) next = temp; else next = temp.next;
		 * 
		 * if(revList == null) { revList = next.prev; revList.prev = null; revList.next
		 * = null; } else {
		 * 
		 * if(temp.next == null) { temp.next = revList; revList.prev = temp; temp.prev =
		 * null; revList = temp; break; } else { prev = next.prev; prev.next = revList;
		 * revList.prev = prev; prev.prev = null; revList = prev; } } temp = next; }
		 * return revList;
		 */

		/*
		 * 1->2->3->4->null
		 * 
		 * 
		 * 
		 * 
		 */

		if (head == null) {
			return head;
		}

		Node current = head;
		Node next = null;
		Node revList = null;

		while (current != null) {

			next = current.next;
			if (revList == null) {
				revList = current;
				revList.prev = null;
				revList.next = null;
			} else {
				current.next = revList;
				current.prev = null;
				revList.prev = current;
				revList = current;
			}
			current = next;
		}
		return revList;
	}

	// Rotate
	static Node rotateAntiClock(Node head) {

		if(head == null || head.next == null) {
			return head;
		}
		
		Node first = head;
		head = head.next;
		Node temp = head;
		head.prev = null;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = first;
		first.prev = temp;
		first.next = null;		
		return head;
	}

	// Rotate
	static Node rotateClock(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node temp = head;		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.prev.next = null;
		temp.next = head;
		head.prev = temp;
		head = temp;		
		return head;
	}

	public static void main(String[] args) {

		Node head = null;
		// displayForword(head);

		head = insertAtEnd(head, 1);
		head = insertAtEnd(head, 2);
		head = insertAtEnd(head, 3);
		head = insertAtEnd(head, 4);
		displayForword(head);
		// head = insertAtPosition(head, 3, 10);
		// head = removeAtEnd(head);
		// head = removeAtEnd(head);
		// head = removeAtEnd(head);
		// head = removeAtEnd(head);
		head = rotateAntiClock(head);
		head = rotateAntiClock(head);
//		head = rotateClock(head);
//		head = rotateClock(head);
//		head = rotateClock(head);
		// head = removeAtPosition(head, 0);
		displayForword(head);
//		displayBackword(head);

		// displayBackword(head);
	}
}
