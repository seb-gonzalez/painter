package com.springer.graph;

public class Arista {
	
	private Point start, end;
	
	public Arista(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	public boolean equals(Object objeto) {
		boolean result = false;
		
		if(objeto instanceof Arista) {
			if(start.equals(((Arista)objeto).getStart()) &&
			   end.equals(((Arista)objeto).getEnd())) result = true;
		}
		
		return result;
	}
	
	public String toString() {
		return "Arista ["+start.getX()+","+start.getY()+"] - ["+end.getX()+","+end.getY()+"]";
	}

}
