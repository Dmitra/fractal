package com.Shape;
import static com.func.Puts.*;

public class Mirror implements Processor{
	public Shape process(Shape shp){
		puts(shp+" was mirrored");
		return shp;
	}

	public String name() {
		return "Mirror";
	}
}