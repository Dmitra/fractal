package com.Shape;
import static com.func.Puts.*;

import java.util.ArrayList;

public class Square extends Shape{
	private ArrayList<String> symm;
	
	public void draw(){
		puts("Square is drawn");
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