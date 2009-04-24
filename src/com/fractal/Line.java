package com.fractal;
import java.util.ArrayList;

public class Line extends Set{
	private double[] coords = new double[4];	//Line has 4 coordinates - cannot be changed from outside
	public Line(double x1, double y1, double x2, double y2){	//constructor from absolute coordinates
		coords[0] = x1; coords[1]=y1; coords[2]=x2; coords[3]=y2;
	}
	public static Line rel(double x1, double y1, double relX, double relY){	//constructor from relative coordinates
		return new Line(x1, y1, x1 + relX, y1 + relY);
	}
	public Line(Point start, Point end){		//constructor from Points
		coords = new double[]{start.x,start.y,end.x,end.y};
	}
	public Line(double array[]){				//constructor from array
		coords = array;
	}
	public Point starting(){
		return new Point(coords[0],coords[1]);
	}
	public Point ending(){
		return new Point(coords[2],coords[3]);
	}
	public double[] array(){				//this is array of coordinates, required by parent Shape class
		return coords; 						//read only, have no effect on Line's coordinates
	}
	public void setArray(double[] array){	//coordinates can be accessed via this function 
		coords = array;
	}
	public double x(){
		return coords[2] - coords[0];
	}
	public double y(){
		return coords[3] - coords[1];
	}
	public double length(){
		return Math.sqrt(Math.pow(x(),2) + Math.pow(y(),2));
	}
	public Point vector(){
		return new Point(x(),y());
	}
	public ArrayList<Line> tick(Angle angle){
		ArrayList<Line> result = new ArrayList<Line>(2);
        double right_angle = new Angle(90).toRadian();
        double alpha = Math.atan(y()/x()) + right_angle;    //вычисляем угол наклона отрезка к горизонтали в радианах; 90 - угол смещения координатной сетки приложения к декартовой
        //puts("alpha in degree: "+alpha)
        double beta = angle.toRadian() + right_angle - alpha;
        //puts("beta in degree: "+beta.to_deg)
        //Angle alpha_deg = new Angle(alpha).toDegree
        double nano = 1e-10;
        double m;
        if ((alpha < nano) && (alpha > -nano)){
        	alpha = 0;   
        	m = -y();
        } else if ((alpha < Math.PI + nano) && (alpha > Math.PI -nano)){
            m = y();}
        else {m = x()/Math.sin(alpha);}
        double c = m/(2*Math.sin(alpha + beta));
        double a = Math.cos(beta) *c;
        double b = Math.sin(beta) *c;
        double x3; double y3;
        coords = array();
        x3 = a +coords[0]; y3 = -b +coords[1];
        result.add(new Line(coords[0],coords[1], x3,y3));
        result.add(new Line(x3,y3, coords[2], coords[3]));
        return result;
	}
	public ArrayList<Line> divide(int parts){
		ArrayList<Line> result = new ArrayList<Line>(parts);
		double[] x = new double[parts+1]; double[] y = new double[parts+1];
		coords = array();
        x[0] = coords[0];		//starting().x;
        y[0] = coords[1];		//starting().y;
        x[parts] = coords[2];	//ending().x;
        y[parts] = coords[3];	//ending().y;
        double w = (x[parts] - x[0])/parts;	//stretch (отрезка) length after division by 'x' axis
        double h = (y[parts] - y[0])/parts;  // 										  by 'y' axis
        for (int i=1; i < parts; i++){
          x[i] = x[i-1] + w;
          y[i] = y[i-1] + h;
        }
        for (int i=0; i < parts; i++){
          result.add(new Line(x[i],y[i], x[i+1],y[i+1]));
        }
		return result;
	}
	public Line grow(Angle direction, Point distance){
		return (Line) Line.rel(ending().x, ending().y, distance.x, distance.y).rotate(direction, ending());
	}
	public Line grow(Angle direction) {
		Point vector = vector(); 
		return (Line) Line.rel(ending().x, ending().y, vector.x, vector.y).rotate(direction, ending());
	}
}
