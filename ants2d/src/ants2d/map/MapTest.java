package ants2d.map;

import org.junit.Test;
import static org.junit.Assert.*;

//import java.util.ArrayList;
import java.util.List;

public class MapTest {
	@Test
	public void objBagMapNearbyObjects(){
		MapPart m = MapFactory.newMap(new  Rectangle(new Point(0,0),new Point(10,10)));
		MapPoint p = new MapPoint(new Point(1,1),"one");
		m.add(p);
		m.add(new MapPoint(new Point(2,2),"two"));
		m.add(new MapPoint(new Point(9,9),"nine"));
		checkNearbyObjectsCount(m);
		double a1 = area(m.findMap(p.getCoords()).getRectangle());
		m.trySplit(2);
		double a2 = area(m.findMap(p.getCoords()).getRectangle());
		checkNearbyObjectsCount(m);
		assertEquals(a1,a2*4,0.01);
	}
	
	public void checkNearbyObjectsCount(MapPart m ){

		List<MapObject> l2 = m.getNearbyObjects(new Point(1.5,1.5), 1.0);
		assertEquals(l2.size(),2);
		l2 = m.getNearbyObjects(new Point(1.5,1.5), 15.0);
		assertEquals(l2.size(),3);
		l2 = m.getNearbyObjects(new Point(5.5,5.5), 0.01);
		assertTrue(l2.isEmpty());
	}
	
	public double area(AB rr) {
		XY r = rr.dimentions();
		return r.getX() * r.getY();
	}

}
