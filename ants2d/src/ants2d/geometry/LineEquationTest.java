package ants2d.geometry;
import org.junit.Test;

import ants2d.map.Point;

import static org.junit.Assert.*;

public class LineEquationTest {
	
	@Test
	public void checkCreation() {
		LineEquation line = new LineEquation(-1.0,-1.0,2.0);
		Point p0 = new Point(0,2);
		Point p1 = new Point(2,0);
		Double eps = 0.001;
		assertEquals("p0 belongs to line",0,line.f(p0),eps);
		assertEquals("p1 belongs to line",0,line.f(p1),eps);
		Point w1 = new Point(5,5);
		assertNotEquals("w1 NOT belongs to line",0,line.f(w1),eps);
		
		LineEquation lineP = new LineEquation(p0,p1);
		checkLinesKoefEquality(line,lineP,eps);
	}
	@Test
	public void checkAlignement() {
		Point p0 = new Point(1,1);
		Point p1 = new Point(2,7);
		Point d = new Point(p1.sub(p0));
		Point mid = new Point(p0.sum(d.scaleBy(0.5)));
		Point _p0 = new Point(p0.sub(d));
		Point _p1 = new Point(p1.sum(d));
		
		Double eps = 0.001;
		
		LineEquation line = new LineEquation(p0,p1);
		assertEquals(0,line.f(p0),eps);
		assertEquals(line.f(p1),0,eps);
		assertEquals(line.f(mid),0,eps);
		assertEquals(line.f(_p0),0,eps);
		assertEquals(line.f(_p1),0,eps);
	}
	
	@Test
	public void checkPerpendicular() {
		Point p0 = new Point(0,1);
		Point p1 = new Point(1,0);
		LineEquation line = new LineEquation(p0,p1);
		Point p = new Point(1,2);
		Double eps = 0.001;
		LineEquation perp = line.perpendicularLine(p);
		LineEquation manPerp = new LineEquation(1.0,-1.0,1.0);
		checkLinesKoefEquality(manPerp,perp,eps);
		assertEquals("perp passes p",0,perp.f(p),eps);
		assertEquals("perp passes p0",0,perp.f(p0),eps);
		assertEquals("perp passes (-1,0)",perp.f(new Point(-1,0)),0,eps);
	}
	
	public void checkLinesKoefEquality(LineEquation line, LineEquation other,Double eps) {
		assertEquals("koef A",line.getA(),other.getA(),eps);
		assertEquals("koef B",line.getB(),other.getB(),eps);
		assertEquals("koef C",line.getC(),other.getC(),eps);
	}
}
