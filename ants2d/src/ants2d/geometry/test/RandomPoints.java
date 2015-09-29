package ants2d.geometry.test;

import java.util.Iterator;

import ants2d.geometry.AB;
import ants2d.geometry.Point;

public class RandomPoints implements Iterable<Point> {

	private AB ab;
	private int count = -1;
	
	public RandomPoints(AB _ab){
		ab = _ab;
	}
	public RandomPoints(AB _ab,int c){
		ab = _ab;
		count = c;
	}
	
	public void setCount(int c) {
		count = c;
	}
	
	@Override
	public Iterator<Point> iterator() {
		if (count>=0)
		   return new RandomPointsNIterator(ab,count);
		else
		   return new RandomPointsIterator(ab);
	}

}
