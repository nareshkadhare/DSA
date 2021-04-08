package com.dsa.linkedlist;

public class SinglyLinkedList {

	public static Node head;

	// Insert Node at the beginning of list
	public static void addAtHead(Node node) {

		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	// Insert Node at the ending of list
	public static void addAtTail(Node node) {

		if (head == null) {
			head = node;
		} else {

			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	// Search value and return its position
	public static int search(int value) {

		if (head == null) {
			return -1;
		} else {
			Node temp = head;
			int position = 1;
			while (temp != null) {
				if (temp.value == value) {
					return position;
				}
				temp = temp.next;
				position++;
			}
			return -1;
		}
	}

	// Search & Update value in list
	public static boolean update(int searchValue, int updatedValue) {

		boolean isUpdated = false;

		if (head != null) {

			Node temp = head;
			while (temp != null) {

				if (temp.value == searchValue) {
					temp.value = updatedValue;
					isUpdated = true;
					break;
				}
				temp = temp.next;
			}
		}

		return isUpdated;
	}

	// Remove node from list
	public static boolean removeNode(int value) {

		boolean isRemoved = false;
		if (head == null) {
			System.out.println("Can't remove because list is empty.");
		} else {
			Node temp = head;
			if (temp.value == value) {
				head = head.next;
				isRemoved = true;
			} else {
				while (temp.next != null) {
					if (temp.next.value == value) {
						temp.next = temp.next.next;
						isRemoved = true;
						break;
					}
					temp = temp.next;
				}
			}
		}
		return isRemoved;
	}

	// Display List
	public static void display() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			Node temp = head;
			System.out.println("==============================");
			while (temp != null) {
				System.out.println(temp.value);
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {
		addAtHead(new Node(10));
		addAtHead(new Node(20));
		addAtHead(new Node(30));
		addAtHead(new Node(40));
		addAtTail(new Node(9));
		addAtTail(new Node(8));
		display();
		System.out.println("Searching for 9 " + search(9));
		System.out.println("Searching for 50 " + search(50));
		System.out.println("Updating 9 to 900 : " + update(9, 900));
		System.out.println("Updating 90 to 900 : " + update(90, 900));
		display();
		System.out.println("Removing 30 from list : " + removeNode(40));
		System.out.println("Removing 300 from list : " + removeNode(8));
		display();

	}
}
