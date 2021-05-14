package com.dsa.arrays;

import java.util.Arrays;

public class Main {

	// Rotate Array by specified number
	public static void rotateArray(int[] arr, int rotationNumber) {

		if (arr.length == 0 || arr.length == 1) {
			System.out.println("Rotation is not possible.");
			return;
		}
		if (rotationNumber < 1 || rotationNumber > arr.length) {
			System.out.println("Rotation number must be greter than 1");
			return;
		}

		int temp;
		for (int rotateCount = 1; rotateCount <= rotationNumber; rotateCount++) {

			temp = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[arr.length - 1] = temp;
		}
		display(arr);
	}

	public static void cyclicRotate(int[] arr, int rotationCount) {

		int temp;
		int length = arr.length;

		while (rotationCount > 0) {

			temp = arr[length - 1];
			for (int i = length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp;
			rotationCount--;
		}

	}

	public static void display(int[] arr) {
		System.out.println("\n======================\n");
		System.out.println(Arrays.toString(arr));
	}

	public static void reArrangeArray(int[] arr) {
		int length = arr.length;

		Arrays.sort(arr);

		boolean isFound;
		for (int i = 0; i < length; i++) {
			isFound = false;
			for (int j = 0; j < length; j++) {
				if (i == arr[j]) {
					arr[i] = i;
					isFound = true;
					break;
				}
			}

			if (!isFound) {
				arr[i] = -1;
			}
		}
	}

	public static void reverseUsingSwap(int[] a) {

		int startIndex = 0;
		int endIndex = a.length - 1;

		int temp;
		while (startIndex < endIndex) {

			temp = a[startIndex];
			a[startIndex] = a[endIndex];
			a[endIndex] = temp;

			startIndex++;
			endIndex--;
		}
	}

	public static String reverseStrUsingSwap(String a) {

		StringBuilder sb = new StringBuilder(a);

		int startIndex = 0;
		int endIndex = sb.length() - 1;

		char temp;
		while (startIndex < endIndex) {

			temp = sb.charAt(startIndex);
			sb.setCharAt(startIndex, sb.charAt(endIndex));
			sb.setCharAt(endIndex, temp);

			startIndex++;
			endIndex--;
		}

		return sb.toString();
	}

	public static void findSumExists(int[] a, int sum) {

		int length = a.length - 1;

		// boolean hasPair = false;
		// for (int i = 0; i < length; i++) {
		//
		// hasPair = false;
		// for (int j = i + 1; j < length; j++) {
		//
		// if (a[i] + a[j] == sum) {
		// System.out.println(" O/P : " + a[i] + " + " + a[j] + " => " + (a[i] + a[j]));
		// hasPair = true;
		// break;
		// }
		// }
		// if (hasPair) {
		// break;
		// }
		// }
		//
		// if (!hasPair) {
		// System.out.println(" O/P : " + -1);
		// }

		Arrays.sort(a);

		int startIndex = 0;
		int endIndex = length;
		int calculatedSum;
		while (startIndex < endIndex) {
			calculatedSum = a[startIndex] + a[endIndex];
			if (calculatedSum == sum) {
				System.out.println(
						" O/P : " + a[startIndex] + " + " + a[endIndex] + " => " + (a[startIndex] + a[endIndex]));

			}

			if (calculatedSum < sum) {
				startIndex++;
			} else {
				endIndex--;
			}
		}
		System.out.println(" O/P : " + -1);
	}

	public static void union(int[] firstArray, int[] secondArray) {

		int ap = 0;
		int bp = 0;
		int[] unionArray = new int[firstArray.length + secondArray.length];
		int mainIndex = 0;
		while (ap != firstArray.length - 1 && bp != secondArray.length - 1) {

			if (firstArray[ap] == secondArray[bp]) {
				unionArray[mainIndex++] = firstArray[ap];
				ap++;
				bp++;
			} else if (firstArray[ap] < secondArray[bp]) {
				unionArray[mainIndex++] = firstArray[ap];
				ap++;
			} else {
				unionArray[mainIndex++] = secondArray[bp];
				bp++;
			}
		}

		System.out.println(ap);
		while (ap != firstArray.length - 1) {
			unionArray[mainIndex++] = firstArray[++ap];

		}

		System.out.println(bp);
		while (bp != secondArray.length - 1) {
			unionArray[mainIndex++] = secondArray[++bp];

		}
		System.out.println(Arrays.toString(firstArray));
		System.out.println(Arrays.toString(secondArray));
		System.out.println(Arrays.toString(unionArray));
	}

	public static void main(String[] args) {

		int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
		int[] arr2 = new int[] { 3, 4, 5, 7 };

		union(arr1, arr2);

		// display(arr);
		//
		// findSumExists(arr, 7);
		//
		// reverseUsingSwap(arr);
		// display(arr);
		//
		// String n = "NARESH";
		// System.out.println(reverseStrUsingSwap(n));
		//
		//
		//

		//// // rotateArray(arr, 4);
		////
		//// cyclicRotate(arr, 4);
		//
		// reArrangeArray(arr);
		//
		// display(arr);

	}
}
