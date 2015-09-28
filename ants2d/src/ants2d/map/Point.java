package ants2d.map;

public class Point extends XY {

	public Point(double _x, double _y) {
		x = _x;
		y = _y;
	}
	public Point(final XY xy) {
		x = xy.getX();
		y = xy.getY();
	}
	@Override
	public Point create(double x, double y) {
		return new Point(x,y);
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
