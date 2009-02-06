package com.Shape;
import static com.func.Puts.*;

public class Filter{
	public Shape process(Shape shp, Effect eff){
		puts("Effect "+eff.getName()+" was applyed");
		return shp;
	}
}