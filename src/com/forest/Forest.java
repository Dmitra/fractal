package com.forest;

import java.util.*;
import com.tree.*;
import com.tree.bush.*;

class Forest{
	public static Place place1;
	public static Place place2;
	public Bunch[] bunches = new Bunch[5];
	public Tree[] trees = new Tree[3];
	private Random rand = new Random(47);
		
	static { 								//this section of initializing of instance is executed before any constructors
		place1 = new Place("Dale"); 		//dale - участок земли, поле (в горной долине)
		place2 = new Place("Лощина");
	}
 {											//Block of initialization: is executed with guarantee
	 place1.getRelief();					
	 place1.setRelief("Равнинный");
 }
 	Forest(){
 		for (int i=0; i<2; i++){
			trees[i] = new Tree("birch");	//'trees[i]' of class 'Tree' will be assigned to value: constructor 'new', will create object 'Tree' with initializing parameter "name of the tree"
 		}
		Tree t3 = new Tree(2, "oak");									//using overloaded construct
 	}
 	public Bunch next(){
 		switch(rand.nextInt(3)){
	 		default:
	 		case 0: return Gooseberry.plant();	
	 		case 1: return Gooseberry.plant();	//how to make one return in several cases?
	 		case 2: return Currant.plant();
	}
}
}