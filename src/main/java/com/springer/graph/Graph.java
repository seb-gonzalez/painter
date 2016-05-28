package com.springer.graph;

import java.util.ArrayList;
import java.util.Hashtable;

import com.springer.main.Canvas;

public class Graph {
	
	private Canvas canvas;
	private String[][] board;
	
	private ArrayList<Point> vertexList;
	private ArrayList<Arista> aristaList;
	
	private int nVertex;
	private Hashtable<Integer, ArrayList<Point>> adjacentList;
	
	
	
	public Graph(Canvas canvas) {
		this.canvas = canvas;
		this.board = canvas.getBoard();
		
		vertexList = new ArrayList<Point>();
		aristaList = new ArrayList<Arista>();
		
		adjacentList = new Hashtable<Integer, ArrayList<Point>>();
		nVertex = 0;
	}
	
	
	/**
	 * Method that will deal with insertion of a new vertex
	 * in our ArraList. We will also keep a track of the number
	 * of Vertex that we have so far.
	 * 
	 * If the vertex was stored in the ArrayList, this will not
	 * be stored on it.
	 * */
	private void insertVertex(Point p) {
		if(!vertexList.contains(p)) {
			vertexList.add(p);
			//for each vertex we keep a track of all their neighbors
			adjacentList.put(p.getIdPoint(), new ArrayList<Point>());
			nVertex++;			
		}
	}
	
	
	/**
	 * Method that will create an Arista based on the current position passed
	 * as parameter and the future position that will be given by the direction:
	 * - right
	 * - down
	 * that means that if you get 'right' you will look up to the right of the current
	 * position/Point/vertex to find out a neighbor point that will pair up with the 
	 * current point. By this way we create an Arista [PointA, PointB]
	 * 
	 * @param 
	 * @return true if we successfully create a new Arista, otherwise false
	 * */
	private boolean createArista(int x, int y, String direction) {
		boolean result;		
		int x1 = 0;
		int y1 = 0;		
		Point pointA;
		Point pointB;
		Arista newArista;
		
		if(direction.equals("right")) {
			x1 = x + 1;
			y1 = y;
		}
		else if(direction.equals("down")) {
			x1 = x;
			y1 = y + 1;
		}
		
		//Neighbor point/vertex has to be blank to be considered
		if(board[x1][y1] == " ") {			
			pointA = new Point(x, y);   //current vertex/point
			//pointA.setIdPoint( (x*10) + y);
			pointB = new Point(x1, y1); //neighbor
			//pointB.setIdPoint( (x1*10) + y1);
			
			//we check whether the neighbor is inside the canvas or not
			if(pointB.withinBoundaries(canvas.getWidth(), canvas.getHeight())) {
				
				//I will insert the new Arista in the list just if 
				//it wasn´t inserted in the list previously				
				newArista = new Arista(pointA, pointB);
				
				if(!aristaList.contains(newArista)) {
					aristaList.add(newArista);
					
					//Also the both Vertex/point will be recorded
					insertVertex(pointA);
					insertVertex(pointB);
				}
				
				
				/*Once we get our Arista we add the adjacents*/
				if(!this.adjacentList.get(pointA.getIdPoint()).contains(pointB)) {
					this.adjacentList.get(pointA.getIdPoint()).add(pointB);
				}
				
				if(!this.adjacentList.get(pointB.getIdPoint()).contains(pointA)) {
					this.adjacentList.get(pointB.getIdPoint()).add(pointA);
				}
				
				
				
				result = true;				
			}
			else result = false;
		}
		else result = false;
		
		
		return result;
	}
	
	/**
	 * Method that will go through the entire 'board' located in the Canvas.
	 * Only the positions/vertex with a blank string value = " " will be considered as
	 * candidates to form an Arista. 
	 * 
	 * This method is key as we will generate out of it all elements that integrates
	 * a Graph:
	 * - Vertex : in this case they are made of Point -locations- in the board
	 * - Arista : Made of 2 vertex
	 * - Array of Vertex
	 * - Array of Arista
	 * - total number of Vertex
	 * - Adjacent list of Vertex
	 * */
	public void generateGraph() {
		
		//It will loop over the whole board
		for(int j=0; j<canvas.getHeight(); j++) {    //Y
			for(int i=0; i<canvas.getWidth(); i++) { //X
				
				//It will only be treated locations with no value inside: blank value
				if(board[i][j].equals(" ")) {
					this.createArista(i, j, "right");
					this.createArista(i, j, "down");
				}
				
			}
		}
		
	}
	
	// ************* GETTERS ****************	
	/**
	 * getAdjacents will retrieve the list of vertex adjacents
	 * to the vertex passed as parameter.
	 * 
	 * @param  Point to be consulted on how many neighbor it has
	 * @return ArrayList of Points
	 * */
	public ArrayList<Point> getAdjacents(Point vertex) {
		return adjacentList.get(vertex.getIdPoint());
	}
	/**
	 * This method will retrieve the number of 
	 * vertex within the Graph.
	 * */
	public int getNVertex() {
		return nVertex;
	}
	public ArrayList<Arista> getAristaList() {
		return aristaList;
	}
	
	public ArrayList<Point> getVertexList() {
		return vertexList;
	}

}
