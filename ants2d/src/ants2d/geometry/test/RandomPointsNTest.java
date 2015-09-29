package ants2d.geometry.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;

public class RandomPointsNTest {
	
	@Test
	public void testN(){
		Rectangle r = new Rectangle(new Point(2,2), new Point(13,14));
		int cc = 25;
		RandomPoints ps = new RandomPoints(r,cc);
		int c = 0;
		for (@SuppressWarnings("unused") Point p : ps) c++;
		assertEquals("number of cycles",cc,c);
	}

}
