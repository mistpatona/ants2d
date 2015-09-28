package ants2d.geometry;

import ants2d.map.RectShape;
import ants2d.map.Offset;
import ants2d.map.Point;
import ants2d.map.Quadrants;
import ants2d.map.XY;

public class Segment {
	
	private Point p0,p1;
	
	public Segment(Point _p0,Point _p1) {
		p0 = _p0;
		p1 = _p1;
	}
	
	public Point getP0() {
		return p0;
	}
	
	public Point getP1() {
		return p1;
	}
	
	public double length(){
		return p0.distanceTo(p1);
	}
	
	public LineEquation lineEquation() {
		return new LineEquation(getP0(),getP1());
	}
	
	public boolean intersectsSegment(Segment other){
		return lineEquation().crossesSegment(other) && other.lineEquation().crossesSegment(this);
	}
	
	public double distanceTo(Point p){

		LineEquation eq = this.lineEquation();
		Point proj = eq.projection(p);
		LineEquation perp = eq.perpendicularLine(p);
		if (perp.crossesSegment(this)) {
			return proj.distanceTo(p);
		}
		else {
			return Math.min(p.distanceTo(p0), p.distanceTo(p1));
		}
		
		
	}

}
