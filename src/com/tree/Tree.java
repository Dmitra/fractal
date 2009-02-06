package com.tree;
import com.material.Wood;
import static com.func.Puts.*;		//this imports only static methods and fields

//Переменные инициализируются перед вызовом любого метода, где бы они не были объявлены

class Seed {
	int number;								//quantity of seeds planted
	Seed(final int marker){					//final parameter cannot be changed
		puts("Засеваем семечек:("+marker+")");
		number = marker;
	}
	int getNumber(){
		return number;
	}
}
final class Flower{							//this class cannot be extended
	Flower(){}
	public String blossom(){
		return "in blossom";
	}
}

public class Tree extends Wood{ 			//only one class can be public as an interface for module functionality
	 private final String name;				//define instance variable
	 										//once being assigned in constructor this variable cannot be changed
	 private Flower flower = new Flower();	//flower is a part of a tree; include functions to delegate to this Tree
	 public int height; 					//every field, which is accessible from outside class and package should be 'public'
	 public static final int YEAR = 2000; 	//class field - one for all instances,
	 										//primitive - is accessible without get/set functions
	 										//constant YEAR is one and unchangeable  
	 private int circle = 0; 				//private is accessible only within this class 
	 float f4 = 1e-43f;  					// the last symbol 'f' show compiler to interpret number as float
	 	
	 public Tree(String name){				//constructor of the class 'Tree'
		 this.name = name;
		 this.height = initialHeight();
		 final Seed s1 = new Seed(3);		//s1 - is unchangeable LINK to the object Seed(3)
		 									//s1 cannot be assigned to another object
		 puts("Проростает росток: "+name);
		 }
	 public	Tree(int height, String name){  //overloaded constructor of the class 'Tree'
			 this(name);					//call of another constructor 
			 this.height = height;			//writing parameter height to the class property height
			 puts("Сажаем "+name+ " высотой " + height);
		 }
	 public String blossom(){				//delegated method of 'Flower' class 
		 return flower.blossom();
	 }
	 public	 Tree increment(){ 				//This function is specified as one which returns 'Tree' object
			 circle++;
			 return this; 					//returns object 'self' Повзрослевшее дерево
		 }
		int initialHeight(){
			return 0;
		}
	 public String toString(){ //override of default toString function 
			return name;
		}
	 public void crop(){
			puts("The tree was cropped!");
			//how to delete object?
		}
	 public int countCircles(){ //we can count circles of the tree only by cropping tree 
			this.crop();
			return circle;
		}
	
}