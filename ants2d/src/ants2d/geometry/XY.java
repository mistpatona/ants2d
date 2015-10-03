package ants2d.geometry;

public abstract class XY {
	protected double x, y;

	protected XY(double _x, double _y) {
		x = _x;
		y = _y;
	}
	protected XY(XY xy) {
	this(xy.getX(),xy.getY());
	}
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public String toString() {
		return "@" + x + ":" + y;
	}
	
    public abstract XY create(final double x, final double y);

	/* public abstract XY create(final XY that);*/

	public XY sum(XY b) {
		return create(getX() + b.getX(), getY() + b.getY());
	}

	public XY sub(XY b) {
		return create(getX() - b.getX(), getY() - b.getY());
	}

	public double sumSqr() {
		return getX() * getX() + getY() * getY();
	}
	
	public double distanceTo(XY other) {
		XY delta = sub(other);
		return delta.length();
	}
	public double length(){
		return Math.hypot(getX(), getY());
	}

/*	public abstract boolean isAbs();

	public abstract boolean isOffs();
	
	public XY scaleBy(double k) {
		return create(getX()*k,getY()*k);
	}*/
	
	public double scalarProduct(XY other) {
		return this.getX()*other.getX() + this.getY()*other.getY(); 
	}
	
	public double polarAngle() {
		return Math.atan2(getY(),getX());
	}
}