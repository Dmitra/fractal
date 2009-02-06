package com.Shape;
import static com.func.Puts.*;
import java.util.*;

public class Circle extends Shape implements Orbicular, Symmetric{
	private ArrayList<String> symm;
	Circle(){}
	public void draw(){
		puts("Circle is drawn");
	}
	public String roll(){
		return "Cycloid";
	}
	public int getPerimeter(){
		return 0;
	}
	public int area(){
		return 0;
	}
	public ArrayList<String> getSymmetry(){
		symm.add("axisymmetric");
		symm.add("centrosymmetrical");
		return symm;
	}
}