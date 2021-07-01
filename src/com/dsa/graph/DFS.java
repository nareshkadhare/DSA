package com.dsa.graph;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {
	
	//Declare Adjacency list
	private LinkedList<Integer>[] adj;
		
	//Initialize Adjacency list
	public DFS(int length) {		
		this.adj = new LinkedList[length];		
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	//Add graph edges
	public void addEdge(int source, int destination) {
		this.adj[source].add(destination);
		this.adj[destination].add(source);
	}

	//DFS recursive search
	public boolean dfsUtil(int source, int destination, boolean[] visited) {
		
		if(source == destination) return true;
		visited[source] = true;
		
		for(int neighbure: adj[source]) {
			if(!visited[neighbure]) {
				visited[neighbure] = true;
				return dfsUtil(neighbure, destination, visited);
			}
		}
		
		return false;
	}
	
	public boolean dfs(int source, int destination) {
		boolean[] visited = new boolean[adj.length];			
		return dfsUtil(source, destination, visited);		
	}
	
	//DFS stack solution
	public boolean dfsStack(int source, int destination) {
		boolean[] visited = new boolean[adj.length];
		Stack<Integer> stack = new Stack<>();
		
		//Mark source as visited
		visited[source] = true;
		stack.push(source);
		
		int top;
		
		//Push element until all visit or destination found
		while(!stack.isEmpty()) {
			top = stack.pop();
			if(top == destination) return true;			
			for(int n : adj[top]) {
				if(!visited[n]) {
					visited[n] = true;
					stack.push(n);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		DFS dfs = new DFS(5);
		
		dfs.addEdge(0, 1); 
		dfs.addEdge(0, 4); 
		dfs.addEdge(1, 2); 
		dfs.addEdge(1, 4); 
		dfs.addEdge(1, 3); 
		dfs.addEdge(2, 3); 
		dfs.addEdge(3, 4);
		
		System.out.println("Is path present : "+dfs.dfs(0, 4));
		System.out.println("Is path present : "+dfs.dfsStack(0, 4));
	} 
}
