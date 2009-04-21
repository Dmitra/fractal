package com.fractal;

public class Point {
	double x;
	double y;
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double x(){
		return x;
	}
	public double y(){
		return y;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public Point minus(Point point){
		this.x -= point.x;
		this.y -= point.y;
		return this;
	}
	public Point plus(Point point){
		this.x += point.x;
		this.y += point.y;
		return this;
	}
	public Point negative(){
		this.x = - this.x;
		this.y = - this.y;
		return this;
	}
	public Point multiply(double d) {
		this.x *= d;
		this.y *= d;
		return this;
	}
}
