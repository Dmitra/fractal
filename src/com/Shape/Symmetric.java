package com.Shape;
import java.util.ArrayList;

public interface Symmetric extends ShapeForm{
	Plane PLANE = new Plane("horizontal");		//interface allows non-constant fields
												//all interface fields are static and final
	ArrayList<String> getSymmetry();
}
