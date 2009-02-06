package com.Shape;

import static com.func.Puts.*;
public class Compose{
	private Shared shape;
	private static long counter = 0;
	private final long id = counter++;
	public Compose(Shared shared){
		shape = shared;
		shape.addRef();
	}
	public String toString(){return "Composed shape " +id;}
	public void draw(){
		shape.draw();
		puts("Draw " +this);
	}
	public void erase(){
		puts("Erasing "+this);
		shape.erase();
	}
}