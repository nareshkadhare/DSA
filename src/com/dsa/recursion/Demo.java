package com.dsa.recursion;

/**
 * @author Naresh
 *
 */
public class Demo {

	static int printNumber(int s, int n) {

		if (s == n) {
			return n;
		}
		System.out.println(s);
		return printNumber(s + 1, n);
	}

	static int fact(int n) {

		// base case
		if (n == 1) {
			return 1;
		}

		// Main Logic
		return n * fact(n - 1);
	}

	static int sumOfNnumbers(int n) {

		if (n == 1) {
			return 1;
		}

		return n + sumOfNnumbers(n - 1);
	}

	static int febo(int a, int b, int n) {

		if (n == 0) {
			return 0;
		}
		System.out.println(a);
		return febo(b, (a + b), n - 1);
	}

	static void reveresArray(char[] arr, int s, int e) {

		if (s == e || s > e) {
			return;
		}
		char temp = arr[s];
		arr[s] = arr[e];
		arr[e] = temp;
		reveresArray(arr, ++s, --e);
	}

	static int powerOfNumber(int n, int k) {
		return (k == 1) ? n : n * powerOfNumber(n, k - 1);
	}

	static int sumOfDigits(int n) {

		if (n <= 0) {
			return 0;
		}
		return n % 10 + sumOfDigits(n / 10);
	}

	static void printNaturalNumbers(int s, int limit) {
		if (s > limit) {
			return;
		}
		System.out.println(s);
		printNaturalNumbers(++s, limit);
	}

	static void febonacci(int a, int b, int n) {
		if (n == 0) {
			return;
		}
		System.out.println(a);
		febo(b, a + b, --n);
	}

	static int lengthOfNumber(int n, int length) {
		if( n < 1) {
			return length;
		}
		return lengthOfNumber(n / 10, ++length);
	}

	static int largestElementOfAnArray(int[] arr,int travarsalIndex, int max) {
		
		if(travarsalIndex == arr.length - 1) {
			return max;
		}
		if(arr[travarsalIndex] < arr[travarsalIndex + 1]) {			
			max = arr[travarsalIndex + 1];
		}
		return largestElementOfAnArray(arr, ++travarsalIndex, max);
	}
	
	static boolean isPrime(int n, int index) {
		
		if((n / 2) < index) {
			return true;
		}
		if(n % index == 0) {
			return false;
		}
		
		return isPrime(n, ++index);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		for (int i = 2; i < 20; i++) {
			System.out.println(i + " => " +isPrime(i, 2));
		}
	}

}
