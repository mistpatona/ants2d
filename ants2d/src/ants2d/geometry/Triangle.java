package ants2d.geometry;

import java.util.Arrays;
import java.util.List;

public class Triangle implements Polygonic{
	private Point a,b,c;
	public Triangle(Point _a,Point _b,Point _c) {
		a=_a;
		b=_b;
		c=_c;
	}
	public double area() {
		return 0.5*Math.abs(b.sub(a).cartesianProduct(c.sub(a)));
	}
	public double traditionalArea() {
		LineEquation acline = new LineEquation(a,c);
		Point p = acline.projection(b);
		double h = b.sub(p).length();
		double ac = a.sub(c).length();
		return 0.5*h*ac;	
	}
	public List<Point> points(){
		return Arrays.asList(a,b,c);
	}

}
