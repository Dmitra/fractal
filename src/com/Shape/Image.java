package com.Shape;

public class Image{
	public Image(){
	Shape[] s = new Shape[5];
		for(int i = 0; i < s.length-1; i++)
			s[i] = new Circle();
		s[s.length-1] = new Square();
		for(Shape shp : s)
			shp.draw();
	}
}