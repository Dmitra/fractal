package com.fractal;
import java.util.*;

public class Fractal {
	public static enum names {		//fractal types
		tick, snowflake, tree_cutout, tree_1, dragon, pyramid, branched_tree, rounded_tree;		
	}
	public static int[] iterations = new int[]{15,5,6,6,16,15,12,0};
	
	private names transformation;
	public ArrayList<Line> list;	//list of Lines forming Fractal
	public ArrayList<Line> last;	//last iteration result
	public static ArrayList<Fractal> samples = new ArrayList<Fractal>();
	final static Line line1 = Line.rel(400,750,700,0);
	final static Line line2 = Line.rel(800,1000,0,-800);
	final static Line line6 = Line.rel(1000,800, -600, 0);
	final static Line line3 = Line.rel(700,500,50,0);
	final static Line line4 = Line.rel(600,900,0,-100);
	final static Line line5 = Line.rel(700,900,0,-1);
	
	static {
	samples.add(new Fractal(line4, names.branched_tree));
	}
	
	public Fractal(Shape shape, names transformation){
		if (shape instanceof Line){
			list = new ArrayList<Line>();
			list.add((Line)shape);
			}
		else{list = shape.lines();}
		this.transformation = transformation;
		last = list;							//to continue from "0" iteration
	}
	public names transformation(){
		return transformation;
	}
	public Fractal iter(int iterations, Boolean continueIterations){
		switch(this.transformation){
		case tick: 
			break;
		case snowflake: 
			break;
		case tree_cutout:
			break;
		case branched_tree:
			for (int iter= 1; iter <=iterations; iter++){
				ArrayList<Line> result = new ArrayList<Line>();
				for (Line line:last){
	                Point vector = line.vector().multiply((0.7+0.2*Math.random()));
	                double angle = 15 + 25 * Math.random();
	                
	                result.add(line.grow(-angle, vector));
	                result.add(line.grow(angle, vector));
				}
				last = result;
				list.addAll(result);
			}
			break;
		}
		return this;
	}
}
	
