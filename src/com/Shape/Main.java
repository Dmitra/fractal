package com.Shape;

import static com.func.Puts.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Shared s = new Shared();
		Compose c = new Compose(s);
		Compose c1 = new Compose(s);
		puts("Orbicular shapes have "+Orbicular.VERTEX+" vertexes");
		c.draw();
		c1.draw();
		c1.erase();
		c.erase();
		Triangle t1 = new Triangle();
		puts("Call parent method "+t1.area());
		Circle ci1 = new Circle();
		Ellipse ei1 = new Ellipse();
		Mirror m1 = new Mirror();
		Filter f1 = new Filter();
		Effect e1 = new Effect("Sepia");
		FilterSepiaAdaptor f2 = new FilterSepiaAdaptor(f1);
		m1.process(t1);
		m1.process(ci1);
		f1.process(t1, e1);
		Apply.process(m1, t1);
		Apply.process(f2, ci1);
		Apply.drawTrace(ci1);
		for (Shape.Properties g : Shape.Properties.values()) {   //Shape.Properties - values of inner class
																 //usage of enhanced 'for' cycle
		    puts("Properties of Shape: '" + g + "'");
		    switch (g){											 //usage of 'switch' case
		    case A: puts(g+" is the first property");
		    break;												 //break is required for not to pass to second case
		    case INCOMPLETE: puts("Do not use "+g+" value");
		    break;
		    default: puts("Using property"+g);					 //for all cases if next 'break' is not set
		    break;}												 //only for not mentioned cases if break is set
		}
		puts(s.getProperty());
		ArrayList<Orbicular> shapes = new ArrayList();
		shapes.add(ci1);
		shapes.add(ei1);
		Collection<Integer> a = new ArrayList<Integer>(Arrays.asList(0,1));
		a.addAll(Arrays.asList(2, 3));
		}
	}

