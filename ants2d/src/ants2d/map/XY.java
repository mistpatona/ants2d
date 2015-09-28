package ants2d.map;

public abstract class XY {
	protected double x, y;

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

	public abstract XY create(final XY that);

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
		//return Math.sqrt(delta.sumSqr());
		//return Math.hypot(delta.getX(), delta.getY());
		return delta.length();
	}
	public double length(){
		return Math.hypot(getX(), getY());
	}

	public abstract boolean isAbs();

	public abstract boolean isOffs();
	
	public XY scaleBy(double k) {
		return create(getX()*k,getY()*k);
	}
}
