package com.fractal;

import java.util.ArrayList;

abstract class Shape {
	public double[][] array(){	//this is array of array of coordinates	
		return null;
	}
	public void setArray(double[][] array){
	}
	Shape absolute(){
		return this;
	}
	Shape relative(){
		return this;
	}
	public Point midst(){
		return new Point(0,0);
	}
	public Shape zoom(int times, Point center){
		double x = center.x; double y = center.y; double[][] array = this.array();
		for (int i= 0; i< array.length; i++){
	        array[i][2] = (array[i][2]-x) * times + x;
	        array[i][3] = (array[i][3]-y) * times + y;
	        array[i][0] = (array[i][0]-x) * times + x;
	        array[i][1] = (array[i][1]-y) * times + y;
		}
		this.setArray(array);
		return this;
	}
	public Shape move(Point point){
		double x= point.x; double y= point.y; double[][] array = this.array();
		for (int i= 0; i < array.length; i++){
			array[i][0] +=x;
			array[i][1] +=y;
			array[i][2] +=x;
			array[i][3] +=y;
		}
		this.setArray(array);
		return this;
	}
	public Shape rotate(double fi_deg, Point center){
		double fi = -(new Angle(fi_deg)).toRadian(); double x = center.x; double y = center.y;
		double[][] array = this.array();
	    for (int i= 0; i<this.array().length; i++){
	    	double x1= (array[i][0]-x) * Math.cos(fi) + (array[i][1]-y) * Math.sin(fi) + x;
	  	    double y1=-(array[i][0]-x) * Math.sin(fi) + (array[i][1]-y) * Math.cos(fi) + y;
	  	    double x2= (array[i][2]-x) * Math.cos(fi) + (array[i][3]-y) * Math.sin(fi) + x;
	  	    double y2=-(array[i][2]-x) * Math.sin(fi) + (array[i][3]-y) * Math.cos(fi) + y;
	  	    array[i] = new double[]{x1,y1,x2,y2};
	    }
		this.setArray(array);
		return this;
	}
	public ArrayList<Line> lines() {
		return null;
	}
}