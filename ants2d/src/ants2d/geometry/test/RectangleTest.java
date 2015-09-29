package ants2d.geometry.test;

import org.junit.Test;

import ants2d.geometry.Point;
import ants2d.geometry.Rectangle;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RectangleTest {
	@Test
	public void insideTest() {
		Point p0 = new Point(5,15);
		Point p1 = new Point(10,20);
		Rectangle r = new Rectangle(p0,p1);
		Point p_in  = new Point(7,17);
		Point p_out_1 = new Point(4,16);
		Point p_out_2 = new Point(14,16);
		Point p_out_3 = new Point(6,13);
		Point p_out_4 = new Point(6,23);
		
		
		assertTrue(r.contains(p_in));
		assertFalse(r.contains(p_out_1));
		assertFalse(r.contains(p_out_2));
		assertFalse(r.contains(p_out_3));
		assertFalse(r.contains(p_out_4));
		
	}
	@Test
	public void split4CountTest() {
		Point p0 = new Point(0,0);
		Point p1 = new Point(8,8);
		Rectangle r = new Rectangle(p0,p1);
		List<Rectangle> s = r.split4();
		assertEquals("split into 4 parts",4,s.size());	
	}
	@Test
	public void split4TestFirsts() {
		Point p0 = new Point(0,0);
		Point p1 = new Point(8,8);
		Rectangle r = new Rectangle(p0,p1);
		List<Rectangle> s = r.split4();
		Point pnw = new Point(1,1);
		Point pne = new Point(7,1);
		Point psw = new Point(1,7);
		Point pse = new Point(7,7);
		Point pout = new Point(-1,-1);
		assertEquals(firstMatchIndex(s.iterator(),pnw),(Integer)0);
		assertEquals(firstMatchIndex(s.iterator(),pne),(Integer)1);
		assertEquals(firstMatchIndex(s.iterator(),psw),(Integer)2);
		assertEquals(firstMatchIndex(s.iterator(),pse),(Integer)3);
		assertEquals(firstMatchIndex(s.iterator(),pout),(Integer)(-1));
		/*   */
		List<Point> ps = Arrays.asList(pnw,pne,psw,pse);
		for (Point p : ps) {
			List<Integer> is = matchesIndexes(s.iterator(),p);
			assertEquals(is.size(),1);
		}
	}
	
	private Integer firstMatchIndex(Iterator<Rectangle> ii, Point p)  {
		for (int c = 0;ii.hasNext();c++) {
			if (ii.next().contains(p)) {
				return c;
			}
		}
		return -1;
	}
	private List<Integer> matchesIndexes(Iterator<Rectangle> ii, Point p)  {
		List<Integer> ans = new ArrayList<Integer>(4);
		Integer c = 0;
		for (;ii.hasNext();c++) {
			if (ii.next().contains(p)) {
				ans.add(c);
			}
		}
		return ans;
	}

}
