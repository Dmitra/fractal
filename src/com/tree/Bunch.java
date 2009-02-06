package com.tree;
import com.material.Wood;
import com.tree.bush.Brunch;
import static com.func.Puts.*;

public abstract class Bunch extends Wood{
	protected Bunch(){}
	public String getType(){
		return "Bunch";
	}
//	public static Bunch plant(){
//		return new Bunch();}
//	
	public void raise(Brunch brunch){
		puts("Brunch raised");
	}
}