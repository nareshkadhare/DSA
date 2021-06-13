package com.dsa.queue;

public class DeQueue {

	int front = -1;
	int rear = -1;
	int[] queue;

	public DeQueue(int length) {
		this.queue = new int[length];
	}

	// Insert At Front
	public void insertAtFront(int data) {
		if ((front == 0 && rear == queue.length - 1) || (front - 1 == rear)) {
			System.out.println("Can't insert '" + data + "' because Queue is overflow.");
			return;
		}

		if (isEmpty()) {
			queue[++front] = data;
			rear++;
			return;
		}

		if (front == 0 && rear != queue.length - 1) {
			front = queue.length;
		}
		queue[--front] = data;

	}

	// Insert At Last
	public void insertAtLast(int data) {
		if ((front == 0 && rear == queue.length - 1) || (rear + 1 == front)) {
			System.out.println("Can't insert '" + data + "' because Queue is overflow.");
			return;
		}

		if (isEmpty()) {
			front++;
		} else if (rear == queue.length - 1 && front != 0) {
			rear = -1;
		}

		queue[++rear] = data;
	}

	// Delete At Front
	public int deleteAtFront() {
		if (isEmpty()) {
			System.out.println("Stack undeflow");
			return 0;
		}
		int element = 0;
		element = queue[front];
		queue[front] = 0;
		if (front == rear) {
			front = -1;
			rear = -1;
			return element;
		}
		if (front == 4 && rear != 0) {
			front = -1;
		}
		front++;
		return element;
	}

	// Delete At Last
	public int deleteAtLast() {
		if(isEmpty()) {
			System.out.println("Stack undeflow");
			return 0;
		}
		int element = 0;
		element = queue[rear];
		queue[rear] = 0;
		if (front == rear) {
			front = -1;
			rear = -1;
			return element;
		} 		
		if(rear == 0) {
			rear = queue.length;
		}
		rear--;
		return element;
	}

	// getFront
	public int getFront() {
		return isEmpty() ? -1 : queue[front];
	}

	// getRear
	public int getRear() {
		return isEmpty() ? -1 : queue[rear];
	}

	// isEmpty
	public boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	public void display() {
		System.out.println("\n---------------- Display Start -------------------------\n");
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			System.out.println("\nFront => " + front + " => " + getFront());
			System.out.println("\nRear => " + rear + " => " + getRear());
			System.out.println();
			for (int i = 0; i < queue.length; i++) {
				System.out.println("Queue[ " + i + " ] => " + queue[i]);
			}
		}
		System.out.println("\n---------------- Display End -------------------------\n");
	}

	public static void main(String[] args) {
		DeQueue deQueue = new DeQueue(5);
		// System.out.println("De-Queued => "+deQueue.deleteAtFront());

		deQueue.insertAtFront(10);
		deQueue.insertAtLast(20);
		deQueue.insertAtLast(30);
		deQueue.insertAtLast(40);
		deQueue.insertAtLast(50);
		deQueue.display();
//		deQueue.insertAtFront(20);
		deQueue.deleteAtFront();
		deQueue.deleteAtFront();
		deQueue.insertAtLast(60);
		deQueue.insertAtLast(70);
		deQueue.display();
		
		System.out.println("De-Queued => "+deQueue.deleteAtLast());
		System.out.println("De-Queued => "+deQueue.deleteAtLast());
		System.out.println("De-Queued => "+deQueue.deleteAtLast());
		System.out.println("De-Queued => "+deQueue.deleteAtLast());
		System.out.println("De-Queued => "+deQueue.deleteAtLast());
//		deQueue.insertAtLast(30);
//		deQueue.insertAtFront(40);
//		deQueue.insertAtFront(50);
		
		
		
//		System.out.println("De-Queued => " + deQueue.deleteAtFront());		
//		System.out.println("De-Queued => " + deQueue.deleteAtFront());		
//		System.out.println("De-Queued => " + deQueue.deleteAtFront());		
//		System.out.println("De-Queued => " + deQueue.deleteAtFront());		
//		System.out.println("De-Queued => " + deQueue.deleteAtFront());		
		deQueue.display();
	}
}
