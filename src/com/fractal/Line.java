package com.fractal;

import java.util.ArrayList;

public class Line extends Shape{
	private double[] coords = new double[4];	//Line has 4 coordinates - cannot be changed from outside
	public Line(double x1, double y1, double x2, double y2){	//constructor from absolute coordinates
		coords[0] = x1; coords[1]=y1; coords[2]=x2; coords[3]=y2;
	}
	public static Line rel(double x1, double y1, double relX, double relY){	//constructor from relative coordinates
		return new Line(x1, y1, x1 + relX, y1 + relY);
	}
	public Line(Point start, Point end){		//constructor from Points
		coords = new double[]{start.x,start.y,end.x,end.y};
	}
	public Line(double array[]){				//constructor from array
		coords = array;
	}
	public Point starting(){
		return new Point(coords[0],coords[1]);
	}
	public Point ending(){
		return new Point(coords[2],coords[3]);
	}
	public double[] coords(){
		return coords;
	}
	public double[][] array(){				//this is array of coordinates, required by parent Shape class
		return new double[][]{coords}; 		//returns new instance of Array, have no effect on Line's coordinates
	}
	public void setArray(double[][] array){	//coordinates can be accessed via this function 
		coords = array[0];
	}
	public double x(){
		return ending().x - starting().x;
	}
	public double y(){
		return ending().y - starting().y;
	}
	public Point vector(){
		return new Point(x(),y());
	}
	public ArrayList<Line> tick(String spin, int angle){
		if (spin == "clockwise"){
			
		}
		else{
			
		}
		return new ArrayList<Line>();
	}
	public Line[] divide(int parts){
		Line[] result = new Line[parts];
		double[] x = new double[parts+1]; double[] y = new double[parts+1];
        x[0] = starting().x;
        y[0] = starting().y;
        x[parts] = ending().x;
        y[parts] = ending().y;
        double w = (x[parts] - x[0])/parts;	//stretch (отрезка) length after division by 'x' axis
        double h = (y[parts] - y[0])/parts;  // 										  by 'y' axis
        for (int i=1; i < parts; i++){
          x[i] = x[i-1] + w;
          y[i] = y[i-1] + h;
        }
        for (int i=0; i < parts; i++){
          result[i] = new Line(x[i],y[i], x[i+1],y[i+1]);
        }
		                            
		return result;
	}
	public Line grow(double direction, Point distance){
		return (Line) Line.rel(ending().x, ending().y, distance.x, distance.y).rotate(direction, ending());
	}
}
