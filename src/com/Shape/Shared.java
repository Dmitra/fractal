package com.Shape;

import static com.func.Puts.puts;

public class Shared extends Shape{
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	public String toString(){return "Shared "+id;}
	
	public void addRef(){refcount++;}
	public void draw(){}
	public void erase(){if(--refcount == 0)
		puts("Dispose "+ this);
	}
	public int area(){
		return 0;
	}
	public int[] coords(){
		return new int[]{0,0};
	}
}