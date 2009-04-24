package com.fractal;

import java.util.ArrayList;

public class Polygon extends Set{
	private ArrayList<Line> lines;
	private int edges;

	public Polygon(Line base, int edges) {
		this.edges = edges;
		lines = new ArrayList<Line>(edges);
		lines.add(base);
		Angle alpha = new Angle((edges-2d)/edges*180-180);
		for (int i= 0; i< edges-1; i++){			//there is already the last edge: iterate only to 'edges-1'
			Line line = lines.get(i);
			lines.add(line.grow(alpha, line.vector()));
		}
	}
	public Polygon(Line base, int edges, Angle angle) {
		this.edges = edges;
		lines = new ArrayList<Line>(edges);
		lines.add(base);
		Angle alpha = angle.minus(180);
		for (int i= 0; i< edges-1; i++){
			Line line = lines.get(i);
			lines.add(line.grow(alpha, line.vector()));
		}
	}
	@Override
	public double[] array() {
		double[] a = new double[edges*4];
		for (int i= 0; i < edges; i++){
			double[] array = lines.get(i).array();  
			a[4*i] = array[0];
			a[4*i+1] = array[1];
			a[4*i+2] = array[2];
			a[4*i+3] = array[3];
		}
		return a;
	}
	@Override
	public void setArray(double[] array) {
		for (int i= 0; i < edges; i++){
			lines.set(i, new Line(array[4*i],array[4*i+1],array[4*i+2],array[4*i+3]));
		}		
	}
	public ArrayList<Line> lines(){
		return lines;
	}
}
