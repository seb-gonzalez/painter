package com.springer.main;

import java.util.ArrayList;

import com.springer.graph.DFS;
import com.springer.graph.Graph;
import com.springer.graph.Point;

public class Filler implements Drawable {

	private Canvas canvas;
	private int[] coordinates;
	private char colour;
	private Point point;

	private String[][] board;

	public Filler(Canvas canvas, int[] coordinates, char colour) {
		this.canvas = canvas;
		this.coordinates = coordinates;
		this.colour = colour;
	}

	public void draw() {

		if (this.checkCoordinates()) {
			Graph graph = new Graph(canvas);
			graph.generateGraph();

			DFS busqueda = new DFS(graph);
			busqueda.doDepthFirstSearch(point);
			ArrayList<Point> ver = busqueda.getVisitablePoints();

			board = canvas.getBoard();

			for (Point p : ver) {
				// System.out.println(p);
				board[p.getX()][p.getY()] = this.colour + "";
			}
			canvas.setCanvas(board);
		}

	}

	/**
	 * This method gets the values from the String coordinates variable and
	 * create corresponding Points with them. We are expecting 4 numeric values
	 * to pass the method, otherwise it won´t pass.
	 * 
	 * @return true if the number of values is being 4 or false
	 */
	private boolean parseCoordinates() {
		boolean result = false;

		if (this.coordinates.length == 2) {

			// Now we create the Point objects with those values
			point = new Point(coordinates[0], coordinates[1]);

			result = true;
		}

		return result;

	}

	/**
	 * This method will parse and check whether the string input by the user
	 * contains good coordinates to be drawn on the Canvas or not:
	 * 
	 * 1 - It will check that it does contain 2 values 2 - It will be checked
	 * whether the value is within boundaries
	 * 
	 * @return true if the coordinates are good to go, otherwise false
	 */
	public boolean checkCoordinates() {
		boolean result = false;
		// 1. Check whether there are 2 values or not
		if (parseCoordinates()) { // 2. Check whether the line points are within
									// the canvas size, or not
			if (point.withinBoundaries(canvas.getWidth(), canvas.getHeight())) {
				result = true;
			}
		}
		return result;
	}

}
