package ants2d.map;

import org.junit.Test;
import static org.junit.Assert.*;

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

}
