package com.das.llist.singly;

public class SinglyLinkedList {

	static void insertAtEnd(Node head, int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}

	}

	static Node insertAtBeginning(Node head, int data) {

		if (head == null) {
			head = new Node(data);
		} else {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
		return head;
	}

	static Node insertAtPosition(Node head, int position, Node newNode) {

		// Empty & Position is 1
		if (head == null && position == 1) {
			return newNode;
		}

		// Empty & Position is > 1
		if (head == null && position > 1) {
			System.out.println("\nInvalid Position");
			return null;
		}

		// Not Empty & Position Found
		if (head != null && position == 1) {
			newNode.next = head;
			head = newNode;
			return head;
		}

		Node temp = head;
		for (int i = 2; i < position && temp != null; i++, temp = temp.next) {
		}

		if (temp == null) {
			// Not Empty & Position Not Found
			System.out.println("\n\nElement position not found");
		} else if (temp.next == null) {
			// Not Empty & Position Not Found at Last
			temp.next = newNode;
		} else {
			// Not Empty & Position Found
			newNode.next = temp.next;
			temp.next = newNode;
		}

		return head;
	}

	static Node removeFromBeg(Node head) {

		if (head != null) {

			Node next = head.next;
			if (next == null) {
				head = null;
			} else {
				head = next;
			}
		}
		return head;
	}

	static Node removeAtPosition(Node head, int position) {

		// Empty
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}

		// position 1
		if (position == 1) {
			return removeFromBeg(head);
		}
		// Position 2 to n
		else {
			Node temp = head;
			int counter = 2;
			while (counter < position) {
				temp = temp.next;
				if (temp == null || temp.next == null) {
					System.out.println("\n\nElement not found with the position of " + position);
					return head;
				}
				counter++;
			}

			Node deleteNode = temp.next;
			if (deleteNode != null) {
				Node joinElement = deleteNode.next;
				temp.next = joinElement;
			}
		}
		return head;
	}

	static Node removeAtEnd(Node head) {

		// Empty
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}
		// If only 1 node is there
		else if (head.next == null) {
			return null;
		}
		// if there is more than 1 node
		else {

			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
		}
		return head;
	}

	static void displayList(Node head) {

		System.out.println("\n=============================\n");
		if (head == null) {
			System.out.println("List is empty");
		} else {

			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data);
				System.out.print(" -> ");
				temp = temp.next;
			}
		}

	}

	static boolean searchNode(Node head, int data) {

		Node temp = head;

		while (temp != null) {

			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	static Node updateNodeWithValue(Node head, int data, int updatedData) {

		if (head == null) {
			System.out.println("List is empty");
			return null;
		}

		Node temp = head;
		while (temp != null) {

			if (temp.data == data) {
				temp.data = updatedData;
				return head;
			}
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Value not found" + data);
		}
		return head;
	}

	static Node updateNodeWithPosition(Node head, int position, int updatedData) {

		// Empty
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}

		// Update First Position
		if (position == 1) {
			head.data = updatedData;
			return head;
		}

		Node temp = head;
		for (int i = 2; i <= position && temp != null; i++, temp = temp.next) {
		}

		if (temp == null) {
			System.out.println("Element not found for update");
		} else {
			temp.data = updatedData;
		}
		return head;
	}

	// Reverse
	static Node reverseNode(Node head) {

		Node prev = null;
		Node curr = null;
		Node temp = head;

		while (temp != null) {

			prev = curr;
			curr = temp;
			temp = temp.next;

			curr.next = prev;
		}
		head = curr;

		return head;
	}

	// Rotate ClockWise
	static Node rotateClockWise(Node head) {

		// Empty
		if (head == null) {
			System.out.println("List is empty.");
		} else if (head != null && head.next == null) {
			return head;
		} else {
			Node temp = head;
			while (temp.next != null && temp.next.next != null) {
				temp = temp.next;
			}
			Node last = temp.next;
			temp.next = null;
			last.next = head;
			head = last;
		}

		return head;
	}

	// Rotate AntiClockWise
	static Node rotateAntiClockWise(Node head) {

		if (head == null || head != null && head.next == null) {
			return head;
			
		} else {
			
			Node first = head;
			Node second = head.next;
			first.next = null;
			head = second;
			while (second.next != null) {
				second = second.next;
			}
			second.next = first;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		insertAtEnd(head, 2);
		insertAtEnd(head, 3);
		insertAtEnd(head, 4);
		insertAtEnd(head, 5);
		displayList(head);
		// head = removeAtPosition(head, 5);

		// head = insertAtPosition(head, 7, new Node(10));

		// head = updateNodeWithPosition(head, 6, 20);

		head = rotateAntiClockWise(head);
		displayList(head);
		head = rotateAntiClockWise(head);
		displayList(head);
		head = rotateAntiClockWise(head);
		// System.out.println(searchNode(head,5));
		displayList(head);
		head = rotateAntiClockWise(head);
		displayList(head);
		head = rotateAntiClockWise(head);
		displayList(head);
		// Insert -> beg , pos , end
		// Delete -> beg , pos , end
	}

}
