package com.dsa.stack;

public class BalancedExpression {

	static int top = -1;
	static char[] operators;

	static void push(char chr) {
		operators[++top] = chr;
	}

	static char peek() {
		return (top > -1) ? operators[top] : '0';
	}

	static boolean checkBrackets(char chr) {
		char topChar = peek();
		if ((topChar == '(' && chr == ')') || (topChar == '{' && chr == '}') || (topChar == '[' && chr == ']')) {
			top--;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String expression = "[()]";
		operators = new char[expression.length()];
		
		System.out.println("Expression : "+expression);
		
		if(expression.length() < 2) {
			System.err.println("Expression is invalid.");
			return;
		} else {
			boolean isValid = false;			
			for(char chr : expression.toCharArray()) {
				
				switch (chr) {
				case '{':
				case '(':
				case '[':
					push(chr);
					break;
					
				case '}':
				case ')':
				case ']':
					isValid = checkBrackets(chr);
					if(!isValid) {
						System.err.println("Expression is invalid.");
						return;
					}
					break;		
				}
			}
		}
		
		if(top == -1) {
			System.out.println("Expression is valid.");
		} else {
			System.err.println("Expression is invalid.");
		}
		
	}

}
