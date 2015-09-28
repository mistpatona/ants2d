package ants2d.map;

import org.junit.runners.Suite;

import ants2d.geometry.LineEquationTest;
import ants2d.mappart.MapTest;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({	PointTest.class, 
						RectangleTest.class,
						MapTest.class,
						LineEquationTest.class
					})

public class AllTests {

}
