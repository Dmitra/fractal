package com.Shape;
import static com.func.Puts.*;

public class Star{
	private static int counter = 0;
	private final long id = counter++;
	private Shape s1;
	private Shape s2;
	public String toString(){return "Star " +id;}
	public void draw(Shape t){			//Polymorphic function - can draw Star from any 2 Shapes
		s1 = t; s2=t;
		s1.addRef();
		s1.draw();
		s2.draw();
		puts("Drawn "+ this);
	}
	public void erase(){
		puts("Erased "+this);
		s2.erase();
		s1.erase();
	}
}