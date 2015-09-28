package ants2d.mappart;

import org.junit.Test;

import ants2d.map.RectShape;
import ants2d.map.Point;
import ants2d.map.Rectangle;
import ants2d.map.XY;
import ants2d.mapobject.MapObject;
import ants2d.mapobject.MapPoint;

import static org.junit.Assert.*;

//import java.util.ArrayList;
import java.util.List;

public class MapTest {
	@Test
	public void objBagMapNearbyObjects() {
		MapPart m = prepareMap();
		Point p = new Point(1, 1);
		checkNearbyObjectsCount(m);
		double a1 = area(m.findMap(p).getRectangle());
		m.trySplit(2);
		double a2 = area(m.findMap(p).getRectangle());
		checkNearbyObjectsCount(m);
		assertEquals(a1, a2 * 4, 0.01);
	}
	@Test
	public void mapDepthAndCount() {
		MapPart m = prepareMap();
		int d1 = getDepth(m);
		int c1 = getMapCount(m);
		m.trySplit(2);
		int d2 = getDepth(m);
		int c2 = getMapCount(m);
		assertNotEquals(d1,d2);
		assertEquals(d1+1,d2);
		assertEquals(3,d2);
		assertNotEquals(c1,c2);
		assertEquals(2,c1);
		assertEquals(6,c2);
	}
	public MapPart prepareMap()
	{
		MapPart m = MapFactory.newMap(new Rectangle(new Point(0, 0), new Point(10, 10)));
		MapPoint p = new MapPoint(new Point(1, 1), "one");
		m.add(p);
		m.add(new MapPoint(new Point(2, 2), "two"));
		m.add(new MapPoint(new Point(9, 9), "nine"));
		return m;
	}
	public void checkNearbyObjectsCount(MapPart m) {
		List<MapObject> l2 = m.getNearbyObjects(new Point(1.5, 1.5), 1.0);
		assertEquals(l2.size(), 2);
		l2 = m.getNearbyObjects(new Point(1.5, 1.5), 15.0);
		assertEquals(l2.size(), 3);
		l2 = m.getNearbyObjects(new Point(5.5, 5.5), 0.01);
		assertTrue(l2.isEmpty());
	}

	public double area(RectShape rr) {
		XY r = rr.dimentions();
		return r.getX() * r.getY();
	}

	public Integer getDepth(MapPart m) {
		MapPartTraversalParams<Integer> prms = new MapPartTraversalParams<Integer>() {
			@Override
			public Integer coalesce(Iterable<Integer> xs) {
				Integer s = 0;
				for (Integer i : xs)
					s = Math.max(s, i);
				return s + 1;
			}

			@Override
			public Integer f0(MapPart a) {
				return 0;
			}
		};
		return prms.traverse(m);
	}
	public Integer getMapCount(MapPart m) {
		MapPartTraversalParams<Integer> prms = new MapPartTraversalParams<Integer>() {
			@Override
			public Integer coalesce(Iterable<Integer> xs) {
				Integer s = 0;
				for (Integer i : xs)
					s += i;
				return s;
			}

			@Override
			public Integer f0(MapPart a) {
				return 1;
			}
		};
		return prms.traverse(m);
	}
}
