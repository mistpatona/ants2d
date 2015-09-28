package ants2d.map;

import org.junit.runners.Suite;

import ants2d.geometry.LineEquationTest;
import ants2d.geometry.PointTest;
import ants2d.geometry.RectangleTest;
import ants2d.geometry.SegmentTest;
import ants2d.mappart.MapTest;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({	PointTest.class, 
						RectangleTest.class,
						MapTest.class,
						SegmentTest.class,
						LineEquationTest.class
					})

public class AllTests {

}
