package com.dsa.graph;

import java.util.LinkedList;

public class BFS {
	public LinkedList<Integer>[] adj;

	public BFS(int length) {
		this.adj = new LinkedList[length];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	//Print the graph
	public void breathFirstTraversal(int start) {
		
		//Take initial boolean array for visit check default all are false 
		boolean[] visited = new boolean[adj.length];

		//Use queue for BSF
		LinkedList<Integer> queue = new LinkedList();

		//Add source element in queue & mark it as visited
		queue.add(start);
		visited[start] = true;

		int pollValue;// Fetch queue front value
		LinkedList<Integer> temp;// store current polled node
		
		//Search until destination found or all vertext traversed
		while (!queue.isEmpty()) {
			
			//Dequeue Queue element
			pollValue = queue.poll();
			temp = adj[pollValue];
			
			//Print Graph Vertext 
			System.out.println(pollValue + " ");
			
			//Enqueue temp node vertices element 
			for (Integer integer : temp) {
				
				//if not visited then add into queue and mark it as visited
				if (!visited[integer]) {
					visited[integer] = true;
					queue.add(integer);
				}
			}
		}
	}

	//Find source to destination distance
	private int breathFirstSearch(int source, int destination) {
		
		//Take initial boolean array for visit check default all are false 
		boolean[] visited = new boolean[adj.length];
		int[] parent = new int[adj.length];
		
		//Use queue for BSF
		LinkedList<Integer> queue = new LinkedList();

		//Add source element in queue & mark it as visited
		queue.add(source);
		visited[source] = true;
		parent[source] = -1;
		
		int pollValue; // Fetch queue front value
		int counter = 0; // distance counter
		LinkedList<Integer> temp; // store current poll node
		
		
		//Search until destination found or all vertext traversed
		while (!queue.isEmpty()) {
			pollValue = queue.poll();
			temp = adj[pollValue];			
			
			//if destination found then return counter
			if(pollValue == destination) break;
			
			//Enqueue temp node vertices element 
			for (Integer integer : temp) {
				
				if (!visited[integer]) {
					
					//if not visited then add into queue and mark it as visited
					visited[integer] = true;
					queue.add(integer);
					parent[integer] = pollValue;
				}
			}			
		}
		
		int curr = destination;
		int distance = 0;
		while(parent[curr] != -1) {
			System.out.print(curr+ " -> ");
			curr = parent[curr];
			distance++;
		}
		
		return distance;
	}

	public static void main(String[] args) {
		BFS bfs = new BFS(6);

		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(0, 3);
		bfs.addEdge(1, 3);
		bfs.addEdge(1, 2);
		bfs.addEdge(1, 4);
		bfs.addEdge(4, 5);
		bfs.addEdge(3, 5);

//		bfs.breathFirstTraversal(4);
		System.out.println("Distance : "+bfs.breathFirstSearch(0,5));
	}

}
