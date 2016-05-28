package com.springer.graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
	private Graph graph;
	private ArrayList<Point> visitedList;
	
	public DFS(Graph graph) {
		this.graph = graph;
		visitedList = new ArrayList<Point>();
	}
	
	public void doDepthFirstSearch(Point start) {
		Point u;
		ArrayList<Point> ady;	
		ArrayList<Integer> proccessed = new ArrayList<Integer>();		
		
		Stack<Point> pile = new Stack<Point>();
		pile.push(start);		
		proccessed.add(start.getIdPoint());
		
		while(!pile.isEmpty()) {
			u = pile.pop();			
			//añado a la lista resultado el vertice visitado
			visitedList.add(u);
			
			ady = graph.getAdjacents(u);
			for(int i=0; i<ady.size(); i++) {			
				
				if(!proccessed.contains(ady.get(i).getIdPoint())) {
					pile.push(ady.get(i));
					proccessed.add(ady.get(i).getIdPoint());
				}
				
			}
			
		}
		
	}
	
	
	public ArrayList<Point> getVisitablePoints() {
		return this.visitedList;
	}
}
