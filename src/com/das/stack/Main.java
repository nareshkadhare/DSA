package com.das.stack;

public class Main {
	
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.display();
		System.out.println(stack.push(1));			
		System.out.println(stack.push(2));			
		System.out.println(stack.push(3));			
		System.out.println(stack.push(4));			
		System.out.println(stack.push(5));			
		stack.display();
		System.out.println(" Peek Value : " +stack.peek());			
		System.out.println(" Peek Value : " +stack.peek());			
		System.out.println(" Peek Value : " +stack.peek());			
		System.out.println(" Peek Value : " +stack.peek());			
		System.out.println(" Peek Value : " +stack.peek());			
//		System.out.println(stack.pop());			
//		System.out.println(stack.pop());			
//		System.out.println(stack.pop());			
//		System.out.println(stack.pop());			
//		System.out.println(stack.pop());			
//		System.out.println(stack.pop());			
		stack.display();
	}
}
