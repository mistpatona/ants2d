package ants2d.map;

import org.junit.runners.Suite;

import ants2d.geometry.test.LineEquationTest;
import ants2d.geometry.test.PointTest;
import ants2d.geometry.test.PolygonTest;
import ants2d.geometry.test.RandomPointsNTest;
import ants2d.geometry.test.RectangleTest;
import ants2d.geometry.test.SegmentTest;
import ants2d.geometry.test.TriangleTest;
import ants2d.mappart.MapTest;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({	PointTest.class, 
						RectangleTest.class,
						MapTest.class,
						SegmentTest.class,
						LineEquationTest.class,
						RandomPointsNTest.class,
						TriangleTest.class,
						PolygonTest.class
					})

public class AllTests {

}
