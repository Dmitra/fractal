package com.fractal;
import java.util.*;

public class Fractal {
	public static enum names {	//fractal types
		tick,					//the Levy dragon
		snowflake, 				//#Koch curve
		tree_cutout, tree_1,
		dragon, 				//Heighway dragon aka the Harter-Heighway dragon
		pyramid, branched_tree, rounded_tree,
		last;					//the last enum element
	}
	public static HashMap<names, Integer> siter = new HashMap<names, Integer>(names.last.ordinal());	//iterations of best view of sample fractals
	public static ArrayList<Fractal> samples = new ArrayList<Fractal>(names.last.ordinal());
	final static Line line1 = Line.rel(400,750,700,0);
	final static Triangle triangle = (Triangle) new Triangle(new Angle(60), Line.rel(250,850, 900, 0));
	final static Line line2 = Line.rel(800,1000,0,-800);
	final static Line line3 = Line.rel(1000,800, -600, 0);
	final static Line line4 = Line.rel(700,500,50,0);
	final static Line line5 = Line.rel(600,900,0,-100);
	final static Line line6 = Line.rel(700,900,0,-1);
	
	static {
		siter.put(names.tick, 15);
		siter.put(names.snowflake, 6);
		siter.put(names.tree_cutout, 6);
		siter.put(names.tree_1, 6);
		siter.put(names.dragon, 16);				//18 makes almost solid filling
		siter.put(names.branched_tree, 12);
		siter.put(names.rounded_tree, 12);
		
		samples.add(new Fractal(line1, names.tick));
		samples.add(new Fractal(triangle, names.snowflake));
		samples.add(new Fractal(line2, names.tree_cutout));
		samples.add(new Fractal(line2, names.tree_1));
		samples.add(new Fractal(line3, names.dragon));
		samples.add(new Fractal(line5, names.branched_tree));
		samples.add(new Fractal(line6, names.rounded_tree));
	}
	private names transformation;
	public ArrayList<Line> list = new ArrayList<Line>();		//list of Lines forming 'planar' Fractal
	public ArrayList<Line> last;								//last iteration result
	private ArrayList<Point> cells = new ArrayList<Point>();	//list of Points forming 'neuron' Fractal
	
	private void setFractal(names transformation){			//constructor helper			
		this.transformation = transformation;
		last = (ArrayList<Line>) list.clone();				//to continue from "0" iteration
	}
	public Fractal(Planar shape, names transformation){
		list = shape.lines();
		setFractal(transformation);
	}
	public Fractal(Line line, names transformation){
		list.add(line);
		setFractal(transformation);
	}
	public Fractal(Point neuron, names genesis){
		;
	}
	public names transformation(){
		return transformation;
	}
	public void iter(int iterations, Boolean continueIterations){
		switch(this.transformation){
		case tick:
			for (int iter= 1; iter <=iterations; iter++){
				for (Line line:last){
					list.addAll(line.tick(new Angle(45)));
					list.remove(0);
				}
				last = (ArrayList<Line>) list.clone();
			}
			break;
		case snowflake: 
			for (int iter= 1; iter <=iterations; iter++){
				for (Line line:last){
					ArrayList<Line> lines = line.divide(3);
					list.add(lines.get(0));
					list.addAll(lines.get(1).tick(new Angle(45)));
					list.add(lines.get(2));
					list.remove(0);
				}
				last = (ArrayList<Line>) list.clone();
			}
			break;
		case tree_cutout:
		    list.add(list.get(0));
		    for (int iter= 1; iter <=iterations; iter++){
				int length = list.size();
		    	for (int i= 0; i < length; i++){
		    		ArrayList<Line> lines = list.remove(0).divide(2);
		    		if (i < length/2){	list.add(lines.get(0));	list.addAll(lines.get(1).tick(new Angle(45)));}
		    		else 			 {	list.add(lines.get(0));	list.addAll(lines.get(1).tick(new Angle(-45)));}
				}
		    }
			break;
		case tree_1:
		    for (int iter= 1; iter <=iterations; iter++){
				int length = list.size();
		    	for (int i= 0; i < length; i++){
		    		ArrayList<Line> lines = list.remove(0).divide(2);
		    		list.add(lines.get(0));
		    		list.addAll(lines.get(1).tick(new Angle(45)));
		    		list.addAll(lines.get(1).tick(new Angle(-45)));
				}
		    }
			break;
		case dragon:
		    for (int iter= 1; iter <=iterations; iter++){
		    	int length = list.size();
		    	for (int i= 0; i < length; i++){
		    		if (i%2 == 0){list.addAll(list.remove(0).tick(new Angle(-45)));}
		    		else 		 {list.addAll(list.remove(0).tick(new Angle(45)));}
		    	}
		    }
			break;
		case branched_tree:
			for (int iter= 1; iter <=iterations; iter++){
				ArrayList<Line> result = new ArrayList<Line>();
				for (Line line:last){
	                Point vector = line.vector().multiply((0.7+0.2*Math.random()));
	                Angle angle = new Angle(15 + 25 * Math.random());
	                Angle negative_angle = new Angle(-15 + -25 * Math.random());
	                
	                result.add(line.grow(negative_angle, vector));
	                result.add(line.grow(angle, vector));
				}
				last = result;
				list.addAll(result);
			}
			break;
		}
	}
}