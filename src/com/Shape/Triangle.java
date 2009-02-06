package com.Shape;
import static com.func.Puts.*;

import java.util.ArrayList;

public class Triangle extends Shape implements Angular{
	private ArrayList<String> symm;
	public void draw(){
		puts("Drawing Triangle");
	}
	public void erase(){
		puts("Erase Triangle");
	}
	public int getNumberOfVertexes(){
		return 3;
	}
	public int getPerimeter(){
		return 10;					//Calculate perimeter
	}
	public ArrayList<String> getSymmetry(){
		symm.add("axisymmetric");
		symm.add("centrosymmetrical");
		return symm;
	}
}
