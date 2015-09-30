package ants2d.geometry;

import java.util.Arrays;
import java.util.List;

public class Triangle implements Polygonic,ConvexShape{
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
/*	public Polygon asPolygon() {
		return new Polygon(points());
	}*/
	@Override
	public boolean contains(XY point) {
		Point x = new Point(point);
		return onSameSide(a,b,c,x) && onSameSide(b,c,a,x) && onSameSide(c,a,b,x) ;
	}
	private boolean onSameSide(Point ref1,Point ref2,Point x,Point y) {
		LineEquation l = new LineEquation(ref1,ref2);
		return l.f(x) * l.f(y) > 0;
	}
	/*@Override
	public Rectangle containingRectangle() {
		return this.asPolygon().containingRectangle();
	}*/
/*	@Override
	public Circle containingCircle() { 
		return this.asPolygon().containingCircle(); //sometimes Circumcircle is better
	}*/

}
