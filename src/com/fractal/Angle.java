package com.fractal;

public class Angle {
	double alpha;
	public Angle(double alpha){
		this.alpha = alpha;
	}
	public double toRadian(){
		return alpha/180 *(Math.PI);
	}
	public double toDegree(){
		return alpha*180/(Math.PI);
	}
	public Angle minus(int i) {
		return new Angle(alpha - i);
	}
}
