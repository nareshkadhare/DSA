package com.das.stack;

public class Stack {

	int top = -1;
	int[] stack;

	public Stack(int length) {
		stack = new int[length];
	}

	// Push
	boolean push(int data) {
		System.out.println("Adding : "+data);
		if (stack.length - 1 == this.top) {
			System.err.println("Stack overflow.");
			return false;
		}
	
		stack[++top] = data;
		return true;

	}

	// Pop
	int pop() {
		if(isEmpty()) {
			System.err.println("Stack underflow.");
			return 0;
		}		
		System.out.println("Removing : "+ stack[top]);
		return stack[top--];
	}

	// peek
	int peek() {
		if(isEmpty()) {
			System.err.println("Stack is empty.");
			return 0;
		}				
		return stack[top];		
	}

	// isEmpty
	boolean isEmpty() {
		return (top == -1);
	}
	
	
	void display() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");			
			return;
		}
		System.out.println("\n===============================");
		for (int i = top; i >= 0 ; i--) {
			System.out.println(stack[i]);
		}
		System.out.println("\n===============================");
	}
	
}
