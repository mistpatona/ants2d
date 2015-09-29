package ants2d.geometry;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;


public class PointTest {
	public static final double eps = 0.0001;
	@Test
	public void distanceTest() {
		Point p0 = new Point(0,0);
		Point p1 = new Point(5,12);
		double d = p1.distanceTo(p0);
		assertEquals(13.0, d, eps);
		assertEquals(13.0, p0.distanceTo(p1), eps);
	}
	
	void myAssertEquals(XY a,XY b, double e) {
		assertEquals(a.getX(),b.getX(),e);
		assertEquals(a.getY(),b.getY(),e);
	}
	
	void myAssertEquals(XY a,XY b) {
		myAssertEquals(a, b, eps);
	}
	
	@Test
	public void sumTest(){
		Offset a1 = new Offset(1,10);
		Offset a2 = new Offset(2,20);
		Offset a3 = new Offset(3,30);
		myAssertEquals(a3,a1.sum(a2));
		myAssertEquals(a3,a2.sum(a1));
	}
	
	@Test
	public void subTest(){ 
		Offset a1 = new Offset(1,10);
		Offset a2 = new Offset(2,20);
		Offset a3 = new Offset(3,30);
		myAssertEquals(a1,a3.sub(a2));
		myAssertEquals(a2,a3.sub(a1));
		XY sub32 = a3.sub(a2);
		assertTrue(sub32.isOffs());
	}
	
	@Test
	public void subPPTest(){  // abs minus abs gives offset
		Point p1 = new Point(5,5);
		Point p2 = new Point(2,2);
		XY r = p1.sub(p2);
		assertTrue(r.isOffs());
		assertFalse(r.isAbs());
	}
	@Test
	public void polyContainTest() {
		
		Rectangle r = new Rectangle(new Point(-2.0,-2.0),new Point(2.0,2.0) );
		Point p = new Point(0.0,0.0);
		assertTrue(r.contains(p));
		Point out = new Point(0.0,10.0);
		assertFalse(r.contains(out));
		List<Point> lst = r.points();
		Point out2 = Point.outsidePoint(lst);
		assertFalse(r.contains(out2));
		assertTrue((new Point(1.0,1.15)).isContainedInside(lst));
		assertTrue(p.isContainedInside(lst));
		assertFalse((new Point(3.0,-3.0)).isContainedInside(lst));
		assertFalse(out.isContainedInside(lst));
	}
}
