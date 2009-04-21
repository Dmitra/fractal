package com.fractal;

public class Angle {
	double alpha;
	public Angle(double alpha){
		this.alpha = alpha;
	}
	public double toRadian(){
		return alpha = alpha/180d *(Math.PI);
	}
	public double toDegree(){
		return alpha = alpha*180d/(Math.PI);
	}
}
