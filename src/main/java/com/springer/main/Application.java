package com.springer.main;

import java.util.Scanner;

public class Application {
	
	
	private String cmd;
	private char colour;
	private char option;
	private int[] coordinates;
	
	private Canvas whiteboard;
	
	public Application() {
		cmd = "";		
	}
	
	/**
	 * This method will parse the command the user input in.
	 * 
	 * @return true if the command is good to go, otherwise false
	 * */
	private boolean parseCommand(String command) {
		boolean result = false;
		String[] values;
		
		if(!command.isEmpty()) {
			
			values = command.split(" ");
			coordinates = new int[values.length - 1];
			
			switch(values.length) {
				case 3:
					if(values[0].equals("C")) {
						option = 'C';
						result = true;
					}
					//break;
				case 5:
					if(values[0].equals("L")) {
						option = 'L';
						result = true;
					}
					else if(values[0].equals("R")) {
						option = 'R';
						result = true;
					}
					
					for(int i=1; i<values.length && result; i++) {
						this.coordinates[i-1] = Integer.parseInt(values[i]);
					}
					
					break;
				case 4:
					if(values[0].equals("B")) {
						option = 'B';
						result = true;
						this.coordinates = new int[2];
						this.coordinates[0] = Integer.parseInt(values[1]);
						this.coordinates[1] = Integer.parseInt(values[2]);
						this.colour = values[3].charAt(0);	
					}
									
					break;
				case 1: 
					if(values[0].equals("Q")) { 
						option = 'Q';
						result = true;
					}
					break;
			}
			
			
		}	
		
		return result;
	} 
	
	public void execute() {
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("enter command: ");
			cmd = input.nextLine();
			//No empty
			if(parseCommand(cmd)) {				
				
				//First we should create a Canvas:  C 20 4
				switch(option) {
					case 'C': 
						
						if(coordinates.length == 2) {
							whiteboard = new Canvas(coordinates[0], coordinates[1]);
							whiteboard.drawCanvas();
							whiteboard.showCanvas();
						}					
						break;
					case 'L': 
						if(whiteboard != null) {
							whiteboard.drawLine(coordinates);
							whiteboard.showCanvas();
						}
						break;
					case 'R': 
						if(whiteboard != null) {
							whiteboard.drawRectangle(coordinates);
							whiteboard.showCanvas();
						}
						break;
					case 'B': 
						if(whiteboard != null) {
							whiteboard.drawFiller(coordinates, colour);
							whiteboard.showCanvas();
						}
						break;			
				}
			}
			
		} 
		while(option != 'Q');
		
		input.close();
	}
	
}
