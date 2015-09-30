package ants2d.geometry;

public class Circle implements ConvexShape{
	private Point center;
	private double radius;
	public Circle (Point p, double r) {
		center = p;
		radius = r;
	}
	public Point centrum() {
		return center;
	}
	public double getRadius(){
		return radius;
	}
	@Override
	public double area() {
		return Math.PI*radius*radius;
	}
	@Override
	public boolean contains(XY point) {
		return radius>=center.distanceTo(point);
	}
	@Override
	public Rectangle containingRectangle() {
		Offset rr = new Offset(radius,radius);
		return new Rectangle(center.sub(rr),center.sum(rr));
	}
	public Circle containingCircle() {
		return new Circle(center,radius); // self copy
	}
	
	
	
}
