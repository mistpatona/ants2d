package ants2d.geometry.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ants2d.geometry.Point;
import ants2d.geometry.Polygon;
import ants2d.geometry.Rectangle;
import ants2d.geometry.Segment;
import ants2d.geometry.Triangle;


public class PolygonTest {
	private double eps = 1.0e-4;

	@Test
	public void testRectanglePolyArea(){
		Point p0 = new Point(1,22);
		Point p1 = new Point(17,7);
		Rectangle r = Rectangle.enclosing(Arrays.asList(p0,p1));//new Rectangle(p0,p1);
		List<Point> list = r.points();
		assertEquals("must be 4 points",4,list.size());
		Polygon p = new Polygon(list);
		assertEquals("areas must be equal",r.area(),p.area(),eps);
	}
	
	@Test
	public void testQuadranglePolyArea(){
		Point p0 = new Point(1,22);
		Point p1 = new Point(17,27);
		Point p2 = new Point(17,3);
		Point p3 = new Point(2,2);
		Point p = new Point(10,10); // central
		List<Point> l = Arrays.asList(p0,p1,p2,p3);
		Polygon pol = new Polygon(l);
		
		double ar=0;
		for(Segment s : pol.segments())
			ar += (new Triangle(p,s.getP0(),s.getP1())).area();
		assertEquals("areas must be equal",pol.area(),ar,eps);
	}	
	@Test
	public void testRectangleIntersections(){
		Point p0 = new Point(0,0);
		Point p1 = new Point(10,10);
		Rectangle r = Rectangle.enclosing(Arrays.asList(p0,p1));
		Polygon p = new Polygon(r.points());
		Point pin = new Point(5,5);
		assertTrue("pin inside",r.contains(pin));
		
		Point pout = new Point(25,25); // line passes through the corner, special issue
		assertFalse("pout outside",r.contains(pout));
		Segment seg  = new Segment(pin,pout);
		assertEquals("one intersection",1,p.intersectionsWith(seg));
		Point poutantipode = seg.parametrized(-10.0);  // out of rectangle but on the other side
		assertFalse("poutantipode outside",r.contains(poutantipode));
		Segment seg2  = new Segment(poutantipode,pout);
		assertEquals("two intersections",2,p.intersectionsWith(seg2));
	}
	@Test
	public void testQuadrangleIntersections(){
		Point p0 = new Point(1,22);
		Point p1 = new Point(17,27);
		Point p2 = new Point(17,3);
		Point p3 = new Point(2,2);
		Point p = new Point(10,10); // central
		Point pz = new Point(0,0);
		Point pa = (new Segment(pz,p)).parametrized(4);//on the NE side
		List<Point> l = Arrays.asList(p0,p1,p2,p3);
		Polygon pol = new Polygon(l);
		Segment seg = new Segment(pz,pa);
		assertEquals("two intersections",2,pol.intersectionsWith(seg));
		assertTrue("p is inside",pol.containsPoint(p));
		assertFalse("pz is outside",pol.containsPoint(pz));
		assertFalse("pa is outside",pol.containsPoint(pa));
		
	}
}
