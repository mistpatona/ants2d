package ants2d.geometry;
/* could also be named "Vector in mathematical sense" */
public class Offset extends XY {

	public Offset(double x, double y) {
		super(x,y);
	}

	public Offset(final XY xy) {
		super(xy);
	}

	@Override
	public Offset create(double x, double y) {
		return new Offset(x, y);
	}
	/*
	@Override
	public Offset create(final XY that) {
		return new Offset(that);
	}*/

/*	public boolean isAbs() {
		return false;
	}

	public boolean isOffs() {
		return true;
	}*/

	public Offset sum(Offset other) {
		return new Offset(super.sum(other));
	}

	public Offset scaleBy(double k) {
		return new Offset(getX()*k,getY()*k);//create(super.scaleBy(k));
	}
	
	public double cartesianProduct(Offset other) {
		return this.getX()*other.getY() - this.getY()*other.getX();
	}
	
	public Offset rotateBy(double alpha) {
		double angle = this.polarAngle() + alpha;
		double l = this.length();
		return this.create(l*Math.cos(angle),l*Math.sin(angle));
	}
}
