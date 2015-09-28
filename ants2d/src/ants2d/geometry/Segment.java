package ants2d.geometry;

import ants2d.map.AB;
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

}
