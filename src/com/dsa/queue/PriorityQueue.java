package com.dsa.queue;

class QueueElement {

	public int priority;
	public int data;

	public QueueElement(int priority, int data) {
		this.priority = priority;
		this.data = data;
	}

	@Override
	public String toString() {
		return "QueueElement [priority=" + priority + ", data=" + data + "]";
	}

}

public class PriorityQueue {

	public QueueElement[] queue;
	public int rear = -1;

	public PriorityQueue(int length) {
		this.queue = new QueueElement[length];
	}

	// enqueue
	public void enqueue(QueueElement queueElement) {
		if (isFull()) {
			System.out.println("Queue is full.");
			return;
		}
		queue[++rear] = queueElement;
	}

	// dequeue
	public int dequeue() {
		int index = peek();
		System.out.println("Dequeued : Queue [ " + index + " ] => " + queue[index]);
		for (int i = index; i < rear; i++) {
			queue[i] = queue[i + 1];
		}
		rear--;
		return index;
	}

	// peek
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return 0;
		}

		int min = queue[0].priority;
		int result = 0;

		for (int i = 0; i <= rear; i++) {
			if ((queue[i].priority < min) || (queue[i].priority == min && queue[i].data > queue[result].data)) {
				min = queue[i].priority;
				result = i;
			}
		}
		return result;
	}

	// display Queue
	public void display() {
		System.out.println("\n================ Display Start ==================\n");
		if (isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			for (int i = 0; i <= rear; i++) {
				System.out.println(" Queue [ " + i + " ] => " + queue[i]);
			}
		}
		System.out.println("\n================ Display End ==================\n");
	}

	// isEmpty
	public boolean isEmpty() {
		return (rear == -1);
	}

	// isFull
	public boolean isFull() {
		return (rear == queue.length - 1);
	}

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(5);
		pq.enqueue(new QueueElement(2, 20));
		pq.enqueue(new QueueElement(3, 30));
		pq.enqueue(new QueueElement(3, 40));
		pq.enqueue(new QueueElement(1, 50));
		pq.enqueue(new QueueElement(1, 500));
		pq.display();
		System.out.println("\nGet Hightest Priority at position : " + pq.dequeue());
		pq.display();
		System.out.println("\nGet Hightest Priority at position : " + pq.dequeue());
		pq.display();
		System.out.println("\nGet Hightest Priority at position : " + pq.dequeue());
		pq.display();
		System.out.println("\nGet Hightest Priority at position : " + pq.dequeue());
		pq.display();
		System.out.println("\nGet Hightest Priority at position : " + pq.dequeue());
		pq.display();
	}
}
