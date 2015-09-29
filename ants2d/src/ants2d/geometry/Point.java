package ants2d.geometry;

import java.util.List;

public class Point extends XY {

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
	
	@Override
	public Point create(final XY that){
		return new Point(that);
	}
	
	public boolean isAbs() { return true; }
	public boolean isOffs() { return false; }
	
	public Offset sub(Point other) {
		return new Offset(super.sub(other));
	}
	public Point sum(Offset other) {
		return new Point(super.sum(other));
	}
	public Point sub(Offset other) {
		return new Point(super.sub(other));
	}
	public Point scaleBy(double k) {
		return create(super.scaleBy(k));
	}
	
}
