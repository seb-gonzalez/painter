package com.springer.graph;

public class Point {
	private int x;
	private int y;
	private int idPoint;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.idPoint = (x*10) + y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * This method will check that the point is within the canvas and
	 * we are not going to draw something out of it.
	 * 
	 * @param weigth of the canvas where this point is about to be drawn
	 * @param height of the canvas where this point is about to be drawn
	 * @return true if the point is within the canvas, otherwise false
	 * */
	public boolean withinBoundaries(int weigth, int height) {
		boolean result = false;
		
		if((x >= 1 && x <= weigth-2) && (y >= 1 && y <= height-2) ) result = true;
		
		return result;
	}
	
	 public boolean equals(Object objeto)
    {
        boolean result = false;
        
        if(objeto instanceof Point)
        {
        	if(x == ((Point)objeto).getX() &&
        	   y == ((Point)objeto).getY()) result = true;           
        }
        
        return result;
    }

	public int getIdPoint() {
		return idPoint;
	}

	public void setIdPoint(int idPoint) {
		this.idPoint = idPoint;
	}
	
	public String toString() {
		return "Point ["+this.getX()+","+this.getY()+"]";
	}
}
