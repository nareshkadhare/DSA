package com.das.llist.circuler.singly;

public class Main {

	static void display(Node head) {
		
		System.out.println("\n===============================\n");
		if (head == null) {
			System.out.println("\nList is empty.");
			return;
		}
		Node temp = head;
		do {
			System.out.print(temp.data + "->");
			if (temp.next == null)
				break;
			temp = temp.next;
		} while (temp != head);
	}

	static Node insertAtEnd(Node head, int data) {

		Node newNode = new Node(data);

		if (head == null) {
			return newNode;
		}

		if (head.next == null) {
			head.next = newNode;
			newNode.next = head;
			return head;
		}

		Node temp = head;
		while (temp.next != head) {
			System.out.println(temp.data);
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.next = head;
		return head;
	}

	static Node insertAtBeg(Node head, int data) {

		Node node = new Node(data);
		if (head == null) {
			return node;
		}

		if (head.next == null) {
			head.next = node;
			node.next = head;
			return node;
		}

		Node temp = head;
		while (temp.next != null && temp.next.next != head) {
			temp = temp.next;
		}

		node.next = temp.next;
		temp.next = node;
		return node;
	}

	static Node insertAtPosition(Node head, int position, int data) {

		// 1. position < 1 || 2. empty && position > 1
		if (position < 1 || (head == null && position > 1)) {
			System.out.println("Invalid position");
			return head;
		}

		Node node = new Node(data);
		// 3. empty && position == 1
		// 4. only 1 element && position == 1
		// 5. multiple element && position == 1
		if (position == 1) {
			if (head == null) {
				return node;
			} else if (head.next == null) {
				node.next = head;
				head.next = node;
				return node;
			} else {
				node.next = head;
				Node temp = head;

				while (temp.next != head) {
					temp = temp.next;
				}
				temp.next = node;
				return node;
			}
		}

		// 6. multiple element && position > 1
		int current = 1;
		Node temp = head;
		while (current < position - 1) {
			temp = temp.next;
			current++;
			if (temp == head) {
				System.out.println("Invalid position -> " + position);
				return head;
			}
		}
		node.next = temp.next;
		temp.next = node;
		return head;
	}

	//delete at position
	static Node deleteAtPosition(Node head,int position) {
	
		if(position < 1) {
			System.out.println("Invalid position.");
			return head;
		}
	
		if(head == null) {
			System.out.println("List is empty");
			return head;
		}
	
		if(position == 1) {
			Node next = head.next;
			if(next == null) {
				return next;
			} else {
				//1-2-3-4-1
				Node temp = head;
				while(temp.next != head) {
					temp = temp.next;
				}
				temp.next = next;
				return next;
			}			
		}
	
		int current = 1;
		Node temp = head;
		while(current < position - 1) {
			current++;
			if(temp == head) {
				System.out.println("Invalid position.");
				return head;
			}
			temp = temp.next;
		}
		
		Node next = temp.next;
		if(next != null)
			temp.next = next.next;
		return head;
	}
	
	
	public static void main(String[] args) {

		Node head = new Node(1);
		head = insertAtEnd(head, 2);
//		head = insertAtEnd(head, 3);
//		head = insertAtEnd(head, 4);
		// head = insertAtBeg(head,2);
		// head = insertAtBeg(head,3);
		// head = insertAtBeg(head,4);
//		head = insertAtPosition(head, 0, 10);
		display(head);
		head = deleteAtPosition(head, 2);
		display(head);
	}
}
