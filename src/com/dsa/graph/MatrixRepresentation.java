package com.dsa.graph;

public class MatrixRepresentation {

	static int getVertexIndex(char[] vertices, char source) {

		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] == source)
				return i;
		}
		return -1;
	}

	static int[][] addEdge(char source, char destination, int[][] edges, char[] vertices) {
		int sourceIndex = getVertexIndex(vertices, source);
		int destinationIndex = getVertexIndex(vertices, destination);
		edges[sourceIndex][destinationIndex] = 1;
		return edges;
	}

	public static void main(String[] args) {
		char[] vertices = { 'A', 'B', 'C', 'D', 'E' };
		int[][] edges = new int[vertices.length][vertices.length];

		edges = addEdge('A', 'B', edges, vertices);
		edges = addEdge('A', 'E', edges, vertices);
		edges = addEdge('B', 'D', edges, vertices);
		edges = addEdge('D', 'C', edges, vertices);
		edges = addEdge('C', 'E', edges, vertices);

		for (int i = 0; i < edges.length; i++) {

			for (int j = 0; j < edges.length; j++) {
				if (edges[i][j] == 1) {
					System.out.println(vertices[i] + "," + vertices[j]);
				}

				if (edges[j][i] == 1) {
					System.out.println(vertices[i] + "," + vertices[j]);
				}
			}
		}
	}
}
