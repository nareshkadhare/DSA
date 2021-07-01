package com.dsa.graph;

import java.util.LinkedList;

public class LinkedListRepresentation {
	public LinkedList<Integer>[] adj;

	public LinkedListRepresentation(int v) {
		this.adj = new LinkedList[v];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	public void display() {
		LinkedList<Integer> temp; 
		for (int i = 0; i < adj.length; i++) {
			temp = adj[i];
			System.out.print(i+" => ");
			for (Integer integer : temp) {
				System.out.print(integer+" "); 
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		LinkedListRepresentation graph = new LinkedListRepresentation(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);			
		graph.display();
	}
}
