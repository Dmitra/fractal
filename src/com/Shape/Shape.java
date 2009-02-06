package com.Shape;
import static com.func.Puts.*;

import java.util.EnumMap;

abstract class Shape{
	public enum Properties {			//Inner class 'enumerator' of type Properties
		  A, B, INCOMPLETE;		
	};
	private static EnumMap<Properties, String> shapeMessages = new EnumMap<Properties, String>(Properties.class);
	public Shape(){shapeMessages.put(Properties.A, "Shape property A");}
	public String getProperty(){return shapeMessages.get(Properties.A);};
	
		
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	
	public String toString(){return "Shape "+id;}
	
	public void addRef(){refcount++;}
	public abstract void draw();
	public void erase(){if(--refcount == 0)
		puts("Dispose "+ this);
	}
	public int area(){
		return 10;			//—читать площадь
	}
	
}