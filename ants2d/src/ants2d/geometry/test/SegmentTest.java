package ants2d.geometry.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ants2d.geometry.LineEquation;
import ants2d.geometry.Point;
import ants2d.geometry.Segment;


public class SegmentTest {

	private double eps = 0.0001;
	@Test
	public void testCrossing(){
		Segment s1 = new Segment(new Point(-2,-2),new Point(2,2));
		Segment s2 = new Segment(new Point(-2,2),new Point(2,-2));
		Segment s3 = new Segment(new Point(20,20),new Point(22,22));
		
		assertTrue("1 and 2 must cross",s1.intersectsSegment(s2));
		assertTrue("2 and 1 must cross",s2.intersectsSegment(s1));
		
		assertFalse("1 and 3 must not cross",s1.intersectsSegment(s3));
		assertFalse("3 and 2 must not cross",s3.intersectsSegment(s2));

	}
	
	@Test
	public void testEquation(){
		Point p1 = new Point(1,1);
		Point p2 = new Point(5,6);
		Segment s = new Segment(p1,p2);
		LineEquation l = s.lineEquation();
		assertEquals("p1 belongs to line",0,l.f(p1),eps);
		assertEquals("p2 belongs to line",0,l.f(p2),eps);
	}
}
