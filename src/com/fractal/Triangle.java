package com.fractal;

import java.util.ArrayList;

public class Triangle extends Shape{
	private ArrayList<Line> lines;
	public Triangle(Line line1, Line line2, Line line3){
		lines = new ArrayList<Line>();
		lines.add(line1);
		lines.add(line2);
		lines.add(line3);
	}
	public ArrayList<Line> lines(){
		return lines;
	}
	public double[][] array(){
		double[][] a = {};
		a[0] = ((Line) lines.toArray()[0]).array()[0];
		a[1] = ((Line) lines.toArray()[0]).array()[0];
		a[2] = ((Line) lines.toArray()[0]).array()[0];
		return a;
	}
}
