package ants2d.geometry;

public class Segment extends AB {

	public Segment(Point _p0, Point _p1) {
		super(_p0, _p1);
	}
	
	public Segment(AB ab) {
		super(ab.getP0(),ab.getP1());
	}

	public double distanceTo(Point p) {
	
		LineEquation eq = this.lineEquation();
		Point proj = eq.projection(p);
		LineEquation perp = eq.perpendicularLine(p);
		if (perp.crossesSegment(this)) {
			return proj.distanceTo(p);
		}
		else {
			return Math.min(p.distanceTo(this.getP0()), p.distanceTo(this.getP1()));
		}
		
		
	}

	public double length() {
		return getP0().distanceTo(getP1());
	}

	public LineEquation lineEquation() {
		return new LineEquation(getP0(),getP1());
	}

	public boolean intersectsSegment(Segment other) {
		return lineEquation().crossesSegment(other) && other.lineEquation().crossesSegment(this);
	}
	
	public boolean intersectsSegmentOrP0(Segment other) {
		return lineEquation().crossesSegmentOrP0(other) && other.lineEquation().crossesSegmentOrP0(this);
	}
	
	
	
	public Point parametrized(double t) {
		return this.getP0().sum( this.getP1().sub(this.getP0()).scaleBy(t) );
		
	}

}
