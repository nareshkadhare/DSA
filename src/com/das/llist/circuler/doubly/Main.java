package com.das.llist.circuler.doubly;

public class Main {

	// Traverse
	static void displayForword(Node head) {

		System.out.println("\n===============================\n");
		Node temp = head;
		do {
			if (temp == null)
				break;
			System.out.print(temp.data + "->");
			temp = temp.next;
		} while (temp != head);
	}

	// insertAtBeg
	static Node insertAtBeg(Node head, int data) {

		Node node = new Node(data);
		// 1. Empty
		if (head == null) {
			return node;
		}

		// 2. only 1 Element
		if (head.next == null) {
			node.next = head;
			head.prev = node;
			head.next = node;
			node.prev = head;
			return node;
		}

		// 3. Multiple Element
		node.next = head;
		head.prev = node;
		Node temp = head;

		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = node;
		node.prev = temp;
		return node;
	}

	// insertAtEnd
	static Node insertAtEnd(Node head, int data) {

		Node node = new Node(data);
		// 1. Empty
		if (head == null) {
			return node;
		}

		// 1 element
		if (head.next == null) {
			head.next = node;
			node.prev = head;
			node.next = head;
			head.prev = node;
			return head;
		}

		// 3. Multiple element
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
			if (temp == null)
				break;
		}
		temp.next = node;
		node.prev = temp;
		node.next = head;
		head.prev = node;
		return head;
	}

	static int getLength(Node head) {

		if (head == null) {
			return 0;
		}
		int length = 1;
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
			if (temp == null) {
				break;
			}
			length++;
		}
		return length;
	}

	// insertAtPosition 12:03 | 12:20
	static Node insertAtPosition(Node head, int data, int position) {

		int length = getLength(head);

		if (position > length + 1 || position < 1) {
			System.out.println("Invalid position -> " + position);
			return head;
		}

		Node temp = head;
		for (int i = 1; i < position - 1; i++) {
			temp = temp.next;
		}

		if (position == 1) {
			return insertAtBeg(head, data);
		} else if (position == length + 1) {
			return insertAtEnd(head, data);
		}

		// 1->2->3-<1
		Node node = new Node(data);
		Node next = temp.next;
		temp.next = node;
		node.prev = temp;
		node.next = next;
		return head;
	}

	// deleteAtPosition
	static Node deleteAtPosition(Node head, int position) {

		if (head == null) {
			System.out.println("List is empty.");
			return head;
		}

		int length = getLength(head);

		if (position < 1 || position > length) {
			System.out.println("Invalid position. -> " + position);
			return head;
		}

		if (position == 1) {
			return deleteAtBeg(head);
		} else if (position == length) {
			return deleteAtEnd(head);
		} else {
			
			Node temp = head;
			for(int i = 1;i < position;i++) {
				temp = temp.next;
			}
			
			Node prev = temp.prev;
			Node next = temp.next;
			prev.next = next;
			next.prev = prev;
			return head;
		}
	}

	static Node deleteAtBeg(Node head) {

		// 1 element
		if (head.next == null) {
			return null;
		}

		// multiple element
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		head = head.next;
		head.prev = temp;
		temp.next = head;
		return head;
	}

	static Node deleteAtEnd(Node head) {
		
		if (head.next == null) {
			return null;
		}
		
		// multiple element
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		Node prev = temp.prev;
		prev.next = temp.next;
		head.prev = prev;
		return head;
	}

	public static void main(String[] args) {
		Node head = null;
		head = new Node(1);
		//// head = insertAtBeg(head, 2);
		//// head = insertAtBeg(head, 3);
		//// head = insertAtBeg(head, 4);
		head = insertAtEnd(head, 2);
		head = insertAtEnd(head, 3);
		head = insertAtEnd(head, 4);
		head = insertAtEnd(head, 5);
		// head = insertAtPosition(head, 10, 4);
		displayForword(head);
		head = deleteAtPosition(head, 4);
		displayForword(head);
	}
}
