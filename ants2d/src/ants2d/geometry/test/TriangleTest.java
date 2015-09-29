package ants2d.geometry.test;

import org.junit.Test;

import ants2d.geometry.Approximately;
import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;
import ants2d.geometry.Segment;
import ants2d.geometry.Triangle;

import static org.junit.Assert.*;

public class TriangleTest {
	public static final double eps = Approximately.epsilon;
	@Test
	public void s0() {
		Triangle t0 = new Triangle (new Point(0,0),new Point(10,0),new Point(0,10));
		assertEquals("area of half-square triangle 10x10",10*10/2,t0.area(),eps);
		assertEquals("traditional area of half-square triangle 10x10",10*10/2,t0.traditionalArea(),eps);
	}
	@Test
	public void se() {
		Triangle t0 = new Triangle (new Point(10,-4),new Point(17,7),new Point(-8,-9));
		// TODO: choose random points
		assertEquals("area by both methods",t0.traditionalArea(),t0.area(),eps);
	}
	@Test
	public void ssum(){
		// TODO: choose random points and run test multiple times
		Point a = new Point(10,-14);
		Point b = new Point(-17,7);
		Point c = new Point(-8,-19);
		//Point k = new Point(-1,800);
		//LineEquation abline = new LineEquation(a,b);
		//Point abp = abline.projection(k); // abp point must be on "ab" line
		Point abm = new Segment(a,b).parametrized(0.45); // abm point must be on "ab" line between a and b
		Triangle ta = new Triangle(a,abm,c);
		Triangle tb = new Triangle(b,c,abm);
		Triangle t = new Triangle(a,b,c);
		assertEquals("sum of areas",t.area(),ta.area()+tb.area(),eps);
	}
	@Test
	public void nrsum(){
		RandomPointsIterator rs = 
				new RandomPointsIterator(new Rectangle(new Point(0,0),new Point(10,10)));
		for(int i=0;i<100;i++){
			Point a = rs.next();
			Point b = rs.next();
			Point c = rs.next();
			Point m = new Segment(a,b).parametrized(0.45);
			Triangle ta = new Triangle(a,m,c);
			Triangle tb = new Triangle(b,c,m);
			Triangle t = new Triangle(a,b,c);
			assertEquals("sum of areas",t.area(),ta.area()+tb.area(),eps);
		}
	}

}
