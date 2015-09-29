package ants2d.geometry.test;

import ants2d.geometry.AB;
import ants2d.geometry.Point;

public class RandomPointsNIterator extends RandomPointsIterator {
	private int c;
	
	public RandomPointsNIterator(AB ab,int count) {
		super(ab);
		c = count;
	}
	
	@Override
	public boolean hasNext() {
		return c>0;
	}

	@Override
	public Point next() {
		c--;
		return super.next();
	}

}
