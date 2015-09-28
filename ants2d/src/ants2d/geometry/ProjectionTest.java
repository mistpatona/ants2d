package ants2d.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

import ants2d.map.Point;

public class ProjectionTest {
	private double eps = 1.0e-4;
	@Test
	public void testHandPointProjection(){
		LineEquation line = new LineEquation(new Point(-2,2),new Point(2,2));
		Point p = new Point(1,7);
		Point proj = line.projection(p);
		assertEquals("x=1",1,proj.getX(),eps);
		assertEquals("y=2",2,proj.getY(),eps);
		LineEquation perp = new LineEquation(p,proj);
		double cosA = line.directionVector().scalarProduct(perp.directionVector());
		assertEquals("cosA=0",0,cosA,eps);
		
	}
	@Test
	public void testAnyPointProjection(){
		Point p1 = new Point(-20,12);
		Point p2 = new Point(20,-4);
		LineEquation line = new LineEquation(p1,p2);
		Point p = new Point(1,7);
		assertNotEquals("p must not lie on p1p2 line",0,line.f(p),eps);
		Point proj = line.projection(p);
		assertEquals("proj must lie on p1p2 ",0,line.f(proj),eps);
		LineEquation perp = new LineEquation(p,proj);
		double cosA = line.directionVector().scalarProduct(perp.directionVector());
		assertEquals("cosA=0, that is A is 90",0,cosA,eps);
		
	}

}
