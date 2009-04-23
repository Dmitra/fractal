package com.fractal;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle extends Set implements Planar{
	private ArrayList<Line> lines;
	public Triangle(Angle angle, Line line){
		lines = new ArrayList<Line>(line.tick(angle));
		lines.add((Line) line.mirror(line.midst()));
	}
	public ArrayList<Line> lines(){
		return lines;
	}
	@Override
	public double[] array(){
		double[] a = new double[12];
		for (int i= 0; i < 3; i++){
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
		for (int i= 0; i < 3; i++){
			lines.set(i, new Line(array[4*i],array[4*i+1],array[4*i+2],array[4*i+3]));
		}		
	}
}
