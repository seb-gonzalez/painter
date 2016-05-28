package com.springer.main;

import com.springer.graph.Point;

public class Rectangle implements Drawable {
	
	private Canvas canvas;
	private int[] coordinates;
	
	private Point pointA, pointB;
	
	public Rectangle(Canvas canvas, int[] coordinates) {
		this.canvas = canvas;
		this.coordinates = coordinates;
	}

	public void draw() {
		
		int x1, y1, x2, y2;
		
		if(checkCoordinates() && isRectangle()) {			
			x1 = pointA.getX();
			y1 = pointA.getY();
			x2 = pointB.getX();
			y2 = pointB.getY();
				
			Drawable line1 = new Line(canvas, new int[]{x1, y1, x2, y1});
			Drawable line2 = new Line(canvas, new int[]{x1, y1, x1, y2});
			Drawable line3 = new Line(canvas, new int[]{x1, y2, x2, y2});
			Drawable line4 = new Line(canvas, new int[]{x2, y1, x2, y2});
			
			line1.draw();			
			line2.draw();		
			line3.draw();		
			line4.draw();		
		}
		
		
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
			if(pointA.withinBoundaries(canvas.getWidth(), canvas.getHeight()) && pointB.withinBoundaries(canvas.getWidth(), canvas.getHeight())) {
				
				//3. Is this going to be rectangle
				if(isRectangle()) result = true;
				
			}	
			
		}
		
		return result;
	}
	
	public boolean isRectangle() {
		
		int widthR = Math.abs(pointA.getX() - pointB.getX());
		int heightR = Math.abs(pointA.getY() - pointB.getY());
		
		if(widthR != heightR) return true;
		else return false;
	}

}
