package ants2d.geometry;

import ants2d.map.Point;

public class LineEquation {
	private double a,b,c;
	
	public double f(Point p) {
		return getA()*p.getX() + getB()*p.getY() +c ;
	}
	
	public LineEquation(Point p0, Point p1) {
		
/*		a = p1.getY() - p0.getY();
		b = -(p1.getX() - p0.getX());
		c = -(p0.getX()*p1.getY() - p1.getX()*p0.getY());*/
		
		this (	 p1.getY() - p0.getY(),
		       p0.getX() - p1.getX(),
		       p1.getX()*p0.getY()-p0.getX()*p1.getY() );
		
		if (p0 == p1) throw new Error("cannot construct line by equal points");
	}
	
	public LineEquation(Double _a,Double _b,Double _c) {
		a = _a;
		b = _b;
		c = _c;
		if (Math.abs(a)+Math.abs(b) < Math.abs(c) * 1000) { // (c!=0) for floating point
			a = a/c;
			b = b/c;
			c = 1;
		}
	}
	
	public LineEquation perpendicularLine(Point p) {
		double d = getA()*p.getY()-getB()*p.getX();
		return new LineEquation(b,-a,d);
	}
	
	public boolean isParallelTo(LineEquation other, double eps) {
		return Math.abs(this.getA()*other.getB() - this.getB()*other.getA()) < eps;
	}

	
	protected double getA() { return a;}
	protected double getB() { return b;}
	protected double getC() { return c;}
}
