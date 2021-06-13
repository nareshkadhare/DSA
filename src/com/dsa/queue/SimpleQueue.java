package com.dsa.queue;

public class SimpleQueue {

	int[] queue;
	int front = -1;
	int rear = -1;

	public SimpleQueue(int length) {
		queue = new int[length];
	}
	
	// enqueue
	void enqueue(int data) {
		if (isFull()) {
			System.out.println("\nNot Enqueued => " + data);
			System.out.println("Because Queue is overflow.");
			return;
		}

		if (front == -1 && rear == -1) {
			front++;
		}
		queue[++rear] = data;
		System.out.println("Enqueued => " + data);
	}

	// dequeue
	int dequeue() {

		if (isEmpty()) {
			System.out.println("Queue is underflow.");
			return 0;
		}
		int element = queue[front++];
		if (front > rear) {
			front = -1;
			rear = -1;
		}
		System.out.println("Dequeued => " + element);
		return element;
	}

	// isEmpty
	boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	// isFull
	boolean isFull() {
		return (rear == queue.length - 1);
	}

	// display
	void display() {
		if (isEmpty()) {
			System.out.println("List is empty");
		} else {
			System.out.println("\n=============== DISPLAY START ====================");
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i] + " ");
			}
			System.out.println("\n\nFront => " + front);
			System.out.println("Rear => " + rear);
			System.out.println("\n=============== DISPLAY END ====================");
		}
	}

	public static void main(String[] args) {
		
		SimpleQueue simpleQueue = new SimpleQueue(5);
		
		simpleQueue.enqueue(10);
		simpleQueue.enqueue(20);
		simpleQueue.enqueue(30);
		simpleQueue.display();
		simpleQueue.dequeue();
		simpleQueue.dequeue();
		simpleQueue.dequeue();
		simpleQueue.enqueue(10);
		simpleQueue.display();
	}
}
