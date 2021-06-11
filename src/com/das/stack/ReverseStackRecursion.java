package com.das.stack;

public class ReverseStackRecursion {

	static int[] stack;
	static int top = -1;
	
	static void push(int data) {
		if(top == stack.length - 1) {
			System.out.println("Stackoverflow");
			return;
		}
		stack[++top] = data;
	}
	
	static int pop() {
		if(top == -1) {
			System.out.println("Stackunderflow");
			return 0;
		}
		return stack[top--];
	}
	
	static void display() {
		
		System.out.println("\n========================\n");
		for(int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
	
	static void reverse(int left,int right) {
		
		if(left > right) {
			return;
		}
		int temp = stack[left];
		stack[left] = stack[right];
		stack[right] = temp;
		reverse(++left, --right);
	}

	public static void main(String[] args) {
		stack =  new int[5];
		push(1);
		push(2);
		push(3);
	
		display();
		reverse(0,top);
		display();
	}

}
