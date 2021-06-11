package com.dsa.stack;

public class InfixToPrefix {
	static char[] operator;
	static int top = -1;
	static String result = "";

	static void push(char chr) {

		if (top == -1) {
			operator[++top] = chr;
		} else {
			char topChar = peek();
			if ((topChar == '+' || topChar == '-') && (chr == '*' || chr == '/' || chr == '^' || chr == '(')
					|| ((topChar == '*' || topChar == '/') && (chr == '^' || chr == '('))
					|| (topChar == '^' && chr == '(') || (topChar == '(')) {

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
		return (top == -1) ? ' ' : operator[top];
	}

	public static void main(String[] args) {

		StringBuilder inputInfix = new StringBuilder("(A-B/C)*(A/K-L)");
		System.out.println("Infix : " + inputInfix);
		operator = new char[inputInfix.length()];

		// 1. Reverse the infix
		String reverseInfix = inputInfix.reverse().toString();

		// 2. find post fix
		for (char chr : reverseInfix.toCharArray()) {

			switch (chr) {
			case '^':
			case '/':
			case '*':
			case '+':
			case '-':
				push(chr);
				break;
			case ')':
				push('(');

				break;
			case '(':
				pop(')');
				break;
			default:
				result += chr;
				break;
			}
		}
		// contact to result - all remaining operators from stack
		pop(' ');

		StringBuilder preFix = new StringBuilder(result);

		// 3. Reverse the postfix to get prefix
		System.out.println("Prefix : " + preFix.reverse());
	}
}
