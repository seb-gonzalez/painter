package com.springer.main;

import java.util.ArrayList;

public class Canvas {

	private ArrayList<Drawable> elements;
	
	private String[][] board;
	private int width;
	private int height;

	public Canvas(int w, int h) {
		width = w + 2;
		height = h + 2;
		board = new String[width][height];
		setBlankCanvas();
		
		elements = new ArrayList<Drawable>();
	}
	
	/**
	 * This method will set the whole canvas with the 
	 * default value " "
	 * */
	private void setBlankCanvas() {
		for(int x=0; x<width; x++)
			for(int y=0; y<height; y++)
				board[x][y] = " ";
	}
	
	
	/**
	 * Method that shows the canvas´ content
	 * */
	public void showCanvas() {	
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				System.out.print(board[x][y]);
			}
			System.out.println("");
		}	
	}

	/**
	 * Method that will draw the frame of the canvas
	 * */
	public void drawCanvas() {		
		
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				
				if(y == 0 || y == height-1) {
					board[x][y] = "-"; 				
				}				
				else if(y > 0 && y < height-1) {
					if(x == 0 || x == width-1) board[x][y] = "|";									
				}			
			}
        }
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public String[][] getBoard() {
		return this.board;
	}
	public void setCanvas(String[][] board ) {
		this.board = board;
	}
	
	public void drawLine(int[] coordinates) {
		
		Drawable line = new Line(this, coordinates);
		line.draw();
		
		elements.add(line);
	}
	
	public void drawRectangle(int[] coordinates) {
		Drawable rectangle = new Rectangle(this, coordinates);
		rectangle.draw();
		
		elements.add(rectangle);
	}
	
	public void drawFiller(int[] coordinates, char colour) {
		Drawable filler = new Filler(this, coordinates, colour);
		filler.draw();
		
		elements.add(filler);
	}
	
	
}
