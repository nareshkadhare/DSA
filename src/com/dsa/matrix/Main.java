package com.dsa.matrix;

public class Main {

	static void displayMatrix(int[][] m) {

		int rows = m.length;
		int columns = m[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(m[i][j] + "  ");
			}
			System.out.println("");
		}
		System.out.println("=============");
	}

	static void addition(int[][] a, int[][] b) {

		int rows = a.length;
		int columns = a[0].length;

		int[][] c = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}

		displayMatrix(a);
		displayMatrix(b);
		displayMatrix(c);
	}

	static void subtraction(int[][] a, int[][] b) {

		int rows = a.length;
		int columns = a[0].length;

		int[][] c = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}

		displayMatrix(a);
		displayMatrix(b);
		displayMatrix(c);
	}

	static void multiplication(int[][] a, int[][] b) {

		int c[][] = new int[a.length][b[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int k = 0; k < a.length; k++) {
				for (int j = 0; j < b.length; j++) {
					c[i][k] += a[i][j] * b[j][k];
				}
			}
		}

		displayMatrix(a);
		displayMatrix(b);
		displayMatrix(c);
	}

	static int transpose(int[][] a) {

		int b[][] = new int[a.length][a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				b[j][i] = a[i][j];
			}
		}
		boolean isIdentical = true;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] != b[i][j]) {
					System.out.println("Its not identical.");
					isIdentical = false;
					return -1;
				}
			}
		}
		if (isIdentical) {
			return 1;
		}
		displayMatrix(a);
		displayMatrix(b);
		return 2;
	}

	static boolean symetric(int[][] a) {
		int b[][] = new int[a.length][a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				b[j][i] = a[i][j];
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] != b[i][j]) {
					System.out.println("Its not identical.");
					return false;
				}
			}
		}
		return true;
	}

	static boolean skewSymetric(int[][] a) {
		//row -> column
		int[][] at = new int[a.length][a[0].length];
		int[][] an = new int[a.length][a[0].length];
		
		System.out.println("Origanal");		
		displayMatrix(a);
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				at[j][i] = a[i][j];
			}			
		}		
		System.out.println("Origanal Transposed");
		displayMatrix(at);
		
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				an[i][j] = a[i][j] * -1;
			}			
		}		
		System.out.println("Origanal Negative");
		displayMatrix(an);
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(at[i][j] != an[i][j]) {
					return false;
				}
			}			
		}
			
		return true;
	}
	
	
	static boolean diogonal(int[][] a) {
		
		int rows = a.length;
		int columns = a[0].length;
		displayMatrix(a);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(i == j && a[i][j] == 0 ) {
					return false;
				} else if(i != j && a[i][j] != 0) {
					return false;
				}
			}			
		}
		return true;
	}
	
	static boolean scaler(int[][] a) {
		
		int firstvalue = a[0][0];
		int rows = a.length;
		int columns = a[0].length;
		
		displayMatrix(a);
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				
				
				if(i == j && firstvalue != a[i][j] && a[i][j] == 0) {					
					return false;
				} else if(i != j && a[i][j] != 0) {
					System.out.println(a[i][j]);
					return false;
				}
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = { { 2,0,0}, { 0,2,0 } , {0,0,2} };
		int[][] b = { { 4 }, { 5 }, { 6 } };
		// addition(a, b);

		System.out.println(scaler(a));
	}

}
