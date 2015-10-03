package ants2d.geometry;

import java.util.List;

public class Point extends XY implements ConvexShape  {

	public Point(double x, double y) {
		super(x,y);
	}
	public Point(final XY xy) {
		super(xy);
	}
	@Override
	public Point create(double x, double y) {//of no much use because of erasure (?)
		return new Point(x,y);
	}
	
	/*
	 * @deprecated use Polygon.outsidePoint() instead  {@link #new()} 
	 * */
	@Deprecated
	protected static Point outsidePoint(List<Point> ps) {
		Rectangle encl = Rectangle.enclosing(ps);
		Double margin = encl.dimentions().length() /10.0;
		return Rectangle.enclosing(encl, margin).getP0();
	}
	/*
	 * @deprecated use Polygon.containsPoint(p) instead
	 * */
	@Deprecated
	public boolean isContainedInside(List<Point> ps) {
		Point out = outsidePoint(ps); 
		// calculate point that is safely out of our polygon
		Segment s = new Segment(this,out);
		// count times that our segment intersects with ribs of a poly
		int count = 0;
		Point pold=ps.get(ps.size()-1);//last element
		for (Point p : ps){ 
			if ((new Segment(p,pold)).intersectsSegmentOrP0(s)) count++;
			pold = p;
		}
		return ( (count & 1) == 1 ); // odd count means point is inside
	}
	
	public Offset sub(Point other) {
		return new Offset(super.sub(other));
	}
	public Point sum(Offset other) {
		return new Point(super.sum(other));
	}
	public Point sub(Offset other) {
		return new Point(super.sub(other));
	}
	
	@Override
	public double area() {
		return 0;
	}
	@Override
	public boolean contains(XY point) {
		return false;
	}
	@Override
	public Rectangle containingRectangle() {
		return new Rectangle(this, new Offset(0,0) );
	}
	
	@Override
	public Point center() {
		return this;
	}
	@Override
	public Circle containingCircle(){
		return new Circle(this,0);
	}
	
}