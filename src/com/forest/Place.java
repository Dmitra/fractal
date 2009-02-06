package com.forest;

import static com.func.Puts.puts;

public class Place{
	String name, relief;
	public int sides[] = {2,3,2,3,};		//array initialization
	Place(String name){
		this.name = name;
		relief = "Холмистый";
		puts("Место для посадки будет: " + name);
	}
	String getPlace(){
		return this.name;
	}
	void setRelief(String relief){
		this.relief = relief;
	}
	String getRelief(){
		return relief;
	}
	public int getPerimeter(){
		int perimeter = 0;
		for (int i = 0; i < sides.length; i++) {
			perimeter += sides[i];
		}
		return perimeter;
	}
	
}
