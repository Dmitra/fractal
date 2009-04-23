package com.fractal;

abstract class Set {
	public abstract double[] array();		//this is array of coordinates	
	public abstract void setArray(double[] array);
	
	Set absolute(){
		return this;
	}
	Set relative(){
		return this;
	}
	public Point midst(){			//Shape's geometric center
		double[] array = this.array();
		double maxX = array[0]; double maxY = array[1];
		double minX = array[0]; double minY = array[1];
		for (int i= 0; i < array.length; i++){
	        if (i%2 == 0)	{if (maxX < array[i]){maxX = array[i];} if (minX > array[i]){minX = array[i];};}
	        else 			{if (maxY < array[i]){maxY = array[i];} if (minY > array[i]){minY = array[i];};}
		}
		return new Point((maxX-minX)/2+minX,(maxY-minY)/2+minY);
	}
	public Set zoom(float times, Point center){
		double x = center.x; double y = center.y; double[] array = this.array();
		for (int i= 0; i< array.length; i++){
	        if (i%2 == 0)	{array[i] = (array[i]-x) * times + x;}
	        else 			{array[i] = (array[i]-y) * times + y;}
		}
		this.setArray(array);
		return this;
	}
	public Set move(Point point){
		double x= point.x; double y= point.y; double[] array = this.array();
		for (int i= 0; i< array.length; i++){
	        if (i%2 == 0)	{array[i] +=x;}
	        else 			{array[i] +=y;}
		}
		this.setArray(array);
		return this;
	}
	public Set rotate(Angle fi_deg, Point center){
		double fi = -fi_deg.toRadian(); double x = center.x; double y = center.y;
		double[] array = this.array();
	    for (int i= 0; i < this.array().length/2; i++){
	    	double x1= (array[i*2]-x) * Math.cos(fi) + (array[i*2+1]-y) * Math.sin(fi) + x;
	  	    double y1=-(array[i*2]-x) * Math.sin(fi) + (array[i*2+1]-y) * Math.cos(fi) + y;
	  	    array[i*2] = x1; array[i*2+1] = y1;
	    }
		this.setArray(array);
		return this;
	}
	public Set mirror(Point center){
		double x = center.x; double y = center.y;
		double[] array = this.array();
	    for (int i= 0; i < array.length; i++){
	    	if (i%2 == 0)	{array[i] = 2*x - array[i];}
	        else 			{array[i] = 2*y - array[i];}
	    }
		this.setArray(array);
		return this;
	}
	public Set mirror(Line line){
		return this;
	}
}