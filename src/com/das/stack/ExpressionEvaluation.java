package com.das.stack;

import java.util.Arrays;

public class ExpressionEvaluation {

	static char[] operators;
	static int opTop = -1;
	static double[] values;
	static int valTop = -1;

	static void pushOperator(char operator) {
		if (opTop == -1) {
			operators[++opTop] = operator;
		} else {

			if (operator == ')') {

				while (opTop > -1 && operators[opTop] != '(') {
					evaluate();
				}
				opTop--;
				return;
			}

			char topOp = peekOperator();

			if (!hasPrecedence(topOp, operator)) {
				evaluate();
			}
			operators[++opTop] = operator;
		}
	}

	static void pushToValue(double value) {
		values[++valTop] = value;
	}

	static char peekOperator() {
		return operators[opTop];
	}

	static double popValue() {
		return values[valTop--];
	}

	static char popOperator() {
		return operators[opTop--];
	}

	static boolean hasPrecedence(char topOp, char op) {
		if (topOp == '(' || topOp == ')') {
			return true;
		}

		if (topOp == '^' && (op == '*' || op == '/' || op == '+' || op == '-')) {
			return false;
		}

		if ((topOp == '*' || topOp == '/') && (op == '+' || op == '-')) {
			return false;
		}
		return true;
	}

	static void evaluate() {
		double second = popValue();
		double first = popValue();
		double result = 0;

		char operator = popOperator();

		switch (operator) {
		case '+':
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '/':
			result = first / second;
			break;
		case '*':
			result = first * second;
			break;
		case '^':
			result = Math.pow(first, second);
			break;
		}
		pushToValue(result);
	}

	public static void main(String[] args) {

		String expression = "4*(2+2)+(2+2)";
		expression = "100*2";
		values = new double[expression.length()];
		operators = new char[expression.length()];

		double val;
		String charVal = "";

		char[] chrs = expression.toCharArray();

		for (int i = 0; i < chrs.length; i++) {

			if (!Character.isDigit(chrs[i])) {
				pushOperator(chrs[i]);
			} else {
				charVal = String.valueOf(chrs[i]);
				while (i < chrs.length - 1 && Character.isDigit(chrs[i + 1])) {
					charVal += String.valueOf(chrs[i + 1]);
					i++;
				}
				val = Double.parseDouble(charVal);
				pushToValue(val);
			}
		}
		while (opTop > -1) {
			evaluate();
		}
		System.out.println(expression + " => " + values[0]);
	}

}