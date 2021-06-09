package com.das.llist.stack;

public class InfixPostfix {

	static String result = "";
	static char[] operator;
	static int top = -1;

	static void push(char chr) {
		if (top == -1) {
			operator[++top] = chr;
		} else {
			char topChar = peek();						
			if ((topChar == '+' || topChar == '-') && (chr == '*' || chr == '/' || chr == '^' || chr == '(')
					|| ((topChar == '*' || topChar == '/') && (chr == '^' || chr == '('))
					|| ((topChar == '^') && (chr == '(')) || (topChar == '(')) {

			} else {
				pop(chr);
			}
			operator[++top] = chr;
		}

	}

	static void pop(char chr) {
		if (top != -1) {

			while (top > -1 && operator[top] != '(') {
				result += operator[top];
				top--;
			}

			if (chr == ')') {
				top--;
			}
		}
	}

	static char peek() {
		return operator[top];
	}

	public static void main(String[] args) {

		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		operator = new char[infix.length()];

		for (char chr : infix.toCharArray()) {
			switch (chr) {
			case '(':
			case '^':
			case '*':
			case '/':
			case '+':
			case '-':
				push(chr);
				break;

			case ')':
				pop(chr);
				break;

			default:
				result += chr;
			}
		}
		pop(' ');

		System.out.println("Input String: " + infix);
		System.out.println("Output String: " + result);
	}
}
