//package com.forest;
//
//import java.util.Arrays;
//import com.tree.*;
//import com.tree.bush.Fascicle;
//
//import static com.func.Puts.*;
//
//public class Main_forest {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		//puts ("Событие в жизни дерева" + t1.getName()+ "не может произойти до его посадки");
//		Forest f1 = new Forest();
//		puts("The trees are of "+ f1.trees[0].getMaterial());					//call of 'Wood' base class method 
//		puts("Planting Forest in "+ Forest.place1.getPlace()+ "; relief "+ Forest.place1.relief);
//		puts("Sides of parcel: " + Arrays.toString(Forest.place1.sides));
//		puts("Perimeter of parcel: " + Forest.place1.getPerimeter());
//		puts("Theese are two different maples: " + (f1.trees[1] != f1.trees[2])); 		//this results in false as t1 and t2 are different links to equal objects
//		puts(f1.trees[1].equals(f1.trees[2])); 											// this results in false, because by default method equals compares link to the objects
//		puts ("The name of the first tree: f1.trees[0].getName = " + f1.trees[0]);		//t1 concatenation with String will call t1.toString function 
//		puts ("The tree will grow soon, but now: " + (f1.trees[0].height++)); 	// using t1.height++ will not take effect on this result 
//		puts ("The tree has grown up to " + f1.trees[0].height);
//		puts ("After two year the tree will have circles: " + f1.trees[0].increment().increment().countCircles());
//		puts ("All trees in our forest where planted in "+ Tree.YEAR);   // this is how we get static field of class
//		puts("In spring trees are "+f1.trees[0].blossom());
//		for (int i=0; i < f1.bunches.length; i++)
//			f1.bunches[i] = f1.next();									//Planting Forest randomly with bunches
//																		//how to do multiple functions in one cycle
//		f1.bunches[0].raise(new Fascicle()); 							//Восходящее преобразование Upcasting: when we feed method with derivative object to the parameter should be
//		
//		int f[] = new int[3];
//		for (int i = 0; i<3; i++)  f[i] = i; 							// semicolon symbol closes 'for' cycle
//		for (int x : f) //puts ("Год жизни дерева: " + x) 				//special syntax foreach - works only for object, here it is 'f', supporting interface 'Iterable'
//			switch(x){
//				default: puts("the tree is growing");
//				case 0: puts(0); 
//				case 1: puts("first or second");  		//break - if this break is not put next case will be executed
//				case 2: puts("third");
//						break;
//			}
//		;											 //end of the cycle for
//	}
//
//}
