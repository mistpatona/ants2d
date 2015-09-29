package ants2d.geometry.test;

import java.util.Iterator;

import ants2d.geometry.AB;
import ants2d.geometry.Offset;
import ants2d.geometry.Point;

public class RandomPointsIterator implements Iterator<Point> {
	
	private Point p0;
	private Offset d;
	
	public RandomPointsIterator(AB ab) {
		p0 = ab.getP0();
		d = ab.getP1().sub(p0);
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Point next() {
		return p0.sum(new Offset(Math.random()*d.getX(),Math.random()*d.getY()));
	}

}
