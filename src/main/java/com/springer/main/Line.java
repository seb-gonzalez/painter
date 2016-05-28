package com.springer.main;

import com.springer.graph.Point;

public class Line implements Drawable {
	
	
	private Canvas canvas;
	
	private String[][] board;
	private int w, h;
	private int[] coordinates;
	
	private Point pointA, pointB;
	
	/**
	 * Constructor
	 * 
	 * @param board is the surface where it will be drawn the line
	 * @param coordinates is the string that contains Point the two points
	 * 		  that define the line - x1 y1 x2 y2
	 * */
	public Line(Canvas canvas, int[] coordinates) {
		this.canvas = canvas;
		board = canvas.getBoard();
		w = canvas.getWidth();
		h = canvas.getHeight();
		this.coordinates = coordinates;
	}
	
	

	public void draw() {
		if(this.checkCoordinates()) {			
			
			if(isHorizontal()) {
				for(int x=0; x<this.w; x++) {
					if(x >= pointA.getX() && x <= pointB.getX())							
						board[x][pointA.getY()] = "x";
				}
			}
			else if(isVertical()) {
				for(int y=0; y<this.h; y++) {
					if(y >= pointA.getY() && y <= pointB.getY())
						board[pointA.getX()][y] = "x";
				}
			}
			
		}
		
		//Time to update the canvas board with the new draws!
		canvas.setCanvas(board);
	}

	
	/**
	 * This method will tell us whether the line is Horizontal or not.
	 * 
	 * @param true if the line to be drawn is Horizontal, otherwise false
	 * */
	private boolean isHorizontal() {
		boolean result = false;
		
		if((pointA.getY() == pointB.getY()) && !(pointA.getX() == pointB.getX()) ) 
			result = true;
				
		return result;
	}
	
	/**
	 * This method will tell us whether the line is Vertical or not.
	 * 
	 * @param true if the line to be drawn is Vertical, otherwise false
	 * */
	private boolean isVertical() {
		boolean result = false;
		
		if(!(pointA.getY() == pointB.getY()) && (pointA.getX() == pointB.getX()) ) 
			result = true;
		
		return result;
	}
	
	/**
	 * This method gets the values from the String coordinates variable
	 * and create corresponding Points with them. 
	 * We are expecting 4 numeric values to pass the method, otherwise it won´t pass.
	 * 
	 * @return true if the number of values is being 4 or false
	 * */
	private boolean parseCoordinates() {		
		boolean result = false;		
		
		if(this.coordinates.length == 4) {		
			
			//Now we create the Point objects with those values
			pointA = new Point(coordinates[0], coordinates[1]);
			pointB = new Point(coordinates[2], coordinates[3]);
			
			result = true;
			
		}
		
		return result;
		
	}
	
	/**
	 * This method will parse and check whether the string input by 
	 * the user contains good coordinates to be drawn on the Canvas
	 * or not:
	 * 
	 * 1 - It will check that it does contain 4 values
	 * 2 - It will be checked whether those values are within boundaries
	 * 
	 * @return true if the coordinates are good to go, otherwise false
	 * */
	public boolean checkCoordinates() {
		boolean result = false;
		// 1. Check whether there are 4 values or not
		if(parseCoordinates())
		{	//2. Check whether the line points are within the canvas size, or not
			if(pointA.withinBoundaries(w, h) && pointB.withinBoundaries(w, h)) {
				
				//3. Is the line Horizontal or Vertical?
				if(isHorizontal() || isVertical()) result = true;
				
			}	
			
		}
		
		return result;
	}
	
	public String[][] getBoard() {
		return this.getBoard();
	}
	
	

}
