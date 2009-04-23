package com.fractal;
import java.util.ArrayList;

interface Planar extends Shape{
	public ArrayList<Line> lines();		//This declares that every Planar Shape consists of Lines
}
