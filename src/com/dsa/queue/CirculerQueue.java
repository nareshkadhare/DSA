package com.dsa.queue;

public class CirculerQueue {

	int[] queue;
	int front, rear;

	public CirculerQueue(int length) {
		queue = new int[length];
		front = -1;
		rear = -1;
	}

	// enqueue
	void enqueue(int data) {
		if (isFull()) {
			System.out.println("Cannot add value => "+data+" because of Queue overflow\n");
			return;
		}
		
		if(isEmpty()) {						
			++front;			
		}		
		
		if(rear == queue.length - 1 && front != 0) {
			rear = -1;
		}		
		queue[++rear] = data;
	}

	// dequeue
	int dequeue() {
		int element = 0;
		if(isEmpty()) {
			System.out.println("Queue underflow.");
			return element;
		}
		
		element = queue[front];
		
		if(front == rear) {
			front = -1;
			rear = -1;			
		}		
		else if(front == 4 && rear != -1) {
			front = -1;									
		}		
		
		front++;
		return element;
	}
	
	// display
	void display() {
		System.out.println("Front : "+front);
		System.out.println("Rear : "+rear);
		
		System.out.println("\n============= Display Start ==================\n");
		
		if(front <= rear) {
			for (int i = front; i <= rear; i++) {
				System.out.println("Queue [ "+i+" ] => "+queue[i]);
			}
		} else if(rear < front) {
			for (int i = front; i < queue.length; i++) {
				System.out.println("Queue [ "+i+" ] => "+queue[i]);
			}

			for (int i = 0; i <= rear; i++) {
				System.out.println("Queue [ "+i+" ] => "+queue[i]);
			}
		}
		System.out.println("\n============= Display End ==================\n");
			
	}

	// isEmpty
	boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	// isFull
	boolean isFull() {
		return ((front == 0 && rear == queue.length - 1) || (rear + 1 == front));
	}
	

	public static void main(String[] args) {
		CirculerQueue cq = new CirculerQueue(5);
		//cq.dequeue();
		cq.enqueue(10);
		cq.enqueue(20);
		cq.enqueue(30);
		cq.enqueue(40);
		cq.enqueue(50);				
		cq.dequeue();
		cq.enqueue(100);
		cq.dequeue();
		cq.enqueue(200);
		cq.dequeue();
		cq.enqueue(400);
		cq.dequeue();
		cq.enqueue(500);
		cq.dequeue();		
		cq.enqueue(600);				
		cq.display();
	}

}
